package com.myp.cinema.ui.personread;

import com.myp.cinema.entity.CommentBO;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;

import java.util.List;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PersonReadContract {
    interface View extends BaseRequestView {

        void getReadList(List<CommentBO> commentBOs,int page);
    }

    interface Presenter extends BasePresenter<View> {

        void loadPersonReadList(String appUserId, int page);
    }
}
