package com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.exception;

/**
 * Created by zhangb on 2018/6/7/07
 * 请求网络失败原因
 */
public enum ExceptionReason {
    /**
     * 解析数据失败
     */
    PARSE_ERROR,
    /**
     * 网络问题
     */
    BAD_NETWORK,
    /**
     * 连接错误
     */
    CONNECT_ERROR,
    /**
     * 连接超时
     */
    CONNECT_TIMEOUT,
    /**
     * 未知错误
     */
    UNKNOWN_ERROR,
}
