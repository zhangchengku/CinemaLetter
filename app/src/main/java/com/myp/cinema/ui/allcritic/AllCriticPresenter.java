package com.myp.cinema.ui.allcritic;

import android.util.Log;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.CriticBO;
import com.myp.cinema.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2018/2/27.
 */

public class AllCriticPresenter extends BasePresenterImpl<AllCriticContract.View>
        implements AllCriticContract.Presenter {
    @Override
    public void loadMoviesCritic(Long movieId, final int pageNo) {
        HttpInterfaceIml.criticMovie(movieId,pageNo,20).subscribe(new Subscriber<List<CriticBO>>() {
            @Override
            public void onCompleted() {
                if (mView != null) {
                    mView.onRequestEnd();
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d("电影评论数据", "onError: "+e.getMessage());
                if (mView != null) {
                    mView.onRequestError(e.getMessage());
                }
            }

            @Override
            public void onNext(List<CriticBO> s) {
                Log.d("电影评论数据", "onNext: "+s.size());
                if (mView != null) {
                    mView.getCritic(s,pageNo);
                }
            }
        });
    }
    @Override
    public void loadDianZan(Long Id, final int position) {
        HttpInterfaceIml.dianZan(Id).subscribe(new Subscriber<CriticBO>() {
            @Override
            public void onCompleted() {
                if (mView != null) {
                    mView.onRequestEnd();
                }
            }

            @Override
            public void onError(Throwable e) {
                Log.d("电影评论数据", "onError: "+e.getMessage());
                if (mView != null) {
                    mView.onRequestError(e.getMessage());
                }
            }

            @Override
            public void onNext(CriticBO s) {
                Log.d("点赞数据", "onNext: "+s.getUpvoteStatus());
                if (mView != null) {
                    mView.getDianZan(s,position);
                }
            }
        });
    }
}
