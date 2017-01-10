package com.walton.cob.settingviewlibrary;

import android.provider.Settings;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;
import java.util.Map;

import poisondog.android.preference.SaveSharedPreferences;

/**
 * Created by 27758 on 2017/1/3.
 */

public class ViewListener implements View.OnClickListener {


    private SaveSharedPreferences mSaveSharedPreferences;
    private Map<String, String> mMap;
    private RadioView mRadioView;

    private RadioButton mV;


    public ViewListener(SaveSharedPreferences save, Map<String, String> map, RadioView radioView) {
        mSaveSharedPreferences = save;
        mMap = map;
        mRadioView = radioView;
    }


    public void onClick(View v) {

        System.out.println("Index :" + mRadioView.getIndex());
        mMap.put("keyRadio",Integer.toString(mRadioView.getIndex()));
        mSaveSharedPreferences.execute(mMap);




        System.out.println(Integer.parseInt(mMap.get("keyRadio")));





    }


}
