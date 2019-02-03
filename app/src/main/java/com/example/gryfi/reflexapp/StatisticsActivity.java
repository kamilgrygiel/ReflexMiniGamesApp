package com.example.gryfi.reflexapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class StatisticsActivity extends AppCompatActivity {

    TextView tv1, tv2, tv3, tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        tv1 = (TextView) findViewById(R.id.textView11);
        tv2 = (TextView) findViewById(R.id.textView13);
        tv3 = (TextView) findViewById(R.id.textView15);
        tv4 = (TextView) findViewById(R.id.textView17);

        tv1.setText(Long.toString(Statistics.game1) + "ms");
        tv2.setText(Long.toString(Statistics.game2));
        tv3.setText(Long.toString(Statistics.game3)+ "ms");
        tv4.setText(Long.toString(Statistics.game4)+ "ms");
    }
}
