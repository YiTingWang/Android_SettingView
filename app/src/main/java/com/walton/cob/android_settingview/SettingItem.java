package com.walton.cob.android_settingview;

import android.view.View;

/**
 * Created by 27758 on 2016/10/19.
 */
public class SettingItem {

    private String mTitle;
    private String mText;
    private boolean mCheck;
    private boolean mShowText;
    private boolean mShowCheck;
    private View.OnClickListener mListener;

    public SettingItem(String title){
        mTitle = title;
        mShowText = false;
        mShowCheck = false;
        mListener = new NoListener();
    }

    public SettingItem(String title, String text){
        mTitle = title;
        mText = text;
        mShowText = true;
        mShowCheck = false;
        mListener = new NoListener();
    }

    public SettingItem(String title, String text, boolean check){
        mTitle = title;
        mText = text;
        mShowText = true;
        mShowCheck = true;
        mCheck = check;
        mListener = new NoListener();
    }

    public String getTitle(){
        return mTitle;
    }

    public String getText(){
        return mText;
    }

    public void setText(String text){
        mText=text;
    }

    public boolean getCheck(){
        return mCheck;
    }

    public void setCheck(boolean check){
        mCheck = check;
    }

    public boolean getShowTextVisibility(){
        return mShowText;
    }

    public boolean getShowCheckVisibility(){
        return mShowCheck;
    }

    public View.OnClickListener getClickListener(){
        return mListener;
    }

    public void setClickListener(View.OnClickListener listener){
        mListener=listener;
    }
}
