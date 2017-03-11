package com.example.manav.tindermaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.facebook.FacebookSdk;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Choose your Category");
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

    public void selectCategory(View view){
        Intent i;
        switch(view.getId()) {
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
}
