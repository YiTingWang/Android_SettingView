package com.walton.cob.settingviewlibrary;

import android.content.DialogInterface;

import java.util.Map;

/**
 * Created by 27758 on 2016/11/21.
 */
public class YesClickListener implements DialogInterface.OnClickListener{

    public YesClickListener(){

    }

    public void onClick(DialogInterface dialog, int which){
        System.out.println("Yes");

    }


}
