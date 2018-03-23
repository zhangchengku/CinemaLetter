package com.myp.cinema.ui.playgame;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.GameBO;
import com.myp.cinema.entity.LunBoBO;
import com.myp.cinema.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PlayGamePresenter extends BasePresenterImpl<PlayGameContract.View>
        implements PlayGameContract.Presenter {

//    private int pageNo = 1;

    @Override
    public void lunboList(String souce, String cinemaId) {
        HttpInterfaceIml.lunboList(souce, cinemaId).subscribe(new Subscriber<List<LunBoBO>>() {
            @Override
            public void onCompleted() {
                if (mView == null)
                    return;
                mView.onRequestEnd();
            }

            @Override
            public void onError(Throwable e) {
                if (mView == null)
                    return;
                mView.onRequestError(e.getMessage());
            }

            @Override
            public void onNext(List<LunBoBO> s) {
                if (mView == null)
                    return;
                mView.getLunBo(s);
            }
        });
    }

    @Override
    public void loadGameList(final int pageNo) {
//        if (isPageAdd) {
//            pageNo++;
//        } else {
//            pageNo = 1;
//        }
        HttpInterfaceIml.gameList(pageNo + "").subscribe(new Subscriber<List<GameBO>>() {
            @Override
            public void onCompleted() {
                if (mView == null)
                    return;
                mView.onRequestEnd();
            }

            @Override
            public void onError(Throwable e) {
                if (mView == null)
                    return;
                mView.onRequestError(e.getMessage());
            }

            @Override
            public void onNext(List<GameBO> s) {
                if (mView == null)
                    return;
                mView.getGameList(s);
            }
        });
    }
}
