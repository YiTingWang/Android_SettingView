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

import com.walton.cob.settingviewlibrary.DialogAdapter;
import com.walton.cob.settingviewlibrary.DialogItem;
import com.walton.cob.settingviewlibrary.NoClickListener;
import com.walton.cob.settingviewlibrary.ShowAnotherItem;
import com.walton.cob.settingviewlibrary.RadioListener;
import com.walton.cob.settingviewlibrary.UpdateText;
import com.walton.cob.settingviewlibrary.YesClickListener;
import com.walton.cob.settingviewlibrary.SettingItem;
import com.walton.cob.settingviewlibrary.SettingAdapter;
import com.walton.cob.settingviewlibrary.MultiChoiceListener;
import com.walton.cob.settingviewlibrary.ConfirmListener;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import poisondog.core.Mission;
import poisondog.android.preference.SaveSharedPreferences;
import poisondog.android.preference.LoadSharedPreferences;



public class MainActivity extends AppCompatActivity {

    private Map<String, String> mMap;
    private SaveSharedPreferences mSavaSharePreference;

    private RadioListener mRadioListener;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        load();

        setTheme(Integer.parseInt(mMap.get("keyTheme")));
        RadioListener.setColor(Integer.parseInt(mMap.get("keyDialog")));
        MultiChoiceListener.setColor(Integer.parseInt(mMap.get("keyDialog")));
        ConfirmListener.setColor(Integer.parseInt(mMap.get("keyDialog")));

        setContentView(R.layout.activity_main);



        ListView lvSetting = (ListView) findViewById(R.id.lvSetting);
        List<SettingItem> list = new ArrayList<>();
        final SettingAdapter settingAdapter = new SettingAdapter(list,this);



        final SaveSharedPreferences saveSharedPreferences = new SaveSharedPreferences(this,"temp");
        mSavaSharePreference = saveSharedPreferences;
//        saveSharedPreferences.execute(input);



        SettingItem settingItem = new SettingItem("ACCOUNT");
        settingItem.setTitleSize(25);
        settingItem.setPadding(10,10,10,10);
        list.add(settingItem);


        SettingItem settingItem1 = new SettingItem("Email",mMap.get("keyEmail"));
        list.add(settingItem1);


        SettingItem settingItem2 = new SettingItem("Device ID",mMap.get("keyDevice ID"));
        list.add(settingItem2);


        SettingItem settingItem3 = new SettingItem("Version",mMap.get("keyVersion"));
        list.add(settingItem3);


        SettingItem settingItem4 = new SettingItem("Date",mMap.get("keyDate"));
        list.add(settingItem4);


        SettingItem settingItem5 = new SettingItem("SETTING");
        settingItem5.setTitleSize(25);
        settingItem5.setPadding(10,10,10,10);
        list.add(settingItem5);


        final SettingItem settingItemHidden = new SettingItem("Only Wi-Fi Upload","",Boolean.parseBoolean(mMap.get("BooleanHidden")),false,false,false);
        final SettingItem settingItem6 = new SettingItem("Camera",mMap.get("keyStatus"),Boolean.parseBoolean(mMap.get("Boolean")));
        final Mission<SettingItem> mission = new ShowAnotherItem(settingItemHidden);
        final Mission<SettingItem> mission1 = new UpdateText(settingItem6.getText().substring(0,16)+"Open",settingItem6.getText().substring(0,16)+"Close");
        try {
            mission.execute(settingItem6);
        }catch (Exception e){
            e.printStackTrace();
        }
        settingItem6.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingItem6.setCheck(!settingItem6.getCheck());

                mMap.put("Boolean",Boolean.toString(settingItem6.getCheck()));

                try{
                    mission.execute(settingItem6);
                    mission1.execute(settingItem6);
                }catch (Exception e) {
                    e.printStackTrace();
                }

                mMap.put("keyStatus",settingItem6.getText());

