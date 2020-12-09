package com.example.first_aid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.first_aid.BottomNavigationBarFragment.FragmentContents;
import com.example.first_aid.BottomNavigationBarFragment.FragmentMain;
import com.example.first_aid.BottomNavigationBarFragment.FragmentQuiz;
import com.example.first_aid.BottomNavigationBarFragment.FragmentSetting;
import com.example.first_aid.FirstAid.FirstAidPage1_1;
import com.example.first_aid.LockScreen.LockScreenActivity;
import com.example.first_aid.MainTabBar.MainFirstAidTab;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.first_aid.LockScreen.RealService;
import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity
                            implements FragmentSetting.OnSettingListener {

    private Intent serviceIntent;

    BottomNavigationView bottomNavigationView;
    FragmentMain fragmentMain;
    FragmentContents fragmentContents;
    FragmentQuiz fragmentQuiz;
    FragmentSetting fragmentSetting;
    MainFirstAidTab mainFirstAidTab;
    FirstAidPage1_1 firstAidPage1_1;
    boolean ls_on;
    private SharedPreferences appData;



    @Override
    public void onSetting(boolean lockscreen_on){
        ls_on = lockscreen_on;
        Log.d(TAG, "ls_on: " + ls_on);
        save();
        load();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCrate MainActivity: " + ls_on);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        appData = getSharedPreferences("appData", MODE_PRIVATE);
        load();



        // 서비스 실행
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

        if (RealService.serviceIntent == null) {
            serviceIntent = new Intent(this, RealService.class);
            startService(serviceIntent);
        } else {
            serviceIntent = RealService.serviceIntent;//getInstance().getApplication();
            //Toast.makeText(getApplicationContext(), "already", Toast.LENGTH_LONG).show();
        }



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
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("ls_on",ls_on);
                        Log.d(TAG, "MainActivity ls_on: " + ls_on);
                        fragmentSetting.setArguments(bundle);
                        return true;
                    }

                    default: return false;
                }
            }
        });

    }


    // 설정값을 저장하는 함수
    private void save() {
        // SharedPreferences 객체만으론 저장 불가능 Editor 사용
        SharedPreferences.Editor editor = appData.edit();

        // 에디터객체.put타입( 저장시킬 이름, 저장시킬 값 )
        // 저장시킬 이름이 이미 존재하면 덮어씌움
        editor.putBoolean("SAVE_Lockscreen_DATA", ls_on);

        // apply, commit 을 안하면 변경된 내용이 저장되지 않음
        editor.apply();
    }

    // 설정값을 불러오는 함수
    private void load() {
        // SharedPreferences 객체.get타입( 저장된 이름, 기본값 )
        // 저장된 이름이 존재하지 않을 시 기본값
        ls_on = appData.getBoolean("SAVE_Lockscreen_DATA", false);
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (serviceIntent != null) {
            stopService(serviceIntent);
            serviceIntent = null;
        }
    }
}