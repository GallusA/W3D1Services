package com.example.awagallus.w3d1services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HP on 8/16/2017.
 */

public class SecondActivity  extends AppCompatActivity{
    MyBoundService myBoundService;
    ServiceRecycle myServiceRecycle;
    boolean isBound = false;
    boolean isBoundRecycler = false;
    TextView tv1, tv2, tvrandom;
    int random = -1;
    private  static final  String TAG = "SecondActivity";

    //  ArrayList<randomStuff> n = new ArrayList();
    TextView textView, textView2;
    //   int x  =45;

    RecyclerView rvRandomsList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    randomListAdaptor randomsListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);


        textView = (TextView) findViewById(R.id.textView) ;
        textView2 = (TextView) findViewById(R.id.textView2);

        Intent i = getIntent();
        textView.setText(i.getStringExtra("data"));

        Intent e= getIntent();
        textView2.setText(e.getStringExtra("data1"));


        Intent recycleboundIntent = new Intent(this, ServiceRecycle.class);
        recycleboundIntent.putExtra("value3",e.getStringExtra("data1"));
        bindService(recycleboundIntent, recycleserviceConnection, Context.BIND_AUTO_CREATE);


    }

    ServiceConnection recycleserviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder) {
            ServiceRecycle.MyBinder myBinder = (ServiceRecycle.MyBinder) iBinder;
            myServiceRecycle = myBinder.getService();

            ArrayList<RandomNum> randomsList = myServiceRecycle.getRecyclerViewList();
            rvRandomsList = (RecyclerView) findViewById(R.id.recycleID);
            layoutManager = new LinearLayoutManager(getApplicationContext());
            itemAnimator = new DefaultItemAnimator();
            rvRandomsList.setLayoutManager(layoutManager);
            rvRandomsList.setItemAnimator(itemAnimator);

            Log.d(TAG, "onServiceConnected: "+randomsList.size());
            //initialize the adapter
            randomsListAdapter = new randomListAdaptor(randomsList);
            rvRandomsList.setAdapter(randomsListAdapter);

            randomsListAdapter.notifyDataSetChanged();

            isBoundRecycler = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

}
