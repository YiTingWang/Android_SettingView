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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.List;



public class DialogAdapter extends BaseAdapter {

    private List<DialogItem> mDialogList;
    private Context mContext;
    private RadioButton mRadioButton;
    private RadioGroup mRadioGroup;


    @Override
    public int getCount() {
        return mDialogList.size();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        DialogItem dialogItem = mDialogList.get(position);

        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_item,parent,false);

        TextView dialogTitleView = (TextView) dialogView.findViewById(R.id.tvDialogTitle);
        TextView dialogTextView = (TextView) dialogView.findViewById(R.id.tvDialogText);
        TextView dialogOtherView = (TextView) dialogView.findViewById(R.id.tvDialogOther);
        CheckBox dialogCheckBox = (CheckBox) dialogView.findViewById(R.id.DialogCheckbox);
        RadioButton dialogRadioButton = (RadioButton) dialogView.findViewById(R.id.DialogRadioButton);


        dialogView.setOnClickListener(dialogItem.getClickListener());
        dialogCheckBox.setOnClickListener(dialogItem.getClickListener());


        dialogTitleView.setText(dialogItem.getDialogTitle());
        dialogTextView.setText(dialogItem.getDialogText());
        dialogOtherView.setText(dialogItem.getDialogOther());
        dialogRadioButton.setText(dialogItem.getItems());

        dialogCheckBox.setChecked(dialogItem.getDialogCheck());

        dialogView.setBackgroundColor(dialogItem.getBackgroundColor());
        dialogTitleView.setTextColor(dialogItem.getTitleColor());
        dialogTextView.setTextColor(dialogItem.getTextColor());
        dialogOtherView.setTextColor(dialogItem.getOtherColor());
        dialogRadioButton.setTextColor(dialogItem.getRadioTextColor());



        if(dialogItem.getRadioButtonVisibility()){
            dialogTitleView.setVisibility(View.GONE);
            dialogTextView.setVisibility(View.GONE);
            dialogOtherView.setVisibility(View.GONE);
            dialogCheckBox.setVisibility(View.GONE);
            dialogRadioButton.setVisibility(View.VISIBLE);
        }else{
            dialogRadioButton.setVisibility(View.GONE);
        }


        if(dialogItem.getTextViewVisibility()){
            dialogRadioButton.setVisibility(View.GONE);
        }else{
            dialogTitleView.setVisibility(View.GONE);
            dialogTextView.setVisibility(View.GONE);
            dialogOtherView.setVisibility(View.GONE);
        }


        return dialogView;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public DialogItem getItem(int position) {
        return mDialogList.get(position);
    }

    public DialogAdapter(List<DialogItem> list, Context context) {
        mDialogList = list;
        mContext = context;
        mRadioGroup = new RadioGroup(mContext);
    }

}
