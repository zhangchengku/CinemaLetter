package com.myp.cinema.ui.balance;

import com.myp.cinema.entity.RechBo;
import com.myp.cinema.entity.SumptionBo;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;

import java.util.List;

/**
 * Created by Administrator on 2018/1/28.
 */

public class onsumptiondetailContract {
    interface View extends BaseRequestView {
        void getcosumption(List<SumptionBo> sumptionBo,int pageNo);

    }

    interface Presenter extends BasePresenter<View> {

        void loadcosumption(int pageNo,String cardNum);
    }
}

