package com.example.first_aid.BottomNavigationBarFragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.first_aid.R;
import com.kyleduo.switchbutton.SwitchButton;

import static android.content.ContentValues.TAG;


public class FragmentSetting extends Fragment {
    private OnSettingListener onSettingListener;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_setting, container, false);

        Switch switchButton = (Switch) v.findViewById(R.id.lockscreen_switch);

        boolean ls_on;
        Bundle bundle = getArguments();
        ls_on = bundle.getBoolean("ls_on");
        switchButton.setChecked(ls_on);
        Log.d(TAG, "Fragment ls_on: " + ls_on);

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 스위치 버튼이 체크되었는지 검사하여 텍스트뷰에 각 경우에 맞게 출력합니다.
                boolean lockscreen_on;
                Log.d(TAG, "boolean: " + isChecked);
                lockscreen_on = isChecked;
                if(onSettingListener != null){
                    onSettingListener.onSetting(lockscreen_on);
                }
            }
        });

        return v;
    }

    public interface OnSettingListener {
        void onSetting(boolean lockscreen_on);
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(getActivity() != null && getActivity() instanceof OnSettingListener){
            onSettingListener = (OnSettingListener) getActivity();
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        onSettingListener = null;
    }
}