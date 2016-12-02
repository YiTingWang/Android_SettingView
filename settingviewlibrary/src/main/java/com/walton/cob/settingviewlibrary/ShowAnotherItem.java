/*
 * Copyright (C) 2016 Adam Huang <poisondog@gmail.com>
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

import poisondog.core.Mission;

/**
 * @author Adam Huang <poisondog@gmail.com>
 * @since 2016-12-02
 */
public class ShowAnotherItem implements Mission<SettingItem> {
	private SettingItem mCheck;

	/**
	 * Constructor
	 */
	public ShowAnotherItem(SettingItem check) {
		mCheck = check;
	}

	@Override
	public SettingItem execute(SettingItem item) {
		if(mCheck.getCheck()){
			item.setTitleVisibility(true);
			item.setTextVisibility(true);
			item.setCheckVisibility(true);
		}else{
			item.setTitleVisibility(false);
			item.setTextVisibility(false);
			item.setCheckVisibility(false);
		}
		return item;
	}
}
