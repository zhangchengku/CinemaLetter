package com.myp.cinema.ui.userregister;

import com.myp.cinema.entity.UserBO;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;
import com.myp.cinema.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class RegisterContract {
    interface View extends BaseRequestView {

        void getVersition(String version);

        void getUser(UserBO user);

    }

    interface Presenter extends BasePresenter<View> {

        void loadVersition(String phone);

        void loadRegisterUser(String phone, String password, String version, String sex);

    }
}
