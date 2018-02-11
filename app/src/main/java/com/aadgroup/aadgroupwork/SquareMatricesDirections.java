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
    public int choosePicture;
    ImageView a41, a42, a43, a44, a31, a32, a33, a34, a21, a22, a23, a24, a11, a12, a13, a14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.square_matrices_directions);

        findViewById(R.id.dragAnswer41).setOnTouchListener(this);
        findViewById(R.id.dragAnswer42).setOnTouchListener(this);
        findViewById(R.id.dragAnswer43).setOnTouchListener(this);
        findViewById(R.id.dragAnswer44).setOnTouchListener(this);
        findViewById(R.id.dragAnswer31).setOnTouchListener(this);
        findViewById(R.id.dragAnswer32).setOnTouchListener(this);
        findViewById(R.id.dragAnswer33).setOnTouchListener(this);
        findViewById(R.id.dragAnswer34).setOnTouchListener(this);
        findViewById(R.id.dragAnswer21).setOnTouchListener(this);
        findViewById(R.id.dragAnswer22).setOnTouchListener(this);
        findViewById(R.id.dragAnswer23).setOnTouchListener(this);
        findViewById(R.id.dragAnswer24).setOnTouchListener(this);
        findViewById(R.id.dragAnswer11).setOnTouchListener(this);
        findViewById(R.id.dragAnswer12).setOnTouchListener(this);
        findViewById(R.id.dragAnswer13).setOnTouchListener(this);
        findViewById(R.id.dragAnswer14).setOnTouchListener(this);


        findViewById(R.id.box41).setOnDragListener(this);
        findViewById(R.id.box42).setOnDragListener(this);
        findViewById(R.id.box43).setOnDragListener(this);
        findViewById(R.id.box44).setOnDragListener(this);
        findViewById(R.id.box31).setOnDragListener(this);
        findViewById(R.id.box32).setOnDragListener(this);
        findViewById(R.id.box33).setOnDragListener(this);
        findViewById(R.id.box34).setOnDragListener(this);
        findViewById(R.id.box21).setOnDragListener(this);
        findViewById(R.id.box22).setOnDragListener(this);
        findViewById(R.id.box23).setOnDragListener(this);
        findViewById(R.id.box24).setOnDragListener(this);
        findViewById(R.id.box11).setOnDragListener(this);
        findViewById(R.id.box12).setOnDragListener(this);
        findViewById(R.id.box13).setOnDragListener(this);
        findViewById(R.id.box14).setOnDragListener(this);

        //a41 = (ImageView) findViewById(R.id.dragAnswer41);
       // a41.setVisibility(View.INVISIBLE);
        a42 = (ImageView) findViewById(R.id.dragAnswer42);
        a42.setVisibility(View.INVISIBLE);
        a43 = (ImageView) findViewById(R.id.dragAnswer43);
        a43.setVisibility(View.INVISIBLE);
        a44 = (ImageView) findViewById(R.id.dragAnswer44);
        a44.setVisibility(View.INVISIBLE);

        a31 = (ImageView) findViewById(R.id.dragAnswer31);
        a31.setVisibility(View.INVISIBLE);
        a32 = (ImageView) findViewById(R.id.dragAnswer32);
        a32.setVisibility(View.INVISIBLE);
        a33 = (ImageView) findViewById(R.id.dragAnswer33);
        a33.setVisibility(View.INVISIBLE);
        a34 = (ImageView) findViewById(R.id.dragAnswer34);
        a34.setVisibility(View.INVISIBLE);

        a21 = (ImageView) findViewById(R.id.dragAnswer21);
        a21.setVisibility(View.INVISIBLE);
        a22 = (ImageView) findViewById(R.id.dragAnswer22);
        a22.setVisibility(View.INVISIBLE);
        a23 = (ImageView) findViewById(R.id.dragAnswer23);
        a23.setVisibility(View.INVISIBLE);
        a24 = (ImageView) findViewById(R.id.dragAnswer24);
        a24.setVisibility(View.INVISIBLE);

        a11 = (ImageView) findViewById(R.id.dragAnswer11);
        a11.setVisibility(View.INVISIBLE);
        a12 = (ImageView) findViewById(R.id.dragAnswer12);
        a12.setVisibility(View.INVISIBLE);
        a13 = (ImageView) findViewById(R.id.dragAnswer13);
        a13.setVisibility(View.INVISIBLE);
        a14 = (ImageView) findViewById(R.id.dragAnswer14);
        a14.setVisibility(View.INVISIBLE);
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
        int choosePicture = 0;
        View view = (View) e.getLocalState();
        switch (e.getAction()) {
            case DragEvent.ACTION_DROP:
                if (view.getId() == R.id.dragAnswer41 && v.getId() == R.id.box41) {
                    ViewGroup from = (ViewGroup) view.getParent();
                    from.removeView(view);
                    v.setBackgroundResource(R.drawable.directions41);//TODO: change this pseudo code.
                    a42.setVisibility(View.VISIBLE);
                    System.out.print(choosePicture);
                    return true;
                }
                else if (view.getId() == R.id.dragAnswer42 && v.getId() == R.id.box42) {
                    ViewGroup from = (ViewGroup) view.getParent();
                    from.removeView(view);
                    v.setBackgroundResource(R.drawable.directions42);//TODO: change this pseudo code.
                    a43.setVisibility(View.VISIBLE);
                    return true;
                }
                else if (view.getId() == R.id.dragAnswer43 && v.getId() == R.id.box43) {
                    ViewGroup from = (ViewGroup) view.getParent();
                    from.removeView(view);
                    v.setBackgroundResource(R.drawable.directions43);//TODO: change this pseudo code.
                    a44.setVisibility(View.VISIBLE);
                    return true;
                }
                else if (view.getId() == R.id.dragAnswer44 && v.getId() == R.id.box44) {
                    ViewGroup from = (ViewGroup) view.getParent();
                    from.removeView(view);
                    v.setBackgroundResource(R.drawable.directions44);//TODO: change this pseudo code.
                    a31.setVisibility(View.VISIBLE);
                    return true;
                }
                else if (view.getId() == R.id.dragAnswer31 && v.getId() == R.id.box31) {
                    ViewGroup from = (ViewGroup) view.getParent();
                    from.removeView(view);
                    v.setBackgroundResource(R.drawable.directions31);//TODO: change this pseudo code.
                    a32.setVisibility(View.VISIBLE);
                    return true;
                }
                else if (view.getId() == R.id.dragAnswer32 && v.getId() == R.id.box32) {
                    ViewGroup from = (ViewGroup) view.getParent();
                    from.removeView(view);
                    v.setBackgroundResource(R.drawable.directions43);//TODO: change this pseudo code.
                    a33.setVisibility(View.VISIBLE);
                    return true;
                }
                else if (view.getId() == R.id.dragAnswer33 && v.getId() == R.id.box33) {
                    ViewGroup from = (ViewGroup) view.getParent();
                    from.removeView(view);
                    v.setBackgroundResource(R.drawable.directions33);//TODO: change this pseudo code.
                    a34.setVisibility(View.VISIBLE);
                    return true;
                }
                else if (view.getId() == R.id.dragAnswer34 && v.getId() == R.id.box34) {
                    ViewGroup from = (ViewGroup) view.getParent();
                    from.removeView(view);
                    v.setBackgroundResource(R.drawable.directions34);//TODO: change this pseudo code.
                    a21.setVisibility(View.VISIBLE);
                    return true;
                }
                else if (view.getId() == R.id.dragAnswer21&& v.getId() == R.id.box21) {
                    ViewGroup from = (ViewGroup) view.getParent();
                    from.removeView(view);
                    v.setBackgroundResource(R.drawable.directions21);//TODO: change this pseudo code.
                    a22.setVisibility(View.VISIBLE);
                    return true;
                }
                else if (view.getId() == R.id.dragAnswer22&& v.getId() == R.id.box22) {
                    ViewGroup from = (ViewGroup) view.getParent();
                    from.removeView(view);
                    v.setBackgroundResource(R.drawable.directions22);//TODO: change this pseudo code.
                    a23.setVisibility(View.VISIBLE);
                    return true;
                }
                else if (view.getId() == R.id.dragAnswer23&& v.getId() == R.id.box23) {
                    ViewGroup from = (ViewGroup) view.getParent();
                    from.removeView(view);
                    v.setBackgroundResource(R.drawable.directions23);//TODO: change this pseudo code.
                    a24.setVisibility(View.VISIBLE);
                    return true;
                }
                else if (view.getId() == R.id.dragAnswer24&& v.getId() == R.id.box24) {
                    ViewGroup from = (ViewGroup) view.getParent();
                    from.removeView(view);
                    v.setBackgroundResource(R.drawable.directions24);//TODO: change this pseudo code.
                    a11.setVisibility(View.VISIBLE);
                    return true;
                }
                else if (view.getId() == R.id.dragAnswer11&& v.getId() == R.id.box11) {
                    ViewGroup from = (ViewGroup) view.getParent();
                    from.removeView(view);
                    v.setBackgroundResource(R.drawable.directions11);//TODO: change this pseudo code.
                    a12.setVisibility(View.VISIBLE);
                    return true;
                }
                else if (view.getId() == R.id.dragAnswer12&& v.getId() == R.id.box12) {
                    ViewGroup from = (ViewGroup) view.getParent();
                    from.removeView(view);
                    v.setBackgroundResource(R.drawable.directions12);//TODO: change this pseudo code.
                    a13.setVisibility(View.VISIBLE);
                    return true;
                }
                else if (view.getId() == R.id.dragAnswer13&& v.getId() == R.id.box13) {
                    ViewGroup from = (ViewGroup) view.getParent();
                    from.removeView(view);
                    v.setBackgroundResource(R.drawable.directions13);//TODO: change this pseudo code.
                    a14.setVisibility(View.VISIBLE);
                    return true;
                }
                else if (view.getId() == R.id.dragAnswer14&& v.getId() == R.id.box14) {
                    ViewGroup from = (ViewGroup) view.getParent();
                    from.removeView(view);
                    v.setBackgroundResource(R.drawable.directions14);//TODO: change this pseudo code.
                    //a14.setVisibility(View.VISIBLE);
                    return true;
                }



                else{

                }
                break;
        }
        return true;
    }
}

