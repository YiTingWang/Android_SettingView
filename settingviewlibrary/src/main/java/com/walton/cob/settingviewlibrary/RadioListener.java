package com.walton.cob.settingviewlibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Map;

import poisondog.android.preference.SaveSharedPreferences;


public class RadioListener implements View.OnClickListener {

    private Context mMainActivity;

    //final String[] items = new String[] {"5 Days","10 Days","20 Days","30 Days"};
    private String selection;

    private SaveSharedPreferences mSaveSharedPreferences;
    private Map<String, String> mMap;

    private int mBackgroundColor;

    private String mTitle;
    private String[] mItems;


    public RadioListener(Context activity, SaveSharedPreferences save, Map<String, String> map, int color, String title, String[] items) {
        mMainActivity = activity;
        mSaveSharedPreferences = save;
        mMap = map;
        mBackgroundColor = color;
        mTitle = title;
        mItems = items;
    }


    public void onClick(View v) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(mMainActivity,mBackgroundColor);
        builder.setTitle(mTitle).setSingleChoiceItems(mItems, Integer.parseInt(mMap.get("keyRadio")), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        selection = (String) mItems[which];
                        break;
                    case 1:
                        selection = (String) mItems[which];
                        break;
                    case 2:
                        selection = (String) mItems[which];
                        break;
                    case 3:
                        selection = (String) mItems[which];
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
