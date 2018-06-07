package com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.interceptor;

import android.support.annotation.NonNull;

import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.utils.LogUtils;
import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.utils.NetworkUtils;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhangb on 2018/6/6/006
 */

public class HttpCacheInterceptor implements Interceptor {
    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request request = chain.request();
        if (!NetworkUtils.isConnected()) {//没网强制从缓存读取
            request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
            LogUtils.d("Retrofit2---->", "no network");
        }

        Response response = chain.proceed(request);
        if (NetworkUtils.isConnected()) {
            //有网的时候读接口上的@Headers里的配置，可以在这里进行统一的设置
            String cacheControl = request.cacheControl().toString();

            return response.newBuilder()
                    .header("Cache-Control",cacheControl)
                    .removeHeader("Pragma")
                    .build();
        }else {
            return response.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
                    .removeHeader("Pragma")
                    .build();
        }
    }
}
