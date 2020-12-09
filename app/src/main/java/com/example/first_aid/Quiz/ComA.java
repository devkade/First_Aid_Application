package com.example.first_aid.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.first_aid.R;
import com.example.first_aid.database.odapNote;

import java.util.List;

public class ComA extends AppCompatActivity {
    private odapNote odapnoteA = new odapNote();
    private List<List<String>> odapA = odapnoteA.getOdapA();
    private List<List<String>> odapNA = odapnoteA.getOdapNA();
    private ListView listView;
    private ListViewAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_comment);

        final int[] index=new int[odapA.size()+odapNA.size()];
        for(int i = 0; i< odapA.size(); i++){
            index[i]=i;
        }

        for(int i = odapA.size(); i<odapA.size()+odapNA.size(); i++){
            index[i]=i;
        }

        adapter=new ListViewAdapter();

        listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        for(int i = 0; i< odapA.size(); i++){
            adapter.addItem(odapA.get(i).get(0), odapA.get(i).get(1), odapA.get(i).get(2));
        }

        for(int i = 0; i< odapNA.size(); i++){
            adapter.addItem(odapNA.get(i).get(0), odapNA.get(i).get(1), odapNA.get(i).get(2));
        }

        odapNote odapnote=new odapNote();
        odapnote.setOdapAAll();
        odapnote.setOdapANumAll();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ComA.this, CommentA.class);
                intent.putExtra("indexs", index[position]);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        adapter.notifyDataSetChanged();
    }
}
