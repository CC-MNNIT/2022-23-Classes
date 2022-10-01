package com.ujjwalkumar.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;
    Integer count = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.changeActivityBtn);

        // Open NewActivity on clicking button and passing the value of count to it
        button.setOnClickListener(v-> {
            Intent i = new Intent(MainActivity.this, NewActivity.class);
            i.putExtra("count", count);
            startActivity(i);
        });
    }
}