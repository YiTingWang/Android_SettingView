# Android_SettingView

Android_SettingView is a Android library for building and presenting in app settings. It provides a manager to store and retrieve data,and provides some listeners to controll action of view and supports the phones and tablets which using Android System.

## Features

- [x] Android Settings app look & feel
- [x] Easy to use store and retrieve

## Requirements

- Android Studio 2.2.3 (suggestion for you)
- Android Version 6.0.1 (phones and tablets compatible)
- Java Version "1.8.0_101"

## Set Cells and the tables

- Create a Section Map
- Put in different contents for starting the app when the map is empty

```java

//...

Map<String, String> input = new HashMap<Strtring,String>();

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

//...

```

- Design an Adapter for the ListView

```java

public class SettingAdapter extends BaseAdapter{

//...

    public View getView(int position, View convertView, ViewGroup parent){

        SettingItem settingItem = mList.get(position);

        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list_item,parent,false);
        TextView titleView = (TextView) row.findViewById(R.id.tvTitle);
        TextView textView = (TextView) row.findViewById(R.id.tvText);
        CheckBox checkBox = (CheckBox) row.findViewById(R.id.checkbox);
        TextView textViews = (TextView) row.findViewById(R.id.tvTexts);
        CheckBox checkBoxs = (CheckBox) row.findViewById(R.id.checkboxs);
        row.setOnClickListener(settingItem.getClickListener());
        checkBox.setOnClickListener(settingItem.getClickListener());
        checkBoxs.setOnClickListener(settingItem.getClickListener());

//...

```

```java

//...

 ListView lvSetting = (ListView) findViewById(R.id.lvSetting);
        List<SettingItem> list = new ArrayList<>();
        final SettingAdapter settingAdapter = new SettingAdapter(list,this);
        
//...

//...

lvSetting.setAdapter(settingAdapter);

//...

```

- Use the SettingItem to new the item into the list

```java

//...

public class SettingItem {

    private String mTitle;
    private String mText;
    private boolean mCheck;
    private boolean mShowTitle;
    private boolean mShowText;
    private boolean mShowCheck;
    private View.OnClickListener mListener;
    private float mTitleSize;
    private int mLeft;
    private int mTop;
    private int mRight;
    private int mBottom;

    public SettingItem(){
        this("","",false,false,false,false);
    }

    public SettingItem(String title){
        this(title,"",false,true,false,false);
    }

    public SettingItem(String title, String text){
        this(title,text,false,true,true,false);
    }

    public SettingItem(String title, String text, boolean check){
        this(title, text, check, true, true, true);
    }

    public SettingItem(String title, String text, boolean check, boolean showTitle, boolean showText, boolean showCheck){
        mTitle = title;
        mText = text;
        mCheck = check;
        mShowTitle = showTitle;
        mShowText = showText;
        mShowCheck = showCheck;
        mListener = new NoListener();
        mTitleSize = 15;
        mLeft = 50;
        mTop = 20;
        mRight = 20;
        mBottom = 20;
    }
    
//...    
    
```

```java

//...

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
        
//...        

```

- Result:

