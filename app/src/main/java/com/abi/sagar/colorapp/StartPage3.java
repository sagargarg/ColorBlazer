package com.abi.sagar.colorapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by Sagar on 7/20/2015.
 */
public class StartPage3 extends Activity {

    Animation pent_rotate1;
    Animation pent_rotate2;
    Animation pent_rotate3;
    Animation pent_rotate4;
    Animation pent_rotate5;

    View pentagon;
    int currentAnimation = 0;
    int ballcolor;

    TranslateAnimation move;
    View color1;
    View color2;
    View color3;
    View color4;
    View color5;

    Random color_box_fall_random;
    int i;
    Handler handler;

    TextView total_score;
    protected static int total_score_num_pent;
    public static int high_score_pent = 0;
    public static boolean new_high_pent;

    int duration = 2000;
    //TextView duration_num;

    int[] loc, loc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new_high_pent = false;
        super.onCreate(savedInstanceState);
        SharedPreferences settings_pent = getSharedPreferences("high_score_pent", 0);
        high_score_pent = settings_pent.getInt("high_score_pent", 0);
        setContentView(R.layout.start_page_three);

        pent_rotate1 = AnimationUtils.loadAnimation(this, R.anim.pent_rotate1);
        pent_rotate2 = AnimationUtils.loadAnimation(this, R.anim.pent_rotate2);
        pent_rotate3 = AnimationUtils.loadAnimation(this, R.anim.pent_rotate3);
        pent_rotate4 = AnimationUtils.loadAnimation(this, R.anim.pent_rotate4);
        pent_rotate5 = AnimationUtils.loadAnimation(this, R.anim.pent_rotate5);

        pentagon = findViewById(R.id.pentagon);
        pentagon.setRotation(36);


        move = new TranslateAnimation(0, 0 , dpToPx(-50), dpToPx(325));
        move.setFillAfter(true);
        move.setStartOffset(200);
        move.setInterpolator(new LinearInterpolator());

        color1 = findViewById(R.id.color1);
        color2 = findViewById(R.id.color2);
        color3 = findViewById(R.id.color3);
        color4 = findViewById(R.id.color4);
        color5 = findViewById(R.id.color5);

        total_score = (TextView) findViewById(R.id.total_score);
        //duration_num = (TextView) findViewById(R.id.duration_num);

