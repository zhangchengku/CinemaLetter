package com.myp.cinema.ui.membercard1;

import android.content.Context;
import android.util.Log;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.CardBO;
import com.myp.cinema.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MemberCard1Presenter extends BasePresenterImpl<MemberCard1Contract.View> implements MemberCard1Contract.Presenter{
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
                Log.d("会员卡列表bug", "onNext: "+s.size());
                if (mView == null)
                    return;
                mView.getCardList(s);
            }
        });
    }
}
