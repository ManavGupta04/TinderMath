package com.example.manav.tindermaths;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;
import android.view.GestureDetector.OnGestureListener;

public class QuizUI extends AppCompatActivity implements OnGestureListener {


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

        //gesture
        gestureDetector = new GestureDetector(QuizUI.this, QuizUI.this);
        //end of gesture


        nextQuestion();

    }

    public void nextQuestion() {
        String[] readQuestion = questions.getNextQuestion();
        //set question text
        String questionText = readQuestion[0];
        lblQuestions.setText(questionText);
        //set if true = correct, false= wrong
        if (readQuestion[1].equals("FALSE")) {
            questionAnswer = false;
        } else {
            questionAnswer = true;
        }
    }

    public void checkAnswerCorrect(View view) {
        int answerGiven = view.getId();
        boolean correct = false;
        if (answerGiven == R.id.btnCorrect) {
            correct = true;
        }
        if (correct == questionAnswer) {
            Snackbar.make(view, "Correct", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            score++;
        } else {
            Snackbar.make(view, "False", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
        numberOfAnsweredQuestions++;
        //redraw scores
        lblScore.setText("Score: " + score + "/" + numberOfAnsweredQuestions);
        nextQuestion();
    }

    //swipe stuff below
    GestureDetector gestureDetector;



    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y) {


    //swipe left
        if(motionEvent1.getX() - motionEvent2.getX() > 50){

            Toast.makeText(QuizUI.this , " Swipe Left " , Toast.LENGTH_LONG).show();

            return true;
        }
    //swipe right
        if(motionEvent2.getX() - motionEvent1.getX() > 50) {

            Toast.makeText(QuizUI.this, " Swipe Right ", Toast.LENGTH_LONG).show();

            return true;
        }
        else {

            return true ;
        }
    }

    @Override
    public void onLongPress(MotionEvent arg0) {

        // TODO Auto-generated method stub

    }

    @Override
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {

        // TODO Auto-generated method stub

        return false;
    }

    @Override
    public void onShowPress(MotionEvent arg0) {

        // TODO Auto-generated method stub

    }

    @Override
    public boolean onSingleTapUp(MotionEvent arg0) {

        // TODO Auto-generated method stub

        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {

        // TODO Auto-generated method stub

        return gestureDetector.onTouchEvent(motionEvent);
    }

    @Override
    public boolean onDown(MotionEvent arg0) {

        return false;
    }



}