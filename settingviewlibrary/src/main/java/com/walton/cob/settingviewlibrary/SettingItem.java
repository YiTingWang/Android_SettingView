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
package com.walton.cob.settingviewlibrary;

import android.view.View;



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

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getTitle(){
        return mTitle;
    }

    public void setText(String text){
        mText = text;
    }

    public String getText(){
        return mText;
    }

    public void setTitleSize(float size) {
        mTitleSize = size;
    }

    public float getTitleSize(){
        return mTitleSize;
    }

    public void setPadding(int left, int top, int right, int bottom) {
        mLeft = left;
        mTop = top;
        mRight = right;
        mBottom = bottom;
    }

    public int getPaddingLeft() {
        return mLeft;
    }

    public int getPaddingTop() {
        return mTop;
    }

    public int getPaddingRight() {
        return mRight;
    }

    public int getPaddingBottom() {
        return mBottom;
    }

    public void setCheck(boolean check){
        mCheck = check;
    }

    public boolean getCheck(){
        return mCheck;
    }

    public void setTitleVisibility(boolean showTitle){
        mShowTitle = showTitle;
    }

    public boolean getTitleVisibility(){
        return mShowTitle;
    }

    public void setTextVisibility(boolean showText){
        mShowText = showText;
    }

    public boolean getTextVisibility(){
        return mShowText;
    }

    public void setCheckVisibility(boolean showCheck){
        mShowCheck = showCheck;
    }

    public boolean getCheckVisibility(){
        return mShowCheck;
    }

    public void setClickListener(View.OnClickListener listener){
        mListener = listener;
    }

    public View.OnClickListener getClickListener(){
        return mListener;
    }

}
