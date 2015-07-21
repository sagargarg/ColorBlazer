package com.abi.sagar.colorapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Sagar on 7/20/2015.
 */
public class EndPage3 extends Activity implements View.OnClickListener {

    public static TextView score_pent;
    public static TextView highscore_pent;
    public static TextView gameOver, gameOver2;

    Animation score_box_0;
    Animation score_box_1;
    Animation score_box_2;
    Animation score_box_3;
    Animation score_box_4;

    View scores;
    TextView score_word;
    TextView highscore_word;
    View replay_button_pent;
    View home_button;
    View nothing_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_page_three);

        Button mBtn1 = (Button) findViewById(R.id.replay_button_pent);
        mBtn1.setOnClickListener(this);

        Button mBtn2 = (Button) findViewById(R.id.home_button);
        mBtn2.setOnClickListener(this);

        gameOver = (TextView) findViewById(R.id.gameover);
        gameOver2 = (TextView) findViewById(R.id.gameover2);
        score_box_0 = AnimationUtils.loadAnimation(this, R.anim.score_box_0);

        if (StartPage3.new_high_pent) {
            gameOver2.setText("New High Score!");
            gameOver2.startAnimation(score_box_0);
        }
        else {
            gameOver.setText("Game Over!");
            gameOver.startAnimation(score_box_0);
        }

        highscore_pent = (TextView) findViewById(R.id.highscore_pent);
        score_pent = (TextView) findViewById(R.id.score_pent);

        highscore_pent.setText("" + StartPage3.high_score_pent);
        score_pent.setText("" + StartPage3.total_score_num_pent);

        score_box_1 = AnimationUtils.loadAnimation(this, R.anim.score_box_1);
        score_box_2 = AnimationUtils.loadAnimation(this, R.anim.score_box_2);
        score_box_3 = AnimationUtils.loadAnimation(this, R.anim.score_box_3);
        score_box_4 = AnimationUtils.loadAnimation(this, R.anim.score_box_4);

        scores = findViewById(R.id.scores);
        score_word = (TextView) findViewById(R.id.score_word);
        highscore_word = (TextView) findViewById(R.id.highscore_word);
        replay_button_pent = findViewById(R.id.replay_button_pent);
        home_button = findViewById(R.id.home_button);
        nothing_button = findViewById(R.id.nothing_button);

        scores.startAnimation(score_box_1);
        score_pent.startAnimation(score_box_1);
        score_word.startAnimation(score_box_1);
        highscore_word.startAnimation(score_box_1);
        highscore_pent.startAnimation(score_box_1);
        replay_button_pent.startAnimation(score_box_2);
        home_button.startAnimation(score_box_3);
        nothing_button.startAnimation(score_box_4);


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
            case R.id.replay_button_pent:
                //StartPage.red_score_num = 0;
                //StartPage.blue_score_num = 0;
                //StartPage.green_score_num = 0;
                Intent intent = new Intent(this, StartPage3.class);
                finish();
                startActivity(intent);
                break;
            case R.id.home_button:
                //Intent intent2 = new Intent(this, MainActivity.class);
                finish();
                //startActivity(intent2);
                break;
        }
    }
}
