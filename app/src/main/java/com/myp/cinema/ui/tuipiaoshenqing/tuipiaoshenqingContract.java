package com.myp.cinema.ui.tuipiaoshenqing;

import com.myp.cinema.api.RefundBO;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;

/**
 * Created by Administrator on 2018/2/5.
 */

public class tuipiaoshenqingContract {
        interface View extends BaseRequestView {
            void getrefundinfo(RefundBO refundBO);
            void getrefund(RefundBO orderMessage);

        }

        interface Presenter extends BasePresenter<View> {

            void refundinfo(String id );
            void refund(String id ,String cinemaId);

        }
    }

