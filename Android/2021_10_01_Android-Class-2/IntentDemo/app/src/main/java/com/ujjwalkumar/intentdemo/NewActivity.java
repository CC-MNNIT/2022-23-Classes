package com.ujjwalkumar.intentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent i = getIntent();
        Integer count = i.getIntExtra("count", 0);
        Toast.makeText(this, "count = " + count, Toast.LENGTH_LONG).show();
    }
}