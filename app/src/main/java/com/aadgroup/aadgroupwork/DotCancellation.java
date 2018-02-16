package com.aadgroup.aadgroupwork;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DotCancellation extends AppCompatActivity implements View.OnClickListener
{
    ArrayList<Tile> allTiles = new ArrayList<>();
    Boolean scrollBottom = false;
    Boolean scrollRight = false;
    TextView txtCounter;
    Counter counter;

    Account loggedInAcc;
    TestResults allResults;
    ArrayList<Integer> testFinish = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dot_cancellation);

        counter = new Counter();

        txtCounter = findViewById(R.id.txtCounter);
        txtCounter.setText(counter.getTimeString());

        Intent intent = getIntent();
        if (intent.hasExtra("AccountDetails")) {
            loggedInAcc = (Account) intent.getSerializableExtra("AccountDetails");
        }
        if (intent.hasExtra("TestResults")) {
            allResults = (TestResults) intent.getSerializableExtra("TestResults");
        }
        else
        {
            allResults = new TestResults();
        }
        if (intent.hasExtra("TestFinish")) {
            testFinish = (ArrayList<Integer>) getIntent().getIntegerArrayListExtra("TestFinish");
        }
        else
        {
            testFinish.add(0);
            testFinish.add(0);
            testFinish.add(0);
            testFinish.add(0);
        }

        AddAllTiles();

        ImageView finishButton = findViewById(R.id.iv_finish);
        finishButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CalculateScore();
                txtCounter.setText(counter.getTimeString());

                Intent intent = new Intent(getApplicationContext(), menuActivity.class);
                intent.putExtra("AccountDetails", loggedInAcc);
                intent.putExtra("TestResults", allResults);
                testFinish.set(0, 1);
                intent.putIntegerArrayListExtra("TestFinish", testFinish);
                startActivity(intent);
            }
        });

        ImageView verticalButton = findViewById(R.id.iv_vertical);
        verticalButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ScrollView scrollTiles = findViewById(R.id.scrollTiles);
                if (scrollBottom)
                {
                    scrollTiles.scrollTo(0, 0);
                }
                else
                {
                    scrollTiles.scrollTo(0, scrollTiles.getBottom());
                }
                scrollBottom = !scrollBottom;
            }
        });

        ImageView horizontalButton = findViewById(R.id.iv_horizontal);
        horizontalButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HorizontalScrollView scrollHorizontal = findViewById(R.id.horizontalScrollTiles);
                if (scrollRight)
                {
                    scrollHorizontal.scrollTo(0, 0);
                }
                else
                {
                    scrollHorizontal.scrollTo(scrollHorizontal.getRight(), 0);
                }
                scrollRight = !scrollRight;
            }
        });

        Thread t = new Thread(){
            @Override
            public void run(){
                while(true){
                    try {
                        Thread.sleep(1000);  //1000ms = 1 sec
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                counter.increaseTime();
                                txtCounter.setText(counter.getTimeString());
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }

    private void AddAllTiles()
    {
        GridLayout gridLayout = findViewById(R.id.gridLayout);

        try {
            InputStream is = getAssets().open("tiles.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String tileName = reader.readLine();

            while (tileName != null)
            {
                gridLayout.addView(AddNewTile(tileName));
                tileName = reader.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private Tile AddNewTile(String fileName)
    {
        Tile tempTile = new Tile(this, Character.getNumericValue(fileName.charAt(5)));

        tempTile.setImageResource(GetImage(this, fileName));
        tempTile.setOnClickListener(this);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(75, 75);
        params.setMargins(50, 50, 50, 50);
        tempTile.setLayoutParams(params);

        allTiles.add(tempTile);

        return tempTile;
    }

    // Solution from https://stackoverflow.com/questions/22664938/get-drawable-by-string/22665046
    public static int GetImage(Context c, String ImageName) {
        return c.getResources().getIdentifier(ImageName, "drawable", c.getPackageName());
    }

    @Override
    public void onClick(View v) {
        Tile tile = (Tile)v;
        tile.toggleActive();
    }

    private void CalculateScore()
    {
        int timeTaken = counter.getSeconds();
        int missedFourDots = 0;
        int cancelledNonFourDots = 0;

        if (timeTaken > 900)
        {
            timeTaken = 900;
        }

        for (int i = 0; i < allTiles.size(); i++)
        {
            if (allTiles.get(i).getIsActive())
            {
                if (allTiles.get(i).getNumberOfDots() == 3 || allTiles.get(i).getNumberOfDots() == 5)
                {
                    cancelledNonFourDots++;
                }
            }
            else if (allTiles.get(i).getNumberOfDots() == 4)
            {
                missedFourDots++;
            }
        }
        allResults = new TestResults();
        allResults.setDotCancellationResults(timeTaken, missedFourDots, cancelledNonFourDots);
    }


}
