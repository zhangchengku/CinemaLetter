package com.myp.cinema.ui.main.hotwire;

import com.myp.cinema.entity.HotWireBO;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;

import java.util.List;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class HotwireContract {
    interface View extends BaseRequestView {

        void getHotWire(List<HotWireBO> hotWireBOs,int flpage,String articleType);
    }

    interface Presenter extends BasePresenter<View> {

        void loadHotWire(String articleType, int flpage, String cinemaId);
    }
}
