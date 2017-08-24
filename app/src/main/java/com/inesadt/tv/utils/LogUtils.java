package com.inesadt.tv.utils;

import android.util.Log;

/**
 * 日志帮助类
 *
 * @author Cheyy
 */
public class LogUtils {

    private LogUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("LogUtils cannot be instantiated");
    }

    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    public static final int NOTHING = 6;
    public static final int LEVEL = VERBOSE;//控制日志权限

    public static void v(String tag, String msg) {
        if (LEVEL <= VERBOSE) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (LEVEL <= DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (LEVEL <= INFO) {
            Log.i(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (LEVEL <= WARN) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (LEVEL <= ERROR) {
            Log.e(tag, msg);
        }
    }

    public static void v(String tag, String msg, Throwable ex) {
        if (LEVEL <= VERBOSE) {
            Log.v(tag, msg, ex);
        }
    }

    public static void d(String tag, String msg, Throwable ex) {
        if (LEVEL <= DEBUG) {
            Log.d(tag, msg, ex);
        }
    }

    public static void i(String tag, String msg, Throwable ex) {
        if (LEVEL <= INFO) {
            Log.i(tag, msg, ex);
        }
    }

    public static void w(String tag, String msg, Throwable ex) {
        if (LEVEL <= WARN) {
            Log.w(tag, msg, ex);
        }
    }

    public static void e(String tag, String msg, Throwable ex) {
        if (LEVEL <= ERROR) {
            Log.e(tag, msg, ex);
        }
    }

}