                settingAdapter.notifyDataSetChanged();
            }
        });
        settingItemHidden.setClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingItemHidden.setCheck(!settingItemHidden.getCheck());

                mMap.put("BooleanHidden",Boolean.toString(settingItemHidden.getCheck()));

                settingAdapter.notifyDataSetChanged();
            }
        });
        list.add(settingItem6);
        list.add(settingItemHidden);


        SettingItem settingItem7 = new SettingItem(mMap.get("keyUsed"));
        list.add(settingItem7);


        List<String> listDialogText = new ArrayList<>();
        listDialogText.add("Dark Gray");
        listDialogText.add("Pink");
        listDialogText.add("Purple");
        listDialogText.add("Green");

        SettingItem settingItem8 = new SettingItem("Keep Day",mMap.get("keyDefault"));

        final RadioListener radioListener = new RadioListener(MainActivity.this,"Keep Day",listDialogText);
	    radioListener.setIndex(Integer.parseInt(mMap.get("keyRadio")));

        View.OnClickListener listener = new ViewListener(MainActivity.this,mMap,radioListener.getRadioView());

        radioListener.setViewClickListener(listener);

        mRadioListener = radioListener;

        radioListener.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        radioListener.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        radioListener.setNeutralButton("其他", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        settingItem8.setClickListener(radioListener);
        list.add(settingItem8);


        SettingItem settingItem9 = new SettingItem(mMap.get("keyLegal"));
        list.add(settingItem9);


        final List<DialogItem> listDialog = new ArrayList<>();

        final DialogItem dialogItem = new DialogItem("Title1","Text1","X1");
        listDialog.add(dialogItem);

        DialogItem dialogItem1 = new DialogItem("Title2","Text2","X2");
        listDialog.add(dialogItem1);

        DialogItem dialogItem2 = new DialogItem("Title3","Text3","X3");
        listDialog.add(dialogItem2);

        final SettingItem settingItem10 = new SettingItem(mMap.get("keyInvite"));
        final MultiChoiceListener multiChoiceListener = new MultiChoiceListener(MainActivity.this);
        multiChoiceListener.setAdapter(new DialogAdapter(listDialog,MainActivity.this));
        multiChoiceListener.setClickListener(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        multiChoiceListener.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        multiChoiceListener.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        multiChoiceListener.setNeutralButton("Invite", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        settingItem10.setClickListener(multiChoiceListener);
        list.add(settingItem10);


        SettingItem settingItem11 = new SettingItem("Erase",mMap.get("keyEraseAll"));
        ConfirmListener confirmListener = new ConfirmListener(MainActivity.this,"Erase",mMap.get("keyEraseAll"));
        YesClickListener yesClickListener = new YesClickListener();
        confirmListener.setYesListener(yesClickListener);
        NoClickListener noClickListener = new NoClickListener();
        confirmListener.setNoListener(noClickListener);
        settingItem11.setClickListener(confirmListener);
        list.add(settingItem11);


        SettingItem settingItem12 = new SettingItem("Sing out");
        ConfirmListener confirmListener1 = new ConfirmListener(MainActivity.this,"Sing out",mMap.get("keyLogout"));
        YesClickListener yesClickListener1 = new YesClickListener();
        confirmListener1.setYesListener(yesClickListener1);
        NoClickListener noClickListener1 = new NoClickListener();
        confirmListener1.setNoListener(noClickListener1);
        settingItem12.setClickListener(confirmListener1);
        list.add(settingItem12);



        lvSetting.setAdapter(settingAdapter);


    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSavaSharePreference.execute(mMap);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mRadioListener.getAlertDialog() != null){
            mRadioListener.getAlertDialog().dismiss();
        }
    }

    public void load() {

        Map<String, String> input = new HashMap<String,String>();

        input.put("keyEmail","box02@walton.com.tw");
        input.put("keyDevice ID","WAS-14-0002");
        input.put("keyVersion","2.4.6");
        input.put("keyDate","2016-09-20 " + "09:11:20");
        input.put("keyStatus","Current Status:  ");
        input.put("Boolean",Boolean.toString(false));
        input.put("BooleanHidden",Boolean.toString(false));
        input.put("keyUsed","Used Disk Space");
        input.put("keyDefault","Default keep days");
        input.put("keyLegal","Legal and Privacy");
        input.put("keyInvite","Invite Code Manage");
        input.put("keyEraseAll","Erase all offline file");
        input.put("keyLogout","Ready to logout?");
        input.put("keyRadio",Integer.toString(-1));
        input.put("keyTheme",Integer.toString(R.style.AppTheme));
        input.put("keyDialog",Integer.toString(R.style.AlertDialog));

        LoadSharedPreferences loadSharedPreferences = new LoadSharedPreferences(this,"temp");
        Map<String, String> map = loadSharedPreferences.execute("");

        for (String key : map.keySet()) {
		input.put(key, map.get(key));
        }
        mMap = input;
    }

}


