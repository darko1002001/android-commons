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

  public static <T> ModelPreference<T> modelPreference(String key, Class cls) {
    return new ModelPreference<T>(prefs, key, cls);
  }

  public static <T> ListPreference<T> listPreference(String key, Class cls) {
    return new ListPreference<T>(prefs, key, cls);
  }

}
