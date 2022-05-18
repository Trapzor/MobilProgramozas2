package com.example.beadando2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.beadando2.Room.RoomActivity;
import com.example.beadando2.Worker.WorkerActivity;

public class MainActivity extends AppCompatActivity {

    Button sensorButton, roomButton, workerButton;

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
        roomButton = findViewById(R.id.buttonToRoom);
        workerButton = findViewById(R.id.buttonToWorker);

        sensorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toSensor = new Intent(MainActivity.this, SensorActivity.class);
                startActivity(toSensor);
            }
        });

        roomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toRoom = new Intent(MainActivity.this, RoomActivity.class);
                startActivity(toRoom);
            }
        });

        workerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toWorker = new Intent(MainActivity.this, WorkerActivity.class);
                startActivity(toWorker);
            }
        });
    }



}