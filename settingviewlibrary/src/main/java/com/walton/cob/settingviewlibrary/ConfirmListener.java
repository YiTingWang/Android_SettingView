package com.walton.cob.settingviewlibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.preference.CheckBoxPreference;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import poisondog.core.Mission;
import poisondog.core.NoMission;


public class ConfirmListener implements View.OnClickListener {


    private Context mMainActivity;
    private String mTitle;
    private String mMessage;
    private DialogInterface.OnClickListener mYesListener;
    private DialogInterface.OnClickListener mNoListener;

    public ConfirmListener(Context activity, String title, String message) {
        mMainActivity = activity;
        mTitle = title;
        mMessage = message;

        mNoListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        };
        mYesListener = mNoListener;
    }

    public DialogInterface.OnClickListener getYesListener(){
        return mYesListener;
    }

    public void setYesListener(DialogInterface.OnClickListener listener){
        mYesListener = listener;
    }

    public DialogInterface.OnClickListener getNoListener(){
        return mNoListener;
    }

    public void setNoListener(DialogInterface.OnClickListener listener){
        mNoListener = listener;
    }


    public void onClick(View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(mMainActivity);
        builder.setTitle(mTitle);
        builder.setMessage(mMessage);
        //builder.setCancelable(false);   //不能使用手機返回鑑離開AlertDialogtime
        builder.setPositiveButton("YES", mYesListener);
        builder.setNegativeButton("NO", mNoListener);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

