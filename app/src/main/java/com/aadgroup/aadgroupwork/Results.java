package com.aadgroup.aadgroupwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Results extends AppCompatActivity {

    Account loggedInAcc;
    TestResults allResults;

    TextView dotTime, dotMissed, dotFalsePositives, direction, compass, roadSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        if (intent.hasExtra("AccountDetails")) {
            loggedInAcc = (Account) intent.getSerializableExtra("AccountDetails");
        }
        if (intent.hasExtra("TestResults")) {
            allResults = (TestResults) intent.getSerializableExtra("TestResults");
        }
        else
        {
            allResults = new TestResults();
            allResults.setDotCancellationResults(9000, 500, 100);
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
    }
}
