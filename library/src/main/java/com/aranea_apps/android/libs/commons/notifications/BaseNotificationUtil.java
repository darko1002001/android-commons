package com.aranea_apps.android.libs.commons.notifications;

import android.widget.Toast;

import com.aranea_apps.android.libs.commons.app.Commons;

public class BaseNotificationUtil {

  private static Toast toast;

  public static void makeSingleShowToast(int resId) {
    makeSingleShowToast(Commons.getContext().getString(resId));
  }
  public static void makeSingleShowToast(String message) {
    if (toast != null) {
      toast.cancel();
    }
    toast = Toast.makeText(Commons.getContext(), message, Toast.LENGTH_SHORT);
    toast.show();
  }

  public static void makeToast(String message) {
    Toast.makeText(Commons.getContext(), message, Toast.LENGTH_SHORT).show();
  }

  public static void makeToast(int stringId) {
    Toast.makeText(Commons.getContext(), stringId, Toast.LENGTH_SHORT).show();
  }

}
