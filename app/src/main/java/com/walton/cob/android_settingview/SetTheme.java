package com.walton.cob.android_settingview;

import com.walton.cob.settingviewlibrary.RadioView;
import java.util.Map;
import poisondog.core.Mission;

/**
 * Created by 27758 on 2017/1/19.
 */

public class SetTheme implements Mission<Map<String,String>>{

    private RadioView mRadioView;

    public SetTheme(RadioView radioView) {
        mRadioView = radioView;
    }

    @Override
    public Map<String, String> execute(Map<String,String> map) {
        System.out.println("RadioView : " + mRadioView.getIndex());
        if(mRadioView.getIndex() == 0){
            map.put("keyTheme",Integer.toString(R.style.AppTheme));
            map.put("keyDialog",Integer.toString(R.style.AlertDialog));
        }else if(mRadioView.getIndex() == 1){
            map.put("keyTheme",Integer.toString(R.style.AppTheme2));
            map.put("keyDialog",Integer.toString(R.style.AlertDialog2));
        }else if(mRadioView.getIndex() == 2){
            map.put("keyTheme",Integer.toString(R.style.AppTheme3));
            map.put("keyDialog",Integer.toString(R.style.AlertDialog3));
        }else if(mRadioView.getIndex() == 3){
            map.put("keyTheme",Integer.toString(R.style.AppTheme4));
            map.put("keyDialog",Integer.toString(R.style.AlertDialog4));
        }else {
            map.put("keyTheme",Integer.toString(R.style.AppTheme));
            map.put("keyDialog",Integer.toString(R.style.AlertDialog));
        }

        map.put("keyRadio",Integer.toString(mRadioView.getIndex()));

        return map;
    }

}
