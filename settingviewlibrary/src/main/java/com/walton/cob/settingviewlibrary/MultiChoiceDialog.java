package com.walton.cob.settingviewlibrary;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 27758 on 2016/10/27.
 */
public class MultiChoiceDialog extends DialogFragment{

    @Override
    public Dialog onCreateDialog(final Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        List<DialogItem> list = new ArrayList<>();
        final DialogAdapter dialogAdapter = new DialogAdapter(list,getActivity());

        final DialogItem dialogItem = new DialogItem("Title1","Text1","X1");
        list.add(dialogItem);

        DialogItem dialogItem1 = new DialogItem("Title2","Text2","X2");
        list.add(dialogItem1);

        DialogItem dialogItem2 = new DialogItem("Title3","Text3","X3");
        list.add(dialogItem2);


//        WindowManager.LayoutParams a = this.getDialog().getWindow().getAttributes();
//        a.alpha = 0.3f;
//        this.getDialog().getWindow().setAttributes(a);





        builder.setAdapter(dialogAdapter, new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
                Toast.makeText(getActivity(),"You clicked"+which,Toast.LENGTH_SHORT).show();
                System.out.println("pressed");
            }
        });


        builder.setTitle("Invite Code Manage");
        //builder.setMessage("delete invite code");
        builder.setNegativeButton("No",null);
        builder.setPositiveButton("Share",null);
        builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do something when click the neutral button
            }
        });

        return builder.create();
    }

}
