package com.myp.cinema.ui.main.home.nextmovies;

import com.myp.cinema.entity.MoviesSoonBO;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;

import java.util.List;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class NextMoviesContract {
    interface View extends BaseRequestView {

        void getMoviesSoon(List<MoviesSoonBO> moviesSoonBO);

    }

    interface Presenter extends BasePresenter<View> {

        void loadMoviesSoon(String cinemaId);

    }
}
