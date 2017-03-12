package com.example.manav.tindermaths;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

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
            outputStream.write(((((EditText)findViewById(R.id.q1q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q1a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q2q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q2a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q3q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q3a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q4q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q4a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q5q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q5a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q6q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q6a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q7q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q7a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q8q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q8a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q9q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q9a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q10q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q10a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q11q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q11a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q12q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q12a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q13q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q13a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q14q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q14a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q15q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q15a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q16q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q16a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q17q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q17a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q18q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q18a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q19q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q19a)).getSelectedItem() + "\n")).getBytes());
            outputStream.write(((((EditText)findViewById(R.id.q20q)).getText().toString()) + "," + String.valueOf(((Spinner)findViewById(R.id.q20a)).getSelectedItem() + "\n")).getBytes());
            outputStream.close();
            //FileOutputStream outputStream = openFileOutput((quizName + ".txt"), Context.MODE_APPEND); // TODO: Make sure this can be read

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
