package com.example.minoscape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BreakActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_break);
    }

    public void menu(View view) {
        // Create an intent for the activity
        Intent i = new Intent(this, MainActivity.class);

        // Start the activity
        startActivity(i);
    }

    public void back(View view) {
        finish();
    }
}