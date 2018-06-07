package com.hengsheng.netcoredemo.net.retrofit;

/**
 * Created by zhangb on 2018/6/6/006
 */

public class BaseEntity<T> {
    private static int SUCCESS_CODE = 0000;
    private int code;
    private String msg;
    private T data;

    public boolean isSuccess(){
        return getCode()==SUCCESS_CODE;
    }
    private int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
