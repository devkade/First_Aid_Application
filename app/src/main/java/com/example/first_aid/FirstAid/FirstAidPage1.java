package com.example.first_aid.FirstAid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.first_aid.R;

public class FirstAidPage1 extends AppCompatActivity {
    Button button1;
    Button button2;
    ImageButton imagebutton1;
    ImageButton imagebutton2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_aid_page1);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFirstAidPage1_1();
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFirstAidPage1_2();
            }
        });

        ImageButton imagebutton1 = (ImageButton) findViewById(R.id.adultcprImageButton);
        imagebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoad1_1 = new Intent(FirstAidPage1.this, FirstAidPage1_1.class);
                startActivity(intentLoad1_1);
            }

        });

        ImageButton imagebutton2 = (ImageButton) findViewById(R.id.childcprImageButton);
        imagebutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoad1_2 = new Intent(FirstAidPage1.this, FirstAidPage1_2.class);
                startActivity(intentLoad1_2);
            }

        });
    }

    public void openFirstAidPage1_1(){
        Intent intentLoad1_1 = new Intent(this, FirstAidPage1_1.class);
        startActivity(intentLoad1_1);
    }

    public void openFirstAidPage1_2(){
        Intent intentLoad1_2 = new Intent(this, FirstAidPage1_2.class);
        startActivity(intentLoad1_2);
    }
}