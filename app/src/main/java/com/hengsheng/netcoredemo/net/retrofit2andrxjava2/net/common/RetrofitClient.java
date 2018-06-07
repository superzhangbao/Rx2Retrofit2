package com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hengsheng.netcoredemo.net.okhttp.https.HttpsUtils;
import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.apiservice.ApiService;
import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.converter.GsonConverterFactory;
import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.interceptor.HttpCacheInterceptor;
import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.interceptor.HttpHeaderInterceptor;
import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.interceptor.LoggingInterceptor;
import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.utils.Utils;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by zhangb on 2018/6/6/006
 */

public class RetrofitClient {

    public static ApiService getApiService() {
        return IdeaApiServiceHolder.API_SERVICE;
    }

    private static final class OkHttpHolder {
        private static final int TIME_OUT = 60;
        private static final File cacheFile = new File(Utils.getContext().getCacheDir(), "cache");
        private static final Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb

        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(new LoggingInterceptor())
                .addInterceptor(new HttpHeaderInterceptor())
                .addNetworkInterceptor(new HttpCacheInterceptor())
                .followRedirects(true)
                .cache(cache)
                //https支持
                .sslSocketFactory(HttpsUtils.initSSLSocketFactory())
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                })
                .build();
    }

    private static final class RetrofitHolder {
        private static final String BASE_URL = "http://172.16.30.191:1080/";
        private static final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();
        private static final Retrofit RETROFIT_client = new Retrofit.Builder()
                .client(OkHttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }

    private static final class IdeaApiServiceHolder {
        private static final ApiService API_SERVICE = RetrofitHolder.RETROFIT_client.create(ApiService.class);
    }


//    public static OkHttpClient.Builder getOkHttpClientBuilder(){
//
//        File cacheFile = new File(Utils.getContext().getCacheDir(), "cache");
//        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb
//
//        return new OkHttpClient.Builder()
//                .readTimeout(60, TimeUnit.SECONDS)
//                .connectTimeout(60, TimeUnit.SECONDS)
//                .addInterceptor(new LoggingInterceptor())
//                .addInterceptor(new HttpHeaderInterceptor())
//                .addNetworkInterceptor(new HttpCacheInterceptor())
//                .followRedirects(true)
//                .cache(cache)
//                //https支持
//                 .sslSocketFactory(SslContextFactory.getSSLSocketFactoryForTwoWay())  // https认证 如果要使用https且为自定义证书 可以去掉这两行注释，并自行配制证书。
//                 .hostnameVerifier(new SafeHostnameVerifier())
//                .sslSocketFactory(HttpsUtils.initSSLSocketFactory())
//                .hostnameVerifier(new HostnameVerifier() {
//                    @Override
//
//                    public boolean verify(String hostname, SSLSession session) {
//                        return true;
//                    }
//                });
//
//    }
//
//    public static Retrofit.Builder getRetrofitBuilder(String baseUrl) {
//        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();
//        OkHttpClient okHttpClient = RetrofitClient.getOkHttpClientBuilder().build();
//        return new Retrofit.Builder()
//                .client(okHttpClient)
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .baseUrl(baseUrl);
//    }

}
