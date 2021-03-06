package com.vondear.rxtools.utils;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;

import java.util.List;

/**
 * @author by vondear on 2016/9/24.
 */

public class RxServiceUtils {

    /**
     * 获取服务是否开启
     *
     * @param className 完整包名的服务类名
     * @return {@code true}: 是<br>{@code false}: 否
     */
    public static boolean isRunningService(String className) {
        // 进程的管理者,活动的管理者
        ActivityManager activityManager = (ActivityManager)
                RxUtils.getContext().getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager != null) {
            // 获取正在运行的服务，最多获取1000个
            List<ActivityManager.RunningServiceInfo> runningServices = activityManager.getRunningServices(1000);
            // 遍历集合
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                ComponentName service = runningServiceInfo.service;
                if (className.equals(service.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }
}
