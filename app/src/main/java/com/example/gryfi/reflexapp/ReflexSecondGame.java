package com.example.gryfi.reflexapp;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ReflexSecondGame extends AppCompatActivity {

    Button startButton, Button1, Button2, Button3;

    long startTime, endTime, currentTime;
    Random random = new Random();
    int randomNumber;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflex_second_game);
        startButton = (Button) findViewById(R.id.startButton1);
        Button1 = (Button) findViewById(R.id.Button1);
        Button2 = (Button) findViewById(R.id.Button2);
        Button3 = (Button) findViewById(R.id.Button3);
        tv = (TextView) findViewById(R.id.textReactionTime);

        startButton.setEnabled(true);
        Button1.setEnabled(false);
        Button2.setEnabled(false);
        Button3.setEnabled(false);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("");
                startButton.setEnabled(false);
                Button1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
                Button2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
                Button3.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startTime = System.currentTimeMillis();
                        randomNumber = random.nextInt(3);
                        switch(randomNumber){
                            case 0:
                                Button1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
                                Button1.setEnabled(true);
                                break;
                            case 1:
                                Button2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
                                Button2.setEnabled(true);
                                break;
                            case 2:
                                Button3.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
                                Button3.setEnabled(true);
                                break;
                        }

                    }
                }, random.nextInt(4000));
            }
        });

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endTime = System.currentTimeMillis();
                currentTime = endTime - startTime;
                startButton.setEnabled(true);
                Button1.setEnabled(false);
                tv.setText(currentTime + " ms");
            }
        });
        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endTime = System.currentTimeMillis();
                currentTime = endTime - startTime;
                startButton.setEnabled(true);
                Button2.setEnabled(false);
                tv.setText(currentTime + " ms");
            }
        });
        Button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endTime = System.currentTimeMillis();
                currentTime = endTime - startTime;
                startButton.setEnabled(true);
                Button3.setEnabled(false);
                tv.setText(currentTime + " ms");
            }
        });

    }

}
