package com.aranea_apps.android.libs.commons.preferences;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ListParameterizedType implements ParameterizedType {

  private Type type;

  public ListParameterizedType(Type type) {
    this.type = type;
  }

  @Override
  public Type[] getActualTypeArguments() {
    return new Type[]{type};
  }

  @Override
  public Type getRawType() {
    return ArrayList.class;
  }

  @Override
  public Type getOwnerType() {
    return null;
  }

}