package com.myp.cinema.ui.moviesseattable;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myp.cinema.R;
import com.myp.cinema.base.MyApplication;
import com.myp.cinema.entity.MoviesByCidBO;
import com.myp.cinema.entity.MoviesSessionBO;
import com.myp.cinema.entity.aCinemaSeatTableBO;
import com.myp.cinema.mvp.MVPBaseActivity;
import com.myp.cinema.ui.orderconfrim.ConfrimOrderActivity;
import com.myp.cinema.util.LogUtils;
import com.myp.cinema.util.StringUtils;
import com.myp.cinema.util.TimeUtils;
import com.myp.cinema.widget.seattable.SeatTable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;


/**
 * 选座购票界面
 */

public class SeatTableActivity extends MVPBaseActivity<SeatTableContract.View, SeatTablePresenter>
        implements SeatTableContract.View, View.OnClickListener {

    @Bind(R.id.seat_table)
    SeatTable seatTable;
    @Bind(R.id.movies_time)
    TextView moviesTime;
    @Bind(R.id.update_session)
    TextView updateSession;
    @Bind(R.id.cinema_address)
    TextView cinemaAddress;
    @Bind(R.id.seat1)
    TextView seat1;
    @Bind(R.id.seat2)
    TextView seat2;
    @Bind(R.id.seat3)
    TextView seat3;
    @Bind(R.id.seat4)
    TextView seat4;
    @Bind(R.id.order_price)
    TextView orderPrice;
    @Bind(R.id.submit_button)
    Button submitButton;
    @Bind(R.id.buttom_layout)
    LinearLayout buttomLayout;


    private Map<String, aCinemaSeatTableBO> setMap;   //座位取值简单
    private Map<String, aCinemaSeatTableBO> selector;   //选中的座位

    private List<Integer> noneRows;

    MoviesSessionBO sessionBO;    //场次bean
    MoviesByCidBO movies;   //当前选座的电影

    @Override
    protected int getLayout() {
        return R.layout.act_seat_table;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sessionBO = (MoviesSessionBO) getIntent().getExtras().getSerializable("session");
        movies = (MoviesByCidBO) getIntent().getExtras().getSerializable("movies");
        goBack();
        setTitle(movies.getMovieName());


        moviesTime.setText(TimeUtils.string2Week(sessionBO.getStartTime()));
        LogUtils.I(sessionBO.getStartTime());
        LogUtils.I(TimeUtils.string2Week(sessionBO.getStartTime()));
        cinemaAddress.setText(MyApplication.cinemaBo.getCinemaName());
        selector = new HashMap<>();
        showProgress("加载中...");
        mPresenter.loadSeatTables(MyApplication.cinemaBo.getCinemaId(),
                sessionBO.getDxId(), sessionBO.getCineUpdateTime());
        seatTable.setScreenName(sessionBO.getHallName() + "银幕");//设置屏幕名称
        seatTable.setMaxSelected(4);//设置最多选中
        submitButton.setOnClickListener(this);
        updateSession.setOnClickListener(this);
    }

    /**
     * 获取返回的座位信息
     * <p>
     * 下标从0开始，显示真实座位号需要加1
     */
    @Override
    public void getSeatData(List<aCinemaSeatTableBO> s) {
        packSeatData(s);
        seatTable.setSeatChecker(new SeatTable.SeatChecker() {

            @Override
            public boolean isValidSeat(int row, int column) {
                row++;
                column++;
                aCinemaSeatTableBO seatTableBO = setMap.get(row + "&&" + column);
                if ("0".equals(seatTableBO.getRowValue()) && "0".equals(seatTableBO.getColumnValue())) {
                    return false;
                }
                return true;

            }

            @Override
            public boolean isSold(int row, int column) {
                row++;
                column++;
                aCinemaSeatTableBO seatTableBO = setMap.get(row + "&&" + column);
                if ("ok".equals(seatTableBO.getSeatStatus())) {
                    return false;
                }
                return true;
            }

            @Override
            public void checked(int row, int column) {
                row++;
                column++;
                addSeatTables(row, column);
            }

            @Override
            public void unCheck(int row, int column) {
                row++;
                column++;
                removeSeatTables(row, column);
            }

            @Override
            public int isFriends(int row, int column) {
                row++;
                column++;
                aCinemaSeatTableBO seatTableBO = setMap.get(row + "&&" + column);
                if (!StringUtils.isEmpty(seatTableBO.getPairValue())) {
                    aCinemaSeatTableBO left = setMap.get(row + "&&" + (column - 1));
                    if (left == null) {
                        return 1;
                    }
                    if (left.getPairValue().equals(seatTableBO.getPairValue())) {
                        return 2;
                    }
                    aCinemaSeatTableBO right = setMap.get(row + "&&" + (column + 1));
                    if (right == null) {
                        return 2;
                    }
                    if (right.getPairValue().equals(seatTableBO.getPairValue())) {
                        return 1;
                    }
                }
                return 0;
            }

            @Override
            public boolean isEmpty(int row, int column) {
                return true;
            }

            @Override
            public String[] checkedSeatTxt(int row, int column) {
                return null;
            }

            @Override
            public boolean isNoneRow(int row) {
                if (Collections.binarySearch(noneRows, row) >= 0) {
                    return true;
                }
                return false;
            }

        });
        int x = Integer.parseInt(s.get(s.size() - 1).getX());
        int y = Integer.parseInt(s.get(s.size() - 1).getY());
        seatTable.setData(x, y);
    }


    /**
     * 出始化空白行及座位重新封装
     */
    private void packSeatData(List<aCinemaSeatTableBO> s) {
        setMap = new HashMap<>();
        noneRows = new ArrayList<>();
        int xNum = 1;   //记录x
        aCinemaSeatTableBO bo;
        for (int i = 0; i < s.size(); i++) {
            bo = s.get(i);
            setMap.put(bo.getX() + "&&" + bo.getY(), bo);
            if ((xNum + "").equals(bo.getX())) {
                if ("0".equals(bo.getRowValue()) && "0".equals(bo.getColumnValue())) {   //走道
                } else {
                    xNum++;
                }
            } else if (Integer.parseInt(bo.getX()) > xNum) {
                noneRows.add(xNum);
                xNum++;
            }
        }
    }


    AnimationSet animationSet;

    /**
     * 选中座位，界面变化
     */

    private void addSeatTables(int row, int column) {
        if (selector.size() == 0) {
            animationSet = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.share_pop_in);
            buttomLayout.startAnimation(animationSet);
            buttomLayout.setVisibility(View.VISIBLE);
        }
        aCinemaSeatTableBO seatTableBO = setMap.get(row + "&&" + column);
        selector.put(row + "&&" + column, seatTableBO);
        if(selector.size()>sessionBO.getLeftScreenLimitNum()){
            double  youhuijia =sessionBO.getLeftScreenLimitNum() * Double.parseDouble(sessionBO.getPartnerPrice());
            double noyouhui = (selector.size()-sessionBO.getLeftScreenLimitNum())* Double.parseDouble(sessionBO.getMarketPrice());
            double zong = youhuijia+noyouhui;
            BigDecimal bd=new BigDecimal(zong);
            orderPrice.setText("¥" + bd.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue());
            Log.d("价0格", "addSeatTables: "+bd.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue());
        }else {
            double zong = (selector.size())* Double.parseDouble(sessionBO.getPartnerPrice());
            BigDecimal bd=new BigDecimal(zong);
            orderPrice.setText("¥" + bd.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue());
            Log.d("价0格", "addSeatTables: "+bd.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue());
        }
        seatShow();
    }


    /**
     * 取消座位，界面控制
     */
    private void removeSeatTables(int row, int column) {
        selector.remove(row + "&&" + column);
        if(selector.size()>sessionBO.getLeftScreenLimitNum()){
            double  youhuijia =sessionBO.getLeftScreenLimitNum() * Double.parseDouble(sessionBO.getPartnerPrice());
            double noyouhui = (selector.size()-sessionBO.getLeftScreenLimitNum())* Double.parseDouble(sessionBO.getMarketPrice());
            double zong = youhuijia+noyouhui;
            BigDecimal bd=new BigDecimal(zong);
            orderPrice.setText("¥" + bd.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue());
            Log.d("价0格", "removeSeatTables: "+bd.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue());
        }else {
            double zong = (selector.size())* Double.parseDouble(sessionBO.getPartnerPrice());
            BigDecimal bd=new BigDecimal(zong);
            orderPrice.setText("¥" + bd.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue());
            Log.d("价0格", "removeSeatTables: "+bd.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue());
        }
        if (selector.size() == 0) {
            animationSet = (AnimationSet) AnimationUtils.loadAnimation(this, R.anim.share_pop_out);
            buttomLayout.startAnimation(animationSet);
            buttomLayout.setVisibility(View.GONE);
        }
        seatShow();
    }

    /**
     * 设置底部座位显示
     */
    private void seatShow() {
        seat1.setVisibility(View.GONE);
        seat2.setVisibility(View.GONE);
        seat3.setVisibility(View.GONE);
        seat4.setVisibility(View.GONE);
        int i = 0;
        for (aCinemaSeatTableBO seatTableBO : selector.values()) {
            i++;
            switch (i) {
                case 1:
                    seat1.setText(seatTableBO.getRowValue() + "排" + seatTableBO.getColumnValue() + "座");
                    seat1.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    seat2.setText(seatTableBO.getRowValue() + "排" + seatTableBO.getColumnValue() + "座");
                    seat2.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    seat3.setText(seatTableBO.getRowValue() + "排" + seatTableBO.getColumnValue() + "座");
                    seat3.setVisibility(View.VISIBLE);
                    break;
                case 4:
                    seat4.setText(seatTableBO.getRowValue() + "排" + seatTableBO.getColumnValue() + "座");
                    seat4.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_button:
                Bundle bundle = new Bundle();
                bundle.putSerializable("MoviesSession", sessionBO);   //场次
                bundle.putSerializable("movies", movies);              //电影
                bundle.putInt("num", selector.size());                  //电影张数
                bundle.putString("seats", getSeats());
                bundle.putString("seatId", getSeatsId());
                gotoActivity(ConfrimOrderActivity.class, bundle, false);
                break;
            case R.id.update_session:   //更换场次
                finish();
                break;
        }
    }


    /**
     * 获取选中的座位用1_1，2_2连起来
     */
    private String getSeats() {
        StringBuffer buffer = new StringBuffer();
        for (aCinemaSeatTableBO seatTableBO : selector.values()) {
            buffer.append(seatTableBO.getRowValue() + "_" + seatTableBO.getColumnValue() + ",");
        }
        return buffer.substring(0, buffer.length() - 1);
    }


    /**
     * 获取座位Id
     *
     * @return
     */
    private String getSeatsId() {
        StringBuffer buffer = new StringBuffer();
        for (aCinemaSeatTableBO seatTableBO : selector.values()) {
            buffer.append(seatTableBO.getCineSeatId() + ",");
        }
        return buffer.substring(0, buffer.length() - 1);
    }


    @Override
    public void onRequestError(String msg) {
        mPresenter.loadSeatTables(MyApplication.cinemaBo.getCinemaId(),
                sessionBO.getDxId(), sessionBO.getCineUpdateTime());
    }

    @Override
    public void onRequestEnd() {
        stopProgress();
    }
}
