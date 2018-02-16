package com.aadgroup.aadgroupwork;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class SquareMatricesCompass extends Activity implements View.OnTouchListener, View.OnDragListener {
    public int choosePicture;
    ImageView a41, a42, a43, a44, a31, a32, a33, a34, a21, a22, a23, a24, a11, a12, a13, a14, b1, b2, b3, b4, b5, b6, b7, b8 ,b9, b10, hint;
    Button menuButton;
    TextView timerText, hintText;
    //ArrayList<String> previousLocation = new ArrayList<String>();
    //ArrayList<String> previousCard = new ArrayList<String>();
    ArrayList<Integer> number = new ArrayList<Integer>();

    //int wrongAnswer = 0;
    int points = 0;
    int totalHints = 2;
    //pushing

    Account loggedInAcc;
    TestResults allResults;
    ArrayList<Integer> testFinish = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Integer> number = new ArrayList<Integer>();
        setContentView(R.layout.square_matrices_compass);

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
        }
        if (intent.hasExtra("TestFinish")) {
            testFinish = (ArrayList<Integer>) getIntent().getIntegerArrayListExtra("TestFinish");
        }
        else
        {
            testFinish.add(0);
            testFinish.add(0);
            testFinish.add(0);
            testFinish.add(0);
        }

        Button resetButton = findViewById(R.id.resetButton);
        final Button startButton = findViewById(R.id.start);
        final TextView timerText = findViewById(R.id.textTimer);

        menuButton = findViewById(R.id.Menu);
        menuButton.setVisibility(View.INVISIBLE);

        hintText = (TextView)findViewById(R.id.hintText);
        hint = (ImageView) findViewById(R.id.hint);

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

        //wrong answers
        findViewById(R.id.dragAnswer).setOnTouchListener(this);
        findViewById(R.id.dragAnswer2).setOnTouchListener(this);
        findViewById(R.id.dragAnswer3).setOnTouchListener(this);
        findViewById(R.id.dragAnswer4).setOnTouchListener(this);
        findViewById(R.id.dragAnswer5).setOnTouchListener(this);
        findViewById(R.id.dragAnswer6).setOnTouchListener(this);
        findViewById(R.id.dragAnswer7).setOnTouchListener(this);
        findViewById(R.id.dragAnswer8).setOnTouchListener(this);
        findViewById(R.id.dragAnswer9).setOnTouchListener(this);
        findViewById(R.id.dragAnswer10).setOnTouchListener(this);

        findViewById(R.id.bin).setOnDragListener(this);
        //wrong answers

        a41 = (ImageView) findViewById(R.id.dragAnswer41);
        a42 = (ImageView) findViewById(R.id.dragAnswer42);
        a43 = (ImageView) findViewById(R.id.dragAnswer43);
        a44 = (ImageView) findViewById(R.id.dragAnswer44);
        a31 = (ImageView) findViewById(R.id.dragAnswer31);
        a32 = (ImageView) findViewById(R.id.dragAnswer32);
        a33 = (ImageView) findViewById(R.id.dragAnswer33);
        a34 = (ImageView) findViewById(R.id.dragAnswer34);
        a21 = (ImageView) findViewById(R.id.dragAnswer21);
        a22 = (ImageView) findViewById(R.id.dragAnswer22);
        a23 = (ImageView) findViewById(R.id.dragAnswer23);
        a24 = (ImageView) findViewById(R.id.dragAnswer24);
        a11 = (ImageView) findViewById(R.id.dragAnswer11);
        a12 = (ImageView) findViewById(R.id.dragAnswer12);
        a13 = (ImageView) findViewById(R.id.dragAnswer13);
        a14 = (ImageView) findViewById(R.id.dragAnswer14);

        b1 = (ImageView) findViewById(R.id.dragAnswer);
        b2 = (ImageView) findViewById(R.id.dragAnswer2);
        b3 = (ImageView) findViewById(R.id.dragAnswer3);
        b4 = (ImageView) findViewById(R.id.dragAnswer4);
        b5 = (ImageView) findViewById(R.id.dragAnswer5);
        b6 = (ImageView) findViewById(R.id.dragAnswer6);
        b7 = (ImageView) findViewById(R.id.dragAnswer7);
        b8 = (ImageView) findViewById(R.id.dragAnswer8);
        b9 = (ImageView) findViewById(R.id.dragAnswer9);
        b10 = (ImageView) findViewById(R.id.dragAnswer10);
        resetListeners();

        findViewById(R.id.bin).setOnDragListener(this);


        hint.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                getHint();
            }
        });


        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), menuActivity.class);
                allResults.setSquareMatriciesDirectionScore(points);
                intent.putExtra("AccountDetails", loggedInAcc);
                intent.putExtra("TestResults", allResults);
                testFinish.set(2, 1);
                intent.putIntegerArrayListExtra("TestFinish", testFinish);
                startActivity(intent);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //finish();
                //Intent myIntent = new Intent(getApplicationContext(), SquareMatricesDirections.class);
                //startActivity(myIntent);

                points = 0;
                resetListeners();

                random();
                randomPicture();

                findViewById(R.id.box41).setBackgroundResource(0);
                findViewById(R.id.box42).setBackgroundResource(0);
                findViewById(R.id.box43).setBackgroundResource(0);
                findViewById(R.id.box44).setBackgroundResource(0);
                findViewById(R.id.box31).setBackgroundResource(0);
                findViewById(R.id.box32).setBackgroundResource(0);
                findViewById(R.id.box33).setBackgroundResource(0);
                findViewById(R.id.box34).setBackgroundResource(0);
                findViewById(R.id.box21).setBackgroundResource(0);
                findViewById(R.id.box22).setBackgroundResource(0);
                findViewById(R.id.box23).setBackgroundResource(0);
                findViewById(R.id.box24).setBackgroundResource(0);
                findViewById(R.id.box11).setBackgroundResource(0);
                findViewById(R.id.box12).setBackgroundResource(0);
                findViewById(R.id.box13).setBackgroundResource(0);
                findViewById(R.id.box14).setBackgroundResource(0);
            }
        });


        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                random();
                randomPicture();

                new CountDownTimer(300000, 1000) { //Sets 5 Minutes

                    public void onTick(long millisUntilFinished) {
                        timerText.setText("Timer: " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        timerText.setText("You can carry on playing if you wish.");
                        points = points;
                        menuButton.setVisibility(View.VISIBLE);
                    }
                }.start();

                startButton.setVisibility(View.INVISIBLE);
            }
        });

    }
