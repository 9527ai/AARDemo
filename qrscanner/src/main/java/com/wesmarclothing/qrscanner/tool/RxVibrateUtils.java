package com.wesmarclothing.qrscanner.tool;

import android.os.Vibrator;

/**
 * Created by Vondear on 2017/7/25.
 * 震动帮助类
 * androidManifest.xml中加入 以下权限
 * <uses-permission android:name="android.permission.VIBRATE" />
 */
public class RxVibrateUtils {
    private static Vibrator vibrator;
    private static android.content.Context Context;


    public static void setContext(android.content.Context context) {
        Context = context;
    }

    /**
     * 简单震动
     *
     * @param millisecond 震动的时间，毫秒
     */
    @SuppressWarnings("static-access")
    public static void vibrateOnce(int millisecond) {
        if (vibrator == null) {
            vibrator = (Vibrator) Context.getSystemService(Context.VIBRATOR_SERVICE);
        } else if (vibrator.hasVibrator()) {
            vibrator.vibrate(millisecond);
        }
    }

    /**
     * 复杂的震动
     *
     * @param pattern 震动形式
     *                数组参数意义：
     *                第一个参数为等待指定时间后开始震动，
     *                震动时间为第二个参数。
     *                后边的参数依次为等待震动和震动的时间
     * @param repeate 震动的次数，-1不重复，非-1为从pattern的指定下标开始重复 0为一直震动
     */
    @SuppressWarnings("static-access")
    public static void vibrateComplicated(long[] pattern, int repeate) {
        if (vibrator == null) {
            vibrator = (Vibrator) Context.getSystemService(Context.VIBRATOR_SERVICE);
        } else if (vibrator.hasVibrator()) {
            vibrator.vibrate(pattern, repeate);
        }
    }

    /**
     * 停止震动
     */
    public static void vibrateStop() {
        if (vibrator != null) {
            vibrator.cancel();
            vibrator = null;
        }
    }
}