package com.myp.cinema.ui.personsetting;

import com.myp.cinema.entity.UserBO;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;

import java.io.File;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PersonSettingContract {
    interface View extends BaseRequestView {

        void getUserImage(UserBO userBO);

        void getUserSex(UserBO userBO);

    }

    interface Presenter extends BasePresenter<View> {

        void updataUserImage(File fileName);

        void updateUserSex(int sex);

    }
}
