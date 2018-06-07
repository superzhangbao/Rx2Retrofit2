package com.hengsheng.netcoredemo.net.okhttp;

import com.hengsheng.netcoredemo.net.okhttp.https.HttpsUtils;
import com.hengsheng.netcoredemo.net.okhttp.response.CommonJsonCallback;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by zhangb on 2018/6/5/05
 * 请求的发送，请求参数的配置，https的支持
 */

public class CommonOkHttpClient {
    private static final int TIME_OUT = 30;//超时参数
    private static OkHttpClient mOkHttpClient;

    //为client配置参数
    static {
        OkHttpClient.Builder mOkHttpClientBuilder = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor())
                //设置超时时间
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .followRedirects(true)
                //https支持
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                })
                .sslSocketFactory(HttpsUtils.initSSLSocketFactory());

        //生成client对象
        mOkHttpClient = mOkHttpClientBuilder.build();
    }

    /**
     * 发送具体的http/https请求
     *
     * @param request
     * @param commCallback
     * @return
     */
    public static Call sendRequest(Request request, CommonJsonCallback commCallback) {
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(commCallback);
        return call;
    }

}
