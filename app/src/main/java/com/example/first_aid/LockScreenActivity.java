package com.example.first_aid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

public class LockScreenActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_screen);

        Intent passedIntent = getIntent();
        processCommand(passedIntent);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        processCommand(getIntent());

        super.onNewIntent(intent);
    }

// 이와 같이 모든 경우에 서비스로부터 받은 인텐트가 처리 될 수 있도록한다.
// 이제 processCommand() 메서드 정의.

    private void processCommand(Intent intent) {
        if (intent != null) {
            String command = intent.getStringExtra("command");
            String name = intent.getStringExtra("name");

            Toast.makeText(this, "서비스로부터 전달받은 데이터: " + command + ", " + name, Toast.LENGTH_LONG).show();
        }
    }
}
