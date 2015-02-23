package com.aranea_apps.android.libs.commons.preferences;

import android.content.SharedPreferences;

import com.google.gson.Gson;

import java.util.List;

public class ListPreference<T> {

  protected final SharedPreferences mPreferences;
  protected final String mKey;
  protected Gson gson = new Gson();
  private Class cls;

  /**
   * Constructs a {@code Generic model} preference for the given key
   */
  public ListPreference(final SharedPreferences preferences, final String key, Class cls) {
    mPreferences = preferences;
    mKey = key;
    this.cls = cls;
  }

  /**
   * Returns the stored {@code T} value if it exists
   * or an empty model.
   */
  public List<T> get() {
    List<T> list = gson.fromJson(mPreferences.getString(mKey, "[]"), new ListParameterizedType(cls));
    return list;
  }

  /**
   * Returns {@code true} if some value is stored for
   * this preference, otherwise {@code false}.
   */
  public boolean isSet() {
    return mPreferences.contains(mKey);
  }

  /**
   * Stores the given {@code boolean} value asynchronously.
   */
  public ListPreference<T> set(List<T> values) {
    mPreferences.edit().putString(mKey, gson.toJson(values)).apply();
    return this;
  }

  /**
   * Removes this preference setting asynchronously.
   */
  public ListPreference<T> delete() {
    mPreferences.edit().remove(mKey).apply();
    return this;
  }


}
