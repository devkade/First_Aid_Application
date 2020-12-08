package com.example.first_aid.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.first_aid.R;
import com.example.first_aid.database.oxquiz;

import java.util.List;

public class NcomlistA extends AppCompatActivity {
    private oxquiz quizA = new oxquiz();
    private List<List<String>> listA = quizA.getoxA();
    private ListView listView;
    private ListViewAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_comment);

        final int[] index=new int[listA.size()];
        for(int i = 0; i< listA.size(); i++){
            index[i]=i;
        }

        adapter=new ListViewAdapter();

        listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        for(int i = 0; i< listA.size(); i++){
            adapter.addItem(listA.get(i).get(0), listA.get(i).get(1), listA.get(i).get(2));
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NcomlistA.this, NcommentA.class);
                intent.putExtra("indexs", index[position]);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        adapter.notifyDataSetChanged();
    }
}
