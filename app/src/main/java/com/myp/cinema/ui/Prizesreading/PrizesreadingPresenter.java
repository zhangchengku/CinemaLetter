package com.myp.cinema.ui.Prizesreading;

import android.util.Log;

import com.myp.cinema.api.HttpInterface;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.mvp.BasePresenterImpl;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;

/**
 * Created by Administrator on 2018/1/24.
 */

public class PrizesreadingPresenter extends BasePresenterImpl<PrizesreadingContract.View>
        implements PrizesreadingContract.Presenter {

    private Object data;
    private ArrayList<HomeTopBean> list;


    @Override
    public void loadTaskList(final int pageNo) {
        HttpInterfaceIml.getList(pageNo+"").subscribe(new Subscriber<HomeTopBean>() {
            @Override
            public void onCompleted() {
                if (mView == null)
                    return;
                mView.onRequestEnd();
            }

            @Override
            public void onError(Throwable e) {
                if (mView == null)
                    return;
                mView.onRequestError(e.getMessage());
            }

            @Override
            public void onNext(HomeTopBean s) {
                if (mView != null) {
                    mView.getTaskList(s.getData(),pageNo);
                }
            }
        });
    }
}

