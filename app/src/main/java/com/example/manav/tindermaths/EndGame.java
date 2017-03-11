package com.example.manav.tindermaths;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EndGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        Bundle b = getIntent().getExtras();
        String score = b.getString("score");
        TextView end = (TextView) findViewById(R.id.EndScore);
        end.setText(score);
    }
}
