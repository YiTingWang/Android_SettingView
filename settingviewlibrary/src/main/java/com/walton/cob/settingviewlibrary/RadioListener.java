package com.walton.cob.settingviewlibrary;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by 27758 on 2016/10/20.
 */
public class RadioListener implements View.OnClickListener {

    private AppCompatActivity mMainActivity;

    public RadioListener(AppCompatActivity activity) {
        mMainActivity = activity;
    }

    public void onClick(View v) {
                RadioDialog radioDialog = new RadioDialog();
                radioDialog.show(mMainActivity.getFragmentManager(),"radioDialog");

                System.out.println("0");
    }

}
