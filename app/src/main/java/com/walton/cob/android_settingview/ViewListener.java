package com.walton.cob.android_settingview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.walton.cob.settingviewlibrary.RadioView;

import java.util.Map;


/**
 * Created by 27758 on 2017/1/16.
 */

public class ViewListener implements View.OnClickListener{

    private Map<String, String> mMap;
    private RadioView mRadioView;
    private Activity mContext;


    public ViewListener(Activity context, Map<String, String> map, RadioView radioView) {
        mContext = context;
        mMap = map;
        mRadioView = radioView;
    }


    public void onClick(View v) {

        Intent intent = new Intent(mContext, mContext.getClass());
        Bundle bundle = new Bundle();

        SetTheme setTheme = new SetTheme(mRadioView);
        setTheme.execute(mMap);


        intent.putExtras(bundle);

        mContext.finish();
        mContext.startActivity(intent);


    }


}
