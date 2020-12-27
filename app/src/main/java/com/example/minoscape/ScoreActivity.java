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
        score2 = (TextView) findViewById(R.id.highScore2);
        score3 = (TextView) findViewById(R.id.highScore3);

        Cursor res = db.getdata();
        if(res.getCount()==0){
            score1.setText("Vous n'avez pas fait de partie pour l'instant");
            score2.setText("");
            score3.setText("");
        }
        else {
            while(res.moveToNext()){
                score1.setText("Level : " + res.getString(0) + "    Time : " + res.getString(1));
            }
        }

    }

    public void back(View view) {
        finish();
    }
}