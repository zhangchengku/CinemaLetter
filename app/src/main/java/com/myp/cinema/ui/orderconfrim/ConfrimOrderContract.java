package com.myp.cinema.ui.orderconfrim;

import com.myp.cinema.entity.OrderBO;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;
import com.myp.cinema.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class ConfrimOrderContract {
    interface View extends BaseRequestView {

        void getOrder(OrderBO orderBO);

    }

    interface Presenter extends BasePresenter<View> {

        void loadSubmitOrder(
                             String orderName,      //联系人姓名（可不传）
                             String seats,              //座位连接
                             String ticketNum,       //票数量
                             String ticketOriginPrice,   //总价
                             String cinemaNumber,     //广电总局影院唯一编码
                             String hallId,              //鼎新影厅id
                             String playId,               //鼎新场次id
                             String cineMovieNum,     //广电总局规定的影片全国唯一编码
                             String seatId);

    }
}
