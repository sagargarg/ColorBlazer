package com.abi.sagar.colorapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.os.Handler;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.util.Random;

public class StartPage2 extends Activity {

    Animation rotate1;
    Animation rotate2;
    Animation rotate3;
    View triangle;
    int currentAnimation = 0;
    int ballcolor;

    Animation move;
    View color1;
    View color2;
    View color3;
    Random color_box_fall_random;
    int i;
    Handler handler;

    TextView red_score;
    TextView blue_score;
    TextView green_score;

    TextView total_score;
    TextView text;

    public static int red_score_num = 0;
    public static int blue_score_num = 0;
    public static int green_score_num = 0;
    protected static int total_score_num = 0;
    public static int high_score = 0;

    int duration = 2000;
    TextView duration_num;

    int[] loc, loc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences settings = getSharedPreferences("high_score", 0);
        high_score = settings.getInt("high_score", 0);
        setContentView(R.layout.start_page_two);

        rotate1 = AnimationUtils.loadAnimation(this, R.anim.rotate1);
        rotate2 = AnimationUtils.loadAnimation(this, R.anim.rotate2);
        rotate3 = AnimationUtils.loadAnimation(this, R.anim.rotate3);
        triangle = findViewById(R.id.triangle);
        triangle.setRotation(300);

        move = AnimationUtils.loadAnimation(this, R.anim.move);
        color1 = findViewById(R.id.color1); //red
        color2 = findViewById(R.id.color2); //green
        color3 = findViewById(R.id.color3); //blue

        red_score = (TextView) findViewById(R.id.red_score);
        blue_score = (TextView) findViewById(R.id.blue_score);
        green_score = (TextView) findViewById(R.id.green_score);
        total_score = (TextView) findViewById(R.id.total_score);
        text = (TextView) findViewById(R.id.text);

        duration_num = (TextView) findViewById(R.id.duration_num);

        color_box_fall_random = new Random();
        handler = new Handler();
        move.setDuration(duration);

        red_score_num = 0;
        blue_score_num = 0;
        green_score_num = 0;
        total_score_num = 0;

