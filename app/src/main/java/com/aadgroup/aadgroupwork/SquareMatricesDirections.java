package com.aadgroup.aadgroupwork;

import android.app.Activity;
import android.content.ClipData;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Danilo on 30/01/2018.
 */

public class SquareMatricesDirections extends Activity implements View.OnTouchListener, View.OnDragListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.square_matrices_directions);
        findViewById(R.id.answer1).setOnTouchListener(this);
        findViewById(R.id.dragAnswer).setOnTouchListener(this);

        findViewById(R.id.imageView12).setOnDragListener(this);

        System.out.print("test");
    }


    @Override
    public boolean onDrag(View v, DragEvent event) {
        // TODO Auto-generated method stub
        if(event.getAction()==DragEvent.ACTION_DROP){
            //we want to make sure it is dropped only to left and right parent view
            View view = (View)event.getLocalState();

            if(v.getId() == R.id.imageView12)
            {

                ViewGroup source = (ViewGroup) view.getParent();
                source.removeView(view);

                LinearLayout target = (LinearLayout) v;
                target.addView(view);
            }
            //make view visible as we set visibility to invisible while starting drag
            view.setVisibility(View.VISIBLE);
        }
        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        // TODO Auto-generated method stub
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
            view.startDrag(null, shadowBuilder, view, 0);
            view.setVisibility(View.INVISIBLE);
            return true;
        }
        return false;
    }
}
