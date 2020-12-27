package com.example.minoscape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void game(View view) {

        // Create an intent for the activity
        Intent i = new Intent(this, GameActivity.class);

        // Start the activity
        startActivity(i);
    }

    public void rules(View view) {

        // Create an intent for the activity
        Intent i = new Intent(this, RulesActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);

        // Start the activity
        startActivity(i);
    }

    public void highScore(View view) {
        // Create an intent for the activity
        Intent i = new Intent(this, ScoreActivity.class);

        // Start the activity
        startActivity(i);
    }
}