package com.example.manav.tindermaths;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class QuizUI extends AppCompatActivity {

    //Global variables
    private String difficulty;
    private boolean questionAnswer;
    private int score = 0;
    private int numberOfAnsweredQuestions = 0;

    //textboxes/labels
    TextView lblDifficulty;
    TextView lblQuestions;
    TextView lblScore;
    //setup questions class
    question questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_ui);
        lblDifficulty = (TextView) findViewById(R.id.lblDifficulty);
        lblQuestions = (TextView) findViewById(R.id.txtQuestion);
        lblScore = (TextView) findViewById(R.id.lblTextScore);
        //set difficulty text
        Bundle b = getIntent().getExtras();
        difficulty = b.getString("id");
        lblDifficulty.setText("Difficulty: " + difficulty);
        questions = new question((difficulty + ".txt"));
        nextQuestion();
    }

    public void nextQuestion()
    {
        String[] readQuestion = questions.getNextQuestion();
        //set question text
        String questionText = readQuestion[0];
        lblQuestions.setText(questionText);
        //set if true = correct, false= wrong
        if(readQuestion[1].equals("FALSE"))
        {
            questionAnswer = false;
        }
        else {
            questionAnswer = true;
        }
    }

    public void checkAnswerCorrect(View view){
        int answerGiven = view.getId();
        boolean correct = false;
        if(answerGiven == R.id.btnCorrect){
            correct = true;
        }
        if(correct == questionAnswer){
            Snackbar.make(view, "Correct" , Snackbar.LENGTH_LONG).setAction("Action", null).show();
            score ++;
        } else {
            Snackbar.make(view, "False" , Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
        numberOfAnsweredQuestions ++;
        //redraw scores
    lblScore.setText("Score: " + score + "/" + numberOfAnsweredQuestions);
        nextQuestion();
    }





    //gesture stuff below

}
