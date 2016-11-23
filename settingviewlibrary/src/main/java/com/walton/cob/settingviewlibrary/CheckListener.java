package com.walton.cob.settingviewlibrary;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import poisondog.core.Mission;
import poisondog.core.NoMission;


/**
 * Created by 27758 on 2016/10/20.
 */
public class CheckListener implements View.OnClickListener {

    private SettingItem mSettingItem;
    private BaseAdapter mSettingAdapter;
    private Mission<Void> mMission;


    public CheckListener(SettingItem settingItem, BaseAdapter settingAdapter){
        mSettingItem = settingItem;
        mSettingAdapter = settingAdapter;
        mMission = new NoMission<Void>();
        //setStatus();
    }

    public void setMission(Mission<Void> mission) {
        mMission = mission;
    }

    public void onClick(View v){
        mSettingItem.setCheck(!mSettingItem.getCheck());

        System.out.println(v.getClass());
        //setStatus();
        //Mission<Void> mission = new ChangeStatus(mSettingItem,mSettingItemHidden);
        try{
            mMission.execute(null);
        }catch (Exception e) {
            e.printStackTrace();
        }



        System.out.println(mSettingItem.getCheck());
        mSettingAdapter.notifyDataSetChanged();
    }


}
