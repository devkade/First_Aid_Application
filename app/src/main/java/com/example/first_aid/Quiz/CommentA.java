package com.example.first_aid.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.first_aid.R;
import com.example.first_aid.database.odapNote;

import java.util.List;

public class CommentA extends AppCompatActivity {
    odapNote odapnote=new odapNote();
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
        List<String> odap=odapnote.getOdapAlist(index);
        textView1.setText(odap.get(0));
        textView2.setText(odap.get(1));
        textView3.setText(odap.get(2));
        textView4.setText("답 : "+odap.get(3));
        textView5.setText("해설 : "+odap.get(4));

        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommentA.this, ComA.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
    }
}
