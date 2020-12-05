package com.example.first_aid.Quiz;

import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.first_aid.R;

public class QuizActivity extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this) ;
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24) ;
        textView.setText("TEXT1") ;
        setContentView(textView) ;
    }

}
