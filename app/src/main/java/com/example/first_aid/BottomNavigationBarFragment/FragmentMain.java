package com.example.first_aid.BottomNavigationBarFragment;


import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.first_aid.Adapter.SectionPagerAdapter;
import com.example.first_aid.MainTabBar.MainFirstAidTab;
import com.example.first_aid.MainTabBar.MainHealthTab;
import com.example.first_aid.MainTabBar.MainNewsTab;
import com.example.first_aid.R;
import com.google.android.material.tabs.TabLayout;


public class FragmentMain extends Fragment {

    View myFragment;

    ViewPager viewPager;
    TabLayout tabLayout;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myFragment = inflater.inflate(R.layout.fragment_main, container, false);

        viewPager = myFragment.findViewById(R.id.viewPager);
        tabLayout = myFragment.findViewById(R.id.tabLayout);


        return myFragment;
    }

    // Call onActivity Create method

    @Override
    public void onActivityCreated(@NonNull Bundle savedInstanceState)   {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter((getChildFragmentManager()));

        adapter.addFragment(new MainFirstAidTab(), "응급처치");
        adapter.addFragment(new MainNewsTab(), "뉴스");
        adapter.addFragment(new MainHealthTab(), "건강정보");

        viewPager.setAdapter(adapter);
    }
}