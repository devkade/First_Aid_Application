package com.example.first_aid.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.first_aid.R;
import com.example.first_aid.database.odapNote;
import com.example.first_aid.database.oxquiz;

import java.util.ArrayList;
import java.util.List;

public class QuizO extends AppCompatActivity {
    public odapNote odapnote=new odapNote();
    private List<String> AllOdap=odapnote.getOdapAll();
    private int size=odapnote.getSize();
    private static int previousSize;
    private static int[] Correct=new int[50];
    private static int ccount;
    private static int count;
    Button O, X;

    protected void onCreate(Bundle savedInstanceState) {
        if(count==size || size!=previousSize){
            count=0;
            ccount=0;
        }

        previousSize=size;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_ox_layout);

        try {
            TextView textView1 = (TextView) findViewById(R.id.quiz_category);
            textView1.setText(AllOdap.get(0));
            TextView textView2 = (TextView) findViewById(R.id.quiz_num);
            textView2.setText(AllOdap.get(1));
            TextView textView3 = (TextView) findViewById(R.id.quiz_question);
            textView3.setText(AllOdap.get(2));
        }
        catch(Exception e){
            Toast.makeText(QuizO.this, "아직 오답이 없습니다.", Toast.LENGTH_SHORT).show();
        }

        O = (Button) findViewById(R.id.O);
        O.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AllOdap.get(3) == "O") {
                    Toast.makeText(QuizO.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                    Correct[ccount]=count;
                    ccount++;
                } else {
                    Toast.makeText(QuizO.this, "틀렸습니다. 답 : X", Toast.LENGTH_SHORT).show();
                }
                count++;
                if(count<size) {
                    Intent intent = new Intent(getApplicationContext(), QuizO.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
                else{
                    for(int i=ccount-1; i>-1; i--){
                        odapnote.remover(Correct[i]);
                    }
                    Intent intent = new Intent(getApplicationContext(), ComO.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
            }
        });

        X = (Button) findViewById(R.id.X);
        X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AllOdap.get(3) == "X") {
                    Toast.makeText(QuizO.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                    Correct[ccount]=count;
                    ccount++;
                } else {
                    Toast.makeText(QuizO.this, "틀렸습니다. 답 : O", Toast.LENGTH_SHORT).show();
                }
                count++;
                if(count<size) {
                    Intent intent = new Intent(getApplicationContext(), QuizO.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
                else{
                    for(int i=ccount-1; i>-1; i--){
                        odapnote.remover(Correct[i]);
                    }
                    Intent intent = new Intent(getApplicationContext(), ComO.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
            }
        });

    }
}
