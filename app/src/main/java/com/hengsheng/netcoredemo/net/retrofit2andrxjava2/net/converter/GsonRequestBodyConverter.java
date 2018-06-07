/*
 * Copyright (C) 2015 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.utils.Base64Utils;
import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.utils.LogUtils;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * Created by zhangb on 2018/6/6/006
 */

final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private final Gson gson;
    private final TypeAdapter<T> adapter;
    private JSONObject requestObject;

    /**
     * 构造器
     */
    GsonRequestBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override
    public RequestBody convert(T value) throws IOException {
        //对requestbody做数据加密处理
        try {
            String postParams = Base64Utils.randomHexString()+Base64Utils.getBase64(value.toString());
            LogUtils.e(postParams);
            if (requestObject == null) {
                requestObject = new JSONObject();
            }
            requestObject.put("mark",postParams);
            LogUtils.e(requestObject.toString());
            return RequestBody.create(MEDIA_TYPE, requestObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

//        Buffer buffer = new Buffer();
//        Writer writer = new OutputStreamWriter(buffer.outputStream(), UTF_8);
//        JsonWriter jsonWriter = gson.newJsonWriter(writer);
//        adapter.write(jsonWriter, value);
//        jsonWriter.close();
//        return RequestBody.create(MEDIA_TYPE, buffer.readByteString());
    }
}
