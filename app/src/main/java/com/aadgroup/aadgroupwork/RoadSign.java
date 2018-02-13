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
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.road_sign);

        firstImg = (ImageView) findViewById(R.id.roadSignOne);
        firstImg.setOnTouchListener(this);
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
