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
    Button resetButton;
    //Road Signs
    ImageView firstImg;
    ImageView secondImg;
    ImageView thirdImg;
    ImageView fourthImg;
    ImageView fifthImg;
    ImageView sixthImage;
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
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.road_sign);

/*        firstImg = (ImageView) findViewById(R.id.roadSignOne);
        firstImg.setOnTouchListener(this);*/

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

        sixthImage = (ImageView) findViewById(R.id.roadSignSix);
        sixthImage.setOnTouchListener(this);

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
                if (view.getId() == R.id.roadSignOne)
                {
                    if(v.getId() == R.id.firstImage)
                    {
/*                        ViewGroup vGroup = (ViewGroup) view.getParent();
                        vGroup.removeView(view);*/
                        firstImg.setVisibility(View.INVISIBLE);
                        firstImageBoxV.setBackgroundResource(R.drawable.road_sign_one);
                        findViewById(R.id.firstImage).setOnDragListener(null);
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
                        fourthImg.setVisibility(View.INVISIBLE);
                        firstImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.firstImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.secondImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        secondImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.secondImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.thirdImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        thirdImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.thirdImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fourthImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        fourthImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.fourthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.fifthImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        fifthImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.fifthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.sixthImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        sixthImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.sixthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.seventhImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        seventhImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.seventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eightImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        eightImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.eightImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.nithImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        ninthImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.nithImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.tenthImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        tenthImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.tenthImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.eleventhImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        eleventhImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.eleventhImage).setOnDragListener(null);
                    }
                    if(v.getId() == R.id.twelvethImage)
                    {
                        fourthImg.setVisibility(View.INVISIBLE);
                        twelvethImageBoxV.setBackgroundResource(R.drawable.road_sign_five);
                        findViewById(R.id.twelvethImage).setOnDragListener(null);
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
