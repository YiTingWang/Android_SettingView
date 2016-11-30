package com.walton.cob.settingviewlibrary;

import android.content.DialogInterface;


public class NoClickListener implements DialogInterface.OnClickListener {

    public NoClickListener(){

    }

    public void onClick(DialogInterface dialog, int which){
        System.out.println("No");

    }
}
