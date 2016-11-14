package com.walton.cob.android_settingview;

import com.walton.cob.settingviewlibrary.SettingItem;
import com.walton.cob.settingviewlibrary.SettingAdapter;
import com.walton.cob.settingviewlibrary.CheckListener;
import com.walton.cob.settingviewlibrary.RadioListener;
import com.walton.cob.settingviewlibrary.MultiChoiceListener;
import com.walton.cob.settingviewlibrary.ConfirmListener;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

//import poisondog.android.log.AndroidLogger;
//import poisondog.android.preference.LoadSharedPreferences;
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
//            System.out.println(key+":"+map.get(key));
//        }


        ListView lvSetting = (ListView) findViewById(R.id.lvSetting);
        List<SettingItem> list = new ArrayList<>();


        SettingAdapter settingAdapter = new SettingAdapter(list,this);


        SharedPreferences preferences = getSharedPreferences("myPreference", 0);
        SharedPreferences.Editor editor = preferences.edit();

        String key = "keyAccount";
        String value = "Account";
        SettingItem settingItem = new SettingItem(value);
        list.add(settingItem);
        editor.putString(key, value);
//        editor.commit();

        String key1 = "keyEmail";
        String value1 = "box02@walton.com.tw";
        SettingItem settingItem1 = new SettingItem("Email",value1);
        list.add(settingItem1);
        editor.putString(key1, value1);
//        editor.commit();

        String key2 = "keyDevice ID";
        String value2 = "WAS-14-0002";
        SettingItem settingItem2 = new SettingItem("Device ID",value2);
        list.add(settingItem2);
        editor.putString(key2, value2);
//        editor.commit();

        String key3 = "keyVersion";
        String value3 = "2.4.6";
        SettingItem settingItem3 = new SettingItem("Version",value3);
        list.add(settingItem3);
        editor.putString(key3, value3);
//        editor.commit();

        String key4 = "keyDate";
        String value4 = "2016-09-20 " + "09:11:20";
        SettingItem settingItem4 = new SettingItem("Date",value4);
        list.add(settingItem4);
        editor.putString(key4, value4);
//        editor.commit();


        SettingItem settingItemHidden = new SettingItem("Only Wi-Fi Upload","",false,false,false,false);
        //要加Listener的話加在這裡
        String key5 = "keyCamera";
        String value5 = "Camera";
        String key5s = "Status";
        String value5s = "Current Status:  ";
        String key5b = "Boolean";
        boolean value5b = false;
        SettingItem settingItem5 = new SettingItem(value5,value5s,value5b);
        CheckListener checkListener = new CheckListener(settingItemHidden,settingItem5,settingAdapter);
        settingItem5.setClickListener(checkListener);
        list.add(settingItem5);
        editor.putString(key5, value5);
        editor.putString(key5s, value5s);
        editor.putBoolean(key5b, value5b);
//        editor.commit();
        list.add(settingItemHidden);


        String key6 = "keyUsed";
        String value6 = "Used Disk Space\n";
        SettingItem settingItem6 = new SettingItem(value6);
        MultiChoiceListener radioListener1 = new MultiChoiceListener(MainActivity.this);
        settingItem6.setClickListener(radioListener1);
        list.add(settingItem6);
        editor.putString(key6, value6);
//        editor.commit();

        String key7 = "keyKeepDay";
        String value7 = "Keep Day";
        String key7s = "keyDefault";
        String value7s = "Default keep days";
        SettingItem settingItem7 = new SettingItem(value7,value7s);
        RadioListener radioListener = new RadioListener(MainActivity.this);
        settingItem7.setClickListener(radioListener);
        list.add(settingItem7);
        editor.putString(key7, value7);
        editor.putString(key7s, value7s);
//        editor.commit();

        String key8 = "keyLegal";
        String value8 = "Legal and Privacy\n";
        SettingItem settingItem8 = new SettingItem(value8);
        list.add(settingItem8);
        editor.putString(key8, value8);
//        editor.commit();

        String key9 = "keyErase";
        String value9 = "Erase";
        String key9s = "keyEraseAll";
        String value9s = "Erase all offline file";
        SettingItem settingItem9 = new SettingItem(value9,value9s);
        ConfirmListener confirmListener = new ConfirmListener(MainActivity.this,value9,value9s);
        settingItem9.setClickListener(confirmListener);
        list.add(settingItem9);
        editor.putString(key9, value9);
        editor.putString(key9s, value9s);
//        editor.commit();

        String key10 = "keySign out";
        String value10 = "Sing out\n";
        String key10s = "keyReady";
        String value10s = "Ready to logout?";
        SettingItem settingItem10 = new SettingItem(value10);
        ConfirmListener confirmListener1 = new ConfirmListener(MainActivity.this,value10,value10s);
        settingItem10.setClickListener(confirmListener1);
        list.add(settingItem10);
        editor.putString(key10, value10);
        editor.putString(key10s, value10s);
        editor.commit();



        lvSetting.setAdapter(settingAdapter);





//        System.out.println(preferences.getString(key, "Wrong"));
//        System.out.println(preferences.getString(key1,"Wrong1"));
//        System.out.println(preferences.getString(key2,"Wrong2"));
//        System.out.println(preferences.getString(key3,"Wrong3"));
//        System.out.println(preferences.getString(key4,"Wrong4"));
//        System.out.println(preferences.getString(key5,"Wrong5"));
//        System.out.println(preferences.getString(key5s,"Wrong5s"));
//        System.out.println(preferences.getBoolean(key5b,false));
//        System.out.println(preferences.getString(key6,"Wrong6"));
//        System.out.println(preferences.getString(key7,"Wrong7"));
//        System.out.println(preferences.getString(key7s,"Wrong7s"));
//        System.out.println(preferences.getString(key8,"Wrong8"));
//        System.out.println(preferences.getString(key9,"Wrong9"));
//        System.out.println(preferences.getString(key9s,"Wrong9s"));
//        System.out.println(preferences.getString(key10,"Wrong10"));
//        System.out.println(preferences.getString(key10s,"Wrong10s"));




    }



}

