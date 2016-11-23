package com.walton.cob.settingviewlibrary;

import android.content.DialogInterface;

/**
 * Created by 27758 on 2016/11/23.
 */
public class NoClickListener implements DialogInterface.OnClickListener {

    public NoClickListener(){

    }

    public void onClick(DialogInterface dialog, int which){
        System.out.println("No");

    }
}
