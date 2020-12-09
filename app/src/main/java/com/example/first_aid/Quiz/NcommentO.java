package com.example.first_aid.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.first_aid.R;
import com.example.first_aid.database.numQuiz;
import com.example.first_aid.database.odapNote;
import com.example.first_aid.database.oxquiz;

import java.util.ArrayList;
import java.util.List;

public class NcommentO extends AppCompatActivity {
    odapNote quizO= new odapNote();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<List<String>> Quiz=new ArrayList<List<String>>();
        for(int i=0; i<quizO.getOdapAllA().size(); i++){
            Quiz.add(quizO.getOdapAllA().get(i));
        }

        for(int i = 0; i< quizO.getOdapNAllA().size(); i++){
            Quiz.add(quizO.getOdapNAllA().get(i));
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_comment_layout);

        TextView textView1 = (TextView) findViewById(R.id.quiz_category);
        TextView textView2 = (TextView) findViewById(R.id.quiz_num);
        TextView textView3 = (TextView) findViewById(R.id.quiz_question);
        TextView textView4 = (TextView) findViewById(R.id.Answer);
        TextView textView5 = (TextView) findViewById(R.id.Comment);

        Intent intent=getIntent();
        int index=intent.getExtras().getInt("indexs");
        List<String> quizs= Quiz.get(index);
        textView1.setText(quizs.get(0));
        textView2.setText(quizs.get(1));
        textView3.setText(quizs.get(2));
        textView4.setText("답 : "+quizs.get(3));
        textView5.setText("해설 : "+quizs.get(4));

        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NcommentO.this, NcomlistO.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
    }
}
