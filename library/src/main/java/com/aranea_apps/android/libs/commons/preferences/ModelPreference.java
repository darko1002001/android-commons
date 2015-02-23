package com.aranea_apps.android.libs.commons.preferences;

import android.content.SharedPreferences;

import com.google.gson.Gson;

public class ModelPreference<T> {

  protected final SharedPreferences mPreferences;
  protected final String mKey;
  protected Gson gson = new Gson();
  private Class cls;

  /**
   * Constructs a {@code Generic model} preference for the given key
   */
  public ModelPreference(final SharedPreferences preferences, final String key, Class cls) {
    mPreferences = preferences;
    mKey = key;
    this.cls = cls;
  }

  /**
   * Returns the stored {@code T} value if it exists
   * or an empty model.
   */
  public T get() {
    T model = (T) gson.fromJson(mPreferences.getString(mKey, "{}"), cls);
    return model;
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
  public ModelPreference<T> set(T value) {
    mPreferences.edit().putString(mKey, gson.toJson(value)).apply();
    return this;
  }

  /**
   * Removes this preference setting asynchronously.
   */
  public ModelPreference<T> delete() {
    mPreferences.edit().remove(mKey).apply();
    return this;
  }

}
