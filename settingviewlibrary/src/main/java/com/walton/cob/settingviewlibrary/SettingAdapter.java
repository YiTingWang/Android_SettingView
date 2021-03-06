/*
 * Copyright (C) 2016 Yi-Ting Wang <ig95233259@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.walton.cob.settingviewlibrary;

import android.content.Context;
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


        if(settingItem.getTitleVisibility() == false && settingItem.getTextVisibility() == false && settingItem.getCheckVisibility() == false){
            settingItem.setPadding(0,0,0,0);
        }else if(settingItem.getCheckVisibility() == true){
            settingItem.setPadding(50,20,20,20);
        }


        checkBox.setChecked(settingItem.getCheck());

        titleView.setText(settingItem.getTitle());
        titleView.setTextSize(settingItem.getTitleSize());
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
