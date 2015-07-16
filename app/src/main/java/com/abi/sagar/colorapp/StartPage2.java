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

/**
 * Created by Sagar on 7/9/2015.
 */
public class StartPage2  extends Activity {

    Animation square_rotate1;
    Animation square_rotate2;
    Animation square_rotate3;
    Animation square_rotate4;

    View rectangle;
    int currentAnimation = 0;
    int ballcolor;

    Animation move;
    View color1;
    View color2;
    View color3;
    View color4;

    Random color_box_fall_random;
    int i;
    Handler handler;

    TextView total_score;
    protected static int total_score_num_rec;
    public static int high_score_rec = 0;
    public static boolean new_high_rec;

    int duration = 1800;
    TextView duration_num;

    int[] loc, loc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new_high_rec = false;
        super.onCreate(savedInstanceState);
        SharedPreferences settings_rec = getSharedPreferences("high_score_rec", 0);
        high_score_rec = settings_rec.getInt("high_score_rec", 0);
        setContentView(R.layout.start_page_two);

        square_rotate1 = AnimationUtils.loadAnimation(this, R.anim.square_rotate1);
        square_rotate2 = AnimationUtils.loadAnimation(this, R.anim.square_rotate2);
        square_rotate3 = AnimationUtils.loadAnimation(this, R.anim.square_rotate3);
        square_rotate4 = AnimationUtils.loadAnimation(this, R.anim.square_rotate4);

        rectangle = findViewById(R.id.rectangle);

        move = AnimationUtils.loadAnimation(this, R.anim.move);
        color1 = findViewById(R.id.color1);
        color2 = findViewById(R.id.color2);
        color3 = findViewById(R.id.color3);
        color4 = findViewById(R.id.color4);

        total_score = (TextView) findViewById(R.id.total_score);
        duration_num = (TextView) findViewById(R.id.duration_num);

