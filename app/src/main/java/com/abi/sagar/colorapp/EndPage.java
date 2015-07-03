package com.abi.sagar.colorapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndPage extends Activity implements View.OnClickListener {

    public static TextView score;
    public static TextView highscore;
    public static TextView gameOver, gameOver2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_page);

        Button mBtn1 = (Button) findViewById(R.id.replay_button);
        mBtn1.setOnClickListener(this);

        Button mBtn2 = (Button) findViewById(R.id.home_button);
        mBtn2.setOnClickListener(this);

        gameOver = (TextView) findViewById(R.id.gameover);
        gameOver2 = (TextView) findViewById(R.id.gameover2);
        if (StartPage2.new_high) {
            gameOver.setText("");
        }
        else {
            gameOver2.setText("");
        }

        highscore = (TextView) findViewById(R.id.highscore);
        score = (TextView) findViewById(R.id.score);

        highscore.setText("" + StartPage2.high_score);
        score.setText("" + StartPage2.total_score_num);


        /*Intent intent = new Intent(getApplicationContext(),EndPage.class);
        startActivity(intent);*/
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
            case R.id.replay_button:
                //StartPage2.red_score_num = 0;
                //StartPage2.blue_score_num = 0;
                //StartPage2.green_score_num = 0;
                Intent intent = new Intent(this, StartPage2.class);
                startActivity(intent);
                break;
            case R.id.home_button:
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
                break;
        }
    }
}