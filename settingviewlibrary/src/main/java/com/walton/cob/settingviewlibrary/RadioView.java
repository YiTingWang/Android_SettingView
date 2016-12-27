package com.walton.cob.settingviewlibrary;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 27758 on 2016/12/26.
 */

public class RadioView extends LinearLayout{

    private Context mContext;
    private RadioGroup mRadioGroup;
    private List<String> mList;


    public RadioView(Context context, List<String> list) {
        super(context);
        mContext = context;
        mList = list;

        RadioGroup radioGroup = new RadioGroup(mContext);
        mRadioGroup = radioGroup;

        for(int i=0; i<mList.size(); i++){
            RadioButton radioButton = new RadioButton(mContext);
            radioButton.setText(mList.get(i));
            radioButton.setPadding(20,20,20,20);
            mRadioGroup.addView(radioButton);
        }


        addView(mRadioGroup);

    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec),MeasureSpec.getSize(mRadioGroup.getHeight()));
        //setBackgroundColor(Color.RED);
    }




}
