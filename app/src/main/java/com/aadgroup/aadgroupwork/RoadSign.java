package com.aadgroup.aadgroupwork;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Danilo on 30/01/2018.
 */

public class RoadSign extends AppCompatActivity implements View.OnTouchListener, View.OnDragListener
{
    int points = 0;
    Button startButton;
    Button resetButton;
    Button finishButton;

    TextView timerText;
    TextView pointsTextView;
    //Road Signs
    ImageView firstImg;
    ImageView secondImg;
    ImageView thirdImg;
    ImageView fourthImg;
    ImageView fifthImg;
    ImageView sixthImg;
    ImageView seventhImg;
    ImageView eightImg;
    ImageView ninthImg;
    ImageView tenthImg;
    ImageView eleventhImg;
    ImageView twelvethImg;
    //Answer boxes
    ImageView firstImageBoxV;
    ImageView secondImageBoxV;
    ImageView thirdImageBoxV;
    ImageView fourthImageBoxV;
    ImageView fifthImageBoxV;
    ImageView sixthImageBoxV;
    ImageView seventhImageBoxV;
    ImageView eightImageBoxV;
    ImageView ninthImageBoxV;
    ImageView tenthImageBoxV;
    ImageView eleventhImageBoxV;
    ImageView twelvethImageBoxV;

    Account loggedInAcc;
    TestResults allResults;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.road_sign);

        Intent intent = getIntent();
        if (intent.hasExtra("AccountDetails")) {
            loggedInAcc = (Account) intent.getSerializableExtra("AccountDetails");
        }
        if (intent.hasExtra("TestResults")) {
            allResults = (TestResults) intent.getSerializableExtra("TestResults");
        }
        {
            allResults = new TestResults();
        }

/*        firstImg = (ImageView) findViewById(R.id.roadSignOne);
        firstImg.setOnTouchListener(this);*/

        //Timer
        timerText = (TextView) findViewById(R.id.timerTextView);
        pointsTextView = (TextView) findViewById(R.id.PointsTestView);
        //Road Signs
        firstImg = (ImageView) findViewById(R.id.roadSignOne);
        firstImg.setOnTouchListener(this);

        secondImg = (ImageView) findViewById(R.id.roadSignTwo);
        secondImg.setOnTouchListener(this);

        thirdImg = (ImageView) findViewById(R.id.roadSignThree);
        thirdImg.setOnTouchListener(this);

        fourthImg = (ImageView) findViewById(R.id.roadSignFour);
        fourthImg.setOnTouchListener(this);

        fifthImg = (ImageView) findViewById(R.id.roadSignFive);
        fifthImg.setOnTouchListener(this);

        sixthImg = (ImageView) findViewById(R.id.roadSignSix);
        sixthImg.setOnTouchListener(this);

        seventhImg = (ImageView) findViewById(R.id.roadSignSeven);
        seventhImg.setOnTouchListener(this);

        eightImg = (ImageView) findViewById(R.id.roadSignEight);
        eightImg.setOnTouchListener(this);

        ninthImg = (ImageView) findViewById(R.id.roadSignNine);
        ninthImg.setOnTouchListener(this);

        tenthImg = (ImageView) findViewById(R.id.roadSignTen);
        tenthImg.setOnTouchListener(this);

        eleventhImg = (ImageView) findViewById(R.id.roadSignEleven);
        eleventhImg.setOnTouchListener(this);

        twelvethImg = (ImageView) findViewById(R.id.roadSignTwelve);
        twelvethImg.setOnTouchListener(this);

        firstImg.setVisibility(View.INVISIBLE);
        secondImg.setVisibility(View.INVISIBLE);
        thirdImg.setVisibility(View.INVISIBLE);
        fourthImg.setVisibility(View.INVISIBLE);
        fifthImg.setVisibility(View.INVISIBLE);
        sixthImg.setVisibility(View.INVISIBLE);
        seventhImg.setVisibility(View.INVISIBLE);
        eightImg.setVisibility(View.INVISIBLE);
        ninthImg.setVisibility(View.INVISIBLE);
        tenthImg.setVisibility(View.INVISIBLE);
        eleventhImg.setVisibility(View.INVISIBLE);
        twelvethImg.setVisibility(View.INVISIBLE);
        //findViewById(R.id.roadSignOne).setOnTouchListener(this);
