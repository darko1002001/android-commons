package com.aranea_apps.android.libs.commons.sample;

import android.app.Activity;

import com.aranea_apps.android.libs.commons.BaseIntentUtil;

public class IntentUtil extends BaseIntentUtil {

  public static void startMainActivity(Activity context) {
    startActivity(context, MainActivity.class);
  }
}