![Result](https://github.com/YiTingWang/Android_SettingView/blob/master/README_content/Result.png "Result")

## Listener

- Add listeners for item

### Listener for CheckBox

```java

//...

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
        
//...        

```

```java

//...

public class ShowAnotherItem implements Mission<SettingItem> {
	private SettingItem mHidden;

	/**
	 * Constructor
	 */
	public ShowAnotherItem(SettingItem hidden) {
		mHidden = hidden;
	}

	@Override
	public SettingItem execute(SettingItem item) {
		if(item.getCheck()){
			mHidden.setTitleVisibility(true);
			mHidden.setTextVisibility(true);
			mHidden.setCheckVisibility(true);
		}else{
			mHidden.setTitleVisibility(false);
			mHidden.setTextVisibility(false);
			mHidden.setCheckVisibility(false);
		}
		return item;
	}
}

//...

```

```java

//...

public class UpdateText implements Mission<SettingItem> {
	private String mSelected;
	private String mUnselected;

	/**
	 * Constructor
	 */
	public UpdateText(String selected, String unselected) {
		mSelected = selected;
		mUnselected = unselected;
	}

	@Override
	public SettingItem execute(SettingItem item) {
		if (item.getCheck()) {
			item.setText(mSelected);
		} else {
			item.setText(mUnselected);
		}
		return item;
	}
}

//...

```

- Example:

![checkbox1](https://github.com/YiTingWang/Android_SettingView/blob/master/README_content/checkbox1.png "checkbox1")

![checkbox2](https://github.com/YiTingWang/Android_SettingView/blob/master/README_content/checkbox2.png "checkbox2")

### Listener for RadioButtonDialog

```java

//...

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

//...

```

```java

//...

public class RadioListener implements View.OnClickListener {

//...

    public void onClick(View v) {

        mRadioView.setListener(mViewListener);

        mBuild.setTitle(mTitle);
        mBuild.setPositiveButton(mPositiveText,mPositiveListener);
        mBuild.setNegativeButton(mNegativeText,mNegativeListener);
        mBuild.setNeutralButton(mNeutralText,mNeutralListener);

        AlertDialog alertDialog = mBuild.create();

        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                ((ViewGroup)mRadioView.getParent()).removeView(mRadioView);
            }
        });

        mAlertDialog = alertDialog;

        alertDialog.show();

    }

}

//...

```

```java

//...

public class RadioView extends ScrollView {

//...

    public RadioView(Context context, List<String> list) {
        super(context);

        LinearLayout linearLayout = new LinearLayout(context);

        List<RadioButton> radioList = new ArrayList<>();
        mList = radioList;

        RadioGroup radioGroup = new RadioGroup(context);
        mRadioGroup = radioGroup;

        for(int i=0; i<list.size(); i++) {
            RadioButton radioButton = new RadioButton(context);
            radioButton.setText(list.get(i));
            radioButton.setPadding(20,20,20,20);
            mList.add(radioButton);
            mRadioGroup.addView(radioButton);
        }

        linearLayout.addView(mRadioGroup);

        addView(linearLayout);

    }

//...

```

- Example:

![radioButtonDialog](https://github.com/YiTingWang/Android_SettingView/blob/master/README_content/radioButtonDialog.png "radioButtonDialog")

### Listener for MultiChoiceDialog

```java

//...

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

//...

```

```java

//...

public class MultiChoiceListener implements View.OnClickListener {

//...

public void onClick(View v) {

        AlertDialog.Builder builder = new AlertDialog.Builder(mMainActivity,mColor);

        builder.setAdapter(mAdapter,mListener);
        builder.setTitle("Invite Code Manage");
        builder.setPositiveButton(mPositiveText,mPositiveListener);
        builder.setNegativeButton(mNegativeText,mNegativeListener);
        builder.setNeutralButton(mNeutralText,mNeutralListener);
        builder.create().show();

    }

}

//...

```

- Example:

![multiChoiceDialog](https://github.com/YiTingWang/Android_SettingView/blob/master/README_content/multiChoiceDialog.png "multiChoiceDialog")

### Listener for ConfirmDialog

```java

//...

	SettingItem settingItem11 = new SettingItem("Erase",mMap.get("keyEraseAll"));
        ConfirmListener confirmListener = new ConfirmListener(MainActivity.this,"Erase",mMap.get("keyEraseAll"));
        YesClickListener yesClickListener = new YesClickListener();
        confirmListener.setYesListener(yesClickListener);
        NoClickListener noClickListener = new NoClickListener();
        confirmListener.setNoListener(noClickListener);
        settingItem11.setClickListener(confirmListener);
        list.add(settingItem11);
	
//...

```

```java

//...

public class ConfirmListener implements View.OnClickListener {

//...

	public void onClick(View v){

        	AlertDialog.Builder builder = new AlertDialog.Builder(mMainActivity,mColor);
       		builder.setTitle(mTitle);
        	builder.setMessage(mMessage);
        	//builder.setCancelable(false);   //不能使用手機返回鑑離開AlertDialogtime
        	builder.setPositiveButton("YES", mYesListener);
        	builder.setNegativeButton("NO", mNoListener);
        	AlertDialog dialog = builder.create();
        	dialog.show();

    	}

}

//...

```

- Example:

![confirmDialog](https://github.com/YiTingWang/Android_SettingView/blob/master/README_content/confirmDialog.png "confirmDialog")
