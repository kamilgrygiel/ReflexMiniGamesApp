package com.example.gryfi.reflexapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpeedGame extends AppCompatActivity {

    Button btn, resetButton;
    TextView tv, timerTv;
    int count;
    long timeLeft = 5000, currentTime;
    boolean isTimerRunning, isFinished;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed_game);
        btn = (Button) findViewById(R.id.btn);
        resetButton = (Button) findViewById(R.id.resetButton);
        tv = (TextView) findViewById(R.id.tv);
        timerTv = (TextView) findViewById(R.id.timerTv);
        count = 0;

        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                if(isFinished == false) {
                    count++;
                }
                else{
                    timerTv.setText("Left: 0 ms");

                }
                tv.setText("Count : " + count);
                startStop();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTimer();
                timeLeft = 5000;
                isFinished = false;
                count = 0;
            }
        });
    }


    void startStop(){
        if(isTimerRunning && timeLeft <= 0){
            timeLeft = 5000;
        } else if (timeLeft >= 5000){
            isFinished = false;
            startTimer();
        }
    }

    void startTimer(){
        countDownTimer = new CountDownTimer(timeLeft, 1) {

            @Override
            public void onTick(long millisUntilFinished) {
                timeLeft = millisUntilFinished;
                timerTv.setText("Left: " + timeLeft + "ms");
            }

            @Override
            public void onFinish() {
                isFinished = true;
            }
        }.start();

        isTimerRunning = true;
    }

    void stopTimer(){
        countDownTimer.cancel();
        isTimerRunning = false;
    }
}
