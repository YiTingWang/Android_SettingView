package com.walton.cob.android_settingview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

/**
 * Created by 27758 on 2016/10/19.
 */
public class ConfirmListener implements View.OnClickListener {

    private MainActivity mMainActivity;
    private String mTitle;
    private String mMessage;

    public ConfirmListener(MainActivity activity,String title,String message) {
        mMainActivity = activity;
        mTitle = title;
        mMessage = message;
    }

    public void onClick(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(mMainActivity);
        builder.setTitle(mTitle);
        builder.setMessage(mMessage);
        //builder.setCancelable(false);   //不能使用手機返回鑑離開AlertDialog
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
