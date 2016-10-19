package com.walton.cob.android_settingview;

import android.view.View;

/**
 * Created by 27758 on 2016/10/19.
 */
public class RadioListener implements View.OnClickListener {

    private MainActivity mMainActivity;

    public RadioListener(MainActivity activity) {
        mMainActivity = activity;
    }
    public void onClick(View v) {
        RadioAlertDialog myDialog = new RadioAlertDialog();
        myDialog.show(mMainActivity.getFragmentManager(),"myDialog");
    }
}
