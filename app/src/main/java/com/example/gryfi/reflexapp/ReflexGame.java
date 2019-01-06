package com.example.gryfi.reflexapp;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReflexGame extends AppCompatActivity {

    Button startButton, mainButton;

    long startTime, endTime, currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflex_game);
        startButton = (Button) findViewById(R.id.startButton);
        mainButton = (Button) findViewById(R.id.mainButton);

        startButton.setEnabled(true);
        mainButton.setEnabled(false);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startButton.setEnabled(false);
                mainButton.setText("");

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startTime = System.currentTimeMillis();
                        mainButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
                        mainButton.setText("PRESS");
                        mainButton.setEnabled(true);
                    }
                }, 2000);
            }
        });

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endTime = System.currentTimeMillis();
                currentTime = endTime - startTime;
                mainButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
                mainButton.setText(currentTime + " ms");
                startButton.setEnabled(true);
                mainButton.setEnabled(false);
            }
        });

    }

}
