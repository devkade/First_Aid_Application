package com.example.first_aid.Quiz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import com.example.first_aid.Quiz.QuizB;
import com.example.first_aid.R;
import com.example.first_aid.database.odapNote;

public class ComB extends AppCompatActivity {
    private odapNote odapnoteB = new odapNote();
    private List<List<String>> odapB = odapnoteB.getOdapB();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_comment);
    }
}
