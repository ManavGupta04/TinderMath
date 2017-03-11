package com.example.manav.tindermaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Choose your Category");
    }

    public void selectCategory(View view){
        switch(view.getId()) {
            case R.id.Primary:
                System.out.println("Primary");
                Intent i = new Intent(this, QuizUI.class);
                i.putExtra("id", "primary");
                startActivity(i);
                break;
            case R.id.GCSE:
                System.out.println("GCSE");
                break;
            case R.id.A_Level:
                System.out.println("A Level");
                break;
        }
    }
}
