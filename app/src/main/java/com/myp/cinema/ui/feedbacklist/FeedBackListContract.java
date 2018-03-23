package com.myp.cinema.ui.feedbacklist;

import android.content.Context;

import com.myp.cinema.entity.FeedBackListBO;
import com.myp.cinema.entity.GameBO;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;
import com.myp.cinema.mvp.BaseView;

import java.util.List;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class FeedBackListContract {
    interface View extends BaseRequestView {
        void getFeedBackListBO(List<FeedBackListBO> feedBackListBOs);
    }

    interface  Presenter extends BasePresenter<View> {
        void loadFeedBackList();
    }
}
