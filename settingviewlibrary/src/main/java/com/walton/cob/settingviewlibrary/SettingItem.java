package com.walton.cob.settingviewlibrary;

import android.view.View;
/**
 * Created by 27758 on 2016/10/20.
 */
public class SettingItem {

    private String mTitle;
    private String mText;
    private boolean mCheck;
    private boolean mShowTitle;
    private boolean mShowText;
    private boolean mShowCheck;
    private View.OnClickListener mListener;

    public SettingItem(){
        mShowTitle = false;
        mShowText = false;
        mShowCheck =false;
        mListener = new NoListener();
    }

    public SettingItem(String title){
        this(title,"",false);
        mShowText = false;
        mShowCheck = false;
        mListener = new NoListener();
    }

    public SettingItem(String title, String text){
        this(title,text,false);
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

    public boolean getShowTitleVisibility(){
        return mShowTitle;
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
        mListener = listener;
    }
}
