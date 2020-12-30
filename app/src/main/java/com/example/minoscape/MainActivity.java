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

    /* Cette classe correspond à l'activité principale de notre application */

    public static Dialog dialog;
    private static Context mContext;
    private Button game;

    /** Cycle de vie de l'activité (création)
     * @param savedInstanceState
     **/
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

    /** Accès à la page de jeu
     * @param view
     **/
    public void game(View view) {
        // Create an intent for the activity
        Intent i = new Intent(this, GameActivity.class);
        // Start the activity
        startActivity(i);
    }

    /** Accès à la page des règles du jeu
     * @param view
     **/
    public void rules(View view) {
        // Create an intent for the activity
        Intent i = new Intent(this, RulesActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        // Start the activity
        startActivity(i);
    }

    /** Accès à la page des scores
     * @param view
     **/
    public void highScore(View view) {
        // Create an intent for the activity
        Intent i = new Intent(this, ScoreActivity.class);
        // Start the activity
        startActivity(i);
    }

    /** Activité principale
     * @param v
     **/
    public void menu(View v) {
        // Create an intent for the activity
        Intent i = new Intent(this, MainActivity.class);
        // Start the activity
        startActivity(i);
    }

    /** Ouverture d'une boite de dialogue pour choisir son niveau avant de jouer **/
    public void openGameDialog() {
        dialog.setContentView(R.layout.dialog_game_layout);
        Button start = dialog.findViewById(R.id.restartGame);
        Button menu = dialog.findViewById(R.id.goBack);
        RadioButton debutant = dialog.findViewById(R.id.debutant);
        RadioButton intermediaire = dialog.findViewById(R.id.intermediaire);
        RadioButton expert = dialog.findViewById(R.id.Expert);

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
                   Labyrinthe.COLS = 8;
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
                if(!debutant.isChecked() && !intermediaire.isChecked() && !expert.isChecked()) {
                    Labyrinthe.COLS = 8;
                    Labyrinthe.ROWS = 4;
                }
                game(v);
            }
        });
        dialog.show();
    }
}