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
import com.walton.cob.settingviewlibrary.DialogAdapter;
import com.walton.cob.settingviewlibrary.DialogItem;
import com.walton.cob.settingviewlibrary.NoClickListener;
import com.walton.cob.settingviewlibrary.ShowAnotherItem;
import com.walton.cob.settingviewlibrary.UpdateText;
import com.walton.cob.settingviewlibrary.YesClickListener;
import com.walton.cob.settingviewlibrary.SettingItem;
import com.walton.cob.settingviewlibrary.SettingAdapter;
import com.walton.cob.settingviewlibrary.CheckListener;
import com.walton.cob.settingviewlibrary.RadioListener;
import com.walton.cob.settingviewlibrary.MultiChoiceListener;
import com.walton.cob.settingviewlibrary.ConfirmListener;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.apache.regexp.REDebugCompiler;

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
        input.put("keyUsed","Used Disk Space");
        input.put("keyDefault","Default keep days");
        input.put("keyLegal","Legal and Privacy");
        input.put("keyInvite","Invite Code Manage");
        input.put("keyEraseAll","Erase all offline file");
        input.put("keyLogout","Ready to logout?");
        input.put("keyRadio",Integer.toString(-1));




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





        SettingItem settingItem = new SettingItem("ACCOUNT");
        settingItem.setTitleSize(25);
        settingItem.setPadding(10,10,10,10);
        list.add(settingItem);


        SettingItem settingItem1 = new SettingItem("Email",map.get("keyEmail"));
        list.add(settingItem1);


        SettingItem settingItem2 = new SettingItem("Device ID",map.get("keyDevice ID"));
        list.add(settingItem2);


        SettingItem settingItem3 = new SettingItem("Version",map.get("keyVersion"));
        list.add(settingItem3);


        SettingItem settingItem4 = new SettingItem("Date",map.get("keyDate"));
        list.add(settingItem4);


        SettingItem settingItem5 = new SettingItem("SETTING");
        settingItem5.setTitleSize(25);
        settingItem5.setPadding(10,10,10,10);
        list.add(settingItem5);


        SettingItem settingItemHidden = new SettingItem("Only Wi-Fi Upload","",Boolean.parseBoolean(map.get("BooleanHidden")),false,false,false);
        SettingItem settingItem6 = new SettingItem("Camera",map.get("keyStatus"),Boolean.parseBoolean(map.get("Boolean")));
        CheckListener checkListener = new CheckListener(settingItem6,settingAdapter,saveSharedPreferences,map);
        settingItem6.setClickListener(checkListener);
        Mission<SettingItem> mission = new ShowAnotherItem(settingItemHidden);
        Mission<SettingItem> mission1 = new UpdateText(settingItem6.getText().substring(0,16)+"Open",settingItem6.getText().substring(0,16)+"Close");
        checkListener.setMission(mission,mission1);

        try {
            mission.execute(settingItem6);
        }catch (Exception e){
            e.printStackTrace();
        }

//        Mission<Void> mission = new ChangeStatus(settingItem6,settingItemHidden,saveSharedPreferences,map);
//        try{
//            mission.execute(null);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//        checkListener.setMission(mission);

        CheckHiddenListener checkHiddenListener = new CheckHiddenListener(settingItemHidden,settingAdapter,saveSharedPreferences,map);
        settingItemHidden.setClickListener(checkHiddenListener);

        list.add(settingItem6);
        list.add(settingItemHidden);


        SettingItem settingItem7 = new SettingItem(map.get("keyUsed"));
        list.add(settingItem7);


        SettingItem settingItem8 = new SettingItem("Keep Day",map.get("keyDefault"));
        String[] items = new String[]{"5 Days","10 Days","20 Days","30 Days"};
        RadioListener radioListener = new RadioListener(MainActivity.this,saveSharedPreferences,map,R.style.AlertDialog,"Keep Day",items);
        settingItem8.setClickListener(radioListener);
        list.add(settingItem8);


        SettingItem settingItem9 = new SettingItem(map.get("keyLegal"));
        list.add(settingItem9);


        /* Invite Code Manage*/
        List<DialogItem> listDialog = new ArrayList<>();

        DialogItem dialogItem = new DialogItem("Title1","Text1","X1");
        listDialog.add(dialogItem);

        DialogItem dialogItem1 = new DialogItem("Title2","Text2","X2");
        listDialog.add(dialogItem1);

        DialogItem dialogItem2 = new DialogItem("Title3","Text3","X3");
        listDialog.add(dialogItem2);

        SettingItem settingItem10 = new SettingItem(map.get("keyInvite"));
        final MultiChoiceListener multiChoiceListener = new MultiChoiceListener(MainActivity.this,R.style.AlertDialog);
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


        SettingItem settingItem11 = new SettingItem("Erase",map.get("keyEraseAll"));
        ConfirmListener confirmListener = new ConfirmListener(MainActivity.this,"Erase",map.get("keyEraseAll"),R.style.AlertDialog);
        YesClickListener yesClickListener = new YesClickListener();
        confirmListener.setYesListener(yesClickListener);
        NoClickListener noClickListener = new NoClickListener();
        confirmListener.setNoListener(noClickListener);
        settingItem11.setClickListener(confirmListener);
        list.add(settingItem11);


        SettingItem settingItem12 = new SettingItem("Sing out");
        ConfirmListener confirmListener1 = new ConfirmListener(MainActivity.this,"Sing out",map.get("keyLogout"),R.style.AlertDialog);
        YesClickListener yesClickListener1 = new YesClickListener();
        confirmListener1.setYesListener(yesClickListener1);
        NoClickListener noClickListener1 = new NoClickListener();
        confirmListener1.setNoListener(noClickListener1);
        settingItem12.setClickListener(confirmListener1);
        list.add(settingItem12);



        lvSetting.setAdapter(settingAdapter);





        System.out.println(Integer.parseInt(map.get("keyRadio")));


    }


}

