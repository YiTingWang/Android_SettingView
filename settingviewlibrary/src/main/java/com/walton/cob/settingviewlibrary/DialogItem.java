package com.walton.cob.settingviewlibrary;

import android.view.View;

import java.util.ArrayList;

/**
 * Created by 27758 on 2016/11/11.
 */
public class DialogItem {

    private String mDialogTitle;
    private String mDialogText;
    private boolean mDialogCheck;
    private View.OnClickListener mListener;

    public DialogItem(String title, String text) {
        mDialogTitle = title;
        mDialogText = text;
        mDialogCheck = false;
        mListener = new NoListener();

    }

    public String getDialogTitle() {
        return mDialogTitle;
    }

    public String getDialogText() {
        return mDialogText;
    }

    public void setDialogTitle(String title) {
        mDialogTitle = title;
    }

    public void setDialogText(String text) {
        mDialogText = text;
    }

    public boolean getDialogCheck(){
        return  mDialogCheck;
    }

    public void setDialogCheck(boolean check){
        mDialogCheck = check;
    }

    public View.OnClickListener getClickListener(){
        return mListener;
    }

    private void setClickListener(View.OnClickListener listener){
        mListener = listener;
    }




}
