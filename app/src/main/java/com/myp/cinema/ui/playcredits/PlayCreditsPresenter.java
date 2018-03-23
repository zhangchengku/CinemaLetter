package com.myp.cinema.ui.playcredits;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.LunBoBO;
import com.myp.cinema.entity.ShopBO;
import com.myp.cinema.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PlayCreditsPresenter extends BasePresenterImpl<PlayCreditsContract.View>
        implements PlayCreditsContract.Presenter {

//    int pageNo = 1;

    @Override
    public void lunboList(String scoce,String cinemaId) {
        HttpInterfaceIml.lunboList(scoce,cinemaId).subscribe(new Subscriber<List<LunBoBO>>() {
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
            public void onNext(List<LunBoBO> s) {
                if (mView == null)
                    return;
                mView.getLunBo(s);
            }
        });
    }

    @Override
    public void loadCreditsShop(String cinemaId, final int  pageNo) {
        HttpInterfaceIml.creditsShop(pageNo + "", cinemaId).subscribe(new Subscriber<List<ShopBO>>() {
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
            public void onNext(List<ShopBO> s) {
                if (mView != null) {
                    mView.getShopList(s,pageNo);
                }
            }
        });
    }
}
