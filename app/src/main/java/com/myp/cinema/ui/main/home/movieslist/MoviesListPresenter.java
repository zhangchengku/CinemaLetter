package com.myp.cinema.ui.main.home.movieslist;

import android.util.Log;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.LunBoAndBO;
import com.myp.cinema.entity.LunBoBO;
import com.myp.cinema.entity.MoviesByCidBO;
import com.myp.cinema.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MoviesListPresenter extends BasePresenterImpl<MoviesListContract.View>
        implements MoviesListContract.Presenter {


    @Override
    public void moviesHot(String cinemaId) {
        Log.d("mainactivityonError", "onError: 进来了");
        HttpInterfaceIml.moviesHot(cinemaId).subscribe(new Subscriber<List<MoviesByCidBO>>() {
            @Override
            public void onCompleted() {
                if (mView == null)
                    return;
                mView.onRequestEnd();
            }

            @Override
            public void onError(Throwable e) {
                Log.d("mainactivityonError", "onError: "+e.getMessage());
                if (mView == null)
                    return;
                mView.onRequestError(e.getMessage());
            }

            @Override
            public void onNext(List<MoviesByCidBO> s) {
                Log.d("mainactivityonError", "onError: "+s);
                if (mView == null)
                    return;

                mView.getMoviesHot(s);
            }
        });
    }

    @Override
    public void lunboList(String souce, String cinemaId) {
        HttpInterfaceIml.lunboandList(souce, cinemaId).subscribe(new Subscriber<LunBoAndBO>() {
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
            public void onNext(LunBoAndBO lunBoAndBOs) {
                if (mView == null)
                    return;
                mView.getLunBo(lunBoAndBOs);
            }
        });
    }
}
