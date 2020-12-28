package com.example.minoscape;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    public static Dialog dialog;
    private static Context mContext;
    private Button game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new Dialog(this);
        mContext = this;

        game = (Button) findViewById(R.id.Game);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGameDialog();
            }
        });
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

    public void menu(View v) {
        // Create an intent for the activity
        Intent i = new Intent(this, MainActivity.class);

        // Start the activity
        startActivity(i);
    }

    public void openGameDialog() {

        dialog.setContentView(R.layout.dialog_game_layout);

        Button start = dialog.findViewById(R.id.restartGame);
        Button menu = dialog.findViewById(R.id.goBack);
        RadioButton debutant = dialog.findViewById(R.id.debutant);
        RadioButton intermediaire = dialog.findViewById(R.id.intermediaire);
        RadioButton expert = dialog.findViewById(R.id.Expert);

        //reset = (Button) dialog.findViewById(R.id.restart);
        //menu = (Button) dialog.findViewById(R.id.menuP2);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu(v);
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Is the button now checked?
               if(debutant.isChecked()) {
                   Labyrinthe.COLS = 6;
                   Labyrinthe.ROWS = 4;
               }
               if(intermediaire.isChecked()) {
                   Labyrinthe.COLS = 10;
                   Labyrinthe.ROWS = 5;
               }
                if(expert.isChecked()) {
                    Labyrinthe.COLS = 14;
                    Labyrinthe.ROWS = 9;
                }
                game(v);
            }
        });

        dialog.show();
    }
}