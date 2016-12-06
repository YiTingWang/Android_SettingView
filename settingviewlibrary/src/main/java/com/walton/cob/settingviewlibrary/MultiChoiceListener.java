package com.walton.cob.settingviewlibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;


public class MultiChoiceListener implements View.OnClickListener {

    private Context mMainActivity;
    private ListAdapter mAdapter;
    private DialogInterface.OnClickListener mListener;
    private String mPositiveText;
    private DialogInterface.OnClickListener mPositiveListener;
    private String mNegativeText;
    private DialogInterface.OnClickListener mNegativeListener;
    private String mNeutralText;
    private DialogInterface.OnClickListener mNeutralListener;


    public MultiChoiceListener(Context activity) {
        mMainActivity = activity;
    }

    public void setAdapter(ListAdapter adapter) {
        mAdapter = adapter;
    }

    public void setClickListener(DialogInterface.OnClickListener listener) {
        mListener = listener;
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

    public void onClick(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(mMainActivity);

        builder.setAdapter(mAdapter,mListener);

        builder.setTitle("Invite Code Manage");
        builder.setPositiveButton(mPositiveText,mPositiveListener);
        builder.setNegativeButton(mNegativeText,mNegativeListener);
        builder.setNeutralButton(mNeutralText,mNeutralListener);

        builder.create().show();

    }


}
