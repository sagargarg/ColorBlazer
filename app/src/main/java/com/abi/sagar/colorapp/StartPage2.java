package com.abi.sagar.colorapp;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class StartPage2 extends Activity {

    AnimationDrawable rocketAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page_two);

        Animation rotate1 = AnimationUtils.loadAnimation(this, R.anim.rotate);
        findViewById(R.id.triangle1).startAnimation(rotate1);
        rotate1.reset();
        rotate1.start();

        final Animation rotate2 = AnimationUtils.loadAnimation(this, R.anim.rotate2);
        View Tri2 = (View) findViewById(R.id.triangle2);//.startAnimation(rotate2);
        Tri2.startAnimation(rotate2);
        rotate2.reset();
        rotate2.start();

        Tri2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rotate2.reset();
                rotate2.start();
            }
        });


        ImageView rocketImage = (ImageView) findViewById(R.id.moving_red_box);
        rocketImage.setBackgroundResource(R.drawable.animation_box);
        rocketAnimation = (AnimationDrawable) rocketImage.getBackground();
        rocketAnimation.start();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // This code makes the animation start after user clicks on the screen
    /*public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            rocketAnimation.start();
            return true;
        }
        return super.onTouchEvent(event);
    }*/
}