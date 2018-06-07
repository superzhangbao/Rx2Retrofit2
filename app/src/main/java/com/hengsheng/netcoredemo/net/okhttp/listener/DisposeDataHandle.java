package com.hengsheng.netcoredemo.net.okhttp.listener;

/**
 * Created by zhangb on 2018/6/5/005
 */

public class DisposeDataHandle {

    public DisposeDataListener mListener = null;
    public Class<?> mClass = null;
    public String mSource = null;

    public DisposeDataHandle(DisposeDataListener listener) {
        this.mListener = listener;
    }

    public DisposeDataHandle(DisposeDataListener listener,Class<?> clazz) {
        this.mListener = listener;
        this.mClass = clazz;
    }

    public DisposeDataHandle(DisposeDataListener listener,String source) {
        this.mListener = listener;
        this.mSource = source;
    }
}
