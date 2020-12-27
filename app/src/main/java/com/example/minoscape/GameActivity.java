package com.example.minoscape;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Map;

import static androidx.core.content.ContextCompat.getSystemService;

public class GameActivity extends AppCompatActivity {

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

        EThread.stop=false;
        t = new Thread(et);
        t.start();
        EThread.minute = 0;
        EThread.seconde = 0;
        //move();
        dialog = new Dialog(this);
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

    public static void restart(View view) {
        // Create an intent for the activity
        Intent i = new Intent(mContext, GameActivity.class);

        // Start the activity
        mContext.startActivity(i);
    }





    public static void openDialog() {
        EThread.stop = true;

        dialog.setContentView(R.layout.dialog_layout);

        Button reset = dialog.findViewById(R.id.reset);
        Button menu = dialog.findViewById(R.id.menuP);

        reset = (Button) dialog.findViewById(R.id.reset);
        menu = (Button) dialog.findViewById(R.id.menuP);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goMenu(v);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restart(v);
            }
        });

        dialog.show();
    }








}