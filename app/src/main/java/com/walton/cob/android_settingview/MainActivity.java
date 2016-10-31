package com.walton.cob.android_settingview;

import com.walton.cob.settingviewlibrary.SettingItem;
import com.walton.cob.settingviewlibrary.SettingAdapter;
import com.walton.cob.settingviewlibrary.CheckListener;
import com.walton.cob.settingviewlibrary.RadioListener;
import com.walton.cob.settingviewlibrary.ConfirmListener;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceConfigurationError;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView lvSetting = (ListView) findViewById(R.id.lvSetting);
        List<SettingItem> list = new ArrayList<>();

        SettingAdapter settingAdapter = new SettingAdapter(list,this);

        SettingItem settingItem = new SettingItem("Account");
        list.add(settingItem);

        SettingItem settingItem1 = new SettingItem("Email","box02@walton.com.tw");
        list.add(settingItem1);

        SettingItem settingItem2 = new SettingItem("Device ID","WAS-14-0002");
        list.add(settingItem2);

        SettingItem settingItem3 = new SettingItem("Version","2.4.6");
        list.add(settingItem3);

        SettingItem settingItem4 = new SettingItem("Date","2016-09-20 " + "09:11:20");
        list.add(settingItem4);

        SettingItem settingItem5 = new SettingItem("Camera","Current Status: ",false);
        CheckListener checkListener = new CheckListener(settingItem5,settingAdapter);
        settingItem5.setClickListener(checkListener);
        list.add(settingItem5);

        SettingItem settingItem6 = new SettingItem("Used Disk Space\n");
        RadioListener radioListener1 = new RadioListener(MainActivity.this,1);
        settingItem6.setClickListener(radioListener1);
        list.add(settingItem6);

        SettingItem settingItem7 = new SettingItem("Keep Day","Default keep days");
        RadioListener radioListener = new RadioListener(MainActivity.this,0);
        settingItem7.setClickListener(radioListener);
        list.add(settingItem7);

        SettingItem settingItem8 = new SettingItem("Legal and Privacy\n");
        list.add(settingItem8);

        SettingItem settingItem9 = new SettingItem("Erase","Erase all offline file");
        ConfirmListener confirmListener = new ConfirmListener(MainActivity.this,"Erase","Erase all offline file");
        settingItem9.setClickListener(confirmListener);
        list.add(settingItem9);

        SettingItem settingItem10 = new SettingItem("Sing out\n");
        ConfirmListener confirmListener1 = new ConfirmListener(MainActivity.this,"Sign out","Ready to logout?");
        settingItem10.setClickListener(confirmListener1);
        list.add(settingItem10);


        lvSetting.setAdapter(settingAdapter);

    }

}

