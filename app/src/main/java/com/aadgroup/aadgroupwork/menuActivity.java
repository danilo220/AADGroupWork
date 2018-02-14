package com.aadgroup.aadgroupwork;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class menuActivity extends AppCompatActivity {
    TextView dotCancel, directions, roadsigns, compass, pathformer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        dotCancel = findViewById(R.id.dotcancel);
        dotCancel.setOnClickListener(new TextView.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), DotCancellation.class);
                startActivity(intent);
            }
        });

        int dotFinish = 0;
        int directionsFinish = 0;
        int roadSignsFinish = 1;
        int compassFinish = 0;
        int pathformFinish = 1;

        directions = findViewById(R.id.directions);
        roadsigns = findViewById(R.id.roadsign);
        compass = findViewById(R.id.compass);
        pathformer = findViewById(R.id.pathforming);

        if (dotFinish == 1){
            dotCancel.setPaintFlags(dotCancel.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            directions.setOnClickListener(new TextView.OnClickListener(){
                public void onClick(View v){
                    Intent intent = new Intent(getApplicationContext(), SquareMatricesDirections.class);
                    startActivity(intent);
                }
            });
        }
        if (directionsFinish == 1){
            directions.setPaintFlags(directions.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            compass.setOnClickListener(new TextView.OnClickListener(){
                public void onClick(View v){
                    Intent intent = new Intent(getApplicationContext(), SquareMatricesCompass.class);
                    startActivity(intent);
                }
            });

        }
        if (compassFinish == 1){
            compass.setPaintFlags(compass.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            roadsigns.setOnClickListener(new TextView.OnClickListener(){
                public void onClick(View v){
                    Intent intent = new Intent(getApplicationContext(), RoadSign.class);
                    startActivity(intent);
                }
            });

        }
        if (roadSignsFinish == 1){
            roadsigns.setPaintFlags(roadsigns.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

            pathformer.setOnClickListener(new TextView.OnClickListener(){
                public void onClick(View v){
                    Intent intent = new Intent(getApplicationContext(), PathForming.class);
                    startActivity(intent);
                }
            });
        }
        if (pathformFinish == 1){
            pathformer.setPaintFlags(pathformer.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }

    }
}
