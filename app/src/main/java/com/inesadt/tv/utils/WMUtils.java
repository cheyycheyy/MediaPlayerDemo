package com.inesadt.tv.utils;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Cheyy on 2016/8/25.
 */
public class WMUtils {

    private WMUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("WMUtils cannot be instantiated");
    }

    private static final String TAG = "WMUtils";

    /**
     * 打印屏幕分辨率信息
     */
    public static void printPxInfo(WindowManager windowManager) {
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;//宽度
        int height = dm.heightPixels ;//高度
        Log.i(TAG ,"window width=" + width + "  height=" + height);
    }

    /**
     * 隐藏导航栏
     * @param window
     */
    public static void hideNavigation(Window window) {
        View decorView = window.getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

}
