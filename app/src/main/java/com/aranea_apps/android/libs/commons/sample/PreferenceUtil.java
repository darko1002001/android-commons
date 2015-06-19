package com.aranea_apps.android.libs.commons.sample;

import com.aranea_apps.android.libs.commons.preferences.BasePreferenceUtil;

import info.metadude.android.typedpreferences.BooleanPreference;

public class PreferenceUtil extends BasePreferenceUtil {

  public static BooleanPreference getRememberMePreference() {
    return booleanPreference("key_remember_me");
  }
}