        move.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation animation){

            }

            @Override
            public void onAnimationEnd(Animation animation){

                i++;
                if(i < 100){
                    handler.postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            //red_score.setText("" + ballcolor);
                            //blue_score.setText("" + currentAnimation);
                            //red_score.setText("ball: " + ballcolor + " animation: " + currentAnimation);

                            switch(ballcolor) {
                                case 1:
                                    if (currentAnimation == 0) {
                                        ++red_score_num;
                                        ++total_score_num;
                                        total_score.setText("" + total_score_num);
                                        red_score.setText("" + red_score_num);
                                        text.setText("Red");
                                        if (total_score_num > 0 && total_score_num <= 5){
                                            duration -= (total_score_num)*8;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 5 && total_score_num <= 10){
                                            duration -= (total_score_num)*5;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 10 && total_score_num <= 15){
                                            duration -= (total_score_num)*4;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 15 && total_score_num <= 20){
                                            duration -= (total_score_num)*3;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 20 && total_score_num <= 25){
                                            duration -= (total_score_num)*2;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 25 && total_score_num <= 30){
                                            duration -= (total_score_num)*1;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 30 && total_score_num <= 40){
                                            duration -= 2;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 40){
                                            duration = 760;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                    }
                                    else {
                                        if (total_score_num > high_score) {
                                            high_score = total_score_num;
                                        }
                                        SharedPreferences settings2 = getSharedPreferences("high_score", 0);

                                        SharedPreferences.Editor editor = settings2.edit();
                                        editor.putInt("high_score", high_score);

                                        Intent intent = new Intent(getApplicationContext(),EndPage.class);
                                        startActivity(intent);
                                    }
                                    break;
                                case 2:
                                    if (currentAnimation == 1) {
                                        ++green_score_num;
                                        ++total_score_num;
                                        total_score.setText("" + total_score_num);
                                        green_score.setText("" + green_score_num);
                                        text.setText("Green");
                                        if (total_score_num > 0 && total_score_num <= 5){
                                            duration -= (total_score_num)*8;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 5 && total_score_num <= 10){
                                            duration -= (total_score_num)*5;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 10 && total_score_num <= 15){
                                            duration -= (total_score_num)*4;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 15 && total_score_num <= 20){
                                            duration -= (total_score_num)*3;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 20 && total_score_num <= 25){
                                            duration -= (total_score_num)*2;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 25 && total_score_num <= 30){
                                            duration -= (total_score_num)*1;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 30 && total_score_num <= 40){
                                            duration -= 2;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 40){
                                            duration = 760;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                    }
                                    else {
                                        Intent intent = new Intent(getApplicationContext(),EndPage.class);
                                        startActivity(intent);
                                    }
                                    break;
                                case 3:
                                    if (currentAnimation == 2) {
                                        ++blue_score_num;
                                        ++total_score_num;
                                        total_score.setText("" + total_score_num);
                                        blue_score.setText("" + blue_score_num);
                                        text.setText("Blue");
                                        if (total_score_num > 0 && total_score_num <= 5){
                                            duration -= (total_score_num)*8;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 5 && total_score_num <= 10){
                                            duration -= (total_score_num)*5;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 10 && total_score_num <= 15){
                                            duration -= (total_score_num)*4;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 15 && total_score_num <= 20){
                                            duration -= (total_score_num)*3;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 20 && total_score_num <= 25){
                                            duration -= (total_score_num)*2;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 25 && total_score_num <= 30){
                                            duration -= (total_score_num)*1;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 30 && total_score_num <= 40){
                                            duration -= 2;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num > 40){
                                            duration = 760;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                    }
                                    else {
                                        Intent intent = new Intent(getApplicationContext(),EndPage.class);
                                        startActivity(intent);
                                    }
                                    break;
                            }
                            switch(color_box_fall_random.nextInt(3)) {
                                case 0:
                                    color1.startAnimation(move);
                                    color2.clearAnimation();
                                    color3.clearAnimation();
                                    //red_score_num++;

                                    ballcolor = 1;
                                    /*if (currentAnimation == 0){
                                        ++red_score_num;
                                    }*/
                                    //red_score.setText("" + red_score_num);
                                    break;
                                case 1:
                                    color2.startAnimation(move);
                                    color1.clearAnimation();
                                    color3.clearAnimation();
                                    //green_score_num++;
                                    /*if (currentAnimation == 1) {
                                        ++green_score_num;
                                    }*/
                                    //green_score.setText("" + green_score_num);
                                    ballcolor = 2;
                                    break;
                                case 2:
                                    color3.startAnimation(move);
                                    color1.clearAnimation();
                                    color2.clearAnimation();
                                    //blue_score_num++;
                                    /*if (currentAnimation == 2) {
                                        ++blue_score_num;
                                    }*/
                                    //blue_score.setText("" + blue_score_num);
                                    ballcolor = 3;
                                    break;
                            }
                        }
                    }, 10);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation){

            }
        });

        switch(color_box_fall_random.nextInt(3)){
            case 0:
                color1.startAnimation(move);
                //red_score_num++;
                //red_score.setText("" + red_score_num);
                ballcolor = 1;
                break;
            case 1:
                color2.startAnimation(move);
                //green_score_num++;
                //green_score.setText("" + green_score_num);
                ballcolor = 2;
                break;
            case 2:
                color3.startAnimation(move);
                //blue_score_num++;
                //blue_score.setText("" + blue_score_num);
                ballcolor = 3;
                break;
        }

        loc = new int[2];
        loc1 = new int[2];

        final android.os.Handler customHandler = new Handler();

        Runnable updateTimerThread = new Runnable() {
            public void run() {
                color1.getLocationOnScreen(loc);
                triangle.getLocationOnScreen(loc1);
                if ((loc1[0] - loc[0]) * (loc1[0] - loc[0]) + (loc1[1] - loc[1]) * (loc1[1] - loc[1]) <= 1000) {
                    move.reset();
                }
                customHandler.postDelayed(this, 1000);
            }
        };

        customHandler.postDelayed(updateTimerThread, 0);

    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {

            switch(++currentAnimation){
                case 1:
                    triangle.startAnimation(rotate1);
                    break;
                case 2:
                    triangle.startAnimation(rotate2);
                    break;
                case 3:
                    currentAnimation = 0;
                    triangle.startAnimation(rotate3);
                    break;
            }
            return true;
        }
        return super.onTouchEvent(event);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}

/*

What do we need to do

Save High Score
Fix Speed of animation (too fast at the end, too slow at the beginning
Convert dp into pixels based on the pixels per inch on different phones
    This is for the ball animation, and how fas the ball should fall
Tap to Start
Counter for games played
Improve the design of the game
Integrate Google Game into the app
Find out how to implement ads
Name and App Icon
Prevent User from going back to previous changes, and set was pages to go to

*/