package com.example.minoscape;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BreakActivity extends AppCompatActivity {

    /* Cette classe permet de gérer la page de pause */

    Thread t;
    EThread et = new EThread();
    TextView coeur, piece, time;

    /** Cycle de vie de l'activité (création)
     * @param savedInstanceState
     **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_break);
        EThread.stop = true;
        t = new Thread(et);
        GameActivity.pause = false;
        coeur = (TextView) findViewById(R.id.coeur);
        piece = (TextView) findViewById(R.id.piece);
        time = (TextView) findViewById(R.id.time);
        coeur.setText(" : " + Labyrinthe.vie);
        piece.setText(" : " + Labyrinthe.piece);
        time.setText(" : " + EThread.minute + "min  " + EThread.seconde + "sec");
    }

    /** Retour à l'activité principale
     * @param view
     **/
    public void menu(View view) {
        // Create an intent for the activity
        Intent i = new Intent(this, MainActivity.class);
        // Start the activity
        startActivity(i);
    }

    /** Retour à l'activité précèdente
     * @param view
     **/
    public void back(View view) {
        EThread.stop = false;
        int sec = EThread.seconde;
        int min = EThread.minute;
        t.start();
        EThread.seconde = sec;
        EThread.minute = min;
        finish();
    }

    /** Recommencer la partie
     * @param view
     **/
    public void restart(View view) {
        Labyrinthe.Bcoin1 = true;
        Labyrinthe.Bcoin2 = true;
        Labyrinthe.Bcoin3 = true;
        Labyrinthe.Bcoin4 = true;
        Labyrinthe.Bcoin5 = true;
        Labyrinthe.BMinos=true;
        Labyrinthe.Bdoor=false;
        Labyrinthe.ABSCURRENT = 0;
        Labyrinthe.ORDCURRENT = 0;
        Labyrinthe.ABSNEXT = 0;
        Labyrinthe.ORDNEXT = 0;
        Labyrinthe.vie = 3;
        Labyrinthe.piece = 0;
        EThread.stop = false;
        t.start();
        EThread.seconde = 0;
        EThread.minute = 0;
        finish();
    }
}