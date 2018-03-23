package com.myp.cinema.ui.selectorcity;

import com.myp.cinema.entity.CityBO;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;

import java.util.List;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class SelectorCityContract {
    interface View extends BaseRequestView {

        void getCityList(List<CityBO> cityBOs);
    }

    interface Presenter extends BasePresenter<View> {


        void loadCityList();

    }
}
