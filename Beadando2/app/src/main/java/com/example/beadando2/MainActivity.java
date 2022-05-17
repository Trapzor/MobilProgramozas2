package com.example.beadando2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button sensorButton;

    MyLifeCycleObserver myLifeCycleObserver;
    Lifecycle lifecycle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLifeCycleObserver = new MyLifeCycleObserver();

        lifecycle = getLifecycle();
        lifecycle.addObserver(myLifeCycleObserver);

        sensorButton = findViewById(R.id.buttonToSensor);

        sensorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toSensor = new Intent(MainActivity.this, SensorActivity.class);
                startActivity(toSensor);
            }
        });
    }



}