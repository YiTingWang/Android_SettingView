package com.walton.cob.settingviewlibrary;

import poisondog.core.Mission;

/**
 * Created by 27758 on 2016/11/14.
 */
public class ChangeStatus implements Mission<Void> {
    private SettingItem mSettingItem;
    private SettingItem mSettingItemHidden;

    public ChangeStatus(SettingItem item, SettingItem hidden) {
        mSettingItem = item;
        mSettingItemHidden = hidden;
    }

    @Override
    public Void execute(Void none) {
        if(mSettingItem.getCheck()){
            mSettingItem.setText(mSettingItem.getText().substring(0,16)+"Open");
            mSettingItemHidden.setTitleVisibility(true);
            mSettingItemHidden.setTextVisibility(false);
            mSettingItemHidden.setCheckVisibility(true);

            System.out.println(mSettingItem.getText());
        }else{
            mSettingItem.setText(mSettingItem.getText().substring(0,16)+"Close");
            mSettingItemHidden.setTitleVisibility(false);
            mSettingItemHidden.setTextVisibility(false);
            mSettingItemHidden.setCheckVisibility(false);

            System.out.println(mSettingItem.getText());
        }
        return null;
    }
}

