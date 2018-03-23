package com.myp.cinema.ui.personorder.ordermessage;

import android.content.Context;

import com.myp.cinema.entity.Bean;
import com.myp.cinema.entity.OrderMessageBO;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;
import com.myp.cinema.mvp.BaseView;

import java.util.List;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class OrderMessageContract {
    interface View extends BaseRequestView {

        void getOrderMessageList(Bean orderMessage);
    }

    interface Presenter extends BasePresenter<View> {

        void loadOrderMessage(String id, String cinemaId );
    }
}
