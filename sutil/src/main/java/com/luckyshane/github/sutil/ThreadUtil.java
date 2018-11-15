package com.luckyshane.github.sutil;

import android.os.Handler;
import android.os.Looper;

public class ThreadUtil {
    private static final Handler handler = new Handler(Looper.getMainLooper());

    public static void runOnUI(Runnable runnable) {
        handler.post(runnable);
    }

    public static void runOnUIDelay(Runnable runnable, long delayMillis) {
        handler.postDelayed(runnable, delayMillis);
    }

    public static Handler getMainHandler() {
        return handler;
    }

}
