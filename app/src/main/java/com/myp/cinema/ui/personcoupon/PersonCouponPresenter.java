package com.myp.cinema.ui.personcoupon;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.mvp.BasePresenterImpl;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PersonCouponPresenter extends BasePresenterImpl<PersonCouponContract.View>
        implements PersonCouponContract.Presenter {

    @Override
    public void loadPersonCoupon() {
        HttpInterfaceIml.personCoupon().subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {

            }
        });
    }
}
