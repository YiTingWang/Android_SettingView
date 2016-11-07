package com.walton.cob.settingviewlibrary;

import android.view.View;
import android.widget.BaseAdapter;

/**
 * Created by 27758 on 2016/11/7.
 */
public class ChecksListener implements View.OnClickListener  {

    private SettingItem mSettingItem;
    private BaseAdapter mSettingAdapter;

    public ChecksListener(SettingItem settingItem, BaseAdapter settingAdapter){
        mSettingItem = settingItem;
        mSettingAdapter = settingAdapter;

    }

    public void onClick(View v){
        mSettingItem.setCheck(!mSettingItem.getCheck());

        System.out.println(mSettingItem.getCheck());
        mSettingAdapter.notifyDataSetChanged();
    }

}
