package com.example.first_aid.MainTabBar;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.first_aid.FirstAid.FirstAidPage1_1;
import com.example.first_aid.MainActivity;
import com.example.first_aid.R;


public class MainFirstAidTab extends Fragment {

    MainFirstAidTab mainFirstAidTab;
    FirstAidPage1_1 firstAidPage1_1;
    ImageButton imageButton;
    public MainFirstAidTab()
    {
    }
    
    public static MainFirstAidTab newInstance(){
        return new MainFirstAidTab();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_first_aid_tab, container, false);

        imageButton = (ImageButton) view.findViewById(R.id.todayFirstAidContentButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), FirstAidPage1_1.class));
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}