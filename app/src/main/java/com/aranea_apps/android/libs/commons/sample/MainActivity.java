package com.aranea_apps.android.libs.commons.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.aranea_apps.android.libs.commons.logging.ALog;
import com.aranea_apps.android.libs.commons.notifications.BaseNotificationUtil;


public class MainActivity extends ActionBarActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    BaseNotificationUtil.makeSingleShowToast("Hello " + PreferenceUtil.getRememberMePreference().get());


    PreferenceUtil.getRememberMePreference().set(!PreferenceUtil.getRememberMePreference().get());


    ALog.d("Hello", "World", "Bla");
  }

}
