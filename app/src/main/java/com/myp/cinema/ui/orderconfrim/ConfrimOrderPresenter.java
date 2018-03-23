package com.myp.cinema.ui.orderconfrim;

import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.entity.OrderBO;
import com.myp.cinema.mvp.BasePresenterImpl;

import rx.Subscriber;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class ConfrimOrderPresenter extends BasePresenterImpl<ConfrimOrderContract.View>
        implements ConfrimOrderContract.Presenter {

    @Override
    public void loadSubmitOrder( String orderName, String seats, String ticketNum,
                                String ticketOriginPrice, String cinemaNumber, String hallId, String playId, String cineMovieNum, String seatId) {
        HttpInterfaceIml.orderSubmit( orderName, seats, ticketNum, ticketOriginPrice,
                cinemaNumber, hallId, playId, cineMovieNum, seatId).subscribe(new Subscriber<OrderBO>() {
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
            public void onNext(OrderBO s) {
                if (mView == null)
                    return;
                mView.getOrder(s);
            }
        });
    }
}
