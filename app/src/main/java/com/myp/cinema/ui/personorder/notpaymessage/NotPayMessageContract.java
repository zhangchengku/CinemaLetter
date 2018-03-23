package com.myp.cinema.ui.personorder.notpaymessage;

import android.content.Context;

import com.myp.cinema.entity.OrderNumBO;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;
import com.myp.cinema.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class NotPayMessageContract {
    interface View extends BaseRequestView {

        void getOrderCancle(OrderNumBO orderNumBO);
    }

    interface  Presenter extends BasePresenter<View> {
        /**
         * 取消订单
         */
        void orderCancle(String orderNum);
    }
}
