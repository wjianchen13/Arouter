package com.cold.arouter;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;


public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        initARouter();
    }

    private void initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

}
