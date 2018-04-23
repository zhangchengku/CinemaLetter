package com.myp.cinema.ui.moviesseattable;

import android.util.Log;


import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.api.HttpServiceIml;
import com.myp.cinema.entity.aCinemaSeatTableBO;
import com.myp.cinema.entity.preferentialnumberBo;
import com.myp.cinema.mvp.BasePresenterImpl;

import java.util.List;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class SeatTablePresenter extends BasePresenterImpl<SeatTableContract.View>
        implements SeatTableContract.Presenter {
    @Override
    public void getsets(String cinemaId, String dxId) {

        HttpInterfaceIml.getsets(cinemaId, dxId).
                subscribe(new Subscriber<preferentialnumberBo>() {
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
                    public void onNext(preferentialnumberBo s) {
                        if (mView == null)
                            return;
                        mView.getpreferentialnumberBo(s);
                    }
                });
    }
    @Override
    public void loadSeatTables(String cid, String playId, String updateTime) {

        HttpServiceIml.getCinemasSeatStatus(cid, playId, updateTime).
                subscribe(new Subscriber<List<aCinemaSeatTableBO>>() {
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
                    public void onNext(List<aCinemaSeatTableBO> s) {
                        if (mView == null)
                            return;
                        mView.getSeatData(s);
                    }
                });
    }


}
