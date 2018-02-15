package com.aadgroup.aadgroupwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Danilo on 30/01/2018.
 */

public class RoadSign extends AppCompatActivity implements View.OnTouchListener, View.OnDragListener
{
    ImageView firstImg;
    Button resetButton;


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
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.road_sign);

/*        firstImg = (ImageView) findViewById(R.id.roadSignOne);
        firstImg.setOnTouchListener(this);*/

        //Road Signs
        findViewById(R.id.roadSignOne).setOnTouchListener(this);
        findViewById(R.id.roadSignTwo).setOnTouchListener(this);
        findViewById(R.id.roadSignThree).setOnTouchListener(this);
        findViewById(R.id.roadSignFour).setOnTouchListener(this);
        findViewById(R.id.roadSignFive).setOnTouchListener(this);
        findViewById(R.id.roadSignSix).setOnTouchListener(this);
        findViewById(R.id.roadSignSeven).setOnTouchListener(this);
        findViewById(R.id.roadSignEight).setOnTouchListener(this);
        findViewById(R.id.roadSignNine).setOnTouchListener(this);
        findViewById(R.id.roadSignTen).setOnTouchListener(this);
        findViewById(R.id.roadSignEleven).setOnTouchListener(this);

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
        firstImageBoxV.setOnDragListener(this);

        secondImageBoxV = (ImageView) findViewById(R.id.secondImageBox);
        secondImageBoxV.setOnDragListener(this);

        thirdImageBoxV = (ImageView) findViewById(R.id.thirdImageBox);
        thirdImageBoxV.setOnDragListener(this);

        thirdImageBoxV = (ImageView) findViewById(R.id.thirdImageBox);
        thirdImageBoxV.setOnDragListener(this);

        fourthImageBoxV = (ImageView) findViewById(R.id.fourthImageBox);
        fourthImageBoxV.setOnDragListener(this);

        fifthImageBoxV = (ImageView) findViewById(R.id.fifthImageBox);
        fifthImageBoxV.setOnDragListener(this);

        sixthImageBoxV = (ImageView) findViewById(R.id.sixthImageBox);
        sixthImageBoxV.setOnDragListener(this);

        seventhImageBoxV = (ImageView) findViewById(R.id.seventhImageBox);
        seventhImageBoxV.setOnDragListener(this);

        eightImageBoxV = (ImageView) findViewById(R.id.eightImageBox);
        eightImageBoxV.setOnDragListener(this);

        ninthImageBoxV = (ImageView) findViewById(R.id.ninthImageBox);
        ninthImageBoxV.setOnDragListener(this);

        tenthImageBoxV = (ImageView) findViewById(R.id.tenthImageBox);
        tenthImageBoxV.setOnDragListener(this);

        eleventhImageBoxV = (ImageView) findViewById(R.id.eleventhImageBox);
        eleventhImageBoxV.setOnDragListener(this);

        twelvethImageBoxV = (ImageView) findViewById(R.id.twelvethImageBox);
        twelvethImageBoxV.setOnDragListener(this);


        resetButton = (Button) findViewById(R.id.resetButtonRoadSign);
        resetButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent myIntent = new Intent(getApplicationContext(), RoadSign.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    public boolean onTouch(View v, MotionEvent e)
    {
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
        final int action = event.getAction();
        View view = (View) event.getLocalState();
        switch (action)
        {
            case DragEvent.ACTION_DROP:
                /*if(view.getId() == R.id.roadSignOne && v.getId() == R.id.firstImage)
                {
                    ViewGroup vGroup = (ViewGroup) view.getParent();
                    vGroup.removeView(view);
                    v.setBackgroundResource(R.drawable.road_sign_one);
                    //v.setBackgroundResource(firstImg);

                    return true;
                }*/
                if(view.getId() == R.id.roadSignOne)
                {
                    ViewGroup vGroup = (ViewGroup) view.getParent();
                    vGroup.removeView(view);
                    v.setBackgroundResource(R.drawable.road_sign_one);
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
