package com.aadgroup.aadgroupwork;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.DragShadowBuilder;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class SquareMatricesDirections extends Activity implements View.OnTouchListener, View.OnDragListener {
    public int choosePicture;
    ImageView a41, a42, a43, a44, a31, a32, a33, a34, a21, a22, a23, a24, a11, a12, a13, a14, hint, answer41, answer42, answer43, answer44, answer31, answer21, answer11;
    Button menuButton;
    TextView hintText;
    ArrayList<Integer> number = new ArrayList<Integer>();

    int points = 0;
    int totalHints = 2;

    TestResults allResults;
    ArrayList<Integer> testFinish = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.square_matrices_directions);

        Intent intent = getIntent();
        if (intent.hasExtra("TestResults")) {
            allResults = (TestResults) intent.getSerializableExtra("TestResults");
        }
        else {
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


        answer41 = (ImageView) findViewById(R.id.box41);
        answer42 = (ImageView) findViewById(R.id.box42);
        answer43 = (ImageView) findViewById(R.id.box43);
        answer44 = (ImageView) findViewById(R.id.box44);
        answer31 = (ImageView) findViewById(R.id.box31);
        answer21 = (ImageView) findViewById(R.id.box21);
        answer11 = (ImageView) findViewById(R.id.box11);

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
        resetListeners();

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
                intent.putExtra("TestResults", allResults);
                testFinish.set(1, 1);
                intent.putIntegerArrayListExtra("TestFinish", testFinish);
                startActivity(intent);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                points = 0;
                resetListeners();

                random();
                randomPicture();

                findViewById(R.id.box41).setBackgroundResource(R.drawable.box);
                findViewById(R.id.box42).setBackgroundResource(R.drawable.box);
                findViewById(R.id.box43).setBackgroundResource(R.drawable.box);
                findViewById(R.id.box44).setBackgroundResource(R.drawable.box);
                findViewById(R.id.box31).setBackgroundResource(R.drawable.box);
                findViewById(R.id.box32).setBackgroundResource(R.drawable.box);
                findViewById(R.id.box33).setBackgroundResource(R.drawable.box);
                findViewById(R.id.box34).setBackgroundResource(R.drawable.box);
                findViewById(R.id.box21).setBackgroundResource(R.drawable.box);
                findViewById(R.id.box22).setBackgroundResource(R.drawable.box);
                findViewById(R.id.box23).setBackgroundResource(R.drawable.box);
                findViewById(R.id.box24).setBackgroundResource(R.drawable.box);
                findViewById(R.id.box11).setBackgroundResource(R.drawable.box);
                findViewById(R.id.box12).setBackgroundResource(R.drawable.box);
                findViewById(R.id.box13).setBackgroundResource(R.drawable.box);
                findViewById(R.id.box14).setBackgroundResource(R.drawable.box);
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
    }

    private void random(){
        number.removeAll(number);
        for (int i = 1; i <= 16; ++i)
        {
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
            builder.setMessage("position the cards shown below so that\n" +
                    "each car is travelling in the direction indicated by the bottom arrows and\n" +
                    "each lorry in the direction indicated by the arrows on the left side.");
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
    }

    @Override
    public boolean onDrag(View v, DragEvent e) {
        View view = (View) e.getLocalState();
        switch (e.getAction()) {
            case DragEvent.ACTION_DROP:
                randomPicture();

                if (view.getId() == R.id.dragAnswer41) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box41) {
                        v.setBackgroundResource(R.drawable.directions41);//TODO: change this pseudo code.
                        points += 2;
                        System.out.println("added 2 points, points atm dragAnswer41 " + points);
                        findViewById(R.id.box41).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box42 || v.getId() == R.id.box43 || v.getId() == R.id.box44 || v.getId() == R.id.box31 || v.getId() == R.id.box21 || v.getId() == R.id.box11)
                    {

                        v.setBackgroundResource(R.drawable.directions41);//TODO: change this pseudo code.
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer41 " + points);
                        v.setOnDragListener(null);

                    }
                    else{
                        v.setBackgroundResource(R.drawable.directions41);//TODO: change this pseudo code.
                        v.setOnDragListener(null);
                    }
                }
                else if (view.getId() == R.id.dragAnswer42) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box42) {
                        v.setBackgroundResource(R.drawable.directions42);//TODO: change this pseudo code.
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box42).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box41 || v.getId() == R.id.box43 || v.getId() == R.id.box44 || v.getId() == R.id.box32 || v.getId() == R.id.box22 || v.getId() == R.id.box12 ) {
                        v.setBackgroundResource(R.drawable.directions42);//TODO: change this pseudo code.
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setBackgroundResource(R.drawable.directions42);//TODO: change this pseudo code..
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                }
                else if (view.getId() == R.id.dragAnswer43) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box43) {
                        v.setBackgroundResource(R.drawable.directions43);//TODO: change this pseudo code.
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box43).setOnDragListener(null);

                    }
                    else if (v.getId() == R.id.box42 || v.getId() == R.id.box41 || v.getId() == R.id.box44 || v.getId() == R.id.box33 || v.getId() == R.id.box23 || v.getId() == R.id.box13 ) {
                        v.setBackgroundResource(R.drawable.directions43);//TODO: change this pseudo code.
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setBackgroundResource(R.drawable.directions43);//TODO: change this pseudo code.
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                }

                else if (view.getId() == R.id.dragAnswer44) {
                    if (v.getId() == R.id.box44) {
                        v.setBackgroundResource(R.drawable.directions44);//TODO: change this pseudo code.
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box44).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box42 || v.getId() == R.id.box41 || v.getId() == R.id.box43 || v.getId() == R.id.box34 || v.getId() == R.id.box24 || v.getId() == R.id.box14 ) {
                        v.setBackgroundResource(R.drawable.directions44);//TODO: change this pseudo code.
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setBackgroundResource(R.drawable.directions44);//TODO: change this pseudo code.
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                }
                else if (view.getId() == R.id.dragAnswer31) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box31) {
                        v.setBackgroundResource(R.drawable.directions31);//TODO: change this pseudo code.
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box31).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box32 || v.getId() == R.id.box33 || v.getId() == R.id.box34 || v.getId() == R.id.box41 || v.getId() == R.id.box21 || v.getId() == R.id.box11 ) {
                        v.setBackgroundResource(R.drawable.directions31);//TODO: change this pseudo code.
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setBackgroundResource(R.drawable.directions31);//TODO: change this pseudo code.
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                }
                else if (view.getId() == R.id.dragAnswer32) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box32) {
                        v.setBackgroundResource(R.drawable.directions32);//TODO: change this pseudo code.
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box32).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box31 || v.getId() == R.id.box33 || v.getId() == R.id.box34 || v.getId() == R.id.box42 || v.getId() == R.id.box22 || v.getId() == R.id.box12 ) {
                        v.setBackgroundResource(R.drawable.directions32);//TODO: change this pseudo code.
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setBackgroundResource(R.drawable.directions32);//TODO: change this pseudo code.
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                }
                else if (view.getId() == R.id.dragAnswer33) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box33) {
                        v.setBackgroundResource(R.drawable.directions33);//TODO: change this pseudo code.
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box33).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box31 || v.getId() == R.id.box32 || v.getId() == R.id.box34 || v.getId() == R.id.box43 || v.getId() == R.id.box23 || v.getId() == R.id.box13 ) {
                        v.setBackgroundResource(R.drawable.directions33);//TODO: change this pseudo code.
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setBackgroundResource(R.drawable.directions33);//TODO: change this pseudo code.
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                }
                else if (view.getId() == R.id.dragAnswer34) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box34) {
                        v.setBackgroundResource(R.drawable.directions34);//TODO: change this pseudo code.
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box34).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box31 || v.getId() == R.id.box32 || v.getId() == R.id.box33 || v.getId() == R.id.box44 || v.getId() == R.id.box24 || v.getId() == R.id.box14 ) {
                        v.setBackgroundResource(R.drawable.directions34);//TODO: change this pseudo code.
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setBackgroundResource(R.drawable.directions34);//TODO: change this pseudo code.
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                }
                else if (view.getId() == R.id.dragAnswer21) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box21) {
                        v.setBackgroundResource(R.drawable.directions21);//TODO: change this pseudo code.
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box21).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box22 || v.getId() == R.id.box23 || v.getId() == R.id.box24 || v.getId() == R.id.box41 || v.getId() == R.id.box31 || v.getId() == R.id.box11 ) {
                        v.setBackgroundResource(R.drawable.directions21);//TODO: change this pseudo code.
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setBackgroundResource(R.drawable.directions21);//TODO: change this pseudo code.
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                }
                else if (view.getId() == R.id.dragAnswer22) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box22) {
                        v.setBackgroundResource(R.drawable.directions22);//TODO: change this pseudo code.
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box22).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box21 || v.getId() == R.id.box23 || v.getId() == R.id.box24 || v.getId() == R.id.box42 || v.getId() == R.id.box32 || v.getId() == R.id.box12 ) {
                        v.setBackgroundResource(R.drawable.directions22);//TODO: change this pseudo code.
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setBackgroundResource(R.drawable.directions22);//TODO: change this pseudo code.
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                }
                else if (view.getId() == R.id.dragAnswer23) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box23) {
                        v.setBackgroundResource(R.drawable.directions23);//TODO: change this pseudo code.
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box23).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box21 || v.getId() == R.id.box22 || v.getId() == R.id.box24 || v.getId() == R.id.box43 || v.getId() == R.id.box33 || v.getId() == R.id.box13 ) {
                        v.setBackgroundResource(R.drawable.directions23);//TODO: change this pseudo code.
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setBackgroundResource(R.drawable.directions23);//TODO: change this pseudo code.
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                }
                else if (view.getId() == R.id.dragAnswer24) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box24) {
                        v.setBackgroundResource(R.drawable.directions24);//TODO: change this pseudo code.
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box24).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box21 || v.getId() == R.id.box22 || v.getId() == R.id.box23 || v.getId() == R.id.box44 || v.getId() == R.id.box34 || v.getId() == R.id.box14 ) {
                        v.setBackgroundResource(R.drawable.directions24);//TODO: change this pseudo code.
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setBackgroundResource(R.drawable.directions24);//TODO: change this pseudo code.
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                }
                else if (view.getId() == R.id.dragAnswer11) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box11) {
                        v.setBackgroundResource(R.drawable.directions11);//TODO: change this pseudo code.
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box11).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box12 || v.getId() == R.id.box13 || v.getId() == R.id.box14 || v.getId() == R.id.box21 || v.getId() == R.id.box31 || v.getId() == R.id.box41 ) {
                        v.setBackgroundResource(R.drawable.directions11);//TODO: change this pseudo code.
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setBackgroundResource(R.drawable.directions11);//TODO: change this pseudo code.
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                }
                else if (view.getId() == R.id.dragAnswer12) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box12) {
                        v.setBackgroundResource(R.drawable.directions12);//TODO: change this pseudo code.
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box12).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box11 || v.getId() == R.id.box13 || v.getId() == R.id.box14 || v.getId() == R.id.box22 || v.getId() == R.id.box32 || v.getId() == R.id.box42 ) {
                        v.setBackgroundResource(R.drawable.directions12);//TODO: change this pseudo code.
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setBackgroundResource(R.drawable.directions12);//TODO: change this pseudo code.
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                }
                else if (view.getId() == R.id.dragAnswer13) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box13) {
                        v.setBackgroundResource(R.drawable.directions13);//TODO: change this pseudo code.
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box13).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box11 || v.getId() == R.id.box12 || v.getId() == R.id.box14 || v.getId() == R.id.box23 || v.getId() == R.id.box33 || v.getId() == R.id.box43 ) {
                        v.setBackgroundResource(R.drawable.directions13);//TODO: change this pseudo code.
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setBackgroundResource(R.drawable.directions13);//TODO: change this pseudo code.
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                }
                else if (view.getId() == R.id.dragAnswer14) {
                    view.setVisibility(View.INVISIBLE);
                    if (v.getId() == R.id.box14) {
                        v.setBackgroundResource(R.drawable.directions14);//TODO: change this pseudo code.
                        points += 2;
                        System.out.println("added 2 point, points atm dragAnswer42 " + points);
                        findViewById(R.id.box14).setOnDragListener(null);
                    }
                    else if (v.getId() == R.id.box12 || v.getId() == R.id.box13 || v.getId() == R.id.box11 || v.getId() == R.id.box24 || v.getId() == R.id.box34 || v.getId() == R.id.box44 ) {
                        v.setBackgroundResource(R.drawable.directions14);//TODO: change this pseudo code.
                        points += 1;
                        System.out.println("added 1 point, points atm dragAnswer42 " + points);
                        v.setOnDragListener(null);
                    }
                    else{
                        v.setBackgroundResource(R.drawable.directions14);//TODO: change this pseudo code.
                        v.setOnDragListener(null);
                        //Wrong answer
                    }
                }
                break;
        }
        return true;
    }
}

