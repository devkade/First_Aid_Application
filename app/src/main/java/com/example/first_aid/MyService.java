package com.example.first_aid;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class MyService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d(TAG, "onStartCommand() called");

        if (intent == null) {
            return Service.START_STICKY; //서비스가 종료되어도 자동으로 다시 실행시켜줘!
        } else {
            String command = intent.getStringExtra("command");
            boolean name = intent.getAction().equals(Intent.ACTION_SCREEN_OFF);

            Log.d(TAG, "전달받은 데이터: " + command+ ", " +name);

            try{
                Thread.sleep(1000);
            } catch(Exception e) {}

            Intent showIntent = new Intent(getApplicationContext(), LockScreenActivity.class);
            /**
             화면이 띄워진 상황에서 다른 액티비티를 호출하는 것은 문제가없으나,
             지금은 따로 띄워진 화면이 없는 상태에서 백그라운드에서 실행중인 서비스가 액티비티를 호출하는 상황이다.
             이러한 경우에는 FLAG_ACTIVITY_NEW_TASK 옵션(플래그)을 사용해줘야 한다.
             **/
            showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);

            showIntent.putExtra("command", "turn on");
            showIntent.putExtra("name", name + " from service.");

            // *** 이제 완성된 인텐트와 startActivity()메소드를 사용하여 MainActivity 액티비티를 호출한다. ***
            if(name) {
                startActivity(showIntent);
            }
        }

        return super.onStartCommand(intent, flags, startId);
    }
}
