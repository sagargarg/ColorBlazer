package com.abi.sagar.colorapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {

    AnimationDrawable rocketAnimation;
    AnimationDrawable rocketAnimation2;

    // THis is a comment
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mBtn1 = (Button) findViewById(R.id.start_button);
        mBtn1.setOnClickListener(this);

        Button mBtn2 = (Button) findViewById(R.id.start_button2);
        mBtn2.setOnClickListener(this);

        Button rocketImage = (Button) findViewById(R.id.start_button);
        rocketImage.setBackgroundResource(R.drawable.animation_start_button);
        rocketAnimation = (AnimationDrawable) rocketImage.getBackground();
        rocketAnimation.start();

        Button rocketImage2 = (Button) findViewById(R.id.start_button2);
        rocketImage2.setBackgroundResource(R.drawable.animation_start_button_two);
        rocketAnimation2 = (AnimationDrawable) rocketImage2.getBackground();
        rocketAnimation2.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_button:
                Intent intent = new Intent(this, StartPage.class);
                startActivity(intent);
                break;
            case R.id.start_button2:
                Intent intent2 = new Intent(this, StartPage2.class);
                startActivity(intent2);
                break;
        }
    }
}