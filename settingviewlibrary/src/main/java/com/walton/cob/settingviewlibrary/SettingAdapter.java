package com.walton.cob.settingviewlibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;


import java.util.List;

/**
 * Created by 27758 on 2016/10/20.
 */
public class SettingAdapter extends BaseAdapter{
    private List<SettingItem> mList;
    private Context mContext;


    public int getCount(){
        return mList.size();
    }

    public View getView(int position, View convertView, ViewGroup parent){

        SettingItem settingItem = mList.get(position);

        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list_item,parent,false);
        TextView titleView = (TextView) row.findViewById(R.id.tvTitle);
        TextView textView = (TextView) row.findViewById(R.id.tvText);
        CheckBox checkBox = (CheckBox) row.findViewById(R.id.checkbox);
        TextView textViews = (TextView) row.findViewById(R.id.tvTexts);
        CheckBox checkBoxs = (CheckBox) row.findViewById(R.id.checkboxs);
        row.setOnClickListener(settingItem.getClickListener());



        settingItem.getShowTextVisibility();
        settingItem.getShowCheckVisibility();
        textView.setVisibility(View.VISIBLE);
        if(settingItem.getShowTextVisibility()){
            textView.setVisibility(View.VISIBLE);
        }else{
            textView.setVisibility(View.GONE);
        }
        if(settingItem.getShowCheckVisibility()){
            checkBox.setVisibility(View.VISIBLE);
        }else{
            checkBox.setVisibility(View.GONE);
        }


        textViews.setVisibility(View.GONE);
        checkBoxs.setVisibility(View.GONE);
        if(settingItem.getCheck()){
            textViews.setVisibility(View.VISIBLE);
            checkBoxs.setVisibility(View.VISIBLE);
        }else{
            textViews.setVisibility(View.GONE);
            checkBoxs.setVisibility(View.GONE);
        }


        checkBox.setChecked(settingItem.getCheck());

        titleView.setText(settingItem.getTitle());
        textView.setText(settingItem.getText());

        return row;

    }

    public long getItemId(int position){
        return 0;
    }

    public SettingItem getItem(int position){
        return mList.get(position);
    }

    public SettingAdapter(List<SettingItem> list, Context context){
        mList = list;
        mContext = context;
    }

}

