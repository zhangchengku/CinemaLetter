package com.myp.cinema.ui.allcritic;

import com.myp.cinema.entity.CriticBO;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;

import java.util.List;

/**
 * Created by Administrator on 2018/2/27.
 */

public class AllCriticContract {
    interface View extends BaseRequestView {

        void getCritic(List<CriticBO> criticBO,int pageNo);
        void getDianZan(CriticBO criticBO,int position);
    }

    interface Presenter extends BasePresenter<View> {

            void loadMoviesCritic(Long movieId,int pageNo);
        void loadDianZan(Long Id, final int position);
    }
}
