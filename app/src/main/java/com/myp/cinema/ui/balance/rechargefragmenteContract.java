package com.myp.cinema.ui.balance;

import com.myp.cinema.entity.HotWireBO;
import com.myp.cinema.entity.RechBo;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;

import java.util.List;

/**
 * Created by Administrator on 2018/1/28.
 */

public class rechargefragmenteContract {
    interface View extends BaseRequestView {
        void getRecharge(List<RechBo> rechBo,int pageNo);

    }

    interface Presenter extends BasePresenter<View> {

        void loadRecharge(int pageNo,String cardNum);
    }
}

