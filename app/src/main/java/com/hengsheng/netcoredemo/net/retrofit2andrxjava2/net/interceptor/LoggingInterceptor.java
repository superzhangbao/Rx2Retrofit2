package com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.interceptor;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;

import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.utils.LogUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by zhangb on 2018/6/6/006
 */

public class LoggingInterceptor implements Interceptor {
    @SuppressLint("DefaultLocale")
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        //这个chain里面包含了request和response，所以你要什么都可以从这里拿
        Request request = chain.request();
        //请求发起的时间
        long t1 = System.nanoTime();

        LogUtils.e(String.format("请求URL------%s on %s%n请求头------%s",
                request.url(), chain.connection(), request.headers()));

        Response response = chain.proceed(request);
        //受到相应的时间
        long t2 = System.nanoTime();

        //这里不能直接使用response.body().string()的方式输出日志
        //因为response.body().string()之后，response中的流会被关闭，程序会报错，我们需要创建出一
        //个新的response给应用层处理
        ResponseBody responseBody = response.peekBody(1024 * 1024);
        LogUtils.e(String.format("响应URL-------: %s %n响应数据------%s 请求用时--------%.1fms%n%s",
                response.request().url(), responseBody.string(), (t2 - t1) / 1e6d, response.headers()));
        return response;
    }
}
