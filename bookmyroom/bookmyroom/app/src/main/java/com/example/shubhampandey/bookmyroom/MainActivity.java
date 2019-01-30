package com.example.shubhampandey.bookmyroom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer timer;
    ProgressBar prg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView newimage = (ImageView) findViewById(R.id.imageview);
        newimage.setImageResource(R.drawable.wall);

        prg=(ProgressBar) findViewById(R.id.progressBar);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                for(int i=1;i<=100;i++){
                    prg.setProgress(i);
                }
                Intent intent=new Intent(MainActivity.this,BOOKMYROOM.class);
                startActivity(intent);
                finish();
            }
        },3000);




    }

}

