package com.example.first_aid.BottomNavigationBarFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.first_aid.Quiz.QuizActivity;
import com.example.first_aid.R;


public class FragmentQuiz extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        Button O1 = (Button) view.findViewById(R.id.O1);
        Button O2 = (Button) view.findViewById(R.id.O2);
        Button A1 = (Button) view.findViewById(R.id.A1);
        Button A2 = (Button) view.findViewById(R.id.A2);
        Button B1 = (Button) view.findViewById(R.id.B1);
        Button B2 = (Button) view.findViewById(R.id.B2);
        Button C1 = (Button) view.findViewById(R.id.C1);
        Button C2 = (Button) view.findViewById(R.id.C2);
        Button D1 = (Button) view.findViewById(R.id.D1);
        Button D2 = (Button) view.findViewById(R.id.D2);
        Button E1 = (Button) view.findViewById(R.id.E1);
        Button E2 = (Button) view.findViewById(R.id.E2);
        Button F1 = (Button) view.findViewById(R.id.F1);
        Button F2 = (Button) view.findViewById(R.id.F2);

        A1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(getActivity().getApplicationContext(),QuizActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

}