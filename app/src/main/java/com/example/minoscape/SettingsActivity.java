package com.example.minoscape;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class SettingsActivity extends AppCompatActivity {

    /* Cette classe correspond à la page des paramettres*/

    EThread et = new EThread();
    Thread t;

    /** Cycle de vie de l'activité (création)
     * @param savedInstanceState
     **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EThread.stop = true;
        setContentView(R.layout.activity_settings);
        Button start = (Button)findViewById(R.id.restartGame);
        Button goback = (Button)findViewById(R.id.goBack);
        RadioButton debutant = (RadioButton)findViewById(R.id.debutant);
        RadioButton intermediaire = (RadioButton)findViewById(R.id.intermediaire);
        RadioButton expert = (RadioButton)findViewById(R.id.Expert);
        GameActivity.pause = false;
        t = new Thread(et);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                t.start();
                EThread.seconde = 0;
                EThread.minute = 0;
                game();
            }
        });

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EThread.stop=false;
                int sec = EThread.seconde;
                int min = EThread.minute;
                t.start();
                EThread.seconde = sec;
                EThread.minute = min;
                finish();
            }
        });
    }

    /** Retour à l'activité principale
     * @param v
     **/
    public void menu(View v) {
        // Create an intent for the activity
        Intent i = new Intent(this, MainActivity.class);
        // Start the activity
        startActivity(i);
    }

    /** Accès à la page de jeu **/
    public void game() {
        // Create an intent for the activity
        Intent i = new Intent(this, GameActivity.class);
        // Start the activity
        startActivity(i);
    }
}