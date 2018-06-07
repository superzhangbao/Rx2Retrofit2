package com.hengsheng.netcoredemo.net.okhttp.listener;

/**
 * Created by zhangb on 2018/6/5/005
 */

public interface DisposeDataListener {

    /**
     * 请求成功回调事件处理
     * @param responseObj
     */
    public void onSuccess(Object responseObj);

    /**
     * 请求失败回调事件处理
     * @param reasonObj
     */
    public void onFailure(Object reasonObj);

}
