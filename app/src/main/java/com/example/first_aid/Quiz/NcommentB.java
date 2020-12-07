package com.example.first_aid.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.first_aid.R;
import com.example.first_aid.database.odapNote;
import com.example.first_aid.database.oxquiz;

import java.util.List;

public class NcommentB extends AppCompatActivity {
    oxquiz quizB=new oxquiz();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_comment_layout);

        TextView textView1 = (TextView) findViewById(R.id.quiz_category);
        TextView textView2 = (TextView) findViewById(R.id.quiz_num);
        TextView textView3 = (TextView) findViewById(R.id.quiz_question);
        TextView textView4 = (TextView) findViewById(R.id.Answer);
        TextView textView5 = (TextView) findViewById(R.id.Comment);

        Intent intent=getIntent();
        int index=intent.getExtras().getInt("indexs");
        List<String> oxquizs=quizB.getoxB().get(index);
        textView1.setText(oxquizs.get(0));
        textView2.setText(oxquizs.get(1));
        textView3.setText(oxquizs.get(2));
        textView4.setText("답 : "+oxquizs.get(3));
        textView5.setText("해설 : "+oxquizs.get(4));

        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NcommentB.this, NcomlistB.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
    }
}
