package com.example.manav.tindermaths;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuizUI extends AppCompatActivity {

    //Global variables
    private String difficulty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_ui);

        //set difficulty text
        Bundle b = getIntent().getExtras();
        difficulty = b.getString("id");
        //lblDifficulty.text = ("Difficulty: " + difficulty);
    }

    /*
    //constructor
    public QuizUI(String )
    {

    }

    */
}
