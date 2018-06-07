package com.hengsheng.netcoredemo;

import android.app.Application;
import android.content.Context;

import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.utils.Utils;

/**
 * Created by zhangb on 2018/6/6/006
 */

public class MyApp extends Application {
    private static MyApp app;
    public static Context getAppContext() {
        return app;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        app=this;
    }
}
