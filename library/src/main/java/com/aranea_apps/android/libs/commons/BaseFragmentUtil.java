package com.aranea_apps.android.libs.commons;

import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.aranea_apps.android.libs.commons.dialogs.ProgressDialogFragment;

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


  public static void showProgressDialog(Activity activity) {
    showProgressDialog(activity.getFragmentManager(),
      activity.getString(R.string.message_progress), true);
  }

  public static void showProgressDialog(FragmentManager manager,
                                        String message, boolean cancelable) {
    final ProgressDialogFragment progressDialogFragment = ProgressDialogFragment
      .newInstance(message, cancelable);
    showDialogFragment(progressDialogFragment, ProgressDialogFragment.TAG,
      manager);
  }

  public static void clearProgressDialog(FragmentManager manager) {
    try {
      removeDialogFragment(ProgressDialogFragment.TAG, manager);
    } catch (Exception e) {
      // Ignore this might happen very rarely in some transitional states
    }
  }

  public static void clearProgressDialog(Activity activity) {
    clearProgressDialog(activity.getFragmentManager());
  }


  public static void replaceFragment(FragmentManager manager, int parent,
                                     Fragment fragment) {
    FragmentTransaction ft = manager.beginTransaction();
    ft.replace(parent, fragment);
    ft.addToBackStack(null);
    ft.commit();
  }

}
