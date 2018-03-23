package com.myp.cinema.ui.main.hotwire.welfareFragment;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.HotWireBO;
import com.myp.cinema.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * Created by Administrator on 2018/2/11.
 */

public class welfarePresenter extends BasePresenterImpl<welfareContract.View> implements welfareContract.Presenter{

    @Override
    public void loadHotWire(final String articleType, final int flpage, String cinemaId) {
        HttpInterfaceIml.hotWire(articleType, flpage + "",cinemaId).subscribe(new Subscriber<List<HotWireBO>>() {
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
            public void onNext(List<HotWireBO> s) {
                if (mView == null)
                    return;
                mView.getHotWire(s,flpage,articleType);
            }
        });
    }
}
