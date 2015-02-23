package com.aranea_apps.android.libs.commons.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.aranea_apps.android.libs.commons.notifications.BaseNotificationUtil;
import com.aranea_apps.android.libs.commons.preferences.ListPreference;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    BaseNotificationUtil.makeSingleShowToast("Hello " + PreferenceUtil.getRememberMePreference().get());
    PreferenceUtil.getRememberMePreference().set(!PreferenceUtil.getRememberMePreference().get());
    PreferenceUtil.modelPreference("test_model", TestModel.class).set(new TestModel("darko", "G"));

    ListPreference<TestModel> testList = PreferenceUtil.listPreference("test_list", TestModel.class);
    List<TestModel> list = new ArrayList<TestModel>();
    list.add(new TestModel("one", "two"));
    list.add(new TestModel("three", "four"));
    testList.set(list);
  }

  public static class TestModel {
    private String name;
    private String surname;

    public TestModel(String name, String surname) {
      this.name = name;
      this.surname = surname;
    }
  }

}
