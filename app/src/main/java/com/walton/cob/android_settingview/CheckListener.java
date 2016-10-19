package com.walton.cob.android_settingview;

import android.view.View;

/**
 * Created by 27758 on 2016/10/19.
 */
public class CheckListener implements View.OnClickListener {

    private SettingItem mSettingItem;
    private SettingAdapter mSettingAdapter;

    public CheckListener(SettingItem settingItem,SettingAdapter settingAdapter){
        mSettingItem = settingItem;
        mSettingAdapter = settingAdapter;

        if(mSettingItem.getCheck()){
            mSettingItem.setText(mSettingItem.getText().substring(0,16)+"Open");
        }
        else{
            mSettingItem.setText(mSettingItem.getText().substring(0,16)+"Close");
        }
    }

    public void onClick(View v){

        mSettingItem.setCheck(!mSettingItem.getCheck());

        if(mSettingItem.getCheck()){
            mSettingItem.setText(mSettingItem.getText().substring(0,16)+"Open");
            System.out.println(mSettingItem.getText());
        }
        else{
            mSettingItem.setText(mSettingItem.getText().substring(0,16)+"Close");
            System.out.println(mSettingItem.getText());
        }

        System.out.println(mSettingItem.getCheck());
        mSettingAdapter.notifyDataSetChanged();


    }

}
