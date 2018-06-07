package com.hengsheng.netcoredemo.net.retrofit2andrxjava2.utils;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * Created by zhangb on 2018/1/8/008.
 */

public class Base64Utils {

    // 加密
    public static String getBase64(String str) {
        String result = "";
        if( str != null) {
            try {
                result = new String(Base64.encode(str.getBytes("utf-8"), Base64.DEFAULT),"utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    // 解密
    public static String getFromBase64(String str) {
        String result = "";
        if (str != null) {
            try {
                result = new String(Base64.decode(str, Base64.DEFAULT), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 获取16进制随机数
     */
    public static String randomHexString()  {
        try {
            StringBuilder result = new StringBuilder();
            Random random = new Random();
            String s;
            for(int i=0;i<5;i++) {
                s = Integer.toHexString(random.nextInt(16));
                if (i == 0) {
                    if (s.equals("0")) {
                        i=-1;
                    }else {
                        result.append(s);
                    }
                }else {
                    result.append(s);
                }
            }
            return result.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }
}
