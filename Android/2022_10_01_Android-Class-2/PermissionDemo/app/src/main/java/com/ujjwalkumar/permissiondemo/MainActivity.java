package com.ujjwalkumar.permissiondemo;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Open the camera activity after 2s
        TimerTask Splash = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(() -> {
                    Intent in = new Intent(MainActivity.this, CameraActivity.class);
                    startActivity(in);
                    finish();
                });
            }
        };

        Timer timer = new Timer();
        timer.schedule(Splash,2000);
    }
}