package com.example.first_aid.LockScreen;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class PersistentService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        Log.d("TAG", "Service Create");

        super.onCreate();
    }



    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        Log.d("Tag", "Service Destroy");

        super.onDestroy();
    }
}