/*        findViewById(R.id.roadSignTwo).setOnTouchListener(this);
        findViewById(R.id.roadSignThree).setOnTouchListener(this);
        findViewById(R.id.roadSignFour).setOnTouchListener(this);
        findViewById(R.id.roadSignFive).setOnTouchListener(this);
        findViewById(R.id.roadSignSix).setOnTouchListener(this);
        findViewById(R.id.roadSignSeven).setOnTouchListener(this);
        findViewById(R.id.roadSignEight).setOnTouchListener(this);
        findViewById(R.id.roadSignNine).setOnTouchListener(this);
        findViewById(R.id.roadSignTen).setOnTouchListener(this);
        findViewById(R.id.roadSignEleven).setOnTouchListener(this);*/

        //Road Scenes
        findViewById(R.id.firstImage).setOnDragListener(this);
        findViewById(R.id.secondImage).setOnDragListener(this);
        findViewById(R.id.thirdImage).setOnDragListener(this);
        findViewById(R.id.fourthImage).setOnDragListener(this);
        findViewById(R.id.fifthImage).setOnDragListener(this);
        findViewById(R.id.sixthImage).setOnDragListener(this);
        findViewById(R.id.seventhImage).setOnDragListener(this);
        findViewById(R.id.eightImage).setOnDragListener(this);
        findViewById(R.id.nithImage).setOnDragListener(this);
        findViewById(R.id.tenthImage).setOnDragListener(this);
        findViewById(R.id.eleventhImage).setOnDragListener(this);
        findViewById(R.id.twelvethImage).setOnDragListener(this);

        //Answer boxes
        firstImageBoxV = (ImageView) findViewById(R.id.firstImageBox);
        //firstImageBoxV.setOnDragListener(this);

        secondImageBoxV = (ImageView) findViewById(R.id.secondImageBox);
        //secondImageBoxV.setOnDragListener(this);

        thirdImageBoxV = (ImageView) findViewById(R.id.thirdImageBox);
        //thirdImageBoxV.setOnDragListener(this);

        thirdImageBoxV = (ImageView) findViewById(R.id.thirdImageBox);
        //thirdImageBoxV.setOnDragListener(this);

        fourthImageBoxV = (ImageView) findViewById(R.id.fourthImageBox);
        //fourthImageBoxV.setOnDragListener(this);

        fifthImageBoxV = (ImageView) findViewById(R.id.fifthImageBox);
        //fifthImageBoxV.setOnDragListener(this);

        sixthImageBoxV = (ImageView) findViewById(R.id.sixthImageBox);
        //sixthImageBoxV.setOnDragListener(this);

        seventhImageBoxV = (ImageView) findViewById(R.id.seventhImageBox);
        //seventhImageBoxV.setOnDragListener(this);

        eightImageBoxV = (ImageView) findViewById(R.id.eightImageBox);
        //eightImageBoxV.setOnDragListener(this);

        ninthImageBoxV = (ImageView) findViewById(R.id.ninthImageBox);
        //ninthImageBoxV.setOnDragListener(this);

        tenthImageBoxV = (ImageView) findViewById(R.id.tenthImageBox);
        //tenthImageBoxV.setOnDragListener(this);

        eleventhImageBoxV = (ImageView) findViewById(R.id.eleventhImageBox);
        //eleventhImageBoxV.setOnDragListener(this);

        twelvethImageBoxV = (ImageView) findViewById(R.id.twelvethImageBox);
        //twelvethImageBoxV.setOnDragListener(this);


        startButton = (Button) findViewById(R.id.startButtonRoadSign);
        startButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                makeImagesVisible();
                //finishGame();
                new CountDownTimer(180000, 1000) //3 minutes
                {

                    public void onTick(long millisUntilFinished)
                    {
                        timerText.setText("Timer: " + millisUntilFinished / 1000);
                    }

                    public void onFinish()
                    {
                        //timerText.setText("That’s fine, you have done enough now and can stop");
                        points = points;
                        //menuButton.setVisibility(View.VISIBLE);
                        resetButton.setVisibility(View.INVISIBLE);
                        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(myIntent);
                    }
                }.start();

                startButton.setVisibility(View.INVISIBLE);
            }
        });

        resetButton = (Button) findViewById(R.id.resetButtonRoadSign);
        resetButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                pointsTextView.setText("Points: " + points);
/*                Intent myIntent = new Intent(getApplicationContext(), RoadSign.class);
                startActivity(myIntent);*/
                points = 0;
                resetListeners();
                firstImg.setVisibility(View.VISIBLE);
                secondImg.setVisibility(View.VISIBLE);
                thirdImg.setVisibility(View.VISIBLE);
                fourthImg.setVisibility(View.VISIBLE);
                fifthImg.setVisibility(View.VISIBLE);
                sixthImg.setVisibility(View.VISIBLE);
                seventhImg.setVisibility(View.VISIBLE);
                eightImg.setVisibility(View.VISIBLE);
                ninthImg.setVisibility(View.VISIBLE);
                tenthImg.setVisibility(View.VISIBLE);
                eleventhImg.setVisibility(View.VISIBLE);
                twelvethImg.setVisibility(View.VISIBLE);

                fifthImageBoxV.setBackground(null);

                firstImageBoxV.setBackground(null);
                secondImageBoxV.setBackground(null);
                thirdImageBoxV.setBackground(null);
                thirdImageBoxV.setBackground(null);
                fourthImageBoxV.setBackground(null);
                fifthImageBoxV.setBackground(null);
                sixthImageBoxV.setBackground(null);
                seventhImageBoxV.setBackground(null);
                eightImageBoxV.setBackground(null);
                ninthImageBoxV.setBackground(null);
                tenthImageBoxV.setBackground(null);
                eleventhImageBoxV.setBackground(null);
                twelvethImageBoxV.setBackground(null);

                //f.setOnDragListener(this);
                //findViewById(R.id.firstImage).setOnDragListener(this);
            }
        });
        finishButton = (Button) findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                points = points;
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(myIntent);
            }
        });
    }
    private void makeImagesVisible()
    {
        firstImg.setVisibility(View.VISIBLE);
        secondImg.setVisibility(View.VISIBLE);
        thirdImg.setVisibility(View.VISIBLE);
        fourthImg.setVisibility(View.VISIBLE);
        fifthImg.setVisibility(View.VISIBLE);
        sixthImg.setVisibility(View.VISIBLE);
        seventhImg.setVisibility(View.VISIBLE);
        eightImg.setVisibility(View.VISIBLE);
        ninthImg.setVisibility(View.VISIBLE);
        tenthImg.setVisibility(View.VISIBLE);
        eleventhImg.setVisibility(View.VISIBLE);
        twelvethImg.setVisibility(View.VISIBLE);

    }
    private void resetListeners()
    {
        findViewById(R.id.firstImage).setOnDragListener(this);
        findViewById(R.id.secondImage).setOnDragListener(this);
        findViewById(R.id.thirdImage).setOnDragListener(this);
        findViewById(R.id.fourthImage).setOnDragListener(this);
        findViewById(R.id.fifthImage).setOnDragListener(this);
        findViewById(R.id.sixthImage).setOnDragListener(this);
        findViewById(R.id.seventhImage).setOnDragListener(this);
        findViewById(R.id.eightImage).setOnDragListener(this);
        findViewById(R.id.nithImage).setOnDragListener(this);
        findViewById(R.id.tenthImage).setOnDragListener(this);
        findViewById(R.id.eleventhImage).setOnDragListener(this);
        findViewById(R.id.twelvethImage).setOnDragListener(this);

    }

