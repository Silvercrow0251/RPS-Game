package com.example.rpsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

      ImageButton Rock, Paper, Scissors;
      Button btnReset, btnClose;
      ImageView imgComputer, imgHuman;
      TextView Machine_Score, Humanity_Score;
      int Human_Score = 0, Computer_Score = 0;
      Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Rock = (ImageButton) findViewById(R.id.Rock);
        Paper = (ImageButton) findViewById(R.id.Paper);
        Scissors = (ImageButton) findViewById(R.id.Scissors);

        imgComputer = (ImageView) findViewById(R.id.imgComputer);
        imgHuman = (ImageView) findViewById(R.id.imgHuman);

        Machine_Score = (TextView) findViewById(R.id.Machine_Score);
        Humanity_Score = (TextView) findViewById(R.id.Humanity_Score);

        btnReset = (Button) findViewById(R.id.btnReset);
        btnClose = (Button) findViewById(R.id.btnClose);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                imgHuman.setImageResource(R.drawable.human_2);
                imgComputer.setImageResource(R.drawable.comp_1);
                Machine_Score.setText("" +Integer.toString(Computer_Score = 0));
                Humanity_Score.setText("" +Integer.toString(Human_Score = 0) );
            }
        });

        Rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                int s = 1000;
                imgHuman.setImageResource(R.drawable.rock_3);
                String message = play_turn("Rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).setDuration(s = 5000);
                Machine_Score.setText("" +Integer.toString(Computer_Score));
                Humanity_Score.setText("" +Integer.toString(Human_Score) );

                if (Human_Score == 6){
                    Toast.makeText(MainActivity.this, "Humanity Wins " + Human_Score + ":"+ Computer_Score, Toast.LENGTH_LONG).show();
                    Machine_Score.setText("" +Integer.toString(Computer_Score = 0));
                    Humanity_Score.setText("" +Integer.toString(Human_Score = 0) );

                }
                if (Computer_Score == 6){
                    Toast.makeText(MainActivity.this, "Death to Humanity, You Lose! " +Computer_Score+":"+ Human_Score, Toast.LENGTH_LONG).show();
                    Machine_Score.setText("" +Integer.toString(Computer_Score = 0));
                    Humanity_Score.setText("" +Integer.toString(Human_Score = 0) );
                }
            }

        });

        Paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                int s = 1000;
            imgHuman.setImageResource(R.drawable.paper_3);
                String message = play_turn("Paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).setDuration(s =5000);
                Machine_Score.setText("" +Integer.toString(Computer_Score));
                Humanity_Score.setText("" +Integer.toString(Human_Score) );

                if (Human_Score == 6){
                    Toast.makeText(MainActivity.this, "Humanity Wins " + Human_Score + ":"+ Computer_Score, Toast.LENGTH_LONG).show();
                    Machine_Score.setText("" +Integer.toString(Computer_Score = 0));
                    Humanity_Score.setText("" +Integer.toString(Human_Score = 0) );

                }
                if (Computer_Score == 6){
                    Toast.makeText(MainActivity.this, "Death to Humanity, You Lose! " + Computer_Score+":"+ Human_Score, Toast.LENGTH_LONG).show();
                    Machine_Score.setText("" +Integer.toString(Computer_Score = 0));
                    Humanity_Score.setText("" +Integer.toString(Human_Score = 0) );

                }
            }
        });

        Scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                int s = 1000;
                imgHuman.setImageResource(R.drawable.scissors_3);
                String message = play_turn("Scissors");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).setDuration(s =5000);
                Machine_Score.setText("" +Integer.toString(Computer_Score));
                Humanity_Score.setText("" +Integer.toString(Human_Score) );

            if (Human_Score == 6){
                Toast.makeText(MainActivity.this, "Humanity Wins " +  ":"+ Computer_Score, Toast.LENGTH_LONG).show();
                Machine_Score.setText("" +Integer.toString(Computer_Score = 0));
                Humanity_Score.setText("" +Integer.toString(Human_Score = 0) );

            }
            if (Computer_Score == 6){
                Toast.makeText(MainActivity.this, "Death to Humanity, You Lose! " + Computer_Score+":"+ Human_Score, Toast.LENGTH_LONG).show();
                Machine_Score.setText("" +Integer.toString(Computer_Score = 0));
                Humanity_Score.setText("" +Integer.toString(Human_Score = 0) );

            }
            }
        });
    }

    public String play_turn( String player_choice){
        String computer_choice ="";
        Random r = new Random();

        Machine_Score.setText("" +Integer.toString(Computer_Score));
        Humanity_Score.setText("" +Integer.toString(Human_Score) );
        if (Human_Score == 5){
            Intent intent = new Intent(getApplicationContext(), Result.class);
        }
        if (Computer_Score == 5){
            Intent intent = new Intent(getApplicationContext(), Result.class);
        }

        // Choose Rock, Paper, or Scissors
        int computer_choice_num = r.nextInt(3) + 1;

        if (computer_choice_num == 1){
            computer_choice ="Rock";
        } else

        if (computer_choice_num == 2){
            computer_choice ="Paper";
        } else

        if (computer_choice_num == 3){
            computer_choice ="Scissors";
        }
        // set computer response image

        if (computer_choice == "Rock"){
            imgComputer.setImageResource(R.drawable.rock_2);
        } else
        if (computer_choice == "Paper"){
            imgComputer.setImageResource(R.drawable.paper_2);
        } else
        if (computer_choice == "Scissors"){
            imgComputer.setImageResource(R.drawable.scissors_2);
        }
        // Computer vs Human
        if (computer_choice == player_choice) {
            //TIE
            return "Draw. hahaha!!! You'll never beat me!";
        }

        else if ((player_choice == "Rock" && computer_choice == "Scissors")) {
            Human_Score++;
            return "Rock BEATS scissors, You Win!";
        }
        else if ((player_choice == "Rock" && computer_choice == "Paper")) {
            Computer_Score++;
            return "Paper beats rock, Machines Win!";
        }
        else if ((player_choice == "Scissors" && computer_choice == "Rock")) {
            Computer_Score++;
            return "Rock BEATS scissors, Machines Win!!";
        }
        else if ((player_choice == "Scissors" && computer_choice == "Paper")) {
            Human_Score++;
            return "Scissors cut paper, You Win!";
        }
        else if (player_choice == "Paper" && computer_choice == "Rock") {
            Human_Score++;
            return "Paper beats rock, You Win!";
        }
        else if (player_choice == "Paper" && computer_choice == "Scissors") {
            Computer_Score++;
            return "Paper beats rock, Machines Win!";
        }
        else return "GG";
    }
}