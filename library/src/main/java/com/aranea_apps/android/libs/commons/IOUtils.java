package com.aranea_apps.android.libs.commons;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

public class IOUtils {

  public static String toString(InputStream input) throws IOException {
    StringWriter sw = new StringWriter();
    InputStreamReader in = new InputStreamReader(input);
    copy(in, sw);
    return sw.toString();
  }

  public static int copy(Reader input, Writer output) throws IOException {
    long count = copyLarge(input, output);
    if (count > Integer.MAX_VALUE) {
      return -1;
    }
    return (int) count;
  }

  private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

  public static long copyLarge(Reader input, Writer output) throws IOException {
    char[] buffer = new char[DEFAULT_BUFFER_SIZE];
    long count = 0;
    int n = 0;
    while (-1 != (n = input.read(buffer))) {
      output.write(buffer, 0, n);
      count += n;
    }
    return count;
  }

}
