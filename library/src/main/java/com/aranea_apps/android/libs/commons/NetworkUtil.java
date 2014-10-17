/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Chute Corporation U.S.A
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

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
