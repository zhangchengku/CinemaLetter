package com.myp.cinema.ui.userregister;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.UserBO;
import com.myp.cinema.mvp.BasePresenterImpl;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class RegisterPresenter extends BasePresenterImpl<RegisterContract.View>
        implements RegisterContract.Presenter {

    @Override
    public void loadVersition(String phone) {
        HttpInterfaceIml.userVerification(phone, "register").subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if (mView == null)
                    return;
                mView.onRequestError(e.getMessage());
            }

            @Override
            public void onNext(String s) {
                if (mView == null)
                    return;
                mView.getVersition(s);
            }
        });
    }

    @Override
    public void loadRegisterUser(String phone, String password, String version, String sex) {
        HttpInterfaceIml.userRegister(phone, password, version, sex).subscribe(new Subscriber<UserBO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                if (mView == null)
                    return;
                mView.onRequestError(e.getMessage());
            }

            @Override
            public void onNext(UserBO s) {
                if (mView == null)
                    return;
                mView.getUser(s);
            }
        });
    }
}
