package com.walton.cob.settingviewlibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.BaseAdapter;

import java.util.List;
import java.util.Map;

import poisondog.android.preference.SaveSharedPreferences;


public class RadioListener implements View.OnClickListener {

    private Context mMainActivity;
    private DialogInterface.OnClickListener mListener;
    private List<String> mList;

    private int mColor;
    private String mTitle;

    private SaveSharedPreferences mSaveSharedPreferences;
    private Map<String, String> mMap;


    public RadioListener(Context activity, SaveSharedPreferences save, Map<String, String> map, String title) {
        mMainActivity = activity;
        mSaveSharedPreferences = save;
        mMap = map;
        mTitle = title;
    }

    public void setList(List<String> list) {
        mList = list;
    }

    public void setClickListener(DialogInterface.OnClickListener listener) {
        mListener = listener;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }

    public void onClick(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(mMainActivity,mColor);

        RadioView radioView = new RadioView(mMainActivity,mList);
        builder.setView(radioView);


        //builder.setAdapter(mAdapter,mListener);
        builder.setTitle(mTitle);


        builder.setNegativeButton("取消",null);

        builder.create().show();

    }

}
