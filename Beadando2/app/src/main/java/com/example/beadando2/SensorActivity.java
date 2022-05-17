package com.example.beadando2;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    List<Sensor> sensorsList;
    Sensor accelerometer;
    TextView sensorText, sensorsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }else{
            Toast.makeText(this, "No such sensor", Toast.LENGTH_SHORT).show();
        }

        sensorText = findViewById(R.id.sensorTextView);

        sensorsText = findViewById(R.id.sensorsTextView);
        sensorsList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for(Sensor s : sensorsList){
            sensorsText.append(
                    "Name: " + s.getName() + "\n"
                    + "Version: " + s.getVersion() + "\n"
                    + "Vendor: " + s.getVendor() + "\n"
                    + "Type: " + s.getType() + "\n\n");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        String values = "Values: ";
        for(float f : sensorEvent.values){
            values += " ";
            values += String.valueOf(f);
        }
        sensorText.setText(values);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(
                this,
                accelerometer,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}