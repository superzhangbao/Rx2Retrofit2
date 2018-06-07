package com.hengsheng.netcoredemo.net.retrofit;


import com.hengsheng.netcoredemo.net.retrofit.callback.IError;
import com.hengsheng.netcoredemo.net.retrofit.callback.IFailure;
import com.hengsheng.netcoredemo.net.retrofit.callback.IRequest;
import com.hengsheng.netcoredemo.net.retrofit.callback.ISuccess;
import com.hengsheng.netcoredemo.net.retrofit.callback.RequestCallback;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by zhangb on 2018/6/5/005
 */

public class RestClient {

    private final String URL;
    private static final Map<String,Object> PARAMS = RestCreator.getParams();
    private final IRequest IREQUEST;
    private final ISuccess ISUCCESS;
    private final IError IERROR;
    private final IFailure IFAILURE;
    private final RequestBody REQUESTBODY;

    public RestClient(String url,
                      Map<String, Object> params,
                      IRequest iRequest,
                      ISuccess iSuccess,
                      IError iError,
                      IFailure iFailure,
                      RequestBody requestBody) {
        URL = url;
        PARAMS.putAll(params);
        IREQUEST = iRequest;
        ISUCCESS = iSuccess;
        IERROR = iError;
        IFAILURE = iFailure;
        REQUESTBODY = requestBody;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HttpMethod httpMethod) {
        final RestService service = RestCreator.getRestService();
        Call<String> call = null;
        if (IREQUEST != null) {
            IREQUEST.onRequestStart();
        }

        switch (httpMethod) {
            case GET:
                call = service.get(URL,PARAMS);
                break;
            case POST:
                call = service.post(URL,PARAMS);
                break;
            case PUT:
                call = service.put(URL,PARAMS);
                break;
            case DELETE:
                call = service.delete(URL,PARAMS);
                break;
            case MYPOST:
                break;
                default:
                    break;
        }

        if (call != null) {
            call.enqueue(getRequestCallback());
        }
    }

    private Callback<String> getRequestCallback() {
        return new RequestCallback(IREQUEST,ISUCCESS,IERROR,IFAILURE);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        request(HttpMethod.POST);
    }

    public final void put() {
        request(HttpMethod.PUT);
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }
}
