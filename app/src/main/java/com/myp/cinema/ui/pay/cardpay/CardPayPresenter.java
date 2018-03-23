package com.myp.cinema.ui.pay.cardpay;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.CardBO;
import com.myp.cinema.entity.PayCardBO;
import com.myp.cinema.entity.ResuBo;
import com.myp.cinema.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class CardPayPresenter extends BasePresenterImpl<CardPayContract.View>
        implements CardPayContract.Presenter {


    @Override
    public void loadCardUser() {
        HttpInterfaceIml.cardUser().subscribe(new Subscriber<List<CardBO>>() {
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
            public void onNext(List<CardBO> s) {
                if (mView == null)
                    return;
                mView.getCardList(s);
            }
        });
    }

    @Override
    public void loadCardPay(final String orderNum, String card) {
        HttpInterfaceIml.cardPayPrice(orderNum, card).subscribe(new Subscriber<PayCardBO>() {
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
            public void onNext(PayCardBO s) {
                if (mView == null)
                    return;
                mView.getCardPrice(s);
            }
        });
    }

    @Override
    public void payCard(String orderNum, String pwd, String card) {
        HttpInterfaceIml.payCard(orderNum, pwd, card).subscribe(new Subscriber<ResuBo>() {
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
            public void onNext(ResuBo s) {
                if (mView == null)
                    return;
                mView.getPayCard(s);
            }
        });
    }
}
