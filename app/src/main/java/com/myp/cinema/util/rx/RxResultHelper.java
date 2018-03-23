package com.myp.cinema.util.rx;

import android.util.Log;

import com.myp.cinema.entity.BaseDingResult;
import com.myp.cinema.entity.BaseResult;
import com.myp.cinema.util.LogUtils;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 作者 by wuliang 时间 16/11/24.
 * <p>
 * 此类用于对请求返回的数据解析并判断筛选
 */

public class RxResultHelper {

    private static final String TAG = "RxResultHelper";

    public static <T> Observable.Transformer<BaseResult<T>, T> httpRusult() {
        return new Observable.Transformer<BaseResult<T>, T>() {
            @Override
            public Observable<T> call(Observable<BaseResult<T>> apiResponseObservable) {
                return apiResponseObservable.flatMap(
                        new Func1<BaseResult<T>, Observable<T>>() {
                            @Override
                            public Observable<T> call(BaseResult<T> result) {
                                LogUtils.E("请求报错啦！！！"+result.getStatus());
                                if (result.surcess()) {
                                    Log.d("res请求报错啦", "call: "+result.getData());
                                    return createData(result.getData());

                                } else {
                                        LogUtils.E("请求报错啦！！！");
                                        return Observable.error(new RuntimeException(result.getMessage()));
                                }
                            }
                        }
                ).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


    /**
     * 鼎新接口筛选
     *
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<BaseDingResult<T>, T> httpDingRusult() {
        return new Observable.Transformer<BaseDingResult<T>, T>() {
            @Override
            public Observable<T> call(Observable<BaseDingResult<T>> apiResponseObservable) {
                return apiResponseObservable.flatMap(
                        new Func1<BaseDingResult<T>, Observable<T>>() {
                            @Override
                            public Observable<T> call(BaseDingResult<T> result) {
                                Log.d(TAG, "call() called with: result = [" + result + "]");
                                if (result.getRes().surcess()) {
                                    return createData(result.getRes().getData());
                                } else {
                                    LogUtils.E("请求报错啦！！！");
                                    return Observable.error(new RuntimeException(result.getRes().getErrorMessage()));
                                }
                            }
                        }
                ).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


    private static <T> Observable<T> createData(final T t) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(t);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
