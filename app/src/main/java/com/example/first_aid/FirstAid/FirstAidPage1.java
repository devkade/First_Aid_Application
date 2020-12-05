package com.example.first_aid.FirstAid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.first_aid.R;

public class FirstAidPage1 extends AppCompatActivity {
    private Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_aid_page1);

        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFirstAidPage1_1();
            }
        });
    }

    public void openFirstAidPage1_1(){
        Intent intent = new Intent(this, FirstAidPage1_1.class);
        startActivity(intent);
    }
}