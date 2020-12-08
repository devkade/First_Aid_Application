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

import java.util.List;

public class QuizA extends AppCompatActivity {
    private final oxquiz oxquiz1 = new oxquiz();
    private List<List<String>> setA = oxquiz1.getoxA();
    public odapNote odapA =new odapNote();
    private static int count;
    Button O, X;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_ox_layout);
        if(count== setA.size()){
            count=0;
        }
        TextView textView1 = (TextView) findViewById(R.id.quiz_category);
        textView1.setText(setA.get(count).get(0));
        TextView textView2 = (TextView) findViewById(R.id.quiz_num);
        textView2.setText(setA.get(count).get(1));
        TextView textView3 = (TextView) findViewById(R.id.quiz_question);
        textView3.setText(setA.get(count).get(2));

        O = (Button) findViewById(R.id.O);
        O.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setA.get(count).get(3) == "O") {
                    Toast.makeText(QuizA.this, "정답입니다!", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(QuizA.this, "틀렸습니다. 답 : X", Toast.LENGTH_SHORT).show();
                    odapA.setOdapA(setA.get(count));
                }
                count++;
                if(count< setA.size()) {
                    Intent intent = new Intent(getApplicationContext(), QuizA.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), ComA.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
            }
        });

        X = (Button) findViewById(R.id.X);
        X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setA.get(count).get(3) == "X") {
                    Toast.makeText(QuizA.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(QuizA.this, "틀렸습니다. 답 : O", Toast.LENGTH_SHORT).show();
                    odapA.setOdapA(setA.get(count));
                }
                count++;
                if(count< setA.size()) {
                    Intent intent = new Intent(getApplicationContext(), QuizA.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(getApplicationContext(), ComA.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
            }
        });

    }
}





