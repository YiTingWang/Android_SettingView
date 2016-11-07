package com.walton.cob.settingviewlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by 27758 on 2016/10/20.
 */
public class CheckListener implements View.OnClickListener {

    private SettingItem mSettingItem;
    private BaseAdapter mSettingAdapter;


    public CheckListener(SettingItem settingItem, BaseAdapter settingAdapter){
        mSettingItem = settingItem;
        mSettingAdapter = settingAdapter;

        setStatus();
    }

    public void onClick(View v){
        mSettingItem.setCheck(!mSettingItem.getCheck());

        setStatus();

        SettingItem settingItem = new SettingItem();
        ChecksListener checksListener = new ChecksListener(settingItem,mSettingAdapter);


        System.out.println(mSettingItem.getCheck());
        mSettingAdapter.notifyDataSetChanged();
    }

    private void setStatus(){
        if(mSettingItem.getCheck()){
            mSettingItem.setText(mSettingItem.getText().substring(0,16)+"Open");
            System.out.println(mSettingItem.getText());
        }else{
            mSettingItem.setText(mSettingItem.getText().substring(0,16)+"Close");
            System.out.println(mSettingItem.getText());
        }
    }


}
