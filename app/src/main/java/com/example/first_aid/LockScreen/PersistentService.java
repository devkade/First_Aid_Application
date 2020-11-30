package com.example.first_aid.LockScreen;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

//import org.apache.http.NameValuePair;
//import org.apache.http.message.BasicNameValuePair;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;


public class PersistentService extends Service {
    private String TAG = "PersistentService";
    private String sPackageName = "com.example";
    private final IBinder mBinder = new LocalBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        unregisterRestartAlram(); //이미 등록된 알람이 있으면 제거
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        registerRestartAlram(); // 서비스가 죽을때 알람을 등록
        super.onDestroy();
    }



// support persistent of Service

    public void registerRestartAlram() {
        Log.d(TAG, "registerRestartAlarm");

        Intent intent = new Intent(PersistentService.this, RestartService.class);
        intent.setAction(RestartService. ACTION_RESTART_PERSISTENTSERVICE);
        PendingIntent sender = PendingIntent.getBroadcast(PersistentService.this, 0, intent, 0);

        long firstTime = SystemClock.elapsedRealtime();
        firstTime += 1*1000; // 1초 후에 알람이벤트 발생  @@@(10초 -> 1초로 변경)@@@
        AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
        am.setRepeating(
                AlarmManager.ELAPSED_REALTIME_WAKEUP, firstTime, 1*1000, sender);
    }

    public void unregisterRestartAlram() {
        Log.d(TAG, "unregisterRestartAlarm");
        Intent intent = new Intent(PersistentService.this, RestartService.class);
        intent.setAction(RestartService.ACTION_RESTART_PERSISTENTSERVICE);
        PendingIntent sender = PendingIntent.getBroadcast(PersistentService.this, 0, intent, 0);

        AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
        am.cancel(sender);
    }

    public class LocalBinder extends Binder {
        PersistentService getService() {
            return PersistentService.this;
        }
    }
}
