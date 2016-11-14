package com.walton.cob.settingviewlibrary;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

/**
 * Created by 27758 on 2016/11/7.
 */
public class MultiChoiceListener implements View.OnClickListener {

    private AppCompatActivity mMainActivity;

    public MultiChoiceListener(AppCompatActivity activity) {
        mMainActivity = activity;
    }

    public void onClick(View v) {
        MultiChoiceDialog Dialog = new MultiChoiceDialog();
        Dialog.show(mMainActivity.getFragmentManager(),"alertDialog");

        System.out.println("1");
    }

}
