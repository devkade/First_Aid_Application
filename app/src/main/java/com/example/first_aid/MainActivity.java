package com.example.first_aid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FragmentMain fragmentMain;
    FragmentContents fragmentContents;
    FragmentQuiz fragmentQuiz;
    FragmentSetting fragmentSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}