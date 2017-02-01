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



public class ConfirmListener implements View.OnClickListener {

    private Context mMainActivity;
    private String mTitle;
    private String mMessage;
    private DialogInterface.OnClickListener mYesListener;
    private DialogInterface.OnClickListener mNoListener;
    private static int mColor;


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

    public int getCColor() {
        return mColor;
    }

    public static void setColor(int color) {
        mColor = color;
    }

    public void onClick(View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(mMainActivity,mColor);
        builder.setTitle(mTitle);
        builder.setMessage(mMessage);
        //builder.setCancelable(false);   //不能使用手機返回鑑離開AlertDialogtime
        builder.setPositiveButton("YES", mYesListener);
        builder.setNegativeButton("NO", mNoListener);
        AlertDialog dialog = builder.create();
        dialog.show();

    }

}

