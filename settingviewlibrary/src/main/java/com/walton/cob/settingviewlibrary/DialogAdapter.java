package com.walton.cob.settingviewlibrary;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;


public class DialogAdapter extends BaseAdapter {

    private SettingAdapter mAdapter;
    private List<DialogItem> mDialogList;
    private Context mContext;


    @Override
    public int getCount() {
        return mDialogList.size();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        DialogItem dialogItem = mDialogList.get(position);

        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View dialogView = inflater.inflate(R.layout.dialog_item,viewGroup,false);

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

        dialogCheckBox.setChecked(dialogItem.getDialogCheck());

        dialogView.setBackgroundColor(dialogItem.getBackgroundColor());
        dialogTitleView.setTextColor(dialogItem.getTitleColor());
        dialogTextView.setTextColor(dialogItem.getTextColor());
        dialogOtherView.setTextColor(dialogItem.getOtherColor());


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
    }


}
