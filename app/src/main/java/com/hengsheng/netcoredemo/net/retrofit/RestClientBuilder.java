package com.hengsheng.netcoredemo.net.retrofit;


import com.hengsheng.netcoredemo.net.retrofit.callback.IError;
import com.hengsheng.netcoredemo.net.retrofit.callback.IFailure;
import com.hengsheng.netcoredemo.net.retrofit.callback.IRequest;
import com.hengsheng.netcoredemo.net.retrofit.callback.ISuccess;

import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by zhangb on 2018/6/6/06
 */

public class RestClientBuilder {
    private String mUrl;
    private static final Map<String,Object> PARAMS = RestCreator.getParams();
    private IRequest mIRequest;
    private ISuccess mISuccess;
    private IError mIERROR;
    private IFailure mIFailure;
    private RequestBody mRequestBody;

     RestClientBuilder() {
    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(Map<String,Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key,value);
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mRequestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"),raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        this.mIERROR = iError;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure) {
        this.mIFailure = iFailure;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl,PARAMS,mIRequest,mISuccess,mIERROR,mIFailure,mRequestBody);
    }
}
