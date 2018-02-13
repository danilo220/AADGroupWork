package com.aadgroup.aadgroupwork;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DotCancellation extends AppCompatActivity implements View.OnClickListener
{
    ArrayList<Tile> allTiles = new ArrayList<>();
    Account loggedInAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dot_cancellation);

        Intent intent = getIntent();

        if (intent.hasExtra("AccountDetails")) {
            loggedInAcc = (Account) intent.getSerializableExtra("AccountDetails");

            Toast toast = Toast.makeText(this, "Logged in as " + loggedInAcc.getUsername(), Toast.LENGTH_SHORT);
            toast.show();
        }

        AddAllTiles();
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

        return tempTile;
    }

    // Solution from https://stackoverflow.com/questions/22664938/get-drawable-by-string/22665046
    public static int GetImage(Context c, String ImageName) {
        return c.getResources().getIdentifier(ImageName, "drawable", c.getPackageName());
    }

    @Override
    public void onClick(View v) {
        Tile t = (Tile)v;
        t.toggleActive();
        Toast toast = Toast.makeText(this, Integer.toString(t.getNumberOfDots()), Toast.LENGTH_SHORT);
        toast.show();
    }

    private void CalculateScore()
    {
        int timeTaken = 900; //dummy int to calculate time
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
            else if (allTiles.get(i).getNumberOfDots() == 3)
            {
                missedFourDots++;
            }
        }
    }
}
