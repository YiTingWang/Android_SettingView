package com.walton.cob.settingviewlibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;



public class RadioListener implements View.OnClickListener {

    private Context mContext;
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

    private RadioView mRadioView;
    private AlertDialog.Builder mBuild;

    public RadioListener(Context activity, String title,List<String> list) {
        mContext = activity;
        mTitle = title;
        mList = list;

        mBuild = new AlertDialog.Builder(mContext,mColor);
        mRadioView = new RadioView(mContext,mList);
        mBuild.setView(mRadioView);

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

    public RadioView getRadioView() {
        return mRadioView;
    }

    public void setIndex(int index) {
    	mRadioView.setIndex(index);
    }

    public void onClick(View v) {

        mRadioView.setListener(mViewListener);
//        mRadioView.setIndex(Integer.parseInt(mMap.get("keyRadio")));



        //builder.setAdapter(mAdapter,mListener);
        mBuild.setTitle(mTitle);
        mBuild.setPositiveButton(mPositiveText,mPositiveListener);
        mBuild.setNegativeButton(mNegativeText,mNegativeListener);
        mBuild.setNeutralButton(mNeutralText,mNeutralListener);



        AlertDialog alertDialog = mBuild.create();

        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                ((ViewGroup)mRadioView.getParent()).removeView(mRadioView);
            }
        });

        alertDialog.show();


    }

}
