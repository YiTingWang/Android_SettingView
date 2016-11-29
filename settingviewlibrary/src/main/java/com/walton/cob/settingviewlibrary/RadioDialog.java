package com.walton.cob.settingviewlibrary;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import java.util.Map;

import poisondog.android.preference.SaveSharedPreferences;

/**
 * Created by 27758 on 2016/10/20.
 */
public class RadioDialog extends DialogFragment {

    final String[] items = new String[] {"5 Days","10 Days","20 Days","30 Days"};
    private String selection;


    public Dialog onCreateDialog(Bundle savedInstanceState){

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Keep Day").setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        selection = (String) items[which];
                        dialog.dismiss();
                        break;
                    case 1:
                        selection = (String) items[which];
                        dialog.dismiss();
                        break;
                    case 2:
                        selection = (String) items[which];
                        dialog.dismiss();
                        break;
                    case 3:
                        selection = (String) items[which];
                        dialog.dismiss();
                        break;
                }
            }
        }).setNegativeButton("取消",null);
        return builder.create();
    }
}
