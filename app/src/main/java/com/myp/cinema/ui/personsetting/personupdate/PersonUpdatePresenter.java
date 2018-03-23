package com.myp.cinema.ui.personsetting.personupdate;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.UserBO;
import com.myp.cinema.mvp.BasePresenterImpl;
import com.myp.cinema.util.MD5;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PersonUpdatePresenter extends BasePresenterImpl<PersonUpdateContract.View>
        implements PersonUpdateContract.Presenter {


    @Override
    public void updatePassWord(String oldPass, String newPass) {
        HttpInterfaceIml.userUpdatePass(MD5.strToMd5Low32(newPass), MD5.strToMd5Low32(oldPass))
                .subscribe(new Subscriber<UserBO>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.onRequestError(e.getMessage());
                    }

                    @Override
                    public void onNext(UserBO userBO) {
                        mView.getData(userBO);
                    }
                });
    }

    @Override
    public void updateName(String name) {
        HttpInterfaceIml.userUpdateName(name).subscribe(new Subscriber<UserBO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.onRequestError(e.getMessage());
            }

            @Override
            public void onNext(UserBO userBO) {
                mView.getData(userBO);
            }
        });
    }
}
