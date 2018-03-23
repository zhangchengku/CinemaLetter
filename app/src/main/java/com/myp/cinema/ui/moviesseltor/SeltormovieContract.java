package com.myp.cinema.ui.moviesseltor;

import com.myp.cinema.entity.CinemaBo;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;

import java.util.List;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class SeltormovieContract {
    interface View extends BaseRequestView {

        void onData(List<CinemaBo> cinemaIdBOs);

    }

    interface Presenter extends BasePresenter<View> {

        /**
         * 获取影厅列表
         */
        void loadCinemaIds(String city,String location,String lacation);
    }
}
