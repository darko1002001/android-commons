package com.aranea_apps.android.libs.commons.app;

import android.app.Application;

public class CommonsApp extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Commons.initWithDefaults(this);
  }

}
