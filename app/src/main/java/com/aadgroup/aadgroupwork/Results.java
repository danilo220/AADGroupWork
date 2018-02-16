package com.aadgroup.aadgroupwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Date;

public class Results extends AppCompatActivity {

    TestResults allResults;
    DatabaseReference databaseReference;
    FirebaseUser user;
    String uid;
    String username;
    String result;
    String date;
    Boolean clinician;

    TextView dotTime, dotMissed, dotFalsePositives, direction, compass, roadSign, passOrFail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        getData();

        Intent intent = getIntent();
        if (intent.hasExtra("TestResults")) {
            allResults = (TestResults) intent.getSerializableExtra("TestResults");
        }
        else
        {
            allResults = new TestResults();
        }

        dotTime = findViewById(R.id.tv_dc_time);
        dotTime.setText(dotTime.getText() + Integer.toString(allResults.getTime()));

        dotMissed = findViewById(R.id.tv_dc_missed);
        dotMissed.setText(dotMissed.getText() + Integer.toString(allResults.getMissed()));

        dotFalsePositives = findViewById(R.id.tv_dc_falsePositives);
        dotFalsePositives.setText(dotFalsePositives.getText() + Integer.toString(allResults.getFalsePositives()));

        direction = findViewById(R.id.tv_directions);
        direction.setText(direction.getText() + Integer.toString(allResults.getSquareMatriciesDirectionScore()));

        compass = findViewById(R.id.tv_compass);
        compass.setText(compass.getText() + Integer.toString(allResults.getSquareMatriciesCompassScore()));

        roadSign = findViewById(R.id.tv_roadsigns);
        roadSign.setText(roadSign.getText() + Integer.toString(allResults.getRoadSignRecognitionScore()));

        addResult();
    }

    private void addResult(){
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        databaseReference.child("users").child(uid).child("Date & Time").setValue(currentDateTimeString);

        passOrFail = findViewById(R.id.tv_pass);
        if (allResults.passTests())
        {
            passOrFail.setText("PASS! :)");
            databaseReference.child("users").child(uid).child("Result").setValue("Pass");
        }
        else
        {
            passOrFail.setText("FAIL! :(");
            databaseReference.child("users").child(uid).child("Result").setValue("Fail");
        }
    }

    public void getData() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                username = dataSnapshot.child("users").child(uid).child("Email").getValue(String.class);
                result = dataSnapshot.child("users").child(uid).child("Result").getValue(String.class);
                date = dataSnapshot.child("users").child(uid).child("Date & Time").getValue(String.class);
                clinician = dataSnapshot.child("users").child(uid).child("Clinician").getValue(Boolean.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
