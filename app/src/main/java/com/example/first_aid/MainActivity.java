package com.example.first_aid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.first_aid.BottomNavigationBarFragment.FragmentContents;
import com.example.first_aid.BottomNavigationBarFragment.FragmentMain;
import com.example.first_aid.BottomNavigationBarFragment.FragmentQuiz;
import com.example.first_aid.BottomNavigationBarFragment.FragmentSetting;
import com.example.first_aid.LockScreen.AlarmReceiver;
import com.example.first_aid.LockScreen.RealService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Intent serviceIntent;

    BottomNavigationView bottomNavigationView;
    FragmentMain fragmentMain;
    FragmentContents fragmentContents;
    FragmentQuiz fragmentQuiz;
    FragmentSetting fragmentSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        PowerManager pm = (PowerManager) getApplicationContext().getSystemService(POWER_SERVICE);
        boolean isWhiteListing = false;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            isWhiteListing = pm.isIgnoringBatteryOptimizations(getApplicationContext().getPackageName());
        }
        if (!isWhiteListing) {
            Intent intent = new Intent();
            intent.setAction(android.provider.Settings.ACTION_REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
            intent.setData(Uri.parse("package:" + getApplicationContext().getPackageName()));
            startActivity(intent);
        }

        if (RealService.serviceIntent==null) {
            serviceIntent = new Intent(this, RealService.class);
            startService(serviceIntent);
        } else {
            serviceIntent = RealService.serviceIntent;//getInstance().getApplication();
            //Toast.makeText(getApplicationContext(), "already", Toast.LENGTH_LONG).show();
        }




        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // 프래그먼트 생성
        fragmentMain = new FragmentMain();
        fragmentContents = new FragmentContents();
        fragmentQuiz = new FragmentQuiz();
        fragmentSetting = new FragmentSetting();

        // 제일 처음 띄워줄 뷰를 세팅한다. commit();까지 해줘야 함.
        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragmentMain).commitAllowingStateLoss();

        // bottomNavigationView의 아이콘 선택 시 원하는 프래그먼트로 전환될 수 있도록 리스너 추가
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.main:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragmentMain).commitAllowingStateLoss();
                        return true;
                    }

                    case R.id.contents:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragmentContents).commitAllowingStateLoss();
                        return true;
                    }

                    case R.id.quiz:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragmentQuiz).commitAllowingStateLoss();
                        return true;
                    }

                    case R.id.setting:{
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_layout, fragmentSetting).commitAllowingStateLoss();
                        return true;
                    }

                    default: return false;
                }
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (serviceIntent!=null) {
            stopService(serviceIntent);
            serviceIntent = null;
        }
    }
}