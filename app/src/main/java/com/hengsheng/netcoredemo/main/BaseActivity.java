package com.hengsheng.netcoredemo.main;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.utils.ToastUtils;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by zhangb on 2018/6/6/006
 */

public abstract class BaseActivity extends RxAppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        init(savedInstanceState);
    }
    protected void showToast(String msg) {
        ToastUtils.show(msg);
    }

    protected abstract @LayoutRes int getLayoutId();

    protected abstract void init(Bundle savedInstanceState);
}
