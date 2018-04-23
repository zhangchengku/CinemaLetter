package com.myp.cinema.ui.detailed;

import android.util.Log;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.RechBo;
import com.myp.cinema.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2018/1/28.
 */

public class rechargefragmentPresenter extends BasePresenterImpl<rechargefragmenteContract.View>
        implements rechargefragmenteContract.Presenter {
    @Override
    public void loadRecharge( final int pageNo,String cardNum) {
        HttpInterfaceIml.loadRecharge(pageNo+"",cardNum).subscribe(new Subscriber<List<RechBo>>() {
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

                Log.d("chognzhimignxi", "onNext: "+e);
            }

            @Override
            public void onNext(List<RechBo> s) {
                Log.d("chognzhimignxi充值明细", "onNext: "+s);
                Log.d("chognzhimignxi充值明细", "充值明细: "+pageNo);
                if (mView == null)
                    return;
                mView.getRecharge(s,pageNo);
            }


        });
    }
}
