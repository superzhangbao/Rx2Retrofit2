package com.hengsheng.netcoredemo.net.okhttp.response;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;
import com.hengsheng.netcoredemo.net.okhttp.exception.OkHttpException;
import com.hengsheng.netcoredemo.net.okhttp.listener.DisposeDataHandle;
import com.hengsheng.netcoredemo.net.okhttp.listener.DisposeDataListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * Created by zhangb on 2018/6/5/05
 * 专门处理Json的回调
 */

public class CommonJsonCallback implements Callback {

    //与服务器返回的字段的一个对应关系
    protected final String RESULT_CODE = "code"; // 有返回则对于http请求来说是成功的，但还有可能是业务逻辑上的错误
    protected final int RESULT_CODE_VALUE = 0000;
    protected final String ERROR_MSG = "msg";
    protected final String EMPTY_MSG = "";
    protected final String COOKIE_STORE = "Set-Cookie";

    //自定义异常类型
    protected final int NETWORK_ERROR = -1;
    protected final int JSON_ERROR = -2;
    protected final int OTHER_ERROR = -3;

    private Handler mDeliveryHandler;//进行消息的转发
    private DisposeDataListener mListener;
    private Class<?> mClass;
    private Gson mGson;

    public CommonJsonCallback(DisposeDataHandle disposeDataHandle) {
        this.mListener = disposeDataHandle.mListener;
        this.mClass = disposeDataHandle.mClass;
        this.mDeliveryHandler = new Handler(Looper.getMainLooper());
    }


    //请求失败处理
    @Override
    public void onFailure(Call call, final IOException e) {
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.onFailure(new OkHttpException(NETWORK_ERROR, e));
            }
        });
    }

    //真正的响应处理函数
    @Override
    public void onResponse(Call call, final Response response) throws IOException {
        final String result = response.body().toString();
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(result);
            }
        });
    }

    /**
     * 处理服务器返回的相应数据
     * @param responseObj
     */
    private void handleResponse(Object responseObj) {
        if (responseObj == null || ("").equals(responseObj.toString().trim())) {
            mListener.onFailure(new OkHttpException(NETWORK_ERROR,EMPTY_MSG));
            return;
        }

        try {
            JSONObject jsonObject = new JSONObject(responseObj.toString());
            //开始解析json
            if (jsonObject.has(RESULT_CODE)) {
                //从json对象中取出我们的响应吗，若为0，则是正确的响应
                if (jsonObject.getInt(RESULT_CODE) == RESULT_CODE_VALUE) {
                    //不需要解析，直接返回数据到应用层
                    if (mClass == null) {
                        mListener.onSuccess(responseObj);
                    }else {
                        //需要我们将json对象转化为实体对象
                        if (mGson == null) {
                            mGson = new Gson();
                        }
                        Object fromJson = mGson.fromJson(jsonObject.toString(), mClass);
                        //标明正确的转为了实体对象
                        if (fromJson != null) {
                            mListener.onSuccess(fromJson);
                        }else {
                            //返回的不是合法的json
                            mListener.onFailure(new OkHttpException(JSON_ERROR,EMPTY_MSG));
                        }
                    }
                }else {
                    mListener.onFailure(new OkHttpException(OTHER_ERROR,jsonObject.get(RESULT_CODE)));
                }
            }
        } catch (JSONException e) {
            mListener.onFailure(new OkHttpException(OTHER_ERROR,e.getMessage()));
            e.printStackTrace();
        }
    }
}
