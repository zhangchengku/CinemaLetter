package com.myp.cinema.ui.orderconfrim;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.myp.cinema.R;
import com.myp.cinema.base.MyApplication;
import com.myp.cinema.entity.MoviesByCidBO;
import com.myp.cinema.entity.MoviesSessionBO;
import com.myp.cinema.entity.OrderBO;
import com.myp.cinema.mvp.MVPBaseActivity;
import com.myp.cinema.ui.pay.PayActivity;
import com.myp.cinema.util.LogUtils;
import com.myp.cinema.util.RegexUtils;
import com.myp.cinema.util.StringUtils;
import com.myp.cinema.util.TimeUtils;
import com.squareup.picasso.Picasso;

import java.math.BigDecimal;

import butterknife.Bind;


/**
 * 确认订单页面
 */

public class ConfrimOrderActivity extends MVPBaseActivity<ConfrimOrderContract.View,
        ConfrimOrderPresenter> implements ConfrimOrderContract.View, View.OnClickListener {


    @Bind(R.id.movies_address)
    TextView orderAddress;
    @Bind(R.id.movies_time)
    TextView orderTime;
    @Bind(R.id.movies_seat)
    TextView seatText;
    @Bind(R.id.order_price)
    TextView orderPrice;
    @Bind(R.id.other_price)
    TextView otherPrice;
    @Bind(R.id.submit_button)
    Button submitButton;
    @Bind(R.id.contact)
    TextView contact;
    @Bind(R.id.movies_num)
    TextView moviesnum;
    @Bind(R.id.movies_type)
    TextView moviestype;
    @Bind(R.id.movies_name)
    TextView moviesName;
    @Bind(R.id.movies_img)
    ImageView moviesimg;
    @Bind(R.id.call_phone)
    ImageView callphone;
    @Bind(R.id.membership_price)
    TextView membership;

    private MoviesByCidBO movies;
    private MoviesSessionBO sessionBO;
    private int ticketNum;
    private String seatId;
    private String seats;
    private String price;
    private int size;

    @Override
    protected int getLayout() {
        return R.layout.act_confrim_order;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goBack();
        setTitle("确认订单");
        getBundlen();
        inittion();
        submitButton.setOnClickListener(this);
        callphone.setOnClickListener(this);
    }


    /**
     * 获取传递过来的参数
     */
    private void getBundlen() {
        Bundle bundle = getIntent().getExtras();
        movies = (MoviesByCidBO) bundle.getSerializable("movies");
        sessionBO = (MoviesSessionBO) bundle.getSerializable("MoviesSession");
        ticketNum = bundle.getInt("num", 0);
        seatId = bundle.getString("seatId", "");
        seats = bundle.getString("seats", "");
        if(ticketNum>sessionBO.getLeftScreenLimitNum()){
            double  youhuijia =sessionBO.getLeftScreenLimitNum() * Double.parseDouble(sessionBO.getPartnerPrice());
            double noyouhui = (ticketNum-sessionBO.getLeftScreenLimitNum())* Double.parseDouble(sessionBO.getMarketPrice());
            double zong = youhuijia+noyouhui;
            BigDecimal bd=new BigDecimal(zong);
            price = bd.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue() + "";
            Log.d("价0格", "订单确认: "+bd.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue());
        }else {
            double zong = (ticketNum)* Double.parseDouble(sessionBO.getPartnerPrice());
            BigDecimal bd=new BigDecimal(zong);
            price = bd.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue() + "";
            Log.d("价0格", "订单确认: "+bd.setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue());
        }
    }


    /**
     * 初始化界面显示
     */
    private void inittion() {
        if (StringUtils.isEmpty(movies.getPicture())) {
            moviesimg.setImageResource(R.color.act_bg01);
        } else {
            Picasso.with(this).load(movies.getPicture()).into(moviesimg);
        }
        moviesName.setText(movies.getMovieName());
        moviestype.setText(movies.getMovieDimensional()+movies.getMovieLanguage());
        orderAddress.setText(MyApplication.cinemaBo.getCinemaName());
        orderTime.setText(sessionBO.getStartTime());
        String[] seat = seats.split(",");
        size = seat.length;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < seat.length; i++) {
            buffer.append(seat[i].split("_")[0] + "排" + seat[i].split("_")[1] + "座 ");
        }
        seatText.setText(buffer.toString());
        moviesnum.setText(String.valueOf(ticketNum));
        contact.setText("客服电话：" + MyApplication.cinemaBo.getContact());
        orderPrice.setText("¥ " + price);
        otherPrice.setText("(含服务费¥" + MyApplication.cinemaBo.getTotalFee() + "/张)");
        if(sessionBO.getPreferPrice()==null){
            membership.setVisibility(View.GONE);
        }else {
            double  membershipprice =ticketNum * Double.parseDouble(String.valueOf(sessionBO.getPreferPrice()));
            BigDecimal bd=new BigDecimal(membershipprice);
            String membershipprices = bd.setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue() + "";
            membership.setText("¥ " + membershipprices);
        }

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_button:
                LogUtils.showToast("提交订单");
                    showNoProgress("提交订单中...");
                Log.d("价0格", "订单提交确认: "+price);
                    mPresenter.loadSubmitOrder( null, seats, ticketNum + "", price,
                            MyApplication.cinemaBo.getCinemaNumber(), sessionBO.getHallId(),
                            sessionBO.getDxId(), sessionBO.getCineMovieNum(), seatId);
                break;
            case R.id.call_phone:
                callPhone();
            break;
        }
    }
    private void callPhone() {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+MyApplication.cinemaBo.getContact()));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
//    /**
//     * 检测电话是否输入
//     */
//    private boolean isEditPhone() {
//        userPhone = phoneEdit.getText().toString().trim();
//        if (StringUtils.isEmpty(userPhone)) {
//            LogUtils.showToast("请输入联系电话！");
//            return false;
//        }
//        if (!RegexUtils.isMobileExact(userPhone)) {
//            LogUtils.showToast("请输入正确的联系电话！");
//            return false;
//        }
//        return true;
//    }


    @Override
    public void onRequestError(String msg) {
        LogUtils.showToast(msg);
        stopProgress();
    }

    @Override
    public void onRequestEnd() {
        stopProgress();
    }

    @Override
    public void getOrder(OrderBO orderBO) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("order", orderBO);
        bundle.putInt("confrim", 1);
        bundle.putInt("size", size);
        bundle.putString("price", price);
        gotoActivity(PayActivity.class, bundle, true);
    }
}