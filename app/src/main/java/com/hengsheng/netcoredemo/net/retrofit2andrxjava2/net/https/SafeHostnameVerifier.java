package com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.https;


import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.common.Constants;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;


/**
 * Created by zhpan on 2018/3/21.
 */

public class SafeHostnameVerifier implements HostnameVerifier {
    @Override
    public boolean verify(String hostname, SSLSession session) {
        if (Constants.IP.equals(hostname)) {//校验hostname是否正确，如果正确则建立连接
            return true;
        }
        return false;
    }
}
