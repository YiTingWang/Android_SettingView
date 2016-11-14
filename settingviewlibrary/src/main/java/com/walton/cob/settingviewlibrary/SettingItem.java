package com.walton.cob.settingviewlibrary;

import android.view.View;
import android.view.textservice.TextInfo;

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
        this("","",false,false,false,false);
    }

    public SettingItem(String title){
        this(title,"",false,true,false,false);
    }

    public SettingItem(String title, String text){
        this(title,text,false,true,true,false);
    }

    public SettingItem(String title, String text, boolean check){
        this(title, text, check, true, true, true);
    }

    public SettingItem(String title, String text, boolean check, boolean showTitle, boolean showText, boolean showCheck){
        mTitle = title;
        mText = text;
        mCheck = check;
        mShowTitle = showTitle;
        mShowText = showText;
        mShowCheck = showCheck;
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

    public boolean getTitleVisibility(){
        return mShowTitle;
    }

    public void setTitleVisibility(boolean showTitle){
        mShowTitle = showTitle;
    }

    public boolean getTextVisibility(){
        return mShowText;
    }

    public void setTextVisibility(boolean showText){
        mShowText = showText;
    }

    public boolean getCheckVisibility(){
        return mShowCheck;
    }

    public void setCheckVisibility(boolean showCheck){
        mShowCheck = showCheck;
    }

    public View.OnClickListener getClickListener(){
        return mListener;
    }

    public void setClickListener(View.OnClickListener listener){
        mListener = listener;
    }
}
