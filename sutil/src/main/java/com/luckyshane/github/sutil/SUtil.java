package com.luckyshane.github.sutil;

import android.content.Context;


public class SUtil {

    private SUtil() { }

    private static Context appContext;

    public static void init(Context context) {
        appContext = context.getApplicationContext();
    }

    public static Context getAppContext() {
        return appContext;
    }


}
