package com.aadgroup.aadgroupwork;

import android.content.ClipData;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Danilo on 30/01/2018.
 */

public class SquareMatricesDirections extends AppCompatActivity
{
    ImageView iv2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.square_matrices_directions);

        iv2 = (ImageView) findViewById(R.id.imageView2);
        iv2.setOnTouchListener(new choiceListener());
    }

    private final class choiceListener implements View.OnTouchListener {
        @Override

        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN && ((ImageView) v).getDrawable() != null) {
                ClipData data = ClipData.newPlainText("","");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                v.startDrag(data,shadowBuilder,0,0);
                return true;
            }
            else{
            }
            return false;
        }
    }

/*    private class ChoiceDragListener implements View.onDragListener{

        public boolean onDrag(View v, DragEvent event){
        return false;
        }

    }*/

}
