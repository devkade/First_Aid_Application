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

public class ComO extends AppCompatActivity {
    private odapNote odapnote = new odapNote();
    private List<List<String>> odapAll = odapnote.getOdapAllA();
    private ListView listView;
    private ListViewAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_comment);

        final int[] index=new int[odapAll.size()];
        for(int i=0; i<odapAll.size(); i++){
            index[i]=i;
        }

        adapter=new ListViewAdapter();

        listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        for(int i=0; i<odapAll.size(); i++){
            adapter.addItem(odapAll.get(i).get(0), odapAll.get(i).get(1), odapAll.get(i).get(2));
        }

        odapNote odapnote=new odapNote();
        odapnote.setOdapAll();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ComO.this, CommentO.class);
                intent.putExtra("indexs", index[position]);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        adapter.notifyDataSetChanged();
    }
}
