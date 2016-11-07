package com.walton.cob.settingviewlibrary;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

/**
 * Created by 27758 on 2016/10/27.
 */
public class MultiChoiceDialog extends DialogFragment{

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        String[] items = new String[]{
                "Item1", "Item2", "Item3", "Item4", "Item5"
        };

        final boolean[] checkedItems = new boolean[]{
                false, false, false, false, false
        };

        final List<String> itemList = Arrays.asList(items);

        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                // Update the current focused item's checked status
                checkedItems[which] = isChecked;

                // Get the current focused item
                String currentItem = itemList.get(which);

                // Notify the current action
//                Toast.makeText(getApplicationContext(),
//                        currentItem + " " + isChecked, Toast.LENGTH_SHORT).show();
            }
        });

        builder.setTitle("Invite Code Manage");
        //builder.setMessage("delete invite code");
        builder.setNegativeButton("NO",null);
        builder.setPositiveButton("YES",null);
        builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when click the neutral button
            }
        });

        return builder.create();
    }

}
