package com.myp.cinema.ui.tuipiaoshenqing;

import android.util.Log;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.api.RefundBO;
import com.myp.cinema.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2018/2/5.
 */

public class tuipiaoshenqingPresenter  extends BasePresenterImpl<tuipiaoshenqingContract.View> implements tuipiaoshenqingContract.Presenter{
    @Override
    public void refundinfo(String id) {

        HttpInterfaceIml.refundinfo(id).subscribe(new Subscriber<RefundBO>() {
            @Override
            public void onCompleted() {
                if (mView == null)
                    return;
                mView.onRequestEnd();
            }

            @Override
            public void onError(Throwable e) {
                Log.d("退票详情", "onNext: "+e);
                if (mView == null)
                    return;
                mView.onRequestError(e.getMessage());
            }

            @Override
            public void onNext(RefundBO s) {
                mView.getrefundinfo(s);
            }
        });

    }
    @Override
    public void refund(String id,String cinemaId) {

        HttpInterfaceIml.refund(id,cinemaId).subscribe(new Subscriber<RefundBO>() {
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
            public void onNext(RefundBO s) {
                    mView.getrefund(s);


            }
        });

    }
}
