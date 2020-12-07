package com.example.first_aid.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import com.example.first_aid.Quiz.QuizB;
import com.example.first_aid.R;
import com.example.first_aid.database.odapNote;

public class ComB extends AppCompatActivity {
    private odapNote odapnoteB = new odapNote();
    private List<List<String>> odapB = odapnoteB.getOdapB();
    private ListView listView;
    private ListViewAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_comment);

        final int[] index=new int[odapB.size()];
        for(int i=0; i<odapB.size(); i++){
            index[i]=i;
        }

        adapter=new ListViewAdapter();

        listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        for(int i=0; i<odapB.size(); i++){
            adapter.addItem(odapB.get(i).get(0), odapB.get(i).get(1), odapB.get(i).get(2));
        }

        odapNote odapnote=new odapNote();
        odapnote.setOdapAll();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ComB.this, CommentB.class);
                intent.putExtra("indexs", index[position]);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        adapter.notifyDataSetChanged();
    }
}
