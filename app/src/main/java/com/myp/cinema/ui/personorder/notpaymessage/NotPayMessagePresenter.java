package com.myp.cinema.ui.personorder.notpaymessage;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.OrderNumBO;
import com.myp.cinema.mvp.BasePresenterImpl;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class NotPayMessagePresenter extends BasePresenterImpl<NotPayMessageContract.View>
        implements NotPayMessageContract.Presenter {


    @Override
    public void orderCancle(String orderNum) {
        HttpInterfaceIml.orderCancle(orderNum).subscribe(new Subscriber<OrderNumBO>() {
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
            public void onNext(OrderNumBO orderNumBO) {
                if (mView == null)
                    return;
                mView.getOrderCancle(orderNumBO);
            }
        });
    }
}
