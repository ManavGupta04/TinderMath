package com.example.manav.tindermaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.facebook.FacebookSdk;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Choose your Category");
        addItemsOnSpinner1();
        Intent i = getIntent();
    }

    public void goToFacebook(View view){
        Intent i = new Intent(this, FacebookLogin.class);
        startActivity(i);
    }

    public void addCustomQuiz(View view){
        Intent i = new Intent(this, CreateCustomQuiz.class);
        startActivity(i);
    }

    public void selectCategory(View view) {
        Intent i;
        switch (view.getId()) {
            case R.id.Primary:
                i = new Intent(this, QuizUI.class);
                i.putExtra("id", "primary");
                startActivity(i);
                break;
            case R.id.GCSE:
                i = new Intent(this, QuizUI.class);
                i.putExtra("id", "gcse");
                startActivity(i);
                break;
            case R.id.A_Level:
                i = new Intent(this, QuizUI.class);
                i.putExtra("id", "alevel");
                startActivity(i);
                break;
        }

    }

    public void addItemsOnSpinner1() {

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        ArrayList<String> CustomQuizNames = readFile("customquizname.txt");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CustomQuizNames);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);spinner1.setAdapter(dataAdapter);
    }

    public ArrayList<String> readFile(String filename) {
        FileInputStream fis;
        ArrayList<String> files = new ArrayList<String>();
        try {
            fis = openFileInput(filename);

            byte[] buffer = new byte[1024];
            int n;
            while ((n = fis.read(buffer)) != -1) {
                String string =new String(buffer, 0, n);
                files.add(string);
            }

        } catch(IOException e) {
            Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
            spinner1.setVisibility(View.INVISIBLE);
        }
        return files;
    }
}
