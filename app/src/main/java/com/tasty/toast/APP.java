package com.tasty.toast;

import android.app.Application;
import android.content.Context;

import com.sdsmdg.tastytoast.ToastUtils;

/**
 * 初始化相关参数
 */
public class APP extends Application {

    public static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = getApplicationContext();

        //初始化提示工具类
        ToastUtils.init(sContext);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        System.gc();
    }
}
