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
package com.walton.cob.android_settingview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.walton.cob.settingviewlibrary.RadioView;
import java.util.Map;



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
