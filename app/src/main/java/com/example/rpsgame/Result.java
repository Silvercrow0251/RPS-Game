package com.example.rpsgame;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.result);

            TextView scoreLabel = (TextView) findViewById(R.id.scoreLabel);

            int score = getIntent().getIntExtra("Score", 0);
            scoreLabel.setText(score + "");
        }
}