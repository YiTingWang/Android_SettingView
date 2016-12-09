package com.walton.cob.settingviewlibrary;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.Map;

import poisondog.android.preference.SaveSharedPreferences;
import poisondog.core.Mission;
import poisondog.core.NoMission;


public class CheckListener implements View.OnClickListener {

    private SettingItem mSettingItem;
    private BaseAdapter mSettingAdapter;
    private Mission<SettingItem> mMission;
    private Mission<SettingItem> mMission1;
    private SaveSharedPreferences mSaveSharedPreferences;
    private Map<String, String> mMap;


    public CheckListener(SettingItem settingItem, BaseAdapter settingAdapter, SaveSharedPreferences save, Map<String, String> map){
        mSettingItem = settingItem;
        mSettingAdapter = settingAdapter;
        mMission = new NoMission<SettingItem>();
        mMission1 = new NoMission<SettingItem>();
        mSaveSharedPreferences = save;
        mMap = map;
    }

    public void setMission(Mission<SettingItem> mission, Mission<SettingItem>  mission1) {
        mMission = mission;
        mMission1 = mission1;
    }

    public void onClick(View v){
        mSettingItem.setCheck(!mSettingItem.getCheck());

        mMap.put("Boolean",Boolean.toString(mSettingItem.getCheck()));
        mSaveSharedPreferences.execute(mMap);


        try{
            mMission.execute(mSettingItem);
            mMission1.execute(mSettingItem);
        }catch (Exception e) {
            e.printStackTrace();
        }


        mMap.put("keyStatus",mSettingItem.getText());
        mSaveSharedPreferences.execute(mMap);



        mSettingAdapter.notifyDataSetChanged();
    }


}
