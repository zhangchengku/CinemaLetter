package com.myp.cinema.ui.moviesseattable;

import com.myp.cinema.entity.aCinemaSeatTableBO;
import com.myp.cinema.entity.preferentialnumberBo;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;
import com.myp.cinema.mvp.BaseView;

import java.util.List;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class SeatTableContract {
    interface View extends BaseRequestView {

        void getSeatData(List<aCinemaSeatTableBO> s);
        void getpreferentialnumberBo(preferentialnumberBo s);
    }

    interface Presenter extends BasePresenter<View> {
        void loadSeatTables(String cid, String playId, String updateTime);
        void getsets(String cinemaId, String dxId);
    }
}
