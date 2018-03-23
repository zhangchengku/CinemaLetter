package com.myp.cinema.ui.personcomment;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.CommentBO;
import com.myp.cinema.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PersonCommentPresenter extends BasePresenterImpl<PersonCommentContract.View>
        implements PersonCommentContract.Presenter {

    @Override
    public void loadPersonComment(String appUserId, final int page) {
        HttpInterfaceIml.personCommentList(appUserId, page + "").subscribe(new Subscriber<List<CommentBO>>() {
            @Override
            public void onCompleted() {
                if (mView != null) {
                    mView.onRequestEnd();
                }
            }

            @Override
            public void onError(Throwable e) {
                if (mView != null) {
                    mView.onRequestError(e.getMessage());
                }
            }

            @Override
            public void onNext(List<CommentBO> s) {
                if (mView != null) {
                    mView.getCommentList(s,page);
                }
            }
        });
    }
}
