package com.walton.cob.settingviewlibrary;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by 27758 on 2016/10/20.
 */
public class RadioListener implements View.OnClickListener {

    private AppCompatActivity mMainActivity;
    private int select;
    private int mSelect;

    private final CharSequence[] items = {"item1","item2","item3"};

    public RadioListener(AppCompatActivity activity,int select) {
        mMainActivity = activity;
        mSelect = select;
    }

    public void onClick(View v) {

        switch(mSelect){
            case 0:
                RadioAlertDialog radioDialog = new RadioAlertDialog();
                radioDialog.show(mMainActivity.getFragmentManager(),"radioDialog");
                System.out.println("0");
                break;
            case 1:
                //InfoDialog Dialog = new InfoDialog();
                //Dialog.show(mMainActivity.getFragmentManager(),"alertDialog");
                new AlertDialog.Builder(mMainActivity).setTitle("Invite Code Manage").setItems(items, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        switch (which) {
                            case 0:
                                //Toast.makeText(mMainActivity, "item1", Toast.LENGTH_SHORT).show();
                                InfoDialog Dialog = new InfoDialog();
                                Dialog.show(mMainActivity.getFragmentManager(),"alertDialog");
                                break;
                            case 1:
                                //Toast.makeText(mMainActivity, "item2", Toast.LENGTH_SHORT).show();
                                InfoDialog Dialog1 = new InfoDialog();
                                Dialog1.show(mMainActivity.getFragmentManager(),"alertDialog");
                                break;
                            case 2:
                               // Toast.makeText(mMainActivity, "item3", Toast.LENGTH_SHORT).show();
                                InfoDialog Dialog2 = new InfoDialog();
                                Dialog2.show(mMainActivity.getFragmentManager(),"alertDialog");
                                break;
                        }
                    }
                }).show();
                System.out.println("1");
                break;
        }
    }


}
