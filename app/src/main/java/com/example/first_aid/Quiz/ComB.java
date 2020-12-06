package com.example.first_aid.Quiz;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

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

        adapter=new ListViewAdapter();

        listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        for(int i=0; i<odapB.size(); i++){
            adapter.addItem(odapB.get(i).get(0), odapB.get(i).get(1), odapB.get(i).get(2));
        }

        adapter.notifyDataSetChanged();
    }
}