/*    void removePoints(View view, View v)
{
    if (view.getId() == R.id.dragAnswer41)
    {
        randomPicture();
        if (v.getId() == R.id.box41)
        {
            points -= 2;
            System.out.println("Removed 2 points atm" + points);
        }
        else if (v.getId() == R.id.box42 || v.getId() == R.id.box43 || v.getId() == R.id.box44
                || v.getId() == R.id.box31 || v.getId() == R.id.box21 || v.getId() == R.id.box11 )
        {
            points -= 1;
            System.out.println("Removed 1 point points atm" + points);
        }
        else
        {
            System.out.print("Error removePoints");
        }
    }
    else
    {
        System.out.print("Error drag not answer 41 and points are  " + points);
    }
}*/

    @Override
    public boolean onTouch(View v, MotionEvent e) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(null, shadowBuilder, v, 0);
            v.setVisibility(View.VISIBLE);
            return true;
        } else {
            return false;
        }
    }

    //ArrayList<String> previousLocation = new ArrayList<Integer>();
    //ArrayList<String> previousCard = new ArrayList<Integer>();

    private void resetListeners(){

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

        a41.setVisibility(View.INVISIBLE);
        a42.setVisibility(View.INVISIBLE);
        a43.setVisibility(View.INVISIBLE);
        a44.setVisibility(View.INVISIBLE);
        a31.setVisibility(View.INVISIBLE);
        a32.setVisibility(View.INVISIBLE);
        a33.setVisibility(View.INVISIBLE);
        a34.setVisibility(View.INVISIBLE);
        a21.setVisibility(View.INVISIBLE);
        a22.setVisibility(View.INVISIBLE);
        a23.setVisibility(View.INVISIBLE);
        a24.setVisibility(View.INVISIBLE);
        a11.setVisibility(View.INVISIBLE);
        a12.setVisibility(View.INVISIBLE);
        a13.setVisibility(View.INVISIBLE);
        a14.setVisibility(View.INVISIBLE);
        b1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.INVISIBLE);
        b4.setVisibility(View.INVISIBLE);
        b5.setVisibility(View.INVISIBLE);
        b6.setVisibility(View.INVISIBLE);
        b7.setVisibility(View.INVISIBLE);
        b8.setVisibility(View.INVISIBLE);
        b9.setVisibility(View.INVISIBLE);
        b10.setVisibility(View.INVISIBLE);
    }

    private void random(){
        int firstNum = 0;
        number.removeAll(number);
        //ArrayList<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= 26; ++i){
            number.add(i);
        }
        Collections.shuffle(number);
        number.add(0);
    }

    private void getHint(){
        if (totalHints > 0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("Hint " + totalHints);
            builder.setMessage("This time the black arm of the compass indicates a direction of travel\n" +
                    "Demonstrate the directions by pointing to each card and indicating the\n" +
                    "direction it shows.\n" +
                    "Can you now, as you did before, position these cards on the grid, so that\n" +
                    "each of the vehicles on these cards (point to the pile of Directions cards)\n" +
                    "goes in the direction indicated on the compass cards? (point to the\n" +
                    "Compass cards). The roundabout sign (point to the roundabout sign) is\n" +
                    "always at the bottom. There are more cards than available spaces, so\n" +
                    "some of the cards will not fit in. These cards can be inserted into the bin\n" +
                    "In order for the game to finish, there must be no cards left, if there is, \n" +
                    "place them in the bin");
            builder.setPositiveButton("OK", null);
            builder.show();
            totalHints = totalHints - 1;
            hintText.setText(totalHints+" Remaining hints left");
        }
        else{
            hintText.setText("No more hints left");
            hint.setVisibility(View.INVISIBLE);
        }
    }

    private void randomPicture(){
        choosePicture = number.get(0);
        number.remove(0);

        System.out.println(number);
        System.out.println("Current Score " + points);
        System.out.println(choosePicture);

        if (choosePicture == 0)
        {
            System.out.println("Finished Game@@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println(points);
            menuButton.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 1){
            a11.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 2){
            a12.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 3){
            a13.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 4){
            a14.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 5){
            a21.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 6){
            a22.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 7){
            a23.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 8){
            a24.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 9){
            a31.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 10){
            a32.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 11){
            a33.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 12){
            a34.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 13){
            a41.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 14){
            a42.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 15){
            a43.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 16){
            a44.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 17){
            b1.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 18){
            b2.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 19){
            b3.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 20){
            b4.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 21){
            b5.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 22){
            b6.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 23){
            b7.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 24){
            b8.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 25){
            b9.setVisibility(View.VISIBLE);
        }
        if (choosePicture == 26){
            b10.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onDrag(View v, DragEvent e) {
        int action = e.getAction();
        int choosePicture = 0;
        View view = (View) e.getLocalState();
        switch (e.getAction()) {
            case DragEvent.ACTION_DROP:
                randomPicture();

                if (v.getId() == R.id.bin) {
                    System.out.println("DOES IT ACTUALLY DROP");
                    view.setVisibility(View.INVISIBLE);
                }

                else if (view.getId() == R.id.dragAnswer41) {

                    if (v.getId() == R.id.box41) {
                        points += 2;
                        System.out.println("added 2 points, points atm dragAnswer41 " + points);
                        findViewById(R.id.box41).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box42 || v.getId() == R.id.box43 || v.getId() == R.id.box44 || v.getId() == R.id.box31 || v.getId() == R.id.box21 || v.getId() == R.id.box11)
                    {
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer41 " + points);
                        v.setOnDragListener(null);

                    }
                    else{
                        v.setOnDragListener(null);
                    }
                    v.setBackgroundResource(R.drawable.car_south_southeast);//TODO: change this pseudo code.
                }
                else if (view.getId() == R.id.dragAnswer42) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box42) {
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box42).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box41 || v.getId() == R.id.box43 || v.getId() == R.id.box44 || v.getId() == R.id.box32 || v.getId() == R.id.box22 || v.getId() == R.id.box12 ) {
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                    v.setBackgroundResource(R.drawable.car_south_northeast);//TODO: change this pseudo code.
                }
                else if (view.getId() == R.id.dragAnswer43) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box43) {
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box43).setOnDragListener(null);

                    }
                    else if (v.getId() == R.id.box42 || v.getId() == R.id.box41 || v.getId() == R.id.box44 || v.getId() == R.id.box33 || v.getId() == R.id.box23 || v.getId() == R.id.box13 ) {
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                    v.setBackgroundResource(R.drawable.car_south_southwest);//TODO: change this pseudo code.
                }

                else if (view.getId() == R.id.dragAnswer44) {
                    if (v.getId() == R.id.box44) {
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box44).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box42 || v.getId() == R.id.box41 || v.getId() == R.id.box43 || v.getId() == R.id.box34 || v.getId() == R.id.box24 || v.getId() == R.id.box14 ) {
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                    v.setBackgroundResource(R.drawable.car_south_east);//TODO: change this pseudo code.
                }



                else if (view.getId() == R.id.dragAnswer31) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box31) {
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box31).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box32 || v.getId() == R.id.box33 || v.getId() == R.id.box34 || v.getId() == R.id.box41 || v.getId() == R.id.box21 || v.getId() == R.id.box11 ) {
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                    v.setBackgroundResource(R.drawable.car_north_southeast);//TODO: change this pseudo code.
                }

                else if (view.getId() == R.id.dragAnswer32) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box32) {
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box32).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box31 || v.getId() == R.id.box33 || v.getId() == R.id.box34 || v.getId() == R.id.box42 || v.getId() == R.id.box22 || v.getId() == R.id.box12 ) {
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                    v.setBackgroundResource(R.drawable.car_north_northeast);//TODO: change this pseudo code.
                }

                else if (view.getId() == R.id.dragAnswer33) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box33) {
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box33).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box31 || v.getId() == R.id.box32 || v.getId() == R.id.box34 || v.getId() == R.id.box43 || v.getId() == R.id.box23 || v.getId() == R.id.box13 ) {
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                    v.setBackgroundResource(R.drawable.car_north_southwest);//TODO: change this pseudo code.
                }
                else if (view.getId() == R.id.dragAnswer34) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box34) {
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box34).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box31 || v.getId() == R.id.box32 || v.getId() == R.id.box33 || v.getId() == R.id.box44 || v.getId() == R.id.box24 || v.getId() == R.id.box14 ) {
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                    v.setBackgroundResource(R.drawable.carnortheast);//TODO: change this pseudo code.
                }
                else if (view.getId() == R.id.dragAnswer21) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box21) {
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box21).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box22 || v.getId() == R.id.box23 || v.getId() == R.id.box24 || v.getId() == R.id.box41 || v.getId() == R.id.box31 || v.getId() == R.id.box11 ) {
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                    v.setBackgroundResource(R.drawable.car_northwest_southeast);//TODO: change this pseudo code.
                }
                else if (view.getId() == R.id.dragAnswer22) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box22) {
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box22).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box21 || v.getId() == R.id.box23 || v.getId() == R.id.box24 || v.getId() == R.id.box42 || v.getId() == R.id.box32 || v.getId() == R.id.box12 ) {
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                    v.setBackgroundResource(R.drawable.car_northeast_northwest);//TODO: change this pseudo code.
                }
                else if (view.getId() == R.id.dragAnswer23) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box23) {
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box23).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box21 || v.getId() == R.id.box22 || v.getId() == R.id.box24 || v.getId() == R.id.box43 || v.getId() == R.id.box33 || v.getId() == R.id.box13 ) {
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                    v.setBackgroundResource(R.drawable.car_northwest_southwest);//TODO: change this pseudo code.
                }
                else if (view.getId() == R.id.dragAnswer24) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box24) {
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box24).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box21 || v.getId() == R.id.box22 || v.getId() == R.id.box23 || v.getId() == R.id.box44 || v.getId() == R.id.box34 || v.getId() == R.id.box14 ) {
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                    v.setBackgroundResource(R.drawable.car_east_northwest);//TODO: change this pseudo code.
                }
                else if (view.getId() == R.id.dragAnswer11) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box11) {
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box11).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box12 || v.getId() == R.id.box13 || v.getId() == R.id.box14 || v.getId() == R.id.box21 || v.getId() == R.id.box31 || v.getId() == R.id.box41 ) {
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                    v.setBackgroundResource(R.drawable.carwestsoutheast);//TODO: change this pseudo code.
                }
                else if (view.getId() == R.id.dragAnswer12) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box12) {
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box12).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box11 || v.getId() == R.id.box13 || v.getId() == R.id.box14 || v.getId() == R.id.box22 || v.getId() == R.id.box32 || v.getId() == R.id.box42 ) {
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                    v.setBackgroundResource(R.drawable.car_west_northeast);//TODO: change this pseudo code.
                }
                else if (view.getId() == R.id.dragAnswer13) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box13) {
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box13).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box11 || v.getId() == R.id.box12 || v.getId() == R.id.box14 || v.getId() == R.id.box23 || v.getId() == R.id.box33 || v.getId() == R.id.box43 ) {
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                    v.setBackgroundResource(R.drawable.car_west_southwest);//TODO: change this pseudo code.
                }
                else if (view.getId() == R.id.dragAnswer14) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box14) {
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box14).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box12 || v.getId() == R.id.box13 || v.getId() == R.id.box11 || v.getId() == R.id.box24 || v.getId() == R.id.box34 || v.getId() == R.id.box44 ) {
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                    v.setBackgroundResource(R.drawable.careastwest);//TODO: change this pseudo code.
                }

                else{
                    view.setVisibility(View.INVISIBLE);
                    v.setOnDragListener(null);
                    if(view.getId() == R.id.dragAnswer){
                        v.setBackgroundResource(R.drawable.car_south_east);//TODO: change this pseudo code.
                    }
                    if(view.getId() == R.id.dragAnswer2){
                        v.setBackgroundResource(R.drawable.carnorthsouth);//TODO: change this pseudo code.
                    }
                    if(view.getId() == R.id.dragAnswer3){
                        v.setBackgroundResource(R.drawable.car_east_southeast);//TODO: change this pseudo code.
                    }
                    if(view.getId() == R.id.dragAnswer4){
                        v.setBackgroundResource(R.drawable.car_west_northwest);//TODO: change this pseudo code.
                    }
                    if(view.getId() == R.id.dragAnswer5){
                        v.setBackgroundResource(R.drawable.car_southeast_southwest);//TODO: change this pseudo code.
                    }
                    if(view.getId() == R.id.dragAnswer6){
                        v.setBackgroundResource(R.drawable.car_northeast_southwest);//TODO: change this pseudo code.
                    }
                    if(view.getId() == R.id.dragAnswer7){
                        v.setBackgroundResource(R.drawable.car_north_northwest);//TODO: change this pseudo code.
                    }
                    if(view.getId() == R.id.dragAnswer8){
                        v.setBackgroundResource(R.drawable.car_east_southeast);//TODO: change this pseudo code.
                    }
                    if(view.getId() == R.id.dragAnswer9){
                        v.setBackgroundResource(R.drawable.car_east_northwest);//TODO: change this pseudo code.
                    }
                    if(view.getId() == R.id.dragAnswer10){
                        v.setBackgroundResource(R.drawable.car_south_southeast);//TODO: change this pseudo code.
                    }

                    //wrongAnswer = wrongAnswer + 1;
                    //System.out.println(wrongAnswer + " Wrong Answer");

                }
                break;
        }
        return true;
    }
}