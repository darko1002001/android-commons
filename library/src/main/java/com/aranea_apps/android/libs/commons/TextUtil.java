package com.aranea_apps.android.libs.commons;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

public class TextUtil {

  public static void setupClickableSpan(TextView textView, String textToMark, ClickableSpan clickableSpan) {
    String source = textView.getText().toString();
    SpannableString ss = new SpannableString(source);

    //we need find oud position of the text: first index and the last
    int termStart = source.indexOf(textToMark);
    int termStop = termStart + textToMark.length();

    //we set here clickable our text
    ss.setSpan(clickableSpan, termStart, termStop, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

    //we set here our color
    ss.setSpan(new ForegroundColorSpan(textView.getContext().getResources().getColor(R.color.c_underline)),
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


}
