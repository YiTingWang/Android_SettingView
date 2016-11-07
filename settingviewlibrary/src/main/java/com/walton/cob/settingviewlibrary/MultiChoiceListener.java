package com.walton.cob.settingviewlibrary;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
//                new AlertDialog.Builder(mMainActivity).setTitle("Invite Code Manage").setItems(items, new DialogInterface.OnClickListener(){
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int which) {
//                        switch (which) {
//                            case 0:
//                                //Toast.makeText(mMainActivity, "item1", Toast.LENGTH_SHORT).show();
//                                MultiChoiceDialog Dialog = new MultiChoiceDialog();
//                                Dialog.show(mMainActivity.getFragmentManager(),"alertDialog");
//                                break;
//                            case 1:
//                                //Toast.makeText(mMainActivity, "item2", Toast.LENGTH_SHORT).show();
//                                MultiChoiceDialog Dialog1 = new MultiChoiceDialog();
//                                Dialog1.show(mMainActivity.getFragmentManager(),"alertDialog");
//                                break;
//                            case 2:
//                               // Toast.makeText(mMainActivity, "item3", Toast.LENGTH_SHORT).show();
//                                MultiChoiceDialog Dialog2 = new MultiChoiceDialog();
//                                Dialog2.show(mMainActivity.getFragmentManager(),"alertDialog");
//                                break;
//                        }
//                    }
//                }).show();
        System.out.println("1");
    }

}
