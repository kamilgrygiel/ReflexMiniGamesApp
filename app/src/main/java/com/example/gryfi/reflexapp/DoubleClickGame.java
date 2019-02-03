package com.example.gryfi.reflexapp;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoubleClickGame extends AppCompatActivity {

    Button resetButton, mainButton;

    long startTime, endTime, currentTime;

    Boolean isItASecondClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_click_game);
        mainButton = (Button) findViewById(R.id.mainButton1);
        resetButton = (Button) findViewById(R.id.resetButton1);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainButton.setText("Double tap");
                mainButton.setEnabled(true);
            }
        });

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isItASecondClick){
                    startTime = System.currentTimeMillis();
                    mainButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.blue));
                    mainButton.setText("Tap once more");
                    isItASecondClick = true;
                }
                else {
                    endTime = System.currentTimeMillis();
                    mainButton.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
                    isItASecondClick = false;
                    mainButton.setEnabled(false);
                    currentTime = endTime - startTime;
                    mainButton.setText(currentTime + " ms");
                    if(Statistics.game4 > currentTime)
                        Statistics.game4 = currentTime;
                }
            }
        });
    }

}