        color_box_fall_random = new Random();
        handler = new Handler();
        move.setDuration(duration);
        total_score_num_rec = 0;

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
                                        ++total_score_num_rec;
                                        total_score.setText("" + total_score_num_rec);
                                        if (total_score_num_rec == 0){
                                            duration = 1800;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 0 && total_score_num_rec <= 5){
                                            duration -= (total_score_num_rec)*9;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 5 && total_score_num_rec <= 10){
                                            duration -= (total_score_num_rec)*6;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 11 && total_score_num_rec <= 19){
                                            duration -= (total_score_num_rec)*3;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 20 && total_score_num_rec <= 28){
                                            duration -= (total_score_num_rec);
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 29){
                                            duration = 800;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                    }
                                    else {
                                        if (total_score_num_rec > high_score_rec) {
                                            high_score_rec = total_score_num_rec;
                                            new_high_rec = true;
                                        }

                                        SharedPreferences settings2_rec = getSharedPreferences("high_score_rec", 0);

                                        SharedPreferences.Editor editor = settings2_rec.edit();
                                        editor.putInt("high_score_rec", high_score_rec);
                                        editor.apply();

                                        Intent intent = new Intent(getApplicationContext(),EndPage2.class);
                                        startActivity(intent);
                                    }
                                    break;
                                case 2:
                                    if (currentAnimation == 1) {
                                        ++total_score_num_rec;
                                        total_score.setText("" + total_score_num_rec);
                                        if (total_score_num_rec == 0){
                                            duration = 1800;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 0 && total_score_num_rec <= 5){
                                            duration -= (total_score_num_rec)*9;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 5 && total_score_num_rec <= 10){
                                            duration -= (total_score_num_rec)*6;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 11 && total_score_num_rec <= 19){
                                            duration -= (total_score_num_rec)*3;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 20 && total_score_num_rec <= 28){
                                            duration -= (total_score_num_rec);
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 29){
                                            duration = 800;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                    }
                                    else {
                                        if (total_score_num_rec > high_score_rec) {
                                            high_score_rec = total_score_num_rec;
                                            new_high_rec = true;
                                        }
                                        SharedPreferences settings2_rec = getSharedPreferences("high_score_rec", 0);

                                        SharedPreferences.Editor editor = settings2_rec.edit();
                                        editor.putInt("high_score_rec", high_score_rec);
                                        editor.apply();

                                        Intent intent = new Intent(getApplicationContext(),EndPage2.class);
                                        startActivity(intent);
                                    }
                                    break;
                                case 3:
                                    if (currentAnimation == 2) {
                                        ++total_score_num_rec;
                                        total_score.setText("" + total_score_num_rec);
                                        if (total_score_num_rec == 0){
                                            duration = 1800;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 0 && total_score_num_rec <= 5){
                                            duration -= (total_score_num_rec)*9;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 5 && total_score_num_rec <= 10){
                                            duration -= (total_score_num_rec)*6;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 11 && total_score_num_rec <= 19){
                                            duration -= (total_score_num_rec)*3;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 20 && total_score_num_rec <= 28){
                                            duration -= (total_score_num_rec);
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 29){
                                            duration = 800;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                    }
                                    else {
                                        if (total_score_num_rec > high_score_rec) {
                                            high_score_rec = total_score_num_rec;
                                            new_high_rec = true;
                                        }
                                        SharedPreferences settings2_rec = getSharedPreferences("high_score_rec", 0);

                                        SharedPreferences.Editor editor = settings2_rec.edit();
                                        editor.putInt("high_score_rec", high_score_rec);
                                        editor.apply();

                                        Intent intent = new Intent(getApplicationContext(),EndPage2.class);
                                        startActivity(intent);
                                    }
                                    break;
                                case 4:
                                    if (currentAnimation == 3) {
                                        ++total_score_num_rec;
                                        total_score.setText("" + total_score_num_rec);
                                        if (total_score_num_rec == 0){
                                            duration = 1800;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 0 && total_score_num_rec <= 5){
                                            duration -= (total_score_num_rec)*9;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 5 && total_score_num_rec <= 10){
                                            duration -= (total_score_num_rec)*6;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 11 && total_score_num_rec <= 19){
                                            duration -= (total_score_num_rec)*3;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 20 && total_score_num_rec <= 28){
                                            duration -= (total_score_num_rec);
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                        else if (total_score_num_rec > 29){
                                            duration = 800;
                                            move.setDuration(duration);
                                            duration_num.setText("" + duration);
                                        }
                                    }
                                    else {
                                        if (total_score_num_rec > high_score_rec) {
                                            high_score_rec = total_score_num_rec;
                                            new_high_rec = true;
                                        }
                                        SharedPreferences settings2_rec = getSharedPreferences("high_score_rec", 0);

                                        SharedPreferences.Editor editor = settings2_rec.edit();
                                        editor.putInt("high_score_rec", high_score_rec);
                                        editor.apply();

                                        Intent intent = new Intent(getApplicationContext(),EndPage2.class);
                                        startActivity(intent);
                                    }
                                    break;
                            }
                            switch(color_box_fall_random.nextInt(4)) {
                                case 0:
                                    color1.startAnimation(move);
                                    color2.clearAnimation();
                                    color3.clearAnimation();
                                    color4.clearAnimation();
                                    ballcolor = 1;
                                    break;
                                case 1:
                                    color2.startAnimation(move);
                                    color1.clearAnimation();
                                    color3.clearAnimation();
                                    color4.clearAnimation();
                                    ballcolor = 2;
                                    break;
                                case 2:
                                    color3.startAnimation(move);
                                    color1.clearAnimation();
                                    color2.clearAnimation();
                                    color4.clearAnimation();
                                    ballcolor = 3;
                                    break;
                                case 3:
                                    color4.startAnimation(move);
                                    color1.clearAnimation();
                                    color2.clearAnimation();
                                    color3.clearAnimation();
                                    ballcolor = 4;
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

        switch(color_box_fall_random.nextInt(4)){
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
        }

        loc = new int[2];
        loc1 = new int[2];

        final android.os.Handler customHandler = new Handler();

        Runnable updateTimerThread = new Runnable() {
            public void run() {
                color1.getLocationOnScreen(loc);
                rectangle.getLocationOnScreen(loc1);
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
                    rectangle.startAnimation(square_rotate1);
                    break;
                case 2:
                    rectangle.startAnimation(square_rotate2);
                    break;
                case 3:
                    rectangle.startAnimation(square_rotate3);
                    break;
                case 4:
                    currentAnimation = 0;
                    rectangle.startAnimation(square_rotate4);
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
        startActivity(new Intent(StartPage2.this, MainActivity.class));
        finish();
    }
}
