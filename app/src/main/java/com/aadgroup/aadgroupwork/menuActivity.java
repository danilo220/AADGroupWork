package com.aadgroup.aadgroupwork;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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
    ImageView dotInfo, compassInfo, roadInfo, formInfo, directionInfo;


    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
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
        getData();

        int dotFinish = 1;
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

        /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Hint " + totalHints);
        builder.setMessage("position the cards shown below so that\n" +
                "each car is travelling in the direction indicated by the bottom arrows and\n" +
                "each lorry in the direction indicated by the arrows on the left side.");
        builder.setPositiveButton("OK", null);
        builder.show();*/

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

    private void getData(){
        //FirebaseUser user = mAuth.getCurrentUser();
        //String test = FirebaseDatabase.getInstance().getReference("Email");
        System.out.println(databaseReference + "COLLECTED");


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
