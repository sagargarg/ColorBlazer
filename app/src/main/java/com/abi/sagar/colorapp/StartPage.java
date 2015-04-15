package com.abi.sagar.colorapp;

import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.view.MotionEvent;
import android.widget.ImageView;

public class StartPage extends Activity {

    int[] drawableIds = {R.drawable.box_red, R.drawable.box_green, R.drawable.box_blue, R.drawable.box_yellow};
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);

        /*ImageView imageView = (ImageView) findViewById(R.id.red_box_change);
        imageView.setOnTouchListener(this);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()== MotionEvent.ACTION_DOWN){
            counter++;
            imageView.setImageResource( drawableIds[ drawableIds.length % counter ] );
        }
        return false;
    }*/

}