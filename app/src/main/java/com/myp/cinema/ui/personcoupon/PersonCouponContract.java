package com.myp.cinema.ui.personcoupon;

import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;
import com.myp.cinema.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PersonCouponContract {
    interface View extends BaseRequestView {

        void getCoupon(Object object);
    }

    interface Presenter extends BasePresenter<View> {

        void loadPersonCoupon();
    }
}
