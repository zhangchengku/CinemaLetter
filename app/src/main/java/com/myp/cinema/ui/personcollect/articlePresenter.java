package com.myp.cinema.ui.personcollect;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.HotWireBO;
import com.myp.cinema.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2018/1/20.
 */

public class articlePresenter extends BasePresenterImpl<articleContract.View>
        implements articleContract.Presenter {


    @Override
    public void loadCollection( final int pageNo) {
        HttpInterfaceIml.articlesCollection(pageNo+"").subscribe(new Subscriber<List<HotWireBO>>() {
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
            public void onNext(List<HotWireBO> s) {
                if (mView == null)
                    return;
                mView.getCollection(s,pageNo);
            }
        });
    }
}
