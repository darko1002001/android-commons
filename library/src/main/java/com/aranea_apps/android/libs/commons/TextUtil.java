package com.aranea_apps.android.libs.commons;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import com.aranea_apps.android.libs.commons.app.Commons;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtil {

  public static void setupClickableSpan(TextView textView, String textToMark, ClickableSpan clickableSpan, int color) {
    String source = textView.getText().toString();
    SpannableString ss = new SpannableString(source);

    //we need find oud position of the text: first index and the last
    int termStart = source.indexOf(textToMark);
    int termStop = termStart + textToMark.length();

    //we set here clickable our text
    ss.setSpan(clickableSpan, termStart, termStop, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

    //we set here our color
    ss.setSpan(new ForegroundColorSpan(color),
      termStart, termStop, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

    //we set here text to be underline
    ss.setSpan(new UnderlineSpan(), termStart, termStop, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

    //I set here spannable text to my previous declared TextView
    textView.setText(ss);

    //We set here clickable text, this is important !!
    textView.setMovementMethod(LinkMovementMethod.getInstance());
  }

  public static void makeTextUnderline(TextView textView) {
    String source = textView.getText().toString();
    SpannableString ss = new SpannableString(source);

    //we need find oud position of the text: first index and the last
    int termStart = source.indexOf(source);
    int termStop = termStart + source.length();

    ss.setSpan(new UnderlineSpan(), termStart, termStop, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

    textView.setText(ss);
  }

  public static List<String> getAccountMail() {
    List<String> list = new LinkedList<String>();
    Pattern emailPattern = Pattern.compile(EMAIL_PATTERN);
    Account[] accounts = AccountManager.get(Commons.getContext()).getAccounts();
    for (Account account : accounts) {
      if (emailPattern.matcher(account.name).matches()) {
        list.add(account.name);
      }
    }
    return list;
  }

  public static final String EMAIL_PATTERN =
    "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
      + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
      + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
      + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
      + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
      + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

  public static boolean isEmailValid(String email) {

    CharSequence inputStr = email;

    Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(inputStr);

    if (matcher.matches()) {
      return true;
    } else {
      return false;
    }
  }


}
