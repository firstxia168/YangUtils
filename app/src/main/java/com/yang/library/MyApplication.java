package com.yang.library;

import android.app.Application;

import com.ymz.baselibrary.BaseApplication;


/**
 * 创建人：$ gyymz1993
 * 创建时间：2017/6/28 18:10
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BaseApplication.instance().initialize(this);
    }
}
