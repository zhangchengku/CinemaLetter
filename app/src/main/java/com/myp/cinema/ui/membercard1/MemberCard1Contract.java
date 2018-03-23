package com.myp.cinema.ui.membercard1;

import android.content.Context;

import com.myp.cinema.entity.CardBO;
import com.myp.cinema.mvp.BasePresenter;
import com.myp.cinema.mvp.BaseRequestView;
import com.myp.cinema.mvp.BaseView;
import java.util.List;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MemberCard1Contract {
    interface View extends BaseRequestView {
        void getCardList(List<CardBO> cardBOs);
    }

    interface Presenter extends BasePresenter<View> {
        void loadCardUser();
    }
}
