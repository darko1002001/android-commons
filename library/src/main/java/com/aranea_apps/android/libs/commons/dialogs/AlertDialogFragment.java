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

package com.aranea_apps.android.libs.commons.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * @author darko.grozdanovski
 */
public class AlertDialogFragment extends DialogFragment {

  private static final String KEY_MESSAGE = "key_message";
  public static final String TAG = AlertDialogFragment.class.getSimpleName();

  private DialogInterface.OnClickListener okListener;
  private DialogInterface.OnClickListener cancelListener;
  private int positiveButtonRes = android.R.string.ok;

  public void setOkListener(DialogInterface.OnClickListener okListener) {
    this.okListener = okListener;
  }

  public void setCancelListener(DialogInterface.OnClickListener cancelListener) {
    this.cancelListener = cancelListener;
  }

  public void setPositiveButtonRes(int positiveButtonRes) {
    this.positiveButtonRes = positiveButtonRes;
  }

  public static AlertDialogFragment newInstance(final Context context,
                                                final int resMessage) {
    return newInstance(context.getString(resMessage));
  }

  public static AlertDialogFragment newInstance(final String message,
                                                boolean cancelable) {
    AlertDialogFragment pd = newInstance(message);
    pd.setCancelable(cancelable);
    return pd;
  }

  public static AlertDialogFragment newInstance(final String message) {
    final AlertDialogFragment progressDialogFragment = new AlertDialogFragment();
    progressDialogFragment.setShowsDialog(true);
    final Bundle b = new Bundle();
    b.putString(KEY_MESSAGE, message);
    progressDialogFragment.setArguments(b);
    return progressDialogFragment;
  }

  @Override
  public Dialog onCreateDialog(final Bundle savedInstanceState) {
    return getDialog();
  }

  @Override
  public Dialog getDialog() {
    // Use the Builder class for convenient dialog construction
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setMessage(getArguments().getString(KEY_MESSAGE))
        .setPositiveButton(positiveButtonRes,
            new DialogInterface.OnClickListener() {

              public void onClick(DialogInterface dialog, int id) {
                if (okListener != null) {
                  okListener.onClick(dialog, id);
                }
              }
            }
        );
    if (cancelListener != null) {
      builder.setNegativeButton(android.R.string.cancel, cancelListener);
    }
    return builder.create();
  }
}