/*    void finishGame()
    {
        if(twelvethImageBoxV.getDrawable() != null && firstImageBoxV.getDrawable() != null)
        {
            //startButton.setVisibility(View.VISIBLE);
*//*            Toast.makeText(RoadSign.this,
                    "Finished", Toast.LENGTH_LONG).show();*//*
            Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(myIntent);
        }
*//*        else
        {
            Toast.makeText(RoadSign.this,
                    "Not finished", Toast.LENGTH_LONG).show();
        }*//*
        //twelvethImageBoxV.setBackgroundResource(R.drawable.road_sign_eight);
    }*/
    @Override
    public boolean onTouch(View v, MotionEvent e)
    {
        //finishGame();
        if (e.getAction() == MotionEvent.ACTION_DOWN)
        {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(null, shadowBuilder, v, 0);
            v.setVisibility(View.VISIBLE);
            return true;
        }
        else
        {
            return false;
        }

    }

    @Override
    public boolean onDrag(View v, DragEvent event)
    {
        //finishGame();
        final int action = event.getAction();
        View view = (View) event.getLocalState();
        switch (action)
        {
            case DragEvent.ACTION_DROP:
                if (view.getId() == R.id.roadSignOne)
                {
                    if(v.getId() == R.id.firstImage)
                    {
/*                        ViewGroup vGroup = (ViewGroup) view.getParent();
                        vGroup.removeView(view);*/
                        firstImg.setVisibility(View.INVISIBLE);
                        firstImageBoxV.setBackgroundResource(R.drawable.road_sign_one);
                        findViewById(R.id.firstImage).setOnDragListener(null);
                        points += 1;
                    }
                    if(v.getId() == R.id.secondImage)
                    {
                        firstImg.setVisibility(View.INVISIBLE);
                        secondImageBoxV.setBackgroundResource(R.drawable.road_sign_one);
                        findViewById(R.id.secondImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.thirdImage)
                    {
                        firstImg.setVisibility(View.INVISIBLE);
                        thirdImageBoxV.setBackgroundResource(R.drawable.road_sign_one);
                        findViewById(R.id.thirdImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fourthImage)
                    {
                        firstImg.setVisibility(View.INVISIBLE);
                        fourthImageBoxV.setBackgroundResource(R.drawable.road_sign_one);
                        findViewById(R.id.fourthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fifthImage)
                    {
                        firstImg.setVisibility(View.INVISIBLE);
                        fifthImageBoxV.setBackgroundResource(R.drawable.road_sign_one);
                        findViewById(R.id.fifthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.sixthImage)
                    {
                        firstImg.setVisibility(View.INVISIBLE);
                        sixthImageBoxV.setBackgroundResource(R.drawable.road_sign_one);
                        findViewById(R.id.sixthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.seventhImage)
                    {
                        firstImg.setVisibility(View.INVISIBLE);
                        seventhImageBoxV.setBackgroundResource(R.drawable.road_sign_one);
                        findViewById(R.id.seventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eightImage)
                    {
                        firstImg.setVisibility(View.INVISIBLE);
                        eightImageBoxV.setBackgroundResource(R.drawable.road_sign_one);
                        findViewById(R.id.eightImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.nithImage)
                    {
                        firstImg.setVisibility(View.INVISIBLE);
                        ninthImageBoxV.setBackgroundResource(R.drawable.road_sign_one);
                        findViewById(R.id.nithImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.tenthImage)
                    {
                        firstImg.setVisibility(View.INVISIBLE);
                        tenthImageBoxV.setBackgroundResource(R.drawable.road_sign_one);
                        findViewById(R.id.tenthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eleventhImage)
                    {
                        firstImg.setVisibility(View.INVISIBLE);
                        eleventhImageBoxV.setBackgroundResource(R.drawable.road_sign_one);
                        findViewById(R.id.eleventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.twelvethImage)
                    {
                        firstImg.setVisibility(View.INVISIBLE);
                        twelvethImageBoxV.setBackgroundResource(R.drawable.road_sign_one);
                        findViewById(R.id.twelvethImage).setOnDragListener(null);
                    }
                }
                //##################################################################################
                if (view.getId() == R.id.roadSignTwo)
                {
                    if(v.getId() == R.id.firstImage)
                    {
                        secondImg.setVisibility(View.INVISIBLE);
                        firstImageBoxV.setBackgroundResource(R.drawable.road_sign_two);
                        findViewById(R.id.firstImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.secondImage)
                    {
                        secondImg.setVisibility(View.INVISIBLE);
                        secondImageBoxV.setBackgroundResource(R.drawable.road_sign_two);
                        findViewById(R.id.secondImage).setOnDragListener(null);
                        points += 1;
                    }
                    if(v.getId() == R.id.thirdImage)
                    {
                        secondImg.setVisibility(View.INVISIBLE);
                        thirdImageBoxV.setBackgroundResource(R.drawable.road_sign_two);
                        findViewById(R.id.thirdImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fourthImage)
                    {
                        secondImg.setVisibility(View.INVISIBLE);
                        fourthImageBoxV.setBackgroundResource(R.drawable.road_sign_two);
                        findViewById(R.id.fourthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fifthImage)
                    {
                        secondImg.setVisibility(View.INVISIBLE);
                        fifthImageBoxV.setBackgroundResource(R.drawable.road_sign_two);
                        findViewById(R.id.fifthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.sixthImage)
                    {
                        secondImg.setVisibility(View.INVISIBLE);
                        sixthImageBoxV.setBackgroundResource(R.drawable.road_sign_two);
                        findViewById(R.id.sixthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.seventhImage)
                    {
                        secondImg.setVisibility(View.INVISIBLE);
                        seventhImageBoxV.setBackgroundResource(R.drawable.road_sign_two);
                        findViewById(R.id.seventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eightImage)
                    {
                        secondImg.setVisibility(View.INVISIBLE);
                        eightImageBoxV.setBackgroundResource(R.drawable.road_sign_two);
                        findViewById(R.id.eightImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.nithImage)
                    {
                        secondImg.setVisibility(View.INVISIBLE);
                        ninthImageBoxV.setBackgroundResource(R.drawable.road_sign_two);
                        findViewById(R.id.nithImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.tenthImage)
                    {
                        secondImg.setVisibility(View.INVISIBLE);
                        tenthImageBoxV.setBackgroundResource(R.drawable.road_sign_two);
                        findViewById(R.id.tenthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eleventhImage)
                    {
                        secondImg.setVisibility(View.INVISIBLE);
                        eleventhImageBoxV.setBackgroundResource(R.drawable.road_sign_two);
                        findViewById(R.id.eleventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.twelvethImage)
                    {
                        secondImg.setVisibility(View.INVISIBLE);
                        twelvethImageBoxV.setBackgroundResource(R.drawable.road_sign_two);
                        findViewById(R.id.twelvethImage).setOnDragListener(null);
                    }
                }

                //##################################################################################
                if (view.getId() == R.id.roadSignThree)
                {
                    if(v.getId() == R.id.firstImage)
                    {
                        thirdImg.setVisibility(View.INVISIBLE);
                        firstImageBoxV.setBackgroundResource(R.drawable.road_sign_three);
                        findViewById(R.id.firstImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.secondImage)
                    {
                        thirdImg.setVisibility(View.INVISIBLE);
                        secondImageBoxV.setBackgroundResource(R.drawable.road_sign_three);
                        findViewById(R.id.secondImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.thirdImage)
                    {
                        thirdImg.setVisibility(View.INVISIBLE);
                        thirdImageBoxV.setBackgroundResource(R.drawable.road_sign_three);
                        findViewById(R.id.thirdImage).setOnDragListener(null);
                        points += 1;
                    }
                    if(v.getId() == R.id.fourthImage)
                    {
                        thirdImg.setVisibility(View.INVISIBLE);
                        fourthImageBoxV.setBackgroundResource(R.drawable.road_sign_three);
                        findViewById(R.id.fourthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fifthImage)
                    {
                        thirdImg.setVisibility(View.INVISIBLE);
                        fifthImageBoxV.setBackgroundResource(R.drawable.road_sign_three);
                        findViewById(R.id.fifthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.sixthImage)
                    {
                        thirdImg.setVisibility(View.INVISIBLE);
                        sixthImageBoxV.setBackgroundResource(R.drawable.road_sign_three);
                        findViewById(R.id.sixthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.seventhImage)
                    {
                        thirdImg.setVisibility(View.INVISIBLE);
                        seventhImageBoxV.setBackgroundResource(R.drawable.road_sign_three);
                        findViewById(R.id.seventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eightImage)
                    {
                        thirdImg.setVisibility(View.INVISIBLE);
                        eightImageBoxV.setBackgroundResource(R.drawable.road_sign_three);
                        findViewById(R.id.eightImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.nithImage)
                    {
                        thirdImg.setVisibility(View.INVISIBLE);
                        ninthImageBoxV.setBackgroundResource(R.drawable.road_sign_three);
                        findViewById(R.id.nithImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.tenthImage)
                    {
                        thirdImg.setVisibility(View.INVISIBLE);
                        tenthImageBoxV.setBackgroundResource(R.drawable.road_sign_three);
                        findViewById(R.id.tenthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eleventhImage)
                    {
                        thirdImg.setVisibility(View.INVISIBLE);
                        eleventhImageBoxV.setBackgroundResource(R.drawable.road_sign_three);
                        findViewById(R.id.eleventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.twelvethImage)
                    {
                        thirdImg.setVisibility(View.INVISIBLE);
                        twelvethImageBoxV.setBackgroundResource(R.drawable.road_sign_three);
                        findViewById(R.id.twelvethImage).setOnDragListener(null);
                    }
                }

                //##################################################################################
                if (view.getId() == R.id.roadSignFour)
                {
                    if(v.getId() == R.id.firstImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        firstImageBoxV.setBackgroundResource(R.drawable.road_sign_four);
                        findViewById(R.id.firstImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.secondImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        secondImageBoxV.setBackgroundResource(R.drawable.road_sign_four);
                        findViewById(R.id.secondImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.thirdImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        thirdImageBoxV.setBackgroundResource(R.drawable.road_sign_four);
                        findViewById(R.id.thirdImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fourthImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        fourthImageBoxV.setBackgroundResource(R.drawable.road_sign_four);
                        findViewById(R.id.fourthImage).setOnDragListener(null);
                        points += 1;
                    }
                    if(v.getId() == R.id.fifthImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        fifthImageBoxV.setBackgroundResource(R.drawable.road_sign_four);
                        findViewById(R.id.fifthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.sixthImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        sixthImageBoxV.setBackgroundResource(R.drawable.road_sign_four);
                        findViewById(R.id.sixthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.seventhImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        seventhImageBoxV.setBackgroundResource(R.drawable.road_sign_four);
                        findViewById(R.id.seventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eightImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        eightImageBoxV.setBackgroundResource(R.drawable.road_sign_four);
                        findViewById(R.id.eightImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.nithImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        ninthImageBoxV.setBackgroundResource(R.drawable.road_sign_four);
                        findViewById(R.id.nithImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.tenthImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        tenthImageBoxV.setBackgroundResource(R.drawable.road_sign_four);
                        findViewById(R.id.tenthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eleventhImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        eleventhImageBoxV.setBackgroundResource(R.drawable.road_sign_four);
                        findViewById(R.id.eleventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.twelvethImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        twelvethImageBoxV.setBackgroundResource(R.drawable.road_sign_four);
                        findViewById(R.id.twelvethImage).setOnDragListener(null);
                    }
                }

                //##################################################################################
                if (view.getId() == R.id.roadSignFive)
                {
                    if(v.getId() == R.id.firstImage)
                    {
                        fifthImg.setVisibility(View.INVISIBLE);
                        firstImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.firstImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.secondImage)
                    {
                        fifthImg.setVisibility(View.INVISIBLE);
                        secondImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.secondImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.thirdImage)
                    {
                        fifthImg.setVisibility(View.INVISIBLE);
                        thirdImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.thirdImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fourthImage)
                    {
                        fifthImg.setVisibility(View.INVISIBLE);
                        fourthImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.fourthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fifthImage)
                    {
                        fifthImg.setVisibility(View.INVISIBLE);
                        fifthImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.fifthImage).setOnDragListener(null);
                        points += 1;
                    }
                    if(v.getId() == R.id.sixthImage)
                    {
                        fifthImg.setVisibility(View.INVISIBLE);
                        sixthImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.sixthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.seventhImage)
                    {
                        fifthImg.setVisibility(View.INVISIBLE);
                        seventhImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.seventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eightImage)
                    {
                        fifthImg.setVisibility(View.INVISIBLE);
                        eightImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.eightImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.nithImage)
                    {
                        fifthImg.setVisibility(View.INVISIBLE);
                        ninthImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.nithImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.tenthImage)
                    {
                        fifthImg.setVisibility(View.INVISIBLE);
                        tenthImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.tenthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eleventhImage)
                    {
                        fifthImg.setVisibility(View.INVISIBLE);
                        eleventhImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.eleventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.twelvethImage)
                    {
                        fifthImg.setVisibility(View.INVISIBLE);
                        twelvethImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.twelvethImage).setOnDragListener(null);
                    }
                }

                //##################################################################################
                if (view.getId() == R.id.roadSignSix)
                {
                    if(v.getId() == R.id.firstImage)
                    {
                        sixthImg.setVisibility(View.INVISIBLE);
                        firstImageBoxV.setBackgroundResource(R.drawable.road_sign_six);
                        findViewById(R.id.firstImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.secondImage)
                    {
                        sixthImg.setVisibility(View.INVISIBLE);
                        secondImageBoxV.setBackgroundResource(R.drawable.road_sign_six);
                        findViewById(R.id.secondImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.thirdImage)
                    {
                        sixthImg.setVisibility(View.INVISIBLE);
                        thirdImageBoxV.setBackgroundResource(R.drawable.road_sign_six);
                        findViewById(R.id.thirdImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fourthImage)
                    {
                        sixthImg.setVisibility(View.INVISIBLE);
                        fourthImageBoxV.setBackgroundResource(R.drawable.road_sign_six);
                        findViewById(R.id.fourthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fifthImage)
                    {
                        sixthImg.setVisibility(View.INVISIBLE);
                        fifthImageBoxV.setBackgroundResource(R.drawable.road_sign_six);
                        findViewById(R.id.fifthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.sixthImage)
                    {
                        sixthImg.setVisibility(View.INVISIBLE);
                        sixthImageBoxV.setBackgroundResource(R.drawable.road_sign_six);
                        findViewById(R.id.sixthImage).setOnDragListener(null);
                        points += 1;
                    }
                    if(v.getId() == R.id.seventhImage)
                    {
                        sixthImg.setVisibility(View.INVISIBLE);
                        seventhImageBoxV.setBackgroundResource(R.drawable.road_sign_six);
                        findViewById(R.id.seventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eightImage)
                    {
                        sixthImg.setVisibility(View.INVISIBLE);
                        eightImageBoxV.setBackgroundResource(R.drawable.road_sign_six);
                        findViewById(R.id.eightImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.nithImage)
                    {
                        sixthImg.setVisibility(View.INVISIBLE);
                        ninthImageBoxV.setBackgroundResource(R.drawable.road_sign_six);
                        findViewById(R.id.nithImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.tenthImage)
                    {
                        sixthImg.setVisibility(View.INVISIBLE);
                        tenthImageBoxV.setBackgroundResource(R.drawable.road_sign_six);
                        findViewById(R.id.tenthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eleventhImage)
                    {
                        sixthImg.setVisibility(View.INVISIBLE);
                        eleventhImageBoxV.setBackgroundResource(R.drawable.road_sign_six);
                        findViewById(R.id.eleventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.twelvethImage)
                    {
                        sixthImg.setVisibility(View.INVISIBLE);
                        twelvethImageBoxV.setBackgroundResource(R.drawable.road_sign_six);
                        findViewById(R.id.twelvethImage).setOnDragListener(null);
                    }
                }

                //##################################################################################
                if (view.getId() == R.id.roadSignSeven)
                {
                    if(v.getId() == R.id.firstImage)
                    {
                        seventhImg.setVisibility(View.INVISIBLE);
                        firstImageBoxV.setBackgroundResource(R.drawable.road_sign_seven);
                        findViewById(R.id.firstImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.secondImage)
                    {
                        seventhImg.setVisibility(View.INVISIBLE);
                        secondImageBoxV.setBackgroundResource(R.drawable.road_sign_seven);
                        findViewById(R.id.secondImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.thirdImage)
                    {
                        seventhImg.setVisibility(View.INVISIBLE);
                        thirdImageBoxV.setBackgroundResource(R.drawable.road_sign_seven);
                        findViewById(R.id.thirdImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fourthImage)
                    {
                        seventhImg.setVisibility(View.INVISIBLE);
                        fourthImageBoxV.setBackgroundResource(R.drawable.road_sign_seven);
                        findViewById(R.id.fourthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fifthImage)
                    {
                        seventhImg.setVisibility(View.INVISIBLE);
                        fifthImageBoxV.setBackgroundResource(R.drawable.road_sign_seven);
                        findViewById(R.id.fifthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.sixthImage)
                    {
                        seventhImg.setVisibility(View.INVISIBLE);
                        sixthImageBoxV.setBackgroundResource(R.drawable.road_sign_seven);
                        findViewById(R.id.sixthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.seventhImage)
                    {
                        seventhImg.setVisibility(View.INVISIBLE);
                        seventhImageBoxV.setBackgroundResource(R.drawable.road_sign_seven);
                        findViewById(R.id.seventhImage).setOnDragListener(null);
                        points += 1;
                    }
                    if(v.getId() == R.id.eightImage)
                    {
                        seventhImg.setVisibility(View.INVISIBLE);
                        eightImageBoxV.setBackgroundResource(R.drawable.road_sign_seven);
                        findViewById(R.id.eightImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.nithImage)
                    {
                        seventhImg.setVisibility(View.INVISIBLE);
                        ninthImageBoxV.setBackgroundResource(R.drawable.road_sign_seven);
                        findViewById(R.id.nithImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.tenthImage)
                    {
                        seventhImg.setVisibility(View.INVISIBLE);
                        tenthImageBoxV.setBackgroundResource(R.drawable.road_sign_seven);
                        findViewById(R.id.tenthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eleventhImage)
                    {
                        seventhImg.setVisibility(View.INVISIBLE);
                        eleventhImageBoxV.setBackgroundResource(R.drawable.road_sign_seven);
                        findViewById(R.id.eleventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.twelvethImage)
                    {
                        seventhImg.setVisibility(View.INVISIBLE);
                        twelvethImageBoxV.setBackgroundResource(R.drawable.road_sign_seven);
                        findViewById(R.id.twelvethImage).setOnDragListener(null);
                    }
                }

                //##################################################################################
                if (view.getId() == R.id.roadSignEight)
                {
                    if(v.getId() == R.id.firstImage)
                    {
                        eightImg.setVisibility(View.INVISIBLE);
                        firstImageBoxV.setBackgroundResource(R.drawable.road_sign_eight);
                        findViewById(R.id.firstImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.secondImage)
                    {
                        eightImg.setVisibility(View.INVISIBLE);
                        secondImageBoxV.setBackgroundResource(R.drawable.road_sign_eight);
                        findViewById(R.id.secondImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.thirdImage)
                    {
                        eightImg.setVisibility(View.INVISIBLE);
                        thirdImageBoxV.setBackgroundResource(R.drawable.road_sign_eight);
                        findViewById(R.id.thirdImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fourthImage)
                    {
                        eightImg.setVisibility(View.INVISIBLE);
                        fourthImageBoxV.setBackgroundResource(R.drawable.road_sign_eight);
                        findViewById(R.id.fourthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fifthImage)
                    {
                        eightImg.setVisibility(View.INVISIBLE);
                        fifthImageBoxV.setBackgroundResource(R.drawable.road_sign_eight);
                        findViewById(R.id.fifthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.sixthImage)
                    {
                        eightImg.setVisibility(View.INVISIBLE);
                        sixthImageBoxV.setBackgroundResource(R.drawable.road_sign_eight);
                        findViewById(R.id.sixthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.seventhImage)
                    {
                        eightImg.setVisibility(View.INVISIBLE);
                        seventhImageBoxV.setBackgroundResource(R.drawable.road_sign_eight);
                        findViewById(R.id.seventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eightImage)
                    {
                        eightImg.setVisibility(View.INVISIBLE);
                        eightImageBoxV.setBackgroundResource(R.drawable.road_sign_eight);
                        findViewById(R.id.eightImage).setOnDragListener(null);
                        points += 1;
                    }
                    if(v.getId() == R.id.nithImage)
                    {
                        eightImg.setVisibility(View.INVISIBLE);
                        ninthImageBoxV.setBackgroundResource(R.drawable.road_sign_eight);
                        findViewById(R.id.nithImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.tenthImage)
                    {
                        eightImg.setVisibility(View.INVISIBLE);
                        tenthImageBoxV.setBackgroundResource(R.drawable.road_sign_eight);
                        findViewById(R.id.tenthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eleventhImage)
                    {
                        eightImg.setVisibility(View.INVISIBLE);
                        eleventhImageBoxV.setBackgroundResource(R.drawable.road_sign_eight);
                        findViewById(R.id.eleventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.twelvethImage)
                    {
                        eightImg.setVisibility(View.INVISIBLE);
                        twelvethImageBoxV.setBackgroundResource(R.drawable.road_sign_eight);
                        findViewById(R.id.twelvethImage).setOnDragListener(null);
                    }
                }

                //##################################################################################
                if (view.getId() == R.id.roadSignNine)
                {
                    if(v.getId() == R.id.firstImage)
                    {
                        ninthImg.setVisibility(View.INVISIBLE);
                        firstImageBoxV.setBackgroundResource(R.drawable.road_sign_nine);
                        findViewById(R.id.firstImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.secondImage)
                    {
                        ninthImg.setVisibility(View.INVISIBLE);
                        secondImageBoxV.setBackgroundResource(R.drawable.road_sign_nine);
                        findViewById(R.id.secondImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.thirdImage)
                    {
                        ninthImg.setVisibility(View.INVISIBLE);
                        thirdImageBoxV.setBackgroundResource(R.drawable.road_sign_nine);
                        findViewById(R.id.thirdImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fourthImage)
                    {
                        ninthImg.setVisibility(View.INVISIBLE);
                        fourthImageBoxV.setBackgroundResource(R.drawable.road_sign_nine);
                        findViewById(R.id.fourthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fifthImage)
                    {
                        ninthImg.setVisibility(View.INVISIBLE);
                        fifthImageBoxV.setBackgroundResource(R.drawable.road_sign_nine);
                        findViewById(R.id.fifthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.sixthImage)
                    {
                        ninthImg.setVisibility(View.INVISIBLE);
                        sixthImageBoxV.setBackgroundResource(R.drawable.road_sign_nine);
                        findViewById(R.id.sixthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.seventhImage)
                    {
                        ninthImg.setVisibility(View.INVISIBLE);
                        seventhImageBoxV.setBackgroundResource(R.drawable.road_sign_nine);
                        findViewById(R.id.seventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eightImage)
                    {
                        ninthImg.setVisibility(View.INVISIBLE);
                        eightImageBoxV.setBackgroundResource(R.drawable.road_sign_nine);
                        findViewById(R.id.eightImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.nithImage)
                    {
                        ninthImg.setVisibility(View.INVISIBLE);
                        ninthImageBoxV.setBackgroundResource(R.drawable.road_sign_nine);
                        findViewById(R.id.nithImage).setOnDragListener(null);
                        points += 1;
                    }
                    if(v.getId() == R.id.tenthImage)
                    {
                        ninthImg.setVisibility(View.INVISIBLE);
                        tenthImageBoxV.setBackgroundResource(R.drawable.road_sign_nine);
                        findViewById(R.id.tenthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eleventhImage)
                    {
                        ninthImg.setVisibility(View.INVISIBLE);
                        eleventhImageBoxV.setBackgroundResource(R.drawable.road_sign_nine);
                        findViewById(R.id.eleventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.twelvethImage)
                    {
                        ninthImg.setVisibility(View.INVISIBLE);
                        twelvethImageBoxV.setBackgroundResource(R.drawable.road_sign_nine);
                        findViewById(R.id.twelvethImage).setOnDragListener(null);
                    }
                }

                //##################################################################################
                if (view.getId() == R.id.roadSignTen)
                {
                    if(v.getId() == R.id.firstImage)
                    {
                        tenthImg.setVisibility(View.INVISIBLE);
                        firstImageBoxV.setBackgroundResource(R.drawable.road_sign_ten);
                        findViewById(R.id.firstImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.secondImage)
                    {
                        tenthImg.setVisibility(View.INVISIBLE);
                        secondImageBoxV.setBackgroundResource(R.drawable.road_sign_ten);
                        findViewById(R.id.secondImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.thirdImage)
                    {
                        tenthImg.setVisibility(View.INVISIBLE);
                        thirdImageBoxV.setBackgroundResource(R.drawable.road_sign_ten);
                        findViewById(R.id.thirdImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fourthImage)
                    {
                        tenthImg.setVisibility(View.INVISIBLE);
                        fourthImageBoxV.setBackgroundResource(R.drawable.road_sign_ten);
                        findViewById(R.id.fourthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fifthImage)
                    {
                        tenthImg.setVisibility(View.INVISIBLE);
                        fifthImageBoxV.setBackgroundResource(R.drawable.road_sign_ten);
                        findViewById(R.id.fifthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.sixthImage)
                    {
                        tenthImg.setVisibility(View.INVISIBLE);
                        sixthImageBoxV.setBackgroundResource(R.drawable.road_sign_ten);
                        findViewById(R.id.sixthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.seventhImage)
                    {
                        tenthImg.setVisibility(View.INVISIBLE);
                        seventhImageBoxV.setBackgroundResource(R.drawable.road_sign_ten);
                        findViewById(R.id.seventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eightImage)
                    {
                        tenthImg.setVisibility(View.INVISIBLE);
                        eightImageBoxV.setBackgroundResource(R.drawable.road_sign_ten);
                        findViewById(R.id.eightImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.nithImage)
                    {
                        tenthImg.setVisibility(View.INVISIBLE);
                        ninthImageBoxV.setBackgroundResource(R.drawable.road_sign_ten);
                        findViewById(R.id.nithImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.tenthImage)
                    {
                        tenthImg.setVisibility(View.INVISIBLE);
                        tenthImageBoxV.setBackgroundResource(R.drawable.road_sign_ten);
                        findViewById(R.id.tenthImage).setOnDragListener(null);
                        points += 1;
                    }
                    if(v.getId() == R.id.eleventhImage)
                    {
                        tenthImg.setVisibility(View.INVISIBLE);
                        eleventhImageBoxV.setBackgroundResource(R.drawable.road_sign_ten);
                        findViewById(R.id.eleventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.twelvethImage)
                    {
                        tenthImg.setVisibility(View.INVISIBLE);
                        twelvethImageBoxV.setBackgroundResource(R.drawable.road_sign_ten);
                        findViewById(R.id.twelvethImage).setOnDragListener(null);
                    }
                }

                //##################################################################################
                if (view.getId() == R.id.roadSignEleven)
                {
                    if(v.getId() == R.id.firstImage)
                    {
                        eleventhImg.setVisibility(View.INVISIBLE);
                        firstImageBoxV.setBackgroundResource(R.drawable.road_sign_eleven);
                        findViewById(R.id.firstImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.secondImage)
                    {
                        eleventhImg.setVisibility(View.INVISIBLE);
                        secondImageBoxV.setBackgroundResource(R.drawable.road_sign_eleven);
                        findViewById(R.id.secondImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.thirdImage)
                    {
                        eleventhImg.setVisibility(View.INVISIBLE);
                        thirdImageBoxV.setBackgroundResource(R.drawable.road_sign_eleven);
                        findViewById(R.id.thirdImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fourthImage)
                    {
                        eleventhImg.setVisibility(View.INVISIBLE);
                        fourthImageBoxV.setBackgroundResource(R.drawable.road_sign_eleven);
                        findViewById(R.id.fourthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fifthImage)
                    {
                        eleventhImg.setVisibility(View.INVISIBLE);
                        fifthImageBoxV.setBackgroundResource(R.drawable.road_sign_eleven);
                        findViewById(R.id.fifthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.sixthImage)
                    {
                        eleventhImg.setVisibility(View.INVISIBLE);
                        sixthImageBoxV.setBackgroundResource(R.drawable.road_sign_eleven);
                        findViewById(R.id.sixthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.seventhImage)
                    {
                        eleventhImg.setVisibility(View.INVISIBLE);
                        seventhImageBoxV.setBackgroundResource(R.drawable.road_sign_eleven);
                        findViewById(R.id.seventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eightImage)
                    {
                        eleventhImg.setVisibility(View.INVISIBLE);
                        eightImageBoxV.setBackgroundResource(R.drawable.road_sign_eleven);
                        findViewById(R.id.eightImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.nithImage)
                    {
                        eleventhImg.setVisibility(View.INVISIBLE);
                        ninthImageBoxV.setBackgroundResource(R.drawable.road_sign_eleven);
                        findViewById(R.id.nithImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.tenthImage)
                    {
                        eleventhImg.setVisibility(View.INVISIBLE);
                        tenthImageBoxV.setBackgroundResource(R.drawable.road_sign_eleven);
                        findViewById(R.id.tenthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eleventhImage)
                    {
                        eleventhImg.setVisibility(View.INVISIBLE);
                        eleventhImageBoxV.setBackgroundResource(R.drawable.road_sign_eleven);
                        findViewById(R.id.eleventhImage).setOnDragListener(null);
                        points += 1;
                    }
                    if(v.getId() == R.id.twelvethImage)
                    {
                        eleventhImg.setVisibility(View.INVISIBLE);
                        twelvethImageBoxV.setBackgroundResource(R.drawable.road_sign_eleven);
                        findViewById(R.id.twelvethImage).setOnDragListener(null);
                    }
                }

                //##################################################################################
                if (view.getId() == R.id.roadSignTwelve)
                {
                    if(v.getId() == R.id.firstImage)
                    {
                        twelvethImg.setVisibility(View.INVISIBLE);
                        firstImageBoxV.setBackgroundResource(R.drawable.road_sign_twelve);
                        findViewById(R.id.firstImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.secondImage)
                    {
                        twelvethImg.setVisibility(View.INVISIBLE);
                        secondImageBoxV.setBackgroundResource(R.drawable.road_sign_twelve);
                        findViewById(R.id.secondImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.thirdImage)
                    {
                        twelvethImg.setVisibility(View.INVISIBLE);
                        thirdImageBoxV.setBackgroundResource(R.drawable.road_sign_twelve);
                        findViewById(R.id.thirdImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fourthImage)
                    {
                        twelvethImg.setVisibility(View.INVISIBLE);
                        fourthImageBoxV.setBackgroundResource(R.drawable.road_sign_twelve);
                        findViewById(R.id.fourthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fifthImage)
                    {
                        twelvethImg.setVisibility(View.INVISIBLE);
                        fifthImageBoxV.setBackgroundResource(R.drawable.road_sign_twelve);
                        findViewById(R.id.fifthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.sixthImage)
                    {
                        twelvethImg.setVisibility(View.INVISIBLE);
                        sixthImageBoxV.setBackgroundResource(R.drawable.road_sign_twelve);
                        findViewById(R.id.sixthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.seventhImage)
                    {
                        twelvethImg.setVisibility(View.INVISIBLE);
                        seventhImageBoxV.setBackgroundResource(R.drawable.road_sign_twelve);
                        findViewById(R.id.seventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eightImage)
                    {
                        twelvethImg.setVisibility(View.INVISIBLE);
                        eightImageBoxV.setBackgroundResource(R.drawable.road_sign_twelve);
                        findViewById(R.id.eightImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.nithImage)
                    {
                        twelvethImg.setVisibility(View.INVISIBLE);
                        ninthImageBoxV.setBackgroundResource(R.drawable.road_sign_twelve);
                        findViewById(R.id.nithImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.tenthImage)
                    {
                        twelvethImg.setVisibility(View.INVISIBLE);
                        tenthImageBoxV.setBackgroundResource(R.drawable.road_sign_twelve);
                        findViewById(R.id.tenthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eleventhImage)
                    {
                        twelvethImg.setVisibility(View.INVISIBLE);
                        eleventhImageBoxV.setBackgroundResource(R.drawable.road_sign_twelve);
                        findViewById(R.id.eleventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.twelvethImage)
                    {
                        twelvethImg.setVisibility(View.INVISIBLE);
                        twelvethImageBoxV.setBackgroundResource(R.drawable.road_sign_twelve);
                        findViewById(R.id.twelvethImage).setOnDragListener(null);
                        points += 1;
                    }
                }
                else
                {
                    System.out.println("Error");
                }
                break;
        }
        return true;
    }
}