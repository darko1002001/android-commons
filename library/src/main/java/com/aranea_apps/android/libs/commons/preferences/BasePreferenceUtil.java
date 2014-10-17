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

package com.aranea_apps.android.libs.commons.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import info.metadude.android.typedpreferences.BooleanPreference;
import info.metadude.android.typedpreferences.DoublePreference;
import info.metadude.android.typedpreferences.FloatPreference;
import info.metadude.android.typedpreferences.IntPreference;
import info.metadude.android.typedpreferences.LongPreference;
import info.metadude.android.typedpreferences.StringPreference;


/**
 * @author Darko.Grozdanovski
 */
public class BasePreferenceUtil {

  public static final String TAG = BasePreferenceUtil.class.getSimpleName();

  public static final String PREF_FILE_NAME = "preferences";

  protected static SharedPreferences prefs;

  protected BasePreferenceUtil() {
  }

  public static void init(Context context) {
    init(context, PREF_FILE_NAME);
  }

  public static void init(Context context, String prefName) {
    prefs = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
  }

  public static BooleanPreference booleanPreference(String key) {
    return new BooleanPreference(prefs, key);
  }

  public static BooleanPreference booleanPreference(String key, boolean defaultValue) {
    return new BooleanPreference(prefs, key, defaultValue);
  }

  public static StringPreference stringPreference(String key) {
    return new StringPreference(prefs, key);
  }

  public static StringPreference stringPreference(String key, String defaultValue) {
    return new StringPreference(prefs, key, defaultValue);
  }

  public static LongPreference longPreference(String key) {
    return new LongPreference(prefs, key);
  }

  public static LongPreference longPreference(String key, long defaultValue) {
    return new LongPreference(prefs, key, defaultValue);
  }

  public static IntPreference intPreference(String key) {
    return new IntPreference(prefs, key);
  }

  public static IntPreference intPreference(String key, int defaultValue) {
    return new IntPreference(prefs, key, defaultValue);
  }

  public static DoublePreference doublePreference(String key, double defaultValue) {
    return new DoublePreference(prefs, key, defaultValue);
  }

  public static DoublePreference doublePreference(String key) {
    return new DoublePreference(prefs, key);
  }

  public static FloatPreference floatPreference(String key, float defaultValue) {
    return new FloatPreference(prefs, key, defaultValue);
  }

  public static FloatPreference floatPreference(String key) {
    return new FloatPreference(prefs, key);
  }

}
