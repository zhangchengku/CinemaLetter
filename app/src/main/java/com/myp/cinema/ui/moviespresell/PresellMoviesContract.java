package com.myp.cinema.ui.moviespresell;

import com.myp.cinema.entity.MoviesCommentBO;
import com.myp.cinema.entity.ShareBO;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class PresellMoviesContract {
    interface View extends BaseRequestView {

        void getMoviesComment(MoviesCommentBO moviesCommentBO);

        void getShareMessage(ShareBO shareBO);
    }

    interface  Presenter extends BasePresenter<View> {

        /**
         * 获取单个电影影评
         */
        void loadMoviesComment(String appUserId, String movieId);

        /**
         * 收藏电影
         */
        void loadMoviesShouCang(String appUserId, String movieId, boolean isShouCang);

        /**
         * 分享电影
         */
        void loadShareMovie(String movieId);
    }
}
