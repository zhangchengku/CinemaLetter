package com.myp.cinema.ui.personcollect;

import android.util.Log;
import android.view.View;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.MoviesByCidBO;
import com.myp.cinema.mvp.BasePresenterImpl;
import com.myp.cinema.mvp.MVPBaseFragment;

import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2018/1/20.
 */

public class moviePresenter extends BasePresenterImpl<movieContract.View> implements movieContract.Presenter{


    @Override
    public void loadCollectMovie(String appUserId,final  int page) {
        Log.d("retrofit", "进行请求 ");
        HttpInterfaceIml.personCollectList(appUserId,page+"").subscribe(new Subscriber<List<MoviesByCidBO>>() {
            @Override
            public void onCompleted() {
                if (mView != null) {
                    mView.onRequestEnd();
                }
            }

            @Override
            public void onError(Throwable e) {
                if (mView != null) {
                    mView.onRequestError(e.getMessage());
                }
            }

            @Override
            public void onNext(List<MoviesByCidBO> s) {
                if (mView != null) {
                    mView.getCollectList(s,page);
                }
            }
        });
    }
}