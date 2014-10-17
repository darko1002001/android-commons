package com.aranea_apps.android.libs.commons;

import android.app.Activity;
import android.content.Intent;

public class BaseIntentUtil {

  private static final int NO_FLAGS = 0;

  protected static void startActivity(Activity activity, Class cls) {
    startActivity(activity, cls, NO_FLAGS);
  }

  protected static void startActivity(Activity activity, Class cls, int flags) {
    Intent intent = new Intent(activity, cls);
    if (flags > 0) {
      intent.addFlags(flags);
    }
    activity.startActivity(intent);
  }

}
