package com.hengsheng.netcoredemo.net.retrofit2andrxjava2.apiservice;

import com.hengsheng.netcoredemo.bean.H191_APP_LOGIN;
import com.hengsheng.netcoredemo.bean.H191_APP_SMSCODE_SND;
import com.hengsheng.netcoredemo.bean.MeiZi;

import org.json.JSONObject;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by zhangb on 2018/6/6/006
 */

public interface ApiService {
    /**
     * 此接口服务器响应数据BasicResponse的泛型T应该是List<MeiZi>
     * 即BasicResponse<List<MeiZi>>
     * @return BasicResponse<List<MeiZi>>
     */
    @Headers("Cache-Control: public, max-age=10")//设置缓存 缓存时间为100s
    @GET("福利/10/1")
    Observable<List<MeiZi>> getMezi();

    @POST("hspc_app/interface/public/pcom.php")
    Observable<H191_APP_SMSCODE_SND> getVerificationCode(@Body JSONObject jsonObject);

    @POST("hspc_app/interface/public/pcom.php")
    Observable<H191_APP_LOGIN> login(@Body JSONObject jsonObject);
}
