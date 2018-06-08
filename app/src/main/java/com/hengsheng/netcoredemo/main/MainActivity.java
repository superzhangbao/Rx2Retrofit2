package com.hengsheng.netcoredemo.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hengsheng.netcoredemo.R;
import com.hengsheng.netcoredemo.bean.H191_APP_LOGIN;
import com.hengsheng.netcoredemo.bean.H191_APP_SMSCODE_SND;
import com.hengsheng.netcoredemo.bean.MeiZi;
import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.common.DefaultObserver;
import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.common.ProgressUtils;
import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.common.RetrofitClient;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private String mJ2;
    private Button mButton,mBtnRxjava2;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        mButton = findViewById(R.id.btn);
        mBtnRxjava2 = findViewById(R.id.btn_rxjava2_demo);
        mButton.setOnClickListener(this);
        mBtnRxjava2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
//        getMeizi();
                test();
                break;
            case R.id.btn_rxjava2_demo:
                startActivity(new Intent(this,Rxjava2Activity.class));
                break;
        }
    }

    private void test() {


        final JSONObject login = new JSONObject();
        try {
            login.put("devid", "ARDa367824a38e3e47ac64d3895fa70215d");
            login.put("exCode", Configuration.H191_APP_LOGIN);
            login.put("j1", Configuration.H191_APP_LOGIN);
            login.put("j2", "15056006309");
            login.put("j3", mJ2);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        //loadingview
        //                .compose(ProgressUtils.<H191_APP_SMSCODE_SND>applyProgressBar(this))


        JSONObject map = new JSONObject();
        try {
            map.put("devid", "ARDa367824a38e3e47ac64d3895fa70215d");
            map.put("exCode", Configuration.H191_APP_SMSCODE_SND);
            map.put("j1", "15056006309");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RetrofitClient.getApiService()
                .getVerificationCode(map)
                .compose(ProgressUtils.<H191_APP_SMSCODE_SND>applyProgressBar(this))
                .compose(this.<H191_APP_SMSCODE_SND>bindToLifecycle())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<H191_APP_SMSCODE_SND, ObservableSource<H191_APP_LOGIN>>() {
                    @Override
                    public ObservableSource<H191_APP_LOGIN> apply(H191_APP_SMSCODE_SND h191_app_smscode_snd) throws Exception {
                        mJ2 = "886033";
                        return RetrofitClient.getApiService().login(login);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultObserver<H191_APP_LOGIN>() {
                    @Override
                    public void onSuccess(H191_APP_LOGIN response) {
                        Toast.makeText(MainActivity.this, response.message, Toast.LENGTH_LONG).show();
                    }
                });
    }

    private void getMeizi() {
        RetrofitClient.getApiService()
                .getMezi()
                .compose(this.<List<MeiZi>>bindToLifecycle())
                .compose(ProgressUtils.<List<MeiZi>>applyProgressBar(this))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DefaultObserver<List<MeiZi>>() {
                    @Override
                    public void onSuccess(List<MeiZi> response) {
                        showToast("请求成功，妹子个数为" + response.size());
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                    }
                });
    }
}
