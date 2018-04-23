package com.myp.cinema.ui.rechatge;

import android.util.Log;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.RechatBo;
import com.myp.cinema.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2018/1/27.
 */

public class rechatgePresenter extends BasePresenterImpl<rechatgeContract.View>
        implements rechatgeContract.Presenter {
    @Override
    public void rechatgejine() {
        HttpInterfaceIml.rechatgejine().subscribe(new Subscriber<List<RechatBo>>() {
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
            public void onNext(List<RechatBo> rechatBos) {
                Log.d("rechatgePresenter", "rechatgePresenter "+rechatBos);
                if (mView == null)
                    return;
                mView.getRechat(rechatBos);

            }



        });
    }




}
