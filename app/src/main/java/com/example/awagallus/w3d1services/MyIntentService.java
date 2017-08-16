package com.example.awagallus.w3d1services;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by HP on 8/16/2017.
 */

public class MyIntentService extends IntentService {
    private static final  String TAG = "MyIntentServiceTAG";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "onHandleIntent: " + Thread.currentThread());

        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        switch (intent.getAction()) {
            case "getRepo":
                Log.d(TAG, "onHandleIntent: " + intent.getStringExtra("data") + Thread.currentThread());
            case "getProfile":
                Log.d(TAG, "onHandleIntent: " + intent.getStringExtra("data") + Thread.currentThread());

        }
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
}