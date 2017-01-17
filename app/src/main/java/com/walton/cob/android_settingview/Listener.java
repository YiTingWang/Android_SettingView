package com.walton.cob.android_settingview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Adapter;

import com.walton.cob.settingviewlibrary.ConfirmListener;
import com.walton.cob.settingviewlibrary.MultiChoiceListener;
import com.walton.cob.settingviewlibrary.RadioListener;
import com.walton.cob.settingviewlibrary.RadioView;
import com.walton.cob.settingviewlibrary.SettingAdapter;

import java.util.Map;

import poisondog.android.preference.SaveSharedPreferences;

/**
 * Created by 27758 on 2017/1/16.
 */

public class Listener implements View.OnClickListener{

    private SaveSharedPreferences mSaveSharedPreferences;
    private Map<String, String> mMap;
    private RadioView mRadioView;
    private Activity mContext;

    private SettingAdapter mAdapter;



    public Listener(Activity context, SaveSharedPreferences save, Map<String, String> map, RadioView radioView, SettingAdapter adapter) {
        mContext = context;
        mSaveSharedPreferences = save;
        mMap = map;
        mRadioView = radioView;

        mAdapter = adapter;

    }


    public void onClick(View v) {


        if(mRadioView.getIndex() == 0){
            mContext.getApplication().setTheme(R.style.AppTheme);
            RadioListener.setColor(R.style.AlertDialog);
            MultiChoiceListener.setColor(R.style.AlertDialog);
            ConfirmListener.setColor(R.style.AlertDialog);
        }else if(mRadioView.getIndex() == 1){
            mContext.getApplication().setTheme(R.style.AppTheme2);
            RadioListener.setColor(R.style.AlertDialog2);
            MultiChoiceListener.setColor(R.style.AlertDialog2);
            ConfirmListener.setColor(R.style.AlertDialog2);
        }else{
            mContext.getApplication().setTheme(R.style.AppTheme);
            RadioListener.setColor(R.style.AlertDialog);
            MultiChoiceListener.setColor(R.style.AlertDialog);
            ConfirmListener.setColor(R.style.AlertDialog);
        }

        //mAdapter.notifyDataSetChanged();
        mContext.finish();
        mContext.startActivity(new Intent(mContext, mContext.getClass()));



        mMap.put("keyRadio",Integer.toString(mRadioView.getIndex()));
        mSaveSharedPreferences.execute(mMap);


        System.out.println("Index :" + mRadioView.getIndex());


    }


}
