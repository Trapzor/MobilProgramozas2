package com.example.beadando2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.beadando2.Room.RoomActivity;

public class MainActivity extends AppCompatActivity {

    Button sensorButton, roomButton;

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
    }



}