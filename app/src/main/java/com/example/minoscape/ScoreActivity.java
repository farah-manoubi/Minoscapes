package com.example.minoscape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    TextView score1, score2, score3;
    private DataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        db = new DataBase(this);
        score1 = (TextView) findViewById(R.id.highScore1);

        Cursor res = db.getTop3();
        if(res.getCount()==0){
            score1.setText("Vous n'avez pas fait de partie pour l'instant");
        }
        else {
            StringBuffer buffer = new StringBuffer(); //double clic, musique ?
            int i = 1;
            while(res.moveToNext()){
                buffer.append("Top " + i+"\n");
                buffer.append("Niveau : "+res.getString(0)+"\n");
                buffer.append("Temps : "+res.getString(1)+"\n");
                buffer.append("Difficulté : "+res.getString(2)+"\n\n");
                i++;
            }

            score1.setText(buffer.toString());
        }

    }

    public void back(View view) {
        finish();
    }
}