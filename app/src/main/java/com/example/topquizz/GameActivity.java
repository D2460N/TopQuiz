package com.example.topquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class GameActivity extends AppCompatActivity {

    private TextView gQuestionText;
    private Button gAnswer1;
    private Button gAnswer2;
    private Button gAnswer3;
    private Button gAnswer4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gQuestionText = (TextView) findViewById(R.id.activity_game_question_text);
        gAnswer1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        gAnswer2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        gAnswer3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        gAnswer4 = (Button) findViewById(R.id.activity_game_answer4_btn);


        gAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        gAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        gAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        gAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
