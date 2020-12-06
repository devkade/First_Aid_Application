package com.example.first_aid.FirstAid;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.first_aid.R;


public class FirstAidMainPage extends AppCompatActivity {
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_aid_main_layout);

        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFirstAidPage1();
            }
        });
    }

    public void openFirstAidPage1(){
        Intent intent = new Intent(this, FirstAidPage1.class);
        startActivity(intent);
    }

}

