package com.fy.dimens_sw;

import android.app.Application;

import com.fy.baselibrary.application.ConfigUtils;

/**
 * Created by fangs on 2018/8/20 14:42.
 */
public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        new ConfigUtils.ConfigBiuder()
                .setBASE_URL("http://www.wanandroid.com/")
                .create(this);
    }
}
