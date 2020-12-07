package com.example.first_aid.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.first_aid.R;
import com.example.first_aid.database.odapNote;
import com.example.first_aid.database.oxquiz;

import java.util.List;

public class NcomlistO extends AppCompatActivity {
    private odapNote quizO= new odapNote();
    private List<List<String>> listO = quizO.getOdapAllA();
    private ListView listView;
    private ListViewAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_comment);

        if(listO.size()==0){
            Toast.makeText(NcomlistO.this, "아직 오답이 없습니다.", Toast.LENGTH_SHORT).show();
        }

        final int[] index=new int[listO.size()];
        for(int i=0; i<listO.size(); i++){
            index[i]=i;
        }

        adapter=new ListViewAdapter();

        listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        for(int i=0; i<listO.size(); i++){
            adapter.addItem(listO.get(i).get(0), listO.get(i).get(1), listO.get(i).get(2));
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NcomlistO.this, NcommentO.class);
                intent.putExtra("indexs", index[position]);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        adapter.notifyDataSetChanged();
    }
}
