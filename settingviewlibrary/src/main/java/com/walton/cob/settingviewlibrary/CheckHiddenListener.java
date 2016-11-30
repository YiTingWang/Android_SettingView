package com.walton.cob.settingviewlibrary;

import android.view.View;
import android.widget.BaseAdapter;

import java.util.Map;

import poisondog.android.preference.SaveSharedPreferences;


public class CheckHiddenListener implements View.OnClickListener  {

    private SettingItem mSettingItem;
    private BaseAdapter mSettingAdapter;
    private SaveSharedPreferences mSaveSharedPreferences;
    private Map<String, String> mMap;

    public CheckHiddenListener(SettingItem settingItem, BaseAdapter settingAdapter, SaveSharedPreferences save, Map<String, String> map){
        mSettingItem = settingItem;
        mSettingAdapter = settingAdapter;
        mSaveSharedPreferences = save;
        mMap = map;

    }

    public void onClick(View v){
        mSettingItem.setCheck(!mSettingItem.getCheck());

        mMap.put("BooleanHidden",Boolean.toString(mSettingItem.getCheck()));
        mSaveSharedPreferences.execute(mMap);

        System.out.println(mSettingItem.getCheck());
        mSettingAdapter.notifyDataSetChanged();
    }

}
