package com.hengsheng.netcoredemo.net.retrofit.callback;

import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by zhangb on 2018/6/6/006
 */

public class RequestCallback implements Callback<String> {
    private final IRequest IREQUEST;
    private final ISuccess ISUCCESS;
    private final IError IERROR;
    private final IFailure IFAILURE;

    public RequestCallback(IRequest request,
                           ISuccess success,
                           IError error,
                           IFailure failure) {
        this.IREQUEST = request;
        this.ISUCCESS = success;
        this.IERROR = error;
        this.IFAILURE = failure;
    }

    @Override
    public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (ISUCCESS != null) {
                    ISUCCESS.onSuccess(response.body());
                }
            }
        }else {
            if (IERROR != null) {
                IERROR.onError(response.code(),response.message());
            }
        }
    }

    @Override
    public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
        if (IFAILURE != null) {
            IFAILURE.onFailure();
        }
        if (IREQUEST != null) {
            IREQUEST.onRequestEnd();
        }
    }
}
