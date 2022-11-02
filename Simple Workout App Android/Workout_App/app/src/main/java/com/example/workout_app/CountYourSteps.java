package com.example.workout_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class CountYourSteps extends AppCompatActivity implements SensorEventListener {

    TextView textViewStepCounter, getTextViewStepDetector;
    SensorManager sensorManager;
    Sensor stepC;
    boolean sensorPresent;
    int countSteps;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_your_steps);

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED){ //ask for permission
            requestPermissions(new String[]{Manifest.permission.ACTIVITY_RECOGNITION}, 0);
        }

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        textViewStepCounter=findViewById(R.id.MoveToMeasure);
        getTextViewStepDetector=findViewById(R.id.UpdatedSteps);

        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null)
        {
            stepC=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            sensorPresent=true;
        }

        else{
            textViewStepCounter.setText("Counter sensor is not present");
            sensorPresent=false;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
         if(sensorEvent.sensor==stepC)
         {
             countSteps= (int) sensorEvent.values[0];
             getTextViewStepDetector.setText(String.valueOf(countSteps));
         }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null)
        {
            sensorManager.registerListener(this,stepC,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    protected void onPause() {
        super.onPause();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null)
        {
            sensorManager.unregisterListener(this,stepC);
        }
    }
}