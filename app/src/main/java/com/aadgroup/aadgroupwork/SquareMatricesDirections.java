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
import android.view.View.DragShadowBuilder;

/**
 * Created by Danilo on 30/01/2018.
 */

public class SquareMatricesDirections extends Activity implements View.OnTouchListener, View.OnDragListener {
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.square_matrices_directions);

        findViewById(R.id.dragAnswer).setOnTouchListener(this);

        findViewById(R.id.imageView21).setOnDragListener(this);
        findViewById(R.id.textToChange).setOnDragListener(this);

        txt = (TextView) findViewById(R.id.textChange);
    }


    @Override
    public boolean onTouch(View v, MotionEvent e) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(null, shadowBuilder, v, 0);
            v.setVisibility(View.VISIBLE);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onDrag(View v, DragEvent e) {
        int action = e.getAction();
        View view = (View) e.getLocalState();
        switch (e.getAction()) {
            case DragEvent.ACTION_DROP:
                if (view.getId() == R.id.dragAnswer && v.getId() == R.id.imageView21) {
                    ViewGroup from = (ViewGroup) view.getParent();
                    from.removeView(view);
                    v.setBackgroundResource(R.drawable.directions21);//TODO: change this pseudo code.
                    System.out.print("Not working");
                    return true;
                }
                else{

                }
                break;

        }
        return true;
    }
}

