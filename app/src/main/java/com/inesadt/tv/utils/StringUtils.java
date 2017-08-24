package com.inesadt.tv.utils;

/**
 * @FileName: com.inesadt.tv.utils.StringUtils.java
 * @Author: Vita
 * @Date: 2017-04-13 09:55
 * @Usage:
 */
public class StringUtils {

    private StringUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("StringUtils cannot be instantiated");
    }

    public static boolean isEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }

    public static boolean isEqual(String string1, String string2) {
        if (string1 == null && string2 == null) return true;
        if (string1 == null || string2 == null) return false;
        return string1.equals(string2);
    }

    public static boolean isUrl(String s) {
        if (isEmpty(s)) return false;

        return s.startsWith("http://") || s.startsWith("https://") || s.startsWith("rtsp://");

    }
}
