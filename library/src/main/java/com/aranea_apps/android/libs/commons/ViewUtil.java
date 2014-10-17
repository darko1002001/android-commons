package com.aranea_apps.android.libs.commons;

import android.view.View;

public class ViewUtil {

  public static void makeVisible(View... views) {
    changeVisibility(View.VISIBLE, views);
  }

  public static void makeGone(View... views) {
    changeVisibility(View.GONE, views);
  }

  public static void makeInvisible(View... views) {
    changeVisibility(View.INVISIBLE, views);
  }

  private static void changeVisibility(int visibility, View... views) {
    for (View v : views) {
      v.setVisibility(visibility);
    }
  }
}
