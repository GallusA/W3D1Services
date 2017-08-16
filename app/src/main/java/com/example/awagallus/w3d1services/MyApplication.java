package com.example.awagallus.w3d1services;

import android.app.Application;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by HP on 8/16/2017.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }
}