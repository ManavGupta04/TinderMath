package com.example.manav.tindermaths;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.widget.ProfilePictureView;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Choose your Category");
        addItemsOnSpinner1();

        //profile pic and name
        Bundle b = getIntent().getExtras();
        String userID = b.getString("userId");
        String userName = b.getString("userName");
        ProfilePictureView profilrPicture = (ProfilePictureView) findViewById(R.id.profilePic);
        profilrPicture = (ProfilePictureView) (getIntent().getSerializableExtra("userPic"));
        TextView txtName = (TextView) findViewById(R.id.txtFbName);
        txtName.setText(userName);



    }

    public void setFBPic(String URL)
    {

    }
    public void goToFacebook(View view) {
        Intent i = new Intent(this, FacebookLogin.class);
        startActivity(i);
    }

    public void addCustomQuiz(View view) {
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

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner);
        ArrayList<String> CustomQuizNames = readFile("customquiznames.txt");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, CustomQuizNames);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter);
    }

    public ArrayList<String> readFile(String filename) {
        FileInputStream fis;
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayList<String> files = new ArrayList<String>();
        try {

            fis = openFileInput(filename);
            spinner.setVisibility(View.VISIBLE);
            byte[] buffer = new byte[1024];
            int n;
            while ((n = fis.read(buffer)) != -1) {
                String string = new String(buffer, 0, n);
                files.add(string);
            }

        } catch (IOException e) {
            spinner.setVisibility(View.INVISIBLE);
        }
        return files;
    }

    public void playCustomQuiz(View view) {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String fileName = String.valueOf(spinner.getSelectedItem());
        Intent i = new Intent(this, QuizUI.class);
        i.putExtra("id", "Name");
        startActivity(i);
    }



}