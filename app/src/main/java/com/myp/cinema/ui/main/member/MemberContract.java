package com.myp.cinema.ui.main.member;

import com.myp.cinema.entity.UserBO;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MemberContract {
    interface View extends BaseRequestView {

        void getUser(UserBO userBO);
    }

    interface Presenter extends BasePresenter<View> {

        void loadMemberRecord(String appUserId);
    }
}
