package com.aadgroup.aadgroupwork;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.DateFormat;
import java.util.Date;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class menuActivity extends AppCompatActivity {
    TextView dotCancel, directions, roadsigns, compass, pathformer, score;
    DatabaseReference databaseReference;
    //Firebase firebaseReference;

    FirebaseUser user;
    String uid;

    List<String> itemlist = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();

        addData();

        int dotFinish = 0;
        int directionsFinish = 0;
        int roadSignsFinish = 0;
        int compassFinish = 0;
        int pathformFinish = 0;

        dotCancel = findViewById(R.id.dotcancel);
        directions = findViewById(R.id.directions);
        roadsigns = findViewById(R.id.roadsign);
        compass = findViewById(R.id.compass);
        pathformer = findViewById(R.id.pathforming);

        dotCancel.setOnClickListener(new TextView.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), DotCancellation.class);
                startActivity(intent);
            }
        });

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

    private void addData(){
        databaseReference = FirebaseDatabase.getInstance().getReference();
        String userID = uid;
        String result = "pass";

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();

        databaseReference.child("users").child(userID).setValue(userID);
        databaseReference.child("users").child(userID).child("Email").setValue(email);
        databaseReference.child("users").child(userID).child("Result").setValue(result);
        databaseReference.child("users").child(userID).child("Date & Time").setValue(currentDateTimeString);
    }

/*    private void go(){
        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.addValueEventListener (new ValueEventListener(){
            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                itemlist.clear();

                String userResult = dataSnapshot.child(uid).child("Result").getValue(String.class);
                String resultDate = dataSnapshot.child(uid).child("Date").getValue(String.class);

                itemlist.add(userResult);
                itemlist.add(resultDate);
            }


    }*/

    protected void onStart(){
        super.onStart();
        score = (TextView) findViewById(R.id.score);
    }

}
