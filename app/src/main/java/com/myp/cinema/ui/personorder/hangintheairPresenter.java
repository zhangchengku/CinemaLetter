package com.myp.cinema.ui.personorder;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.OrderBO;
import com.myp.cinema.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2018/2/11.
 */

public class hangintheairPresenter extends BasePresenterImpl<hangintheairContract.View> implements hangintheairContract.Presenter{

    @Override
    public void loadOrderList( final int page) {
        HttpInterfaceIml.orderList("0", page + "").subscribe(new Subscriber<List<OrderBO>>() {
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
            public void onNext(List<OrderBO> s) {
                if (mView == null)
                    return;
                mView.getOrderList(s,  page);
            }
        });
    }
}
