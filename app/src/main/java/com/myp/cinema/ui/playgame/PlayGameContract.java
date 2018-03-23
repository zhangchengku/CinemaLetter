package com.myp.cinema.ui.playgame;

import com.myp.cinema.entity.GameBO;
import com.myp.cinema.entity.LunBoBO;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;

import java.util.List;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PlayGameContract {
    interface View extends BaseRequestView {

        void getLunBo(List<LunBoBO> lunBoBOs);

        void getGameList(List<GameBO> gameBOs);
    }

    interface Presenter extends BasePresenter<View> {

        void lunboList(String scoce, String cinemaId);

        void loadGameList(int pageNo);
    }
}
