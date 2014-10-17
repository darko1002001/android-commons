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

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

public class BaseFragmentUtil {

  public static final String TAG = BaseFragmentUtil.class.getSimpleName();

  public static void replaceFragmentToLayout(final int containerId, final FragmentManager fragmentManager,
                                             final Fragment fragment, final String tag) {
    final FragmentTransaction ft = fragmentManager.beginTransaction();
    final Fragment previousFragment = fragmentManager
      .findFragmentByTag(tag);
    if (previousFragment != null) {
      ft.remove(previousFragment);
    }
    ft.add(containerId, fragment, tag);
    ft.commit();
  }

  public static void addFragmentToLayout(final int containerId, final FragmentManager fragmentManager,
                                         final Fragment fragment, final String tag) {
    final FragmentTransaction ft = fragmentManager.beginTransaction();
    ft.add(containerId, fragment, tag);
    ft.commit();
  }

  public static void removeDialogFragment(final String tag,
                                          final FragmentManager fragmentManager) {
    if (fragmentManager == null) {
      return;
    }
    final FragmentTransaction ft = fragmentManager.beginTransaction();
    final Fragment prev = fragmentManager.findFragmentByTag(tag);
    if (prev != null && prev.isAdded()) {
      ft.remove(prev);
    }
    ft.commitAllowingStateLoss();
  }

  public static void showDialogFragment(final DialogFragment dialog,
                                        final String tag, final FragmentManager fragmentManager) {
    final FragmentTransaction ft = fragmentManager.beginTransaction();
    final Fragment prev = fragmentManager.findFragmentByTag(tag);
    if (prev != null) {
      ft.remove(prev);
    }
    ft.add(dialog, tag);
    ft.commitAllowingStateLoss();
  }

  public static void replaceFragment(FragmentManager manager, int parent,
                                     Fragment fragment) {
    FragmentTransaction ft = manager.beginTransaction();
    ft.replace(parent, fragment);
    ft.addToBackStack(null);
    ft.commit();
  }

}
