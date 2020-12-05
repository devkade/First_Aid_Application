package com.example.first_aid.Quiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.first_aid.R;
import com.example.first_aid.database.oxquiz;

import java.util.ArrayList;
import java.util.List;

public class QuizA extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_ox_layout);

        oxquiz oxquiz=new oxquiz();
        List<List<String>> setA = new ArrayList<List<String>>();

        setA=oxquiz.getoxA();

        for(int i=0; i<setA.size(); i++){
            TextView textView1 = (TextView) findViewById(R.id.quiz_num) ;
            textView1.setText(setA.get(i).get(1)) ;
            TextView textView2 = (TextView) findViewById(R.id.quiz_question) ;
            textView1.setText(setA.get(i).get(2)) ;

            Button O = (Button) findViewById(R.id.O) ;
            List<List<String>> finalSetA = setA;
            int finalI = i;
            O.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalSetA.get(finalI).get(3)=="O"){
                        Toast.makeText(QuizA.this,"정답입니다!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(QuizA.this,"틀렸습니다. 답 : X", Toast.LENGTH_SHORT).show();
                    }
                }
            }) ;

            Button X = (Button) findViewById(R.id.O) ;
            O.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalSetA.get(finalI).get(3)=="X"){
                        Toast.makeText(QuizA.this,"정답입니다!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(QuizA.this,"틀렸습니다. 답 : O", Toast.LENGTH_SHORT).show();
                    }
                }
            }) ;

        }
    }




}
