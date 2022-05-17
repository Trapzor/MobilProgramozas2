package com.example.beadando2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyLifeCycleObserver myLifeCycleObserver;
    Lifecycle lifecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLifeCycleObserver = new MyLifeCycleObserver();

        lifecycle = getLifecycle();
        lifecycle.addObserver(myLifeCycleObserver);
    }



}