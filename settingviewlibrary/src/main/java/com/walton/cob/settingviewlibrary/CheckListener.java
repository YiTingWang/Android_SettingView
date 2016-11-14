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


/**
 * Created by 27758 on 2016/10/20.
 */
public class CheckListener implements View.OnClickListener {

    private SettingItem mSettingItem;
    private BaseAdapter mSettingAdapter;
    private SettingItem mSettingItemHidden;


    public CheckListener(SettingItem settingItemHidden,SettingItem settingItem, BaseAdapter settingAdapter){
        mSettingItem = settingItem;
        mSettingAdapter = settingAdapter;
        mSettingItemHidden = settingItemHidden;
        setStatus();
    }

    public void onClick(View v){
        mSettingItem.setCheck(!mSettingItem.getCheck());

        setStatus();
        


        System.out.println(mSettingItem.getCheck());
        mSettingAdapter.notifyDataSetChanged();
    }

    private void setStatus(){
        if(mSettingItem.getCheck()){
            mSettingItem.setText(mSettingItem.getText().substring(0,16)+"Open");
            mSettingItemHidden.setTitleVisibility(true);
            mSettingItemHidden.setTextVisibility(false);
            mSettingItemHidden.setCheckVisibility(true);

            System.out.println(mSettingItem.getText());
        }else{
            mSettingItem.setText(mSettingItem.getText().substring(0,16)+"Close");
            mSettingItemHidden.setTitleVisibility(false);
            mSettingItemHidden.setTextVisibility(false);
            mSettingItemHidden.setCheckVisibility(false);

            System.out.println(mSettingItem.getText());
        }
    }


}
