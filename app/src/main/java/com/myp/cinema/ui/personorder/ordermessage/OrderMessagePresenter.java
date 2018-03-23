package com.myp.cinema.ui.personorder.ordermessage;

import android.content.Context;
import android.util.Log;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.Bean;
import com.myp.cinema.entity.OrderMessageBO;
import com.myp.cinema.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class OrderMessagePresenter extends BasePresenterImpl<OrderMessageContract.View> implements OrderMessageContract.Presenter{
    @Override
    public void loadOrderMessage( String id, String cinemaId) {
        HttpInterfaceIml.orderMessage(id,cinemaId ).subscribe(new Subscriber<Bean>() {
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
            public void onNext(Bean s) {
                if(s.getStatus()==1){
                    mView.getOrderMessageList(s);
                }


            }
        });
    }
}
