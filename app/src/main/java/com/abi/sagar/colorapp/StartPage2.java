package com.abi.sagar.colorapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

/**
 * Created by Sagar on 7/9/2015.
 */
public class StartPage2  extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page_two);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
