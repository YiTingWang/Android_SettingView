package com.walton.cob.settingviewlibrary;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;


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
        checkBox.setOnClickListener(settingItem.getClickListener());
        checkBoxs.setOnClickListener(settingItem.getClickListener());



        if(settingItem.getTitleVisibility()){
            titleView.setVisibility(View.VISIBLE);
        }else{
            titleView.setVisibility(View.GONE);
        }
        if(settingItem.getTextVisibility()){
            textView.setVisibility(View.VISIBLE);
        }else{
            textView.setVisibility(View.GONE);
        }
        if(settingItem.getCheckVisibility()){
            checkBox.setVisibility(View.VISIBLE);
        }else{
            checkBox.setVisibility(View.GONE);
        }


//        if(settingItem.getTitleVisibility() == false && settingItem.getTextVisibility() == false && settingItem.getCheckVisibility() == false){
//            row.setVisibility(View.GONE);
//        }else{
//            row.setVisibility(View.VISIBLE);
//        }



        checkBox.setChecked(settingItem.getCheck());

        titleView.setText(settingItem.getTitle());
        titleView.setTextSize(settingItem.getTextSize());
        //titleView.setTypeface(Typeface.DEFAULT,Typeface.BOLD);
        //titleView.setTextColor(Color.RED);
        textView.setText(settingItem.getText());

        row.setPadding(settingItem.getPaddingLeft(),settingItem.getPaddingTop(),settingItem.getPaddingRight(),settingItem.getPaddingBottom());

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
