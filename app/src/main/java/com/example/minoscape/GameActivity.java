package com.example.minoscape;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {
    private static DataBase db;
    private SensorManager sensorManager = null;
    private Labyrinthe lab;
    Bitmap hiro;
    Thread t;
    EThread et = new EThread();
    private boolean bool;
    private ArrayList<Long> al = new ArrayList<Long>();
    int abs, ord;
    Boolean time = true;
    public static Dialog dialog;
    FloatingActionButton button;
    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lab = new Labyrinthe(this, hiro);
        setContentView(R.layout.activity_game);
        sensorManager = (SensorManager) getSystemService( SENSOR_SERVICE );
        Labyrinthe.Bcoin1 = true;
        Labyrinthe.Bcoin2 = true;
        Labyrinthe.Bcoin3 = true;
        Labyrinthe.Bcoin4 = true;
        Labyrinthe.Bcoin5 = true;
        Labyrinthe.BMinos=true;
        Labyrinthe.Bdoor = false;
        Labyrinthe.ABSCURRENT = 0;
        Labyrinthe.ORDCURRENT = 0;
        Labyrinthe.ABSNEXT = 0;
        Labyrinthe.ORDNEXT = 0;
        Labyrinthe.vie = 3;
        Labyrinthe.piece = 0;

        EThread.stop=false;
        t = new Thread(et);
        t.start();
        EThread.minute = 0;
        EThread.seconde = 0;
        //move();
        dialog = new Dialog(this);
        db = new DataBase(this);
        mContext = this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(lab, sensorManager.getDefaultSensor( Sensor.TYPE_LINEAR_ACCELERATION ), SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener( lab );
    }


    public void pause(View view) {

        // Create an intent for the activity
        Intent i = new Intent(this, BreakActivity.class);

        // Start the activity
        startActivity(i);
    }


    public static void goMenu(View view) {
        // Create an intent for the activity
        Intent i = new Intent(mContext, MainActivity.class);

        // Start the activity
        mContext.startActivity(i);
    }

    public static void nextLevel(View view) {
        // Create an intent for the activity
        Labyrinthe.Bcoin1 = true;
        Labyrinthe.Bcoin2 = true;
        Labyrinthe.Bcoin3 = true;
        Labyrinthe.Bcoin4 = true;
        Labyrinthe.Bcoin5 = true;
        Labyrinthe.BMinos=true;
        Labyrinthe.Bdoor = false;
        Labyrinthe.ABSCURRENT = 0;
        Labyrinthe.ORDCURRENT = 0;
        Labyrinthe.ABSNEXT = 0;
        Labyrinthe.ORDNEXT = 0;
        Labyrinthe.vie = 3;
        Labyrinthe.piece = 0;
        Intent i = new Intent(mContext, GameActivity.class);

        // Start the activity
        mContext.startActivity(i);
    }


    public static void openWinDialog() {
        EThread.stop = true;

        Cursor res = db.getdata();
        if(res.getCount()==0){
            String time = "00:" + EThread.minute + ":" + EThread.seconde;
            db.insertData(1, time);
        }
        else {
            String lastTime = "";
            while(res.moveToNext()){
                lastTime = res.getString(1);
            }
            String time = "00:" + EThread.minute + ":" + EThread.seconde;
            String time1 = "00:" + EThread.minute + ":" + (EThread.seconde-1);
            if(time.equals(lastTime) || time1.equals(lastTime)) {}
            else {
                int level = res.getCount()+1;

                db.insertData(level, time);
            }


        }


        dialog.setContentView(R.layout.dialog_win_layout);

        Button reset = dialog.findViewById(R.id.restart);
        Button menu = dialog.findViewById(R.id.menuP2);

        reset = (Button) dialog.findViewById(R.id.restart);
        menu = (Button) dialog.findViewById(R.id.menuP2);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goMenu(v);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextLevel(v);
            }
        });

        dialog.show();
    }

    public static void openLoseDialog() {
        EThread.stop = true;
        dialog.setContentView(R.layout.dialog_lose_layout);

        Button reset = dialog.findViewById(R.id.restart);
        Button menu = dialog.findViewById(R.id.menuP2);

        reset = (Button) dialog.findViewById(R.id.restart);
        menu = (Button) dialog.findViewById(R.id.menuP2);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goMenu(v);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextLevel(v);
            }
        });

        dialog.show();
    }








}