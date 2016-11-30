package com.walton.cob.settingviewlibrary;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Map;

import poisondog.android.preference.SaveSharedPreferences;


public class RadioListener implements View.OnClickListener {

    private AppCompatActivity mMainActivity;


    public RadioListener(AppCompatActivity activity) {
        mMainActivity = activity;
    }

    public void onClick(View v) {
                RadioDialog radioDialog = new RadioDialog();
                radioDialog.show(mMainActivity.getFragmentManager(),"radioDialog");
    }

}
