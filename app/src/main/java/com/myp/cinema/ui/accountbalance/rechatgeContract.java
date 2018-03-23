package com.myp.cinema.ui.accountbalance;

import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;

import java.util.List;

/**
 * Created by Administrator on 2018/1/27.
 */

public class rechatgeContract{
    interface View extends BaseRequestView {



        void getRechat(List<RechatBo> rechats);

    }

interface Presenter extends BasePresenter<View> {

    void rechatgejine();

}
}