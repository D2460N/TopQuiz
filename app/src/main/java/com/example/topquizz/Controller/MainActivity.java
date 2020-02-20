package com.example.topquizz.Controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;




import com.example.topquizz.Model.User;
import com.example.topquizz.R;
import static com.example.topquizz.Controller.LeaderActivity.theSCORE;
import


import static java.lang.System.out;

public class MainActivity extends AppCompatActivity {

    private TextView mGreetingText;
    private EditText mNameInput;
    private Button mPlayButton;
    private Button mLeaderButton;
    private User mUser;
    public static final int GAME_ACTIVITY_REQUEST_CODE = 42;
    private SharedPreferences mPreferences;

    public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";
    public static final String PREF_KEY_FIRSTNAME = "PREF_KEY_FIRSTNAME";


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == GAME_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);
            String alreadyExistingScores = mPreferences.getString(theSCORE, "");
            if (alreadyExistingScores.equals("")) {
                alreadyExistingScores += score;
                mLeaderButton.setVisibility(View.VISIBLE);
            } else {
                alreadyExistingScores += ", " + score;
                mLeaderButton.setVisibility(View.VISIBLE);

            }
            mPreferences.edit().putString(theSCORE, alreadyExistingScores).apply();

            String name = data.getStringExtra(GameActivity.BUNDLE_EXTRA_NAME);
            String alreadyExistingNames = mPreferences.getString(theNAME, "");
            if (alreadyExistingNames.equals("")) {
                alreadyExistingNames += name;
            } else {
                alreadyExistingNames += ", " + name;
            }
            mPreferences.edit().putString(theNAME, alreadyExistingNames).apply();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("MainActivity::onCreate()");

        mUser = new User();

        mPreferences = getPreferences(MODE_PRIVATE);

        mGreetingText =  findViewById(R.id.activity_main_greeting_txt);
        mNameInput =  findViewById(R.id.activity_main_name_input);
        mPlayButton =  findViewById(R.id.activity_main_play_btn);

        mPlayButton.setEnabled(false);

        greetUser();

        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length() != 0);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = mNameInput.getText().toString();
                mUser.setFirstname(firstname);

                mPreferences.edit().putString(PREF_KEY_FIRSTNAME, mUser.getFirstname()).apply();


                Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
                startActivityForResult(gameActivityIntent, GAME_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (GAME_ACTIVITY_REQUEST_CODE == requestCode && RESULT_OK == resultCode) {
            int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE, 0);

            mPreferences.edit().putInt(PREF_KEY_SCORE, score).apply();

            greetUser();
        }
    }

    private void greetUser() {
        String firstname = mPreferences.getString(PREF_KEY_FIRSTNAME, null);

        if (null != firstname) {
            int score = mPreferences.getInt(PREF_KEY_SCORE, 0);

            String fulltext = "Welcome back, " + firstname
                    + "!\nYour last score was " + score
                    + ", will you do better this time?";
            mGreetingText.setText(fulltext);
            mNameInput.setText(firstname);
            mNameInput.setSelection(firstname.length());
            mPlayButton.setEnabled(true);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        out.println("MainActivity::onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();

        out.println("MainActivity::onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();

        out.println("MainActivity::onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();

        out.println("MainActivity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        out.println("MainActivity::onDestroy()");
    }
}


//ok