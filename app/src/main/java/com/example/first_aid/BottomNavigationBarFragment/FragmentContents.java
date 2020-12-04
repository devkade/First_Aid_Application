package com.example.first_aid.BottomNavigationBarFragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.first_aid.FirstAid.FirstAidMainPage;
import com.example.first_aid.FirstAid.FirstAidPage1;
import com.example.first_aid.R;


public class FragmentContents extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.first_aid_main_layout, container, false);

        Button button = (Button) view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), FirstAidPage1.class);
                startActivity(in);
            }
        });

        return view;

    }
}