package com.example.awagallus.w3d1services;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "MainActivityTag";


    Boolean   isBound;
    int d =-5;

    Button button, Play, Stop,Pause, btnStartNormalService, btnStopNormalService, btnStartIntentService, btnBindService, btnUnBindService, btnSecondActivity;
    MyBoundService myBoundService;
    int ramdomNum=-2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Play =(Button) findViewById(R.id.buttonPlay);
        Stop = (Button) findViewById(R.id.buttonStop);
        Pause = (Button) findViewById(R.id.buttonPause);
        btnStartNormalService = (Button) findViewById(R.id.btnStartNormalService);
        btnStopNormalService = (Button) findViewById(R.id.btnStopNormalService);
        btnStartIntentService = (Button) findViewById(R.id.btnStartIntentServices);
        btnBindService = (Button) findViewById(R.id.btnBindservice);
        btnUnBindService = (Button) findViewById(R.id.btnUnBindservice);
        btnSecondActivity = (Button) findViewById(R.id.gotosecondActivity);

        Log.d(TAG, "onCreate: ");

        Play.setOnClickListener(this);
        Stop.setOnClickListener(this);
        Pause.setOnClickListener(this);

        btnStartNormalService.setOnClickListener(this);
        btnStopNormalService.setOnClickListener(this);
        btnStartIntentService.setOnClickListener(this);
        btnBindService.setOnClickListener(this);
        btnUnBindService.setOnClickListener(this);
        btnSecondActivity.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View view) {
        Intent normalIntent = new Intent(this, MyNormalservice.class);
        Intent intIntent = new Intent(this, MyIntentService.class);

        Intent boundIntent = new Intent(this, MyBoundService.class);

        Intent musicInt = new Intent(this, MusicService.class);

        switch(view.getId()) {


            case R.id.btnStartNormalService:
                normalIntent.putExtra("data", "This is a normal service");
                startService(normalIntent);
                break;
            case R.id.btnStopNormalService:
                stopService(normalIntent);

                break;
            case R.id.btnStartIntentServices:
                intIntent.putExtra("data", "this is an intent service");
                intIntent.setAction("getRepo");
                startService(intIntent);
                break;
            case R.id.btnBindservice:
                //     intIntent.putExtra("data", "this is an intent service");
                //           intIntent.setAction("getProfile");
                //         startService(intIntent);
                bindService(boundIntent, serviceConnection, Context.BIND_AUTO_CREATE);
                //       bindService(boundIntent2, serviceConnection, Context.BIND_AUTO_CREATE);


                break;
            case R.id.btnUnBindservice:
             /*    if(isBound){
                    unbindService(serviceConnection);
                    isbound = false;
                    }
                    break;
              */
                unbindService(serviceConnection);
                break;
            case R.id.gotosecondActivity:
                try {
                    Intent intent2 = new Intent(this, SecondActivity.class);

                    intent2.putExtra("data", ""+d);
                    intent2.putExtra("data1", "" +d);
                    startActivity(intent2);
                }catch (Exception e){
                    Toast.makeText(this, "Just added a number!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.buttonPlay:
                Log.d(TAG, "onClick: ");
                musicInt.setAction("Play");
                musicInt.putExtra("id_music",""+R.raw.despacito);
                startService(musicInt);
                break;
            case R.id.buttonPause:
                musicInt.setAction("Pause");
                musicInt.putExtra("id_music",""+R.raw.despacito);
                startService(musicInt);
                break;
            case R.id.buttonStop:
                musicInt.setAction("Stop");
                musicInt.putExtra("id_music",""+R.raw.despacito);
                startService(musicInt);
                break;

        }
    }
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) iBinder;
            myBoundService = myBinder.getService();

            //   Log.d(TAG, "onServiceConnected:" + myBoundService.getRandomData());
            d=myBoundService.getRandomData();
            Log.d(TAG, "onServiceConnected: "+ d);
            Log.d(TAG, "onServiceConnected: " + ramdomNum);
            //  isBound = true:
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            //isBound = false
            Log.d(TAG, "onServiceDisconnected: ");
        }
    };


    public MyBoundService getMyBoundService() {
        return myBoundService;

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}