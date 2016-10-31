package com.walton.cob.settingviewlibrary;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

/**
 * Created by 27758 on 2016/10/27.
 */
public class InfoDialog extends DialogFragment{

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new android.app.AlertDialog.Builder(getActivity());
        builder.setTitle("Delete");
        builder.setMessage("delete invite code");
        builder.setNegativeButton("NO",null);
        builder.setPositiveButton("YES",null);
        return builder.create();
    }


}
