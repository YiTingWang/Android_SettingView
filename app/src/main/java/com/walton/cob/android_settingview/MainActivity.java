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

import com.walton.cob.settingviewlibrary.ChangeStatus;
import com.walton.cob.settingviewlibrary.CheckHiddenListener;
import com.walton.cob.settingviewlibrary.NoClickListener;
import com.walton.cob.settingviewlibrary.YesClickListener;
import com.walton.cob.settingviewlibrary.SettingItem;
import com.walton.cob.settingviewlibrary.SettingAdapter;
import com.walton.cob.settingviewlibrary.CheckListener;
import com.walton.cob.settingviewlibrary.RadioListener;
import com.walton.cob.settingviewlibrary.MultiChoiceListener;
import com.walton.cob.settingviewlibrary.ConfirmListener;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import poisondog.core.Mission;
import poisondog.android.preference.SaveSharedPreferences;
import poisondog.android.preference.LoadSharedPreferences;
//import poisondog.log.LogLevel;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        AndroidLogger.setDefaultLogLevel(LogLevel.TRACE);
//        LoadSharedPreferences loadSharedPreferences = new LoadSharedPreferences(this,"myPreference");
//        Map<String,String> map = loadSharedPreferences.execute("");
//        for(String key:map.keySet()){
//
//            System.out.println(key+":"+map.get(key));
//        }



        ListView lvSetting = (ListView) findViewById(R.id.lvSetting);
        List<SettingItem> list = new ArrayList<>();

        SettingAdapter settingAdapter = new SettingAdapter(list,this);



        Map<String, String> input = new HashMap<String,String>();

        input.put("keyEmail","box02@walton.com.tw");
        input.put("keyDevice ID","WAS-14-0002");
        input.put("keyVersion","2.4.6");
        input.put("keyDate","2016-09-20 " + "09:11:20");
        input.put("keyStatus","Current Status:  ");
        input.put("Boolean",Boolean.toString(false));
        input.put("BooleanHidden",Boolean.toString(false));
        input.put("keyUsed","Used Disk Space\n");
        input.put("keyDefault","Default keep days");
        input.put("keyLegal","Legal and Privacy\n");
        input.put("keyInvite","Invite Code Manage\n");
        input.put("keyEraseAll","Erase all offline file");
        input.put("keyLogout","Ready to logout?");



        LoadSharedPreferences loadSharedPreferences = new LoadSharedPreferences(this,"temp");
        Map<String, String> map = loadSharedPreferences.execute("");

//        for (String key : input.keySet()) {
//            if(map.get(key) == null) {
//                map.put(key,input.get(key));
//            }
//        }

        if(map.isEmpty()){
            map = input;
        }

        SaveSharedPreferences saveSharedPreferences = new SaveSharedPreferences(this,"temp");
        //saveSharedPreferences.execute(input);





        SettingItem settingItem = new SettingItem("Account");
        list.add(settingItem);


        SettingItem settingItem1 = new SettingItem("Email",map.get("keyEmail"));
        list.add(settingItem1);


        SettingItem settingItem2 = new SettingItem("Device ID",map.get("keyDevice ID"));
        list.add(settingItem2);


        SettingItem settingItem3 = new SettingItem("Version",map.get("keyVersion"));
        list.add(settingItem3);


        SettingItem settingItem4 = new SettingItem("Date",map.get("keyDate"));
        list.add(settingItem4);


        SettingItem settingItemHidden = new SettingItem("Only Wi-Fi Upload","",Boolean.parseBoolean(map.get("BooleanHidden")),false,false,false);
        boolean b = Boolean.parseBoolean(map.get("Boolean"));
        SettingItem settingItem5 = new SettingItem("Camera",map.get("keyStatus"),b);
        System.out.println("map : " + map.get("Boolean"));
        System.out.println("checkbox : " + b);
        CheckListener checkListener = new CheckListener(settingItem5,settingAdapter,saveSharedPreferences,map);
        settingItem5.setClickListener(checkListener);
        Mission<Void> mission = new ChangeStatus(settingItem5,settingItemHidden,saveSharedPreferences,map);
        try{
            mission.execute(null);
        }catch (Exception e) {
            e.printStackTrace();
        }
        checkListener.setMission(mission);
        CheckHiddenListener checksListener = new CheckHiddenListener(settingItemHidden,settingAdapter,saveSharedPreferences,map);
        settingItemHidden.setClickListener(checksListener);
        list.add(settingItem5);
        list.add(settingItemHidden);


        SettingItem settingItem6 = new SettingItem(map.get("keyUsed"));
        list.add(settingItem6);


        SettingItem settingItem7 = new SettingItem("Keep Day",map.get("keyDefault"));
        RadioListener radioListener = new RadioListener(MainActivity.this);
        settingItem7.setClickListener(radioListener);
        list.add(settingItem7);


        SettingItem settingItem8 = new SettingItem(map.get("keyLegal"));
        list.add(settingItem8);


        SettingItem settingItem9 = new SettingItem(map.get("keyInvite"));
        MultiChoiceListener multiChoiceListener = new MultiChoiceListener(MainActivity.this);
        settingItem9.setClickListener(multiChoiceListener);
        list.add(settingItem9);


        SettingItem settingItem10 = new SettingItem("Erase",map.get("keyEraseAll"));
        ConfirmListener confirmListener = new ConfirmListener(MainActivity.this,"Erase",map.get("keyEraseAll"));
        YesClickListener yesClickListener = new YesClickListener();
        confirmListener.setYesListener(yesClickListener);
        NoClickListener noClickListener = new NoClickListener();
        confirmListener.setNoListener(noClickListener);
        settingItem10.setClickListener(confirmListener);
        list.add(settingItem10);


        SettingItem settingItem11 = new SettingItem("Sing out\n");
        ConfirmListener confirmListener1 = new ConfirmListener(MainActivity.this,"Sing out\n",map.get("keyLogout"));
        YesClickListener yesClickListener1 = new YesClickListener();
        confirmListener1.setYesListener(yesClickListener1);
        NoClickListener noClickListener1 = new NoClickListener();
        confirmListener1.setNoListener(noClickListener1);
        settingItem11.setClickListener(confirmListener1);
        list.add(settingItem11);





        lvSetting.setAdapter(settingAdapter);

    }


}

