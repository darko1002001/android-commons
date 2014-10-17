package com.aranea_apps.android.libs.commons;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.aranea_apps.android.libs.commons.app.Commons;

public class NetworkUtil {

  public static boolean isWifiConnected() {
    ConnectivityManager connectivityManager = (ConnectivityManager) Commons.getContext()
        .getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo mWifi = connectivityManager
        .getNetworkInfo(ConnectivityManager.TYPE_WIFI);
    return mWifi.isConnected();
  }

  public static boolean isNetworkAvailable() {
    ConnectivityManager connectivityManager
        = (ConnectivityManager) Commons.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
    if (activeNetworkInfo == null) {
      return false;
    }
    return activeNetworkInfo.isConnected();
  }

}
