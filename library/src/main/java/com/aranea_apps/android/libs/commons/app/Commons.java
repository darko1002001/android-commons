package com.aranea_apps.android.libs.commons.app;

import android.content.Context;

import com.aranea_apps.android.libs.commons.preferences.BasePreferenceUtil;

public class Commons {

  private static Context context;

  public static void init(Context context) {
    Commons.context = context;
  }

  public static void initWithDefaults(Context context) {
    Commons.context = context;
    BasePreferenceUtil.init(context);
  }

  public static Context getContext() {
    return context;
  }
}
