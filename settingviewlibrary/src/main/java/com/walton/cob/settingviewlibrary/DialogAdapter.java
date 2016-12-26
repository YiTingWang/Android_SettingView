package com.walton.cob.settingviewlibrary;

import android.content.Context;
import android.graphics.Color;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;


public class DialogAdapter extends BaseAdapter {

    private SettingAdapter mAdapter;
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
        RelativeLayout dialogRelativeLayout = (RelativeLayout) dialogView.findViewById(R.id.rl);


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



//        RadioGroup radioGroup = new RadioGroup(mContext);
//        dialogRelativeLayout.addView(radioGroup);
//        RadioButton radioButton1 = new RadioButton(mContext);
//        radioButton1.setText(dialogItem.getItems());
//        radioGroup.addView(radioButton1);



        if(dialogItem.getRadioButtonVisibility()){
            dialogTitleView.setVisibility(View.GONE);
            dialogTextView.setVisibility(View.GONE);
            dialogOtherView.setVisibility(View.GONE);
            dialogCheckBox.setVisibility(View.GONE);
            dialogRadioButton.setVisibility(View.VISIBLE);

            //mRadioButton = new RadioButton(mContext);
//            dialogRadioButton.setText(dialogItem.getItems());
//            ((ViewGroup)dialogRadioButton.getParent()).removeView(dialogRadioButton);
//            mRadioGroup.addView(dialogRadioButton);
//            if(mRadioGroup.getParent() != null){
//                ((ViewGroup)mRadioGroup.getParent()).removeView(mRadioGroup);
//            }
//
//            parent.addView(mRadioGroup);






//            RadioGroup radioGroup = new RadioGroup(mContext);
//            radioGroup.setOrientation(RadioGroup.VERTICAL);
//            //RelativeLayout.LayoutParams a = new RelativeLayout.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
//            //radioGroup.setLayoutParams(a);
//            dialogRelativeLayout.addView(radioGroup);
//            RadioButton radioButton1 = new RadioButton(mContext);
//            radioButton1.setText(dialogItem.getItems());
//            radioGroup.addView(radioButton1);
//            //radioGroup.removeView(dialogRelativeLayout);
//            //dialogRelativeLayout.addView(radioGroup);
//            //radioGroup.addView(dialogRadioButton);
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
