package com.example.topquizz.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.topquizz.Model.Question;
import com.example.topquizz.Model.QuestionBank;
import com.example.topquizz.R;

import java.util.Arrays;

public class GameActivity extends AppCompatActivity {

    private TextView gQuestionText;
    private Button gAnswer1;
    private Button gAnswer2;
    private Button gAnswer3;
    private Button gAnswer4;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        mQuestionBank = this.generateQuestions();



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

    private QuestionBank generateQuestions() { Question question1 = new Question("What is the name of the current french president?",
            Arrays.asList("François Hollande", "Emmanuel Macron", "Jacques Chirac", "François Mitterand"),
            1);


        return new QuestionBank(Arrays.asList(question1 ));
    }
    }
}
