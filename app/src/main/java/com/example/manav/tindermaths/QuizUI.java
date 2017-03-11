package com.example.manav.tindermaths;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class QuizUI extends AppCompatActivity {

    //Global variables
    private String difficulty;
    private boolean questionAnswer;
    //textboxes/labels
    TextView lblDifficulty = (TextView) findViewById(R.id.lblDifficulty);
    TextView lblQuestion = (TextView) findViewById(R.id.txtQuestion);

    //setup questions class
    question questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_ui);

        //set difficulty text
        Bundle b = getIntent().getExtras();
        difficulty = b.getString("id");
        lblDifficulty.setText("Difficulty: " + difficulty);
        questions = new question((difficulty + ".txt"));

    }

    public void nextQuestion()
    {
        String[] readQuestion = questions.getNextQuestion();
        //set question text
        String questionText = readQuestion[0];
        lblQuestion.setText(questionText);
        //set if true = correct, false= wrong
        if()
        {

        }
        questionAnswer = readQuestion[1];
    }
    /*
    //constructor
    public QuizUI(String )
    {

    }

    */
}
