/*
 * Copyright (C) 2016 Yi-Ting Wang <ig95233259@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.walton.cob.settingviewlibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.BaseAdapter;



public class MultiChoiceListener implements View.OnClickListener {

    private Context mMainActivity;
    private BaseAdapter mAdapter;
    private DialogInterface.OnClickListener mListener;
    private String mPositiveText;
    private DialogInterface.OnClickListener mPositiveListener;
    private String mNegativeText;
    private DialogInterface.OnClickListener mNegativeListener;
    private String mNeutralText;
    private DialogInterface.OnClickListener mNeutralListener;
    private static int mColor;


    public MultiChoiceListener(Context activity) {
        mMainActivity = activity;
    }

    public void setAdapter(BaseAdapter adapter) {
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

    public int getColor() {
        return mColor;
    }

    public static void setColor(int color) {
        mColor = color;
    }

    public void onClick(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(mMainActivity,mColor);

        builder.setAdapter(mAdapter,mListener);
        builder.setTitle("Invite Code Manage");
        builder.setPositiveButton(mPositiveText,mPositiveListener);
        builder.setNegativeButton(mNegativeText,mNegativeListener);
        builder.setNeutralButton(mNeutralText,mNeutralListener);
        builder.create().show();

    }

}
