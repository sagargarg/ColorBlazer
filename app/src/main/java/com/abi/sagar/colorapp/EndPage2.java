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
 * Created by Sagar on 7/14/2015.
 */
public class EndPage2 extends Activity implements View.OnClickListener{

    public static TextView score_rec;
    public static TextView highscore_rec;
    public static TextView gameOver, gameOver2;

    Animation score_box_0;
    Animation score_box_1;
    Animation score_box_2;
    Animation score_box_3;
    Animation score_box_4;

    View scores;
    TextView score_word;
    TextView highscore_word;
    View replay_button_rec;
    View home_button;
    View nothing_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_page_two);

        Button mBtn1 = (Button) findViewById(R.id.replay_button_rec);
        mBtn1.setOnClickListener(this);

        Button mBtn2 = (Button) findViewById(R.id.home_button);
        mBtn2.setOnClickListener(this);

        gameOver = (TextView) findViewById(R.id.gameover);
        gameOver2 = (TextView) findViewById(R.id.gameover2);
        score_box_0 = AnimationUtils.loadAnimation(this, R.anim.score_box_0);

        if (StartPage2.new_high_rec) {
            gameOver2.setText("New High Score!");
            gameOver2.startAnimation(score_box_0);
        }
        else {
            gameOver.setText("Game Over!");
            gameOver.startAnimation(score_box_0);
        }

        highscore_rec = (TextView) findViewById(R.id.highscore_rec);
        score_rec = (TextView) findViewById(R.id.score_rec);

        highscore_rec.setText("" + StartPage2.high_score_rec);
        score_rec.setText("" + StartPage2.total_score_num_rec);

        score_box_1 = AnimationUtils.loadAnimation(this, R.anim.score_box_1);
        score_box_2 = AnimationUtils.loadAnimation(this, R.anim.score_box_2);
        score_box_3 = AnimationUtils.loadAnimation(this, R.anim.score_box_3);
        score_box_4 = AnimationUtils.loadAnimation(this, R.anim.score_box_4);

        scores = findViewById(R.id.scores);
        score_word = (TextView) findViewById(R.id.score_word);
        highscore_word = (TextView) findViewById(R.id.highscore_word);
        replay_button_rec = findViewById(R.id.replay_button_rec);
        home_button = findViewById(R.id.home_button);
        nothing_button = findViewById(R.id.nothing_button);

        scores.startAnimation(score_box_1);
        score_rec.startAnimation(score_box_1);
        score_word.startAnimation(score_box_1);
        highscore_word.startAnimation(score_box_1);
        highscore_rec.startAnimation(score_box_1);
        replay_button_rec.startAnimation(score_box_2);
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
            case R.id.replay_button:
                //StartPage.red_score_num = 0;
                //StartPage.blue_score_num = 0;
                //StartPage.green_score_num = 0;
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