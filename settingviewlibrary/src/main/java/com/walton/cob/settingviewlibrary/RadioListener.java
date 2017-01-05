package com.walton.cob.settingviewlibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.provider.Settings;
import android.view.View;
import android.widget.BaseAdapter;

import java.util.List;
import java.util.Map;

import poisondog.android.preference.SaveSharedPreferences;


public class RadioListener implements View.OnClickListener {

    private Context mMainActivity;
    private DialogInterface.OnClickListener mListener;
    private View.OnClickListener mViewListener;
    private String mPositiveText;
    private DialogInterface.OnClickListener mPositiveListener;
    private String mNegativeText;
    private DialogInterface.OnClickListener mNegativeListener;
    private String mNeutralText;
    private DialogInterface.OnClickListener mNeutralListener;
    private List<String> mList;

    private static int mColor;
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

    public void setViewClickListener(View.OnClickListener viewListener) {
        mViewListener = viewListener;
    }

    public void setPositiveButton(String text, DialogInterface.OnClickListener listener) {
        mPositiveText = text;
        mPositiveListener = listener;
    }

    public void setNegativeButton(String text, DialogInterface.OnClickListener listener) {
        mNegativeText = text;
        mNegativeListener = listener;
    }

    public void setNeutralButton(String text, DialogInterface.OnClickListener listener) {
        mNeutralText = text;
        mNeutralListener = listener;
    }

    public int getColor() {
        return mColor;
    }

    public static void setColor(int color) {
        mColor = color;
    }

    public void onClick(View v) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(mMainActivity,mColor);

        ViewListener viewListener = new ViewListener();
        final RadioView radioView = new RadioView(mMainActivity,mList,mSaveSharedPreferences,mMap,viewListener);
        builder.setView(radioView);





        //builder.setAdapter(mAdapter,mListener);
        builder.setTitle(mTitle);
        builder.setPositiveButton(mPositiveText,mPositiveListener);
        builder.setNegativeButton(mNegativeText,mNegativeListener);
        builder.setNeutralButton(mNeutralText,mNeutralListener);


        builder.create().show();

    }

}
