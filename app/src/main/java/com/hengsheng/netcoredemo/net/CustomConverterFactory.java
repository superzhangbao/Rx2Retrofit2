package com.hengsheng.netcoredemo.net;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by zhangb on 2018/5/2/02
 * 自定义数据解析器
 * 假设服务端返回的数据格式是：username=张三&male=男性,我们的需求是希望在客户端对其解析后，将其放进一个Map里面。
 * 创建一个继承自Converter.Factory的类，然后提供自己的Converter实例就行了。
 */

public class CustomConverterFactory extends Converter.Factory {

    public static CustomConverterFactory create() {
        return new CustomConverterFactory();
    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new CustomConverter();
    }


    class CustomConverter implements Converter<ResponseBody,Map<String,String>> {

        @Override
        public Map<String, String> convert(@NonNull ResponseBody body) throws IOException {
            Map<String,String> map = new HashMap<>();
            String content = body.string();
            String[] keyValues = content.split("&");
            for (String keyValue : keyValues) {
                int postion = keyValue.indexOf("=");
                String key = keyValue.substring(0, postion);
                String value = keyValue.substring(postion + 1, keyValue.length());
                map.put(key, value);
            }
            return map;
        }
    }
}
