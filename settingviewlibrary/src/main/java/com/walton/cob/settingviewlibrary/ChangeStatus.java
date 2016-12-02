package com.walton.cob.settingviewlibrary;

import java.util.Map;

import poisondog.android.preference.SaveSharedPreferences;
import poisondog.core.Mission;


public class ChangeStatus implements Mission<Void> {
    private SettingItem mSettingItem;
    private SettingItem mSettingItemHidden;
    private SaveSharedPreferences mSaveSharedPreferences;
    private Map<String, String> mMap;

    public ChangeStatus(SettingItem item, SettingItem hidden,SaveSharedPreferences save,Map<String, String> map) {
        mSettingItem = item;
        mSettingItemHidden = hidden;
        mSaveSharedPreferences = save;
        mMap = map;
    }

    @Override
    public Void execute(Void none) {
        if(mSettingItem.getCheck()){
            mSettingItem.setText(mSettingItem.getText().substring(0,16)+"Open");
            mSettingItemHidden.setTitleVisibility(true);
            mSettingItemHidden.setTextVisibility(false);
            mSettingItemHidden.setCheckVisibility(true);

            mMap.put("keyStatus",mSettingItem.getText());
            mSaveSharedPreferences.execute(mMap);

        }else{
            mSettingItem.setText(mSettingItem.getText().substring(0,16)+"Close");
            mSettingItemHidden.setTitleVisibility(false);
            mSettingItemHidden.setTextVisibility(false);
            mSettingItemHidden.setCheckVisibility(false);

            mMap.put("keyStatus",mSettingItem.getText());
            mSaveSharedPreferences.execute(mMap);

        }
        return null;
    }
}
