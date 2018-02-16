package com.aadgroup.aadgroupwork;

import android.app.AlertDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class PathForming extends AppCompatActivity implements View.OnTouchListener{

    private DrawView drawView;
    public int clicked;
    public int answer = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.path_forming);

        drawView = new DrawView(this);
        drawView.setBackgroundColor(Color.WHITE);

        RelativeLayout container = findViewById(R.id.container);
        container.addView(drawView);

        container.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] xCords = drawView.getxCords();
        int[] yCords = drawView.getyCords();

        int mouseX = (int)motionEvent.getX();
        int mouseY = (int)motionEvent.getY();

        for(int i = 0; i < xCords.length; ++i)
        {
            int diffX = Math.abs(xCords[i] - mouseX);
            int diffY = Math.abs(yCords[i] - mouseY);

            if(diffX <= 100 && diffY <= 100)
            {
                clicked = i;

                if(answer != clicked)
                    Toast.makeText(this, "You are wrong", Toast.LENGTH_SHORT).show();
                else
                {
                    drawView.setClicked(i);
                    drawView.invalidate();
                    answer++;
                    Toast.makeText(this, "You are right", Toast.LENGTH_SHORT).show();

                    if(answer==5)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setCancelable(true);
                        builder.setTitle("Complete");
                        builder.setMessage("Congratulations you have finished correctly");
                        builder.setPositiveButton("OK", null);
                        builder.show();
                    }
                }
            }
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

