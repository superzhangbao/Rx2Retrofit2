package com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.interceptor;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhangb on 2018/6/6/006
 */

public class HttpHeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        //配置请求头
        Request request = chain.request().newBuilder()
                .header("Content-Type", "application/json")
                .build();
        return chain.proceed(request);
    }
}
