package com.example.minoscape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import static androidx.core.content.ContextCompat.getSystemService;

public class GameActivity extends AppCompatActivity {

    private SensorManager sensorManager = null;
    private Labyrinthe lab;
    Bitmap hiro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lab = new Labyrinthe(this, hiro);
        setContentView(R.layout.activity_game);
        sensorManager = (SensorManager) getSystemService( SENSOR_SERVICE );
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(lab, sensorManager.getDefaultSensor( Sensor.TYPE_ACCELEROMETER ), SensorManager.SENSOR_DELAY_UI);
        
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

}