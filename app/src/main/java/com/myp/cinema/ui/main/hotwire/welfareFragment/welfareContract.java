package com.myp.cinema.ui.main.hotwire.welfareFragment;

import com.myp.cinema.entity.HotWireBO;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;

import java.util.List;

/**
 * Created by Administrator on 2018/2/11.
 */

public class welfareContract {
    interface View extends BaseRequestView {

        void getHotWire(List<HotWireBO> hotWireBOs, int flpage, String articleType);
    }

    interface Presenter extends BasePresenter<View> {

        void loadHotWire(String articleType, int flpage, String cinemaId);
    }
}
