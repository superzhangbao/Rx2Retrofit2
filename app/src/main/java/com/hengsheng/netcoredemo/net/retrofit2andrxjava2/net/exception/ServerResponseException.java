package com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.exception;

/**
 * 服务器返回的异常
 */
public class ServerResponseException extends RuntimeException {
    private String errorCode;

    public ServerResponseException(String errorCode, String cause) {
        super("错误原因:"+cause, new Throwable("Server error"));
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
