package com.abi.sagar.colorapp;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.Random;

public class StartPage2 extends Activity {

    Animation rotate1;
    Animation rotate2;
    Animation rotate3;
    View triangle;
    int currentAnimation = 0;
    int color_box_fall = 0;
    int random_int;

    Animation move;
    Animation move1;
    Animation move2;
    Animation move3;
    View color1;
    View color2;
    View color3;
    Random color_box_fall_random;
    int i;
    Handler handler;

    TextView red_score;
    TextView blue_score;
    TextView green_score;

    int red_score_num = 0;
    int blue_score_num = 0;
    int green_score_num = 0;

    int[] loc, loc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page_two);

        rotate1 = AnimationUtils.loadAnimation(this, R.anim.rotate1);
        rotate2 = AnimationUtils.loadAnimation(this, R.anim.rotate2);
        rotate3 = AnimationUtils.loadAnimation(this, R.anim.rotate3);
        triangle = (View) findViewById(R.id.triangle);
        triangle.setRotation(60);

        move = AnimationUtils.loadAnimation(this, R.anim.move);
        /*move1 = AnimationUtils.loadAnimation(this, R.anim.move1);
        move2 = AnimationUtils.loadAnimation(this, R.anim.move2);
        move3 = AnimationUtils.loadAnimation(this, R.anim.move3);*/
        color1 = (View) findViewById(R.id.color1);
        color2 = (View) findViewById(R.id.color2);
        color3 = (View) findViewById(R.id.color3);

        red_score = (TextView) findViewById(R.id.red_score);
        blue_score = (TextView) findViewById(R.id.blue_score);
        green_score = (TextView) findViewById(R.id.green_score);

        color_box_fall_random = new Random();
        handler = new Handler();

        move.setAnimationListener(new Animation.AnimationListener(){
            @Override
            public void onAnimationStart(Animation animation){

            }

            @Override
            public void onAnimationEnd(Animation animation){
                i++;
                if(i < 1000){
                    handler.postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            switch(color_box_fall_random.nextInt(3)) {
                                case 0:
                                    color1.startAnimation(move);
                                    color2.clearAnimation();
                                    color3.clearAnimation();
                                    red_score_num++;
                                    red_score.setText("" + red_score_num);
                                    break;
                                case 1:
                                    color2.startAnimation(move);
                                    color1.clearAnimation();
                                    color3.clearAnimation();
                                    green_score_num++;
                                    green_score.setText("" + green_score_num);
                                    break;
                                case 2:
                                    color3.startAnimation(move);
                                    color1.clearAnimation();
                                    color2.clearAnimation();
                                    blue_score_num++;
                                    blue_score.setText("" + blue_score_num);
                                    break;
                            }
                        }
                    }, 1000);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation){

            }
        });

        /*red_score.setText("" + red_score_num);
        green_score.setText("" + green_score_num);
        blue_score.setText("" + blue_score_num);*/

        switch(color_box_fall_random.nextInt(3)){
            case 0:
                color1.startAnimation(move);
                red_score_num++;
                red_score.setText("" + red_score_num);
                break;
            case 1:
                color2.startAnimation(move);
                green_score_num++;
                green_score.setText("" + green_score_num);
                break;
            case 2:
                color3.startAnimation(move);
                blue_score_num++;
                blue_score.setText("" + blue_score_num);
                break;
        }



        /*color1.startAnimation(move1);
        color2.startAnimation(move2);
        color3.startAnimation(move3);*/


        /*color_box_fall_random = new Random();
        random_int = (color_box_fall_random.nextInt(2));

        for (int i = 0; i < 10; i++){
            if (random_int == 0){
                color1.startAnimation(move);
            }
            else if (random_int == 1){
                color2.startAnimation(move);
            }
            else{
                color3.startAnimation(move);
            }
        }*/


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