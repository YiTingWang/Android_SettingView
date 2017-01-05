package com.walton.cob.settingviewlibrary;

import android.provider.Settings;
import android.view.View;
import android.widget.RadioButton;

/**
 * Created by 27758 on 2017/1/3.
 */

public class ViewListener implements View.OnClickListener {

    private static int mId;
    private RadioButton mV;

    public ViewListener() {

    }

    public static void setId(int id) {
        mId = id;
    }

    public static int getId() {
        return mId;
    }

    public void onClick(View v) {
        System.out.println("View - Touched");
        System.out.println(v.getClass());

        mV = (RadioButton) v;
        mV.setChecked(true);


        System.out.println(mId);


    }


}
