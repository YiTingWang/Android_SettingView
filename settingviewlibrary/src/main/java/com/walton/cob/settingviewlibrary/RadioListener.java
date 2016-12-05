package com.walton.cob.settingviewlibrary;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Map;

import poisondog.android.preference.SaveSharedPreferences;


public class RadioListener implements View.OnClickListener {

    private AppCompatActivity mMainActivity;

    final String[] items = new String[] {"5 Days","10 Days","20 Days","30 Days"};
    private String selection;

    private SaveSharedPreferences mSaveSharedPreferences;
    private Map<String, String> mMap;


    public RadioListener(AppCompatActivity activity, SaveSharedPreferences save, Map<String, String> map) {
        mMainActivity = activity;
        mSaveSharedPreferences = save;
        mMap = map;
    }


    public void onClick(View v) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(mMainActivity);
        builder.setTitle("Keep Day").setSingleChoiceItems(items, Integer.parseInt(mMap.get("keyRadio")), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        selection = (String) items[which];
                        break;
                    case 1:
                        selection = (String) items[which];
                        break;
                    case 2:
                        selection = (String) items[which];
                        break;
                    case 3:
                        selection = (String) items[which];
                        break;
                }
                mMap.put("keyRadio",Integer.toString(which));
                mSaveSharedPreferences.execute(mMap);
                dialog.dismiss();
            }
        }).setNegativeButton("取消",null);

        builder.create().show();

//        RadioDialog radioDialog = new RadioDialog();
//        radioDialog.show(mMainActivity.getFragmentManager(),"radioDialog");
    }

}
