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
    String reporter;
    String num;
    String[] s_content = {"News1", "News2", "News3", "News4", "News5", "News6", "News7", "News8", "News9", "News10", "News11", "News12", "News13", "News14", "News15", "News16", "News17"};
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



        String[] news_name = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                "News1", "News2", "News3", "News4", "News5", "News6", "News7", "News8", "News9", "News10", "News11", "News12", "News13", "News14", "News15", "News16", "News17",};


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef;


        for(int news_num = 1; news_num <= 17; news_num++) {
            content = s_content[news_num - 1];
            docRef = db.collection("DesignThinking").document(s_content[news_num - 1]);
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {

                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            if(i <= 16) {
                                news = document.getString("NewsName");
                                url = document.getString("NewsUrl");
                                reporter = document.getString("Reporter");
                                num = document.getString("number");

                                news_name[i] = news;
                                news_name[i + 17] = url;
                                news_name[i + 34] = reporter + " 기자";
                                news_name[i + 51] = num;

                                Log.d(TAG, "DocumentSnapshot data: " + news);
                                Log.d(TAG, "DocumentSnapshot data: " + url);
                                Log.d(TAG, "DocumentSnapshot data: " + reporter);
                                Log.d(TAG, "DocumentSnapshot data: " + s_content[i]);
                                Log.d(TAG, "DocumentSnapshot data: " + content);

                                i++;
                            }
                        } else {
                            Log.d(TAG, "No such document");
                        }
                    } else {
                        Log.d(TAG, "get failed with ", task.getException());
                    }
                }
            });
        }


        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        MainNewsTabAdapter adapter = new MainNewsTabAdapter(news_name);
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);



        return rootView;
    }


}