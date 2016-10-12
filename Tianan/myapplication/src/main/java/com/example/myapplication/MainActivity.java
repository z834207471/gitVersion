package com.example.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private TextView num ;
    private int i=3;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num = (TextView) findViewById(R.id.num);
        for (int j=1;j <=3 ; j++) {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    num.setText("("+String.valueOf(--i)+")");
                    Log.d("MainActivity",  String.valueOf(i));
                }
            }, 3000);
        }
    }
}
