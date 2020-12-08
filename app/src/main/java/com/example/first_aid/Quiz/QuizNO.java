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

import java.util.List;

public class QuizNO extends AppCompatActivity {
    public odapNote odapnote=new odapNote();
    private List<String> AllOdap=odapnote.getOdapNAll();
    private int size=odapnote.getNSize();
    private static int previousSize;
    private static int[] Correct=new int[50];
    private static int ccount;
    private static int count;
    Button quiz_1, quiz_2, quiz_3, quiz_4;

    protected void onCreate(Bundle savedInstanceState) {
        if(count==size || size!=previousSize){
            count=0;
            ccount=0;
        }

        previousSize=size;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_numbering_layout);

        try {
            TextView textView1 = (TextView) findViewById(R.id.quiz_category_n);
            textView1.setText(AllOdap.get(0));
            TextView textView2 = (TextView) findViewById(R.id.quiz_num_n);
            textView2.setText(AllOdap.get(1));

            String nums=AllOdap.get(2);
            String result0= nums.substring(0, (nums.substring(0).indexOf("\n")));
            TextView textView3 = (TextView) findViewById(R.id.quiz_question_n);
            textView3.setText(result0);

            int target1=nums.indexOf("1.");
            int target2=nums.indexOf("2.");
            int target3=nums.indexOf("3.");
            int target4=nums.indexOf("4.");

            String result1=nums.substring(target1, (nums.substring(target1).indexOf("\n"))+target1);
            String result2=nums.substring(target2, (nums.substring(target2).indexOf("\n"))+target2);
            String result3=nums.substring(target3, (nums.substring(target3).indexOf("\n"))+target3);
            String result4=nums.substring(target4, (nums.substring(target4).indexOf("\n"))+target4);

            quiz_1 = (Button) findViewById(R.id.quiz_1);
            quiz_2 = (Button) findViewById(R.id.quiz_2);
            quiz_3 = (Button) findViewById(R.id.quiz_3);
            quiz_4 = (Button) findViewById(R.id.quiz_4);

            quiz_1.setText(result1);
            quiz_2.setText(result2);
            quiz_3.setText(result3);
            quiz_4.setText(result4);

        }
        catch(Exception e){
            Toast.makeText(QuizNO.this, "아직 오답이 없습니다.", Toast.LENGTH_SHORT).show();
        }

        quiz_1 = (Button) findViewById(R.id.quiz_1);
        quiz_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AllOdap.get(3) == "1") {
                    Toast.makeText(QuizNO.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                    Correct[ccount]=count;
                    ccount++;
                } else {
                    Toast.makeText(QuizNO.this, "틀렸습니다. 답 : "+AllOdap.get(3), Toast.LENGTH_SHORT).show();
                }
                count++;
                if(count< size) {
                    Intent intent = new Intent(getApplicationContext(), QuizNO.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
                else{
                    for(int i=ccount-1; i>-1; i--){
                        odapnote.Nremover(Correct[i]);
                    }
                    odapnote.setOdapANumAll();
                    odapnote.setOdapBNumAll();
                    Intent intent = new Intent(getApplicationContext(), ComO.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
            }
        });

        quiz_2 = (Button) findViewById(R.id.quiz_2);
        quiz_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AllOdap.get(3) == "2") {
                    Toast.makeText(QuizNO.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                    Correct[ccount]=count;
                    ccount++;
                } else {
                    Toast.makeText(QuizNO.this, "틀렸습니다. 답 : "+AllOdap.get(3), Toast.LENGTH_SHORT).show();
                }
                count++;
                if(count< size) {
                    Intent intent = new Intent(getApplicationContext(), QuizNO.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
                else{
                    for(int i=ccount-1; i>-1; i--){
                        odapnote.Nremover(Correct[i]);
                    }
                    odapnote.setOdapANumAll();
                    odapnote.setOdapBNumAll();
                    Intent intent = new Intent(getApplicationContext(), ComO.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
            }
        });

        quiz_3 = (Button) findViewById(R.id.quiz_3);
        quiz_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AllOdap.get(3) == "3") {
                    Toast.makeText(QuizNO.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                    Correct[ccount]=count;
                    ccount++;
                } else {
                    Toast.makeText(QuizNO.this, "틀렸습니다. 답 : "+AllOdap.get(3), Toast.LENGTH_SHORT).show();
                }
                count++;
                if(count< size) {
                    Intent intent = new Intent(getApplicationContext(), QuizNO.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
                else{
                    for(int i=ccount-1; i>-1; i--){
                        odapnote.Nremover(Correct[i]);
                    }
                    odapnote.setOdapANumAll();
                    odapnote.setOdapBNumAll();
                    Intent intent = new Intent(getApplicationContext(), ComO.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
            }
        });

        quiz_4 = (Button) findViewById(R.id.quiz_4);
        quiz_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AllOdap.get(3) == "4") {
                    Toast.makeText(QuizNO.this, "정답입니다!", Toast.LENGTH_SHORT).show();
                    Correct[ccount]=count;
                    ccount++;
                } else {
                    Toast.makeText(QuizNO.this, "틀렸습니다. 답 : "+AllOdap.get(3), Toast.LENGTH_SHORT).show();
                }
                count++;
                if(count< size) {
                    Intent intent = new Intent(getApplicationContext(), QuizNO.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
                else{
                    for(int i=ccount-1; i>-1; i--){
                        odapnote.Nremover(Correct[i]);
                    }
                    odapnote.setOdapANumAll();
                    odapnote.setOdapBNumAll();
                    Intent intent = new Intent(getApplicationContext(), ComO.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    startActivity(intent);
                }
            }
        });

    }
}
