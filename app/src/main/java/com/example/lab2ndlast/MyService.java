package com.example.lab2ndlast;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by DEll1 on 12/20/2017.
 */
public class MyService extends Service {

    private static final String TAG = "MTAG";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: service start");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: service started");

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i=0;i<10;i++){

                    try {

                        Thread.sleep(1000);

                    }catch (InterruptedException e){

                        e.printStackTrace();
                    }
                }

            }
        });

        t.start();
        return START_STICKY;
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onDestroy(){

        Log.d(TAG, "onDestroy: service destroyed");
        super.onDestroy();
    }


}
