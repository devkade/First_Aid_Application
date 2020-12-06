package com.example.first_aid.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

import androidx.appcompat.app.AppCompatActivity;

import com.example.first_aid.R;
import com.example.first_aid.database.odapNote;
import com.example.first_aid.database.oxquiz;

import java.util.ArrayList;
import java.util.List;

public class QuizB extends AppCompatActivity {
    private final oxquiz oxquiz1 = new oxquiz();
    private List<List<String>> setB = oxquiz1.getoxB();
    public odapNote odapB=new odapNote();
    private static int count;
    Button O, X;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_ox_layout);
            TextView textView1 = (TextView) findViewById(R.id.quiz_category);
            textView1.setText(setB.get(count).get(0));
            TextView textView2 = (TextView) findViewById(R.id.quiz_num);
            textView2.setText(setB.get(count).get(1));
            TextView textView3 = (TextView) findViewById(R.id.quiz_question);
            textView3.setText(setB.get(count).get(2));

            O = (Button) findViewById(R.id.O);
            O.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (setB.get(count).get(3) == "O") {
                        Toast.makeText(QuizB.this, "정답입니다!", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(QuizB.this, "틀렸습니다. 답 : X", Toast.LENGTH_SHORT).show();
                        odapB.setOdapB(setB.get(count));
                    }
                    count++;
                    if(count<setB.size()) {
                        Intent intent = new Intent(getApplicationContext(), QuizB.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(getApplicationContext(), ComB.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(intent);
                    }
                }
            });

            X = (Button) findViewById(R.id.X);
            X.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (setB.get(count).get(3) == "X") {
                        Toast.makeText(QuizB.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(QuizB.this, "틀렸습니다. 답 : O", Toast.LENGTH_SHORT).show();
                        odapB.setOdapB(setB.get(count));
                    }
                    count++;
                    if(count<setB.size()) {
                        Intent intent = new Intent(getApplicationContext(), QuizB.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(getApplicationContext(), ComB.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        startActivity(intent);
                    }
                }
            });

    }
}






