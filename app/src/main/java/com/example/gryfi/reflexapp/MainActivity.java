 package com.example.gryfi.reflexapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

 public class MainActivity extends AppCompatActivity {

    Button speedGameBtn, reflexGameBtn, speedGameBtn2, reflexGameBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        speedGameBtn = (Button) findViewById(R.id.speedGameButton);
        reflexGameBtn = (Button) findViewById(R.id.reflexGameButton);
        speedGameBtn2 = (Button) findViewById(R.id.speedGameButton2);
        reflexGameBtn2 = (Button) findViewById(R.id.reflexGameButton2);

        speedGameBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                openSpeedGame();
            }
        });
        reflexGameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReflexGame();
            }
        });
        speedGameBtn2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                openSpeedGame2();
            }
        });
        reflexGameBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReflexGame2();
            }
        });
    }
     public void openSpeedGame(){
         Intent intent = new Intent(this, SpeedGame.class);
         startActivity(intent);
     }
     public void openReflexGame(){
         Intent intent = new Intent(this, ReflexGame.class);
         startActivity(intent);
     }
     public void openSpeedGame2(){
         Intent intent = new Intent(this, DoubleClickGame.class);
         startActivity(intent);
     }
     public void openReflexGame2(){
         Intent intent = new Intent(this, ReflexSecondGame.class);
         startActivity(intent);
     }
}
