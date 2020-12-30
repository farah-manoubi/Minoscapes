package com.example.minoscape;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RulesActivity extends AppCompatActivity {

    /* Cette classe correspond à la page affichant les règles du jeu*/

    /** Cycle de vie de l'activité (création)
     * @param savedInstanceState
     **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
    }

    /** Retour à l'activité principale
     * @param view
     **/
    public void back(View view) {
        // Create an intent for the activity
        Intent i = new Intent(this, MainActivity.class);
        // Start the activity
        startActivity(i);
    }
}