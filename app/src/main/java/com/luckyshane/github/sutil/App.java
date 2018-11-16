package com.luckyshane.github.sutil;

import android.app.Application;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SUtil.init(this);
    }


}
