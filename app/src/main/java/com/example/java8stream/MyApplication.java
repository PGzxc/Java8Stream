package com.example.java8stream;

import android.app.Application;
import android.content.Context;

/**
 * Created by admin on 2017/12/14.
 */

public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=MyApplication.this;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        MyApplication.context = context;
    }
}
