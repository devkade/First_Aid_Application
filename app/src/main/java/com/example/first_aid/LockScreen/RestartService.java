package com.example.first_aid.LockScreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class RestartService extends BroadcastReceiver {

    public static final String ACTION_RESTART_PERSISTENTSERVICE
            = "ACTION.RESTART.PersistentService";

    @Override
    public void onReceive(Context context, Intent intent) {
        //TODO Auto-generated method stub
        Log.d("ImmortalService", "RestartService called!@!@@@@@#$@$@#$@#$@#");


        if(intent.getAction().equals(ACTION_RESTART_PERSISTENTSERVICE)) {
            Intent i = new Intent(context, PersistentService.class);
            //Intent i = new Intent(this, PersistentService.class);
            context.startService(i);

        }

    }
}