        color_box_fall_random = new Random();
        handler = new Handler();
        move.setDuration(duration);
        total_score_num_pent = 0;

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
                            switch(ballcolor) {
                                case 1:
                                    if (currentAnimation == 0) {
                                        ++total_score_num_pent;
                                        total_score.setText("" + total_score_num_pent);
                                        if (total_score_num_pent == 0){
                                            duration = 2000;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 0 && total_score_num_pent <= 5){
                                            duration -= (total_score_num_pent)*9;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 5 && total_score_num_pent <= 10){
                                            duration -= (total_score_num_pent)*6;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 11 && total_score_num_pent <= 19){
                                            duration -= (total_score_num_pent)*3;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 20 && total_score_num_pent <= 28){
                                            duration -= (total_score_num_pent);
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 29){
                                            duration = 1000;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                    }
                                    else {
                                        if (total_score_num_pent > high_score_pent) {
                                            high_score_pent = total_score_num_pent;
                                            new_high_pent = true;
                                        }

                                        SharedPreferences settings2_pent = getSharedPreferences("high_score_pent", 0);

                                        SharedPreferences.Editor editor = settings2_pent.edit();
                                        editor.putInt("high_score_pent", high_score_pent);
                                        editor.apply();

                                        Intent intent = new Intent(getApplicationContext(),EndPage3.class);
                                        finish();
                                        startActivity(intent);
                                    }
                                    break;
                                case 2:
                                    if (currentAnimation == 1) {
                                        ++total_score_num_pent;
                                        total_score.setText("" + total_score_num_pent);
                                        if (total_score_num_pent == 0){
                                            duration = 2000;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 0 && total_score_num_pent <= 5){
                                            duration -= (total_score_num_pent)*9;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 5 && total_score_num_pent <= 10){
                                            duration -= (total_score_num_pent)*6;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 11 && total_score_num_pent <= 19){
                                            duration -= (total_score_num_pent)*3;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 20 && total_score_num_pent <= 28){
                                            duration -= (total_score_num_pent);
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 29){
                                            duration = 1000;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                    }
                                    else {
                                        if (total_score_num_pent > high_score_pent) {
                                            high_score_pent = total_score_num_pent;
                                            new_high_pent = true;
                                        }
                                        SharedPreferences settings2_pent = getSharedPreferences("high_score_pent", 0);

                                        SharedPreferences.Editor editor = settings2_pent.edit();
                                        editor.putInt("high_score_pent", high_score_pent);
                                        editor.apply();

                                        Intent intent = new Intent(getApplicationContext(),EndPage3.class);
                                        finish();
                                        startActivity(intent);
                                    }
                                    break;
                                case 3:
                                    if (currentAnimation == 2) {
                                        ++total_score_num_pent;
                                        total_score.setText("" + total_score_num_pent);
                                        if (total_score_num_pent == 0){
                                            duration = 2000;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 0 && total_score_num_pent <= 5){
                                            duration -= (total_score_num_pent)*9;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 5 && total_score_num_pent <= 10){
                                            duration -= (total_score_num_pent)*6;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 11 && total_score_num_pent <= 19){
                                            duration -= (total_score_num_pent)*3;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 20 && total_score_num_pent <= 28){
                                            duration -= (total_score_num_pent);
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 29){
                                            duration = 1000;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                    }
                                    else {
                                        if (total_score_num_pent > high_score_pent) {
                                            high_score_pent = total_score_num_pent;
                                            new_high_pent = true;
                                        }
                                        SharedPreferences settings2_pent = getSharedPreferences("high_score_pent", 0);

                                        SharedPreferences.Editor editor = settings2_pent.edit();
                                        editor.putInt("high_score_pent", high_score_pent);
                                        editor.apply();

                                        Intent intent = new Intent(getApplicationContext(),EndPage3.class);
                                        finish();
                                        startActivity(intent);
                                    }
                                    break;
                                case 4:
                                    if (currentAnimation == 3) {
                                        ++total_score_num_pent;
                                        total_score.setText("" + total_score_num_pent);
                                        if (total_score_num_pent == 0){
                                            duration = 2000;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 0 && total_score_num_pent <= 5){
                                            duration -= (total_score_num_pent)*9;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 5 && total_score_num_pent <= 10){
                                            duration -= (total_score_num_pent)*6;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 11 && total_score_num_pent <= 19){
                                            duration -= (total_score_num_pent)*3;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 20 && total_score_num_pent <= 28){
                                            duration -= (total_score_num_pent);
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 29){
                                            duration = 1000;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                    }
                                    else {
                                        if (total_score_num_pent > high_score_pent) {
                                            high_score_pent = total_score_num_pent;
                                            new_high_pent = true;
                                        }
                                        SharedPreferences settings2_pent = getSharedPreferences("high_score_pent", 0);

                                        SharedPreferences.Editor editor = settings2_pent.edit();
                                        editor.putInt("high_score_pent", high_score_pent);
                                        editor.apply();

                                        Intent intent = new Intent(getApplicationContext(),EndPage3.class);
                                        finish();
                                        startActivity(intent);
                                    }
                                    break;
                                case 5:
                                    if (currentAnimation == 4) {
                                        ++total_score_num_pent;
                                        total_score.setText("" + total_score_num_pent);
                                        if (total_score_num_pent == 0){
                                            duration = 2000;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 0 && total_score_num_pent <= 5){
                                            duration -= (total_score_num_pent)*9;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 5 && total_score_num_pent <= 10){
                                            duration -= (total_score_num_pent)*6;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 11 && total_score_num_pent <= 19){
                                            duration -= (total_score_num_pent)*3;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 20 && total_score_num_pent <= 28){
                                            duration -= (total_score_num_pent);
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_pent > 29){
                                            duration = 1000;
                                            move.setDuration(duration);
                                            //duration_num.setText("" + duration);
                                        }
                                    }
                                    else {
                                        if (total_score_num_pent > high_score_pent) {
                                            high_score_pent = total_score_num_pent;
                                            new_high_pent = true;
                                        }
                                        SharedPreferences settings2_pent = getSharedPreferences("high_score_pent", 0);

                                        SharedPreferences.Editor editor = settings2_pent.edit();
                                        editor.putInt("high_score_pent", high_score_pent);
                                        editor.apply();

                                        Intent intent = new Intent(getApplicationContext(),EndPage3.class);
                                        finish();
                                        startActivity(intent);
                                    }
                                    break;
                            }
                            switch(color_box_fall_random.nextInt(5)) {
                                case 0:
                                    color1.startAnimation(move);
                                    color2.clearAnimation();
                                    color3.clearAnimation();
                                    color4.clearAnimation();
                                    color5.clearAnimation();
                                    ballcolor = 1;
                                    break;
                                case 1:
                                    color2.startAnimation(move);
                                    color1.clearAnimation();
                                    color3.clearAnimation();
                                    color4.clearAnimation();
                                    color5.clearAnimation();
                                    ballcolor = 2;
                                    break;
                                case 2:
                                    color3.startAnimation(move);
                                    color1.clearAnimation();
                                    color2.clearAnimation();
                                    color4.clearAnimation();
                                    color5.clearAnimation();
                                    ballcolor = 3;
                                    break;
                                case 3:
                                    color4.startAnimation(move);
                                    color1.clearAnimation();
                                    color2.clearAnimation();
                                    color3.clearAnimation();
                                    color5.clearAnimation();
                                    ballcolor = 4;
                                    break;
                                case 4:
                                    color5.startAnimation(move);
                                    color1.clearAnimation();
                                    color2.clearAnimation();
                                    color3.clearAnimation();
                                    color4.clearAnimation();
                                    ballcolor = 5;
                                    break;
                            }
                        }
                    }, 1);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation){

            }
        });

        switch(color_box_fall_random.nextInt(5)){
            case 0:
                color1.startAnimation(move);
                ballcolor = 1;
                break;
            case 1:
                color2.startAnimation(move);
                ballcolor = 2;
                break;
            case 2:
                color3.startAnimation(move);
                ballcolor = 3;
                break;
            case 3:
                color4.startAnimation(move);
                ballcolor = 4;
                break;
            case 4:
                color5.startAnimation(move);
                ballcolor = 5;
                break;
        }

        loc = new int[2];
        loc1 = new int[2];

        final android.os.Handler customHandler = new Handler();

        Runnable updateTimerThread = new Runnable() {
            public void run() {
                color1.getLocationOnScreen(loc);
                pentagon.getLocationOnScreen(loc1);
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
                    pentagon.startAnimation(pent_rotate1);
                    break;
                case 2:
                    pentagon.startAnimation(pent_rotate2);
                    break;
                case 3:
                    pentagon.startAnimation(pent_rotate3);
                    break;
                case 4:
                    pentagon.startAnimation(pent_rotate4);
                    break;
                case 5:
                    currentAnimation = 0;
                    pentagon.startAnimation(pent_rotate5);
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

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        startActivity(new Intent(StartPage3.this, MainActivity.class));
        finish();
    }

    private static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    private static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }
}
