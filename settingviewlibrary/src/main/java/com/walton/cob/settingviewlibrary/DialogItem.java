package com.walton.cob.settingviewlibrary;

import android.view.View;

import java.util.ArrayList;


public class DialogItem {

    private SettingItem mItem;
    private String mDialogOther;


    public DialogItem(String title, String text, String other) {
        SettingItem settingItem = new SettingItem(title,text);
        mItem = settingItem;
        mDialogOther = other;
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

    public View.OnClickListener getClickListener(){
        return mItem.getClickListener();
    }

    public void setClickListener(View.OnClickListener listener){
        mItem.setClickListener(listener);
    }




}
