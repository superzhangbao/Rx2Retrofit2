package com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.converter;

import com.google.gson.TypeAdapter;
import com.hengsheng.netcoredemo.bean.Mark;
import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.common.BasicResponse;
import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.exception.NoDataExceptionException;
import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.exception.ServerResponseException;
import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.utils.Base64Utils;
import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.utils.JsonUtils;
import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.utils.LogUtils;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by zhangb on 2018/6/6/006
 */

final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, Object> {

    private final TypeAdapter<T> adapter;

    GsonResponseBodyConverter(TypeAdapter<T> adapter) {
        this.adapter = adapter;
    }

    @Override
    public Object convert(ResponseBody value) throws IOException {
        //对返回的数据做解密处理
        try {
            Mark markBean = JsonUtils.parseJsonToBean(value.string(), Mark.class);
            String fromBase64 = Base64Utils.getFromBase64(markBean.mark.substring(5));
            LogUtils.e(fromBase64);
            BasicResponse response = (BasicResponse) adapter.fromJson(fromBase64);
            if (!("0000").equals(response.getCode())) {
                // 特定 API 的错误，在相应的 DefaultObserver 的 onError 的方法中进行处理
                throw new ServerResponseException(response.getCode(), response.getMessage());
            } else {
                if(response.getData()!=null)
                    return response.getData();
                else throw new NoDataExceptionException();
            }
        } finally {
            value.close();
        }
    }
}

