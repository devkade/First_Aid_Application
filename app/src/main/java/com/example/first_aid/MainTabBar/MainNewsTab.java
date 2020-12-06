package com.example.first_aid.MainTabBar;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.first_aid.Adapter.MainNewsTabAdapter;
import com.example.first_aid.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static android.content.ContentValues.TAG;
import static androidx.appcompat.content.res.AppCompatResources.getDrawable;

public class MainNewsTab extends Fragment {
    List<String> mList = new ArrayList<String>();
    String content = null;
    String news;
    String url;
    public int news_num;
    int i = 0;

    public MainNewsTab()
    {
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main_news_tab, container, false);
        /*
        //서버에서 뉴스 제목 받아오기 시작
        String number = "1";
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection("DesignThinking").document("News"+ number);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("Text", "한글 성공: " + document.getString("NewsName"));
                    } else {
                        Log.d("한글 문서 없음", "No such document");
                    }
                } else {
                    Log.d("한글 실패", "get failed with ", task.getException());
                }
            }
        });

        //끝
         */


        String[] news_name = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17"};


        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        MainNewsTabAdapter adapter = new MainNewsTabAdapter(news_name);
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef;

        for(news_num = 1; news_num <= 17; news_num++) {
            if(news_num == 1)
                content = "News1";
            else if(news_num == 2)
                content = "News2";
            else if(news_num == 3)
                content = "News3";
            else if(news_num == 4)
                content = "News4";
            else if(news_num == 5)
                content = "News5";
            else if(news_num == 6)
                content = "News6";
            else if(news_num == 7)
                content = "News7";
            else if(news_num == 8)
                content = "News8";
            else if(news_num == 9)
                content = "News9";
            else if(news_num == 10)
                content = "News10";
            else if(news_num == 11)
                content = "News11";
            else if(news_num == 12)
                content = "News12";
            else if(news_num == 13)
                content = "News13";
            else if(news_num == 14)
                content = "News14";
            else if(news_num == 15)
                content = "News15";
            else if(news_num == 16)
                content = "News16";
            else if(news_num == 17)
                content = "News17";

            docRef = db.collection("DesignThinking").document(content);
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            Log.d(TAG, "DocumentSnapshot data: " + document.getString("NewsName"));

                            news = document.getString("NewsName");
                            url = document.getString("NewsUrl");

                            news_name[i] = news;
                            news_name[i + 17] = url;
                            i++;
                        } else {
                            Log.d(TAG, "No such document");
                        }
                    } else {
                        Log.d(TAG, "get failed with ", task.getException());
                    }
                }
            });
        }



        return rootView;
    }


}
