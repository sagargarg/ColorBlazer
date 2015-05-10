package com.abi.sagar.colorapp;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class StartPage2 extends Activity {

    Animation rotate1;
    Animation rotate2;
    Animation rotate3;
    View triangle;
    int currentAnimation = 0;

    Animation move;
    View shape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page_two);

        /*Animation rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);
        findViewById(R.id.triangle1).startAnimation(rotate);*/

        rotate1 = AnimationUtils.loadAnimation(this, R.anim.rotate1);
        rotate2 = AnimationUtils.loadAnimation(this, R.anim.rotate2);
        rotate3 = AnimationUtils.loadAnimation(this, R.anim.rotate3);
        triangle = (View) findViewById(R.id.triangle);
        triangle.setRotation(60);

        move = AnimationUtils.loadAnimation(this, R.anim.move);
        shape = (View) findViewById(R.id.shape);
        shape.startAnimation(move);

        /*ImageView rocketImage = (ImageView) findViewById(R.id.moving_red_box);
        rocketImage.setBackgroundResource(R.drawable.animation_box);
        AnimationDrawable rocketAnimation = (AnimationDrawable) rocketImage.getBackground();
        rocketAnimation.start();*/

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