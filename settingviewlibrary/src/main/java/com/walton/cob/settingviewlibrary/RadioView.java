package com.walton.cob.settingviewlibrary;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import poisondog.android.preference.SaveSharedPreferences;

/**
 * Created by 27758 on 2016/12/26.
 */

public class RadioView extends LinearLayout {

    private Context mContext;
    private RadioGroup mRadioGroup;
    private List<String> mList;
    private OnClickListener mListener;

    private SaveSharedPreferences mSaveSharedPreferences;
    private Map<String, String> mMap;


    public RadioView(Context context, List<String> list, SaveSharedPreferences save, Map<String, String> map, OnClickListener listener) {
        super(context);
        mContext = context;
        mList = list;
        mSaveSharedPreferences = save;
        mMap = map;
        mListener = listener;



        RadioGroup radioGroup = new RadioGroup(mContext);
        mRadioGroup = radioGroup;
        //mRadioGroup.setOnClickListener(mListener);

        for(int i=0; i<mList.size(); i++){
            RadioButton radioButton = new RadioButton(mContext);
            radioButton.setId(i);
            radioButton.setText(mList.get(i));
            radioButton.setPadding(20,20,20,20);
            radioButton.setOnClickListener(mListener);
            mRadioGroup.addView(radioButton);
            //ViewListener.setId(i);
            //ViewListener.setId(radioButton.getId());
        }

        ViewListener.setId(mRadioGroup.getId());

        //mRadioGroup.setOnClickListener(mListener);
        System.out.println("RadioDialog - Touched");


//        mMap.put("keyRadio",Integer.toString(mRadioGroup.getCheckedRadioButtonId()));
//        mSaveSharedPreferences.execute(mMap);


        addView(mRadioGroup);

    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec),MeasureSpec.getSize(mRadioGroup.getHeight()));
        //setBackgroundColor(Color.RED);
    }

    public int getId() {
        return mRadioGroup.getCheckedRadioButtonId();
    }




}
