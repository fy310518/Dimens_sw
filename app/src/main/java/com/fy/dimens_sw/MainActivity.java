package com.fy.dimens_sw;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.fy.baselibrary.utils.T;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    /**
     * 设计稿尺寸(根据自己设计师的设计稿的宽度填入
     * 目前UI一般按照 苹果 6S --> 4.7英寸屏幕设计 分辨率为 750 * 1334
     * --> 和 Android 5英寸屏幕 720 * 1080 相差不大)
     */
    private static final int DESIGN_WIDTH = 360;// 750

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tvCreate).setOnClickListener(v -> runCreateDemen());
    }



    @SuppressLint("CheckResult")
    private void runCreateDemen() {
        DimenTypes[] values = DimenTypes.values();

        Observable.fromArray(values)
                .map(dimenTypes -> {
                    MakeUtils.makeAll(DESIGN_WIDTH, dimenTypes);
                    return "";
                })
                .subscribeOn(Schedulers.io())//指定的是上游发送事件的线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String str) throws Exception {
                        T.showLong("成功");
                    }
                });
    }
}
