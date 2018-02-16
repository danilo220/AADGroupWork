package com.aadgroup.aadgroupwork;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class menuActivity extends AppCompatActivity {
    TextView dotCancel, directions, roadsigns, compass, pathformer, score;
    ImageView dotInfo, compassInfo, roadInfo, formInfo, directionInfo;

    TestResults allResults;
    ArrayList<Integer> testFinish = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        if (intent.hasExtra("TestResults")) {
            allResults = (TestResults) intent.getSerializableExtra("TestResults");
        }
        else {
            allResults = new TestResults();
        }

        if (intent.hasExtra("TestFinish")) {
            testFinish = getIntent().getIntegerArrayListExtra("TestFinish");
        }
        else
        {
            testFinish.add(0);
            testFinish.add(0);
            testFinish.add(0);
            testFinish.add(0);
        }

        dotCancel = findViewById(R.id.dotcancel);
        directions = findViewById(R.id.directions);
        roadsigns = findViewById(R.id.roadsign);
        compass = findViewById(R.id.compass);
        pathformer = findViewById(R.id.pathforming);

        dotCancel.setPaintFlags(dotCancel.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
        dotCancel.setOnClickListener(new TextView.OnClickListener(){
            public void onClick(View v){
                if (testFinish.get(0) == 0) {
                    Intent intent = new Intent(getApplicationContext(), DotCancellation.class);
                    intent.putExtra("TestResults", allResults);
                    intent.putIntegerArrayListExtra("TestFinish", testFinish);
                    startActivity(intent);
                }
            }
        });

        dotInfo = (ImageView) findViewById(R.id.dotInfo);
        compassInfo = (ImageView) findViewById(R.id.compassInfo);
        roadInfo = (ImageView) findViewById(R.id.roadInfo);
        formInfo = (ImageView) findViewById(R.id.formInfo);
        directionInfo = (ImageView) findViewById(R.id.directionInfo);

        dotInfo.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                giveDotInfo();
            }
        });

        formInfo.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                givePathInfo();
            }
        });

        compassInfo.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                giveCompassInfo();
            }
        });

        roadInfo.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                giveRoadSignsInfo();
            }
        });

        directionInfo.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                giveDirectionInfo();
            }
        });

        pathformer.setOnClickListener(new TextView.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), PathForming.class);
                intent.putExtra("TestResults", allResults);
                intent.putIntegerArrayListExtra("TestFinish", testFinish);
                startActivity(intent);
            }
        });

        if (testFinish.get(0) == 1){
            dotCancel.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            directions.setPaintFlags(directions.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
            directions.setOnClickListener(new TextView.OnClickListener(){
                public void onClick(View v){
                    if (testFinish.get(1) == 0) {
                        Intent intent = new Intent(getApplicationContext(), SquareMatricesDirections.class);
                        intent.putExtra("TestResults", allResults);
                        intent.putIntegerArrayListExtra("TestFinish", testFinish);
                        startActivity(intent);
                    }
                }
            });
        }

        if (testFinish.get(1) == 1){
            directions.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            compass.setPaintFlags(compass.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
            compass.setOnClickListener(new TextView.OnClickListener(){
                public void onClick(View v){
                    if (testFinish.get(2) == 0) {
                        Intent intent = new Intent(getApplicationContext(), SquareMatricesCompass.class);
                        intent.putExtra("TestResults", allResults);
                        intent.putIntegerArrayListExtra("TestFinish", testFinish);
                        startActivity(intent);
                    }
                }
            });
        }

        if (testFinish.get(2) == 1){
            compass.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            roadsigns.setPaintFlags(roadsigns.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
            roadsigns.setOnClickListener(new TextView.OnClickListener(){
                public void onClick(View v){
                    if (testFinish.get(3) == 0) {
                        Intent intent = new Intent(getApplicationContext(), RoadSign.class);
                        intent.putExtra("TestResults", allResults);
                        intent.putIntegerArrayListExtra("TestFinish", testFinish);
                        startActivity(intent);
                    }
                }
            });
        }

        if (testFinish.get(3) == 1)
        {
            roadsigns.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        }

        score = findViewById(R.id.score);
        score.setOnClickListener(new TextView.OnClickListener(){
            public void onClick(View v){
                if (testFinish.get(3) == 1) {
                    score.setPaintFlags(score.getPaintFlags() | Paint.FAKE_BOLD_TEXT_FLAG);
                    Intent intent = new Intent(getApplicationContext(), Results.class);
                    intent.putExtra("TestResults", allResults);
                    intent.putIntegerArrayListExtra("TestFinish", testFinish);
                    startActivity(intent);
                }
            }
        });
    }

    private void giveDotInfo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Information");
        builder.setMessage("You will see that there are groups of dots arranged in rows. Some of the\n" +
                "groups have 3 dots, some 4 and some 5 dots (indicate examples on the\n" +
                "practice row). I want you to cross out every group of 4 dots.");
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    private void giveCompassInfo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Information");
        builder.setMessage("This time the black arm of the compass indicates a direction of travel”\n" +
                "Demonstrate the directions by pointing to each card and indicating the\n" +
                "direction it shows.\n" +
                "“Can you now, as you did before, position these cards on the grid, so that\n" +
                "each of the vehicles on these cards (point to the pile of Directions cards)\n" +
                "goes in the direction indicated on the compass cards? (point to the\n" +
                "Compass cards). The roundabout sign (point to the roundabout sign) is\n" +
                "always at the bottom. There are more cards than available spaces, so\n" +
                "some of the cards will not fit in. I will do the first one as an example.");
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    private void giveDirectionInfo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Information");
        builder.setMessage("The large arrows correspond to the lorries and the small arrows to the\n" +
                "cars. Each arrow indicates a direction of travel.” (Demonstrate right, left,\n" +
                "upwards as away and downwards as towards Arrows facing north‟\n" +
                "indicate the vehicle is travelling away from the client, arrows facing „south‟\n" +
                "indicate the vehicle is travelling towards the client.");
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    private void givePathInfo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Information");
        builder.setMessage("Click the numbers in order in order for the game to finish.");
        builder.setPositiveButton("OK", null);
        builder.show();
    }

    private void giveRoadSignsInfo(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Information");
        builder.setMessage("Put each road sign on the picture of the road situation\n" +
                "which it matches best. This card shows a broken traffic light (point to the\n" +
                "example road situation card). The sign which best matches this situation\n" +
                "is the one indicating a traffic light (pick out the broken traffic light road\n" +
                "sign). So this sign (traffic light) goes with this picture. (Place the traffic\n" +
                "light road sign on the example card and move to one side). Now you do\n" +
                "the rest.” Put the example card with the example sign on top of it to one\n" +
                "side.");
        builder.setPositiveButton("OK", null);
        builder.show();
    }
}
