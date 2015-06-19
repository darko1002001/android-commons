package com.aranea_apps.android.libs.commons;

import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;

import com.aranea_apps.android.libs.commons.app.Commons;

public class ViewUtil {


  public static int dpToPixels(int dp) {
    Resources r = Commons.getContext().getResources();
    int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
    return px;
  }

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
