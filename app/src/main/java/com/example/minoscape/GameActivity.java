package com.example.minoscape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void pause(View view) {

        // Create an intent for the activity
        Intent i = new Intent(this, BreakActivity.class);

        // Start the activity
        startActivity(i);
    }
}