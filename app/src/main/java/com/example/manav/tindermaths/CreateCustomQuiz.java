package com.example.manav.tindermaths;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateCustomQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_custom_quiz);
        Intent i = getIntent();
    }

    public void getQuizDetails(View view){
        String quizName =  ((EditText) findViewById(R.id.enterQuizName)).getText().toString();
        try {
            FileOutputStream outputStream = openFileOutput((quizName + ".txt"), Context.MODE_APPEND); // TODO: Make sure this can be read
            //((EditText)findViewById(R.id.q1q)).getText().toString() + "," + ((EditText)findViewById(R.id.q1q)).getText().toString()
            //outputStream.write();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
