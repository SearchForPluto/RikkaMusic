package com.rikkathewrold.rikkamusic.util;

import android.util.Log;

import com.rikkathewrold.rikkamusic.BuildConfig;

/**
 * 重写日志输出工具类
 * isPrintLog 控制开发生产模式  true打印日志   false不打印
 */
public class LogUtil {
    private static boolean isPrintLog = BuildConfig.DEBUG;
//    private static boolean isPrintLog = false;


    public static void i(String tag, String msg) {
        if (isPrintLog) {
            Log.i(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (isPrintLog) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (isPrintLog) {
            Log.d(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (isPrintLog) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (isPrintLog) {
            Log.e(tag, msg);
        }
    }
}
