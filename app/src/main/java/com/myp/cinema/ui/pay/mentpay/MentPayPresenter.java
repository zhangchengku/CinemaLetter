package com.myp.cinema.ui.pay.mentpay;

import android.util.Log;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.PayBO;
import com.myp.cinema.entity.ResuBo;
import com.myp.cinema.entity.WXPayBO;
import com.myp.cinema.mvp.BasePresenterImpl;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MentPayPresenter extends BasePresenterImpl<MentPayContract.View>
        implements MentPayContract.Presenter {

    @Override
    public void loadAliPay(String orderNum) {
        HttpInterfaceIml.payAlipay(orderNum).subscribe(new Subscriber<PayBO>() {
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
            public void onNext(PayBO s) {
                if (mView == null)
                    return;
                mView.getAliPay(s);
            }
        });
    }

    @Override
    public void loadWeChatPay(String orderNum) {
        HttpInterfaceIml.payWeChat(orderNum).subscribe(new Subscriber<WXPayBO>() {
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
            public void onNext(WXPayBO s) {
                if (mView == null)
                    return;
                mView.getWxPay(s);
            }
        });
    }
    @Override
    public void loadcardPay(String orderNum,String coupon) {
        HttpInterfaceIml.loadcardPay(orderNum,coupon).subscribe(new Subscriber<ResuBo>() {
            @Override
            public void onCompleted() {
                if (mView == null)
                    return;
                mView.onRequestEnd();
            }

            @Override
            public void onError(Throwable e) {
                Log.d("Throwable", "onError: "+e.getMessage());
                if (mView == null)
                    return;
                mView.onRequestError(e.getMessage());
            }

            @Override
            public void onNext(ResuBo s) {
                Log.d("Throwable", "onError: "+s);
                if (mView == null)
                    return;
                mView.getcardPay(s);
            }
        });
    }


}
