package com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.common;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.hengsheng.netcoredemo.net.retrofit2andrxjava2.net.dialog.DialogUtils;

import java.lang.ref.WeakReference;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by zhangb on 2018/6/6/006
 */

public class ProgressUtils {
    public static <T> ObservableTransformer<T,T> applyProgressBar(@NonNull final Activity activity, String msg) {
        final WeakReference<Activity> activityWeakReference = new WeakReference<>(activity);
        final DialogUtils dialogUtils = new DialogUtils();
        dialogUtils.showProgress(activityWeakReference.get());
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {

                    }
                }).doOnTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        Activity context;
                        if ((context = activityWeakReference.get()) != null && !context.isFinishing()) {
                            dialogUtils.dismissProgress();
                        }
                    }
                }).doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {

                    }
                });
            }
        };
    }

    public static <T> ObservableTransformer<T,T> applyProgressBar(final Activity activity){
        return applyProgressBar(activity,"");
    }
}
