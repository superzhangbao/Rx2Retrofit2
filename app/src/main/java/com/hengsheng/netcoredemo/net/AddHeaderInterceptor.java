package com.hengsheng.netcoredemo.net;

import android.support.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhangb on 2018/5/2/002
 * 对所有的请求都添加某个请求头的拦截器
 */

public class AddHeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        //返回Request对象
        Request request = chain.request();
        request.newBuilder().header("User-Agent","Android").build();

        //返回此次请求的响应对象
        Response response = chain.proceed(request);
        return response;
    }


    //在每个Response中都添加某个header值
//    @Override
//    public Response intercept(@NonNull Chain chain) throws IOException {
//        //返回Request对象
//        Request request = chain.request();
//        request.newBuilder().header("User-Agent","Android").build();
//
//        //返回此次请求的响应对象
//        Response response = chain.proceed(request);
//        return response.newBuilder().header("Cache-Control","max-age=100").build();
//    }
}
