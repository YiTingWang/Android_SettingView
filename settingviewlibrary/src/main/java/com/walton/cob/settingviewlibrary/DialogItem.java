package com.walton.cob.settingviewlibrary;

import android.graphics.Color;
import android.view.View;

import java.util.ArrayList;


public class DialogItem {

    private SettingItem mItem;
    private String mDialogOther;
    private String[] mItems;
    private int mBackgroundColor;
    private int mTitleColor;
    private int mTextColor;
    private int mOtherColor;


    public DialogItem(String title, String text, String other) {
        SettingItem settingItem = new SettingItem(title,text);
        mItem = settingItem;
        mDialogOther = other;
    }

    public DialogItem(String[] items) {
        mItems = items;
    }

    public String getDialogTitle() {
        return mItem.getTitle();
    }

    public String getDialogText() {
        return mItem.getText();
    }

    public String getDialogOther() {
        return mDialogOther;
    }

    public void setDialogTitle(String title) {
        mItem.setTitle(title);
    }

    public void setDialogText(String text) {
        mItem.setText(text);
    }

    public void setDialogOther(String other) {
        mDialogOther = other;
    }

    public boolean getDialogCheck(){
        return  mItem.getCheck();
    }

    public void setDialogCheck(boolean check){
        mItem.setCheck(check);
    }

    public int getBackgroundColor() {
        return mBackgroundColor;
    }

    /* Set the individual item's background color which added in the multiChoice dialog*/
    public void setBackgroundColor(int color) {
        mBackgroundColor = color;
    }

    public int getTitleColor() {
        return mTitleColor;
    }

    public void setTitleColor(int titleColor) {
        mTitleColor = titleColor;
    }

    public int getTextColor() {
        return mTextColor;
    }

    public void setTextColor(int textColor) {
        mTextColor = textColor;
    }

    public int getOtherColor() {
        return mOtherColor;
    }

    public void setOtherColor(int otherColor) {
        mOtherColor = otherColor;
    }

    public View.OnClickListener getClickListener(){
        return mItem.getClickListener();
    }

    public void setClickListener(View.OnClickListener listener){
        mItem.setClickListener(listener);
    }




}
