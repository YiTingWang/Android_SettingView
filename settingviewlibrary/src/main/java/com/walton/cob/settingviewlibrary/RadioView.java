package com.walton.cob.settingviewlibrary;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import poisondog.android.preference.SaveSharedPreferences;

/**
 * Created by 27758 on 2016/12/26.
 */

public class RadioView extends ScrollView {

    private RadioGroup mRadioGroup;
    private List<RadioButton> mList;
    private int mIndex;



    public RadioView(Context context, List<String> list) {
        super(context);

        LinearLayout linearLayout = new LinearLayout(context);


        List<RadioButton> radioList = new ArrayList<>();
        mList = radioList;


        RadioGroup radioGroup = new RadioGroup(context);
        mRadioGroup = radioGroup;


        for(int i=0; i<list.size(); i++) {
            RadioButton radioButton = new RadioButton(context);
            radioButton.setText(list.get(i));
            radioButton.setPadding(20,20,20,20);
            mList.add(radioButton);
            mRadioGroup.addView(radioButton);
        }



        linearLayout.addView(mRadioGroup);

        addView(linearLayout);

    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        //setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec),MeasureSpec.getSize(mRadioGroup.getHeight()));
        //setBackgroundColor(Color.RED);
    }

    public void setListener(OnClickListener listener) {
        for(int i=0; i<mList.size();i++){
            mList.get(i).setOnClickListener(listener);
        }
    }

    public void setIndex(int index) {
        mIndex = index;

        if(mIndex == -1){
            System.out.println("Index : -1");
        }else{
            mList.get(mIndex).setChecked(true);
        }

    }

    public int getIndex() {
        for(int i=0; i<mList.size(); i++) {
            if(mList.get(i).isChecked()) {
                mIndex = i;
            }
        }
        return mIndex;
    }

    public List<RadioButton> getList() {
        return mList;
    }




}
