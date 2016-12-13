package com.walton.cob.settingviewlibrary;

import android.graphics.Color;
import android.view.View;

import java.util.ArrayList;


public class DialogItem {

    private SettingItem mItem;
    private String mDialogOther;
    private int mBackgroundColor;
    private String[] mItems;


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

    public View.OnClickListener getClickListener(){
        return mItem.getClickListener();
    }

    public void setClickListener(View.OnClickListener listener){
        mItem.setClickListener(listener);
    }




}
