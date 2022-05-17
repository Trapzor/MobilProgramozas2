package com.example.beadando2;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLifeCycleObserver implements LifecycleObserver {

    public final String TAG = "MyLifeCycleObserver";

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start() {
        Log.d(TAG, "start");
    };

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop() {
        Log.d(TAG, "stop");
    };
}
