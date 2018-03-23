package com.myp.cinema.ui.personorder;

import com.myp.cinema.entity.OrderBO;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;

import java.util.List;

/**
 * Created by Administrator on 2018/2/11.
 */

public class completedContract {
    interface View extends BaseRequestView {

        void getOrderList(List<OrderBO> orderList, int page);
    }

    interface Presenter extends BasePresenter<completedContract.View> {

        void loadOrderList( int page );
    }
}
