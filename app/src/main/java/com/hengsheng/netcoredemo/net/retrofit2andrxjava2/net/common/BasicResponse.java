package com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.common;

/**
 * Created by zhangb on 2018/6/6/006
 */

public class BasicResponse<T> {
    private String code;
    private String message;
    private T data;
    private boolean error;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
