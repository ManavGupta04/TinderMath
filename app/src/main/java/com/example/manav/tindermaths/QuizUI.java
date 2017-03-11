package com.example.manav.tindermaths;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
//import com.facebook.FacebookSdk;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;
import android.view.GestureDetector.OnGestureListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import static android.support.design.R.styleable.CoordinatorLayout;

public class QuizUI extends AppCompatActivity implements OnGestureListener {


    //Global variables
    private String difficulty;
    private boolean questionAnswer;
    private int score = 0;
    private int numberOfAnsweredQuestions = 0;
    private ArrayList<String[]> questions = new ArrayList<String[]>();
    ConstraintLayout cl;
    //textboxes/labels
    TextView lblDifficulty;
    TextView lblQuestions;
    TextView lblScore;

    InputStream is;
    BufferedReader reader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_ui);
        lblDifficulty = (TextView) findViewById(R.id.lblDifficulty);
        lblQuestions = (TextView) findViewById(R.id.txtQuestion);
        lblScore = (TextView) findViewById(R.id.lblTextScore);
        cl = (ConstraintLayout) findViewById(R.id.layout);
        //set difficulty text
        Bundle b = getIntent().getExtras();
        difficulty = b.getString("id");
        lblDifficulty.setText("Difficulty: " + difficulty);

        readFile(difficulty);

        Thread thread = new Thread(new Runnable(){
            @Override
            public void run(){
                final long startTime = System.currentTimeMillis();
                while(numberOfAnsweredQuestions<20) {
                    try {
                        Thread.sleep(100);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                float timeSpent = (System.currentTimeMillis() - startTime) / 1000;
                                setTime(timeSpent);
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                long endTime = System.currentTimeMillis();
                long timeTaken = endTime - startTime;
                float timeTakenSeconds = timeTaken / 1000;
                Intent i = new Intent(QuizUI.this, EndGame.class);
                i.putExtra("score", "It took you " + timeTakenSeconds + " to complete 20 questions");
                startActivity(i);
            }
        });
        thread.start();

        //gesture
        gestureDetector = new GestureDetector(QuizUI.this, QuizUI.this);
        //end of gesture


        nextQuestion();

    }

    public void setTime(float timeSpent){
        TextView time = (TextView) findViewById(R.id.lblTimeLeft);
        time.setText("Time : " + timeSpent);
    }

    public void readFile(String filename){
        switch (filename)
        {
            case "primary":
                is = this.getResources().openRawResource(R.raw.primary);
                break;
            case "gcse":
                is = this.getResources().openRawResource(R.raw.gcse);
                break;
            case "alevel":
                is = this.getResources().openRawResource(R.raw.alevel);
                break;
            case "degree":
                is = this.getResources().openRawResource(R.raw.degree);
                break;
            default:
                is = this.getResources().openRawResource(R.raw.primary);
        }

        reader = new BufferedReader(new InputStreamReader(is));
        System.out.println(filename);
        String questionLine = null;
        String[] question = null;
        System.out.println("Made it to the reading");
        try {
            while((questionLine = reader.readLine()) != null)
            {
                question = questionLine.split(",");
                questions.add(question);
            }
            System.out.println("fbdfbdgb" + questions.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String[] getNextQuestion()
    {
        Random rand = new Random();
        int nextIntIndex = rand.nextInt(questions.size());
        String[] question = questions.get(nextIntIndex);
        questions.remove(nextIntIndex);
        return question;
    }


    public void nextQuestion() {
        String[] readQuestion = getNextQuestion();
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
        if(numberOfAnsweredQuestions != 20)
            nextQuestion();
    }

    public void checkAnswerCorrect(Boolean answerGiven) {
        if (answerGiven == questionAnswer) {
            Snackbar.make(cl, "Correct", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            score++;
        } else {
            Snackbar.make(cl, "False", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        }
        numberOfAnsweredQuestions++;
        //redraw scores
        lblScore.setText("Score: " + score + "/" + numberOfAnsweredQuestions);
        if(numberOfAnsweredQuestions != 20)
            nextQuestion();
    }

    //swipe stuff below
    GestureDetector gestureDetector;



    @Override
    public boolean onFling(MotionEvent motionEvent1, MotionEvent motionEvent2, float X, float Y) {


    //swipe left
        if(motionEvent1.getX() - motionEvent2.getX() > 50){

            //Toast.makeText(QuizUI.this , " Swipe Left " , Toast.LENGTH_LONG).show();
            checkAnswerCorrect(false);
            return true;
        }
    //swipe right
        if(motionEvent2.getX() - motionEvent1.getX() > 50) {

            //Toast.makeText(QuizUI.this, " Swipe Right ", Toast.LENGTH_LONG).show();
            checkAnswerCorrect(true);
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