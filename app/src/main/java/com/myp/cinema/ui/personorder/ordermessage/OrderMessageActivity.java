package com.myp.cinema.ui.personorder.ordermessage;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myp.cinema.R;
import com.myp.cinema.entity.Bean;
import com.myp.cinema.entity.OrderBO;
import com.myp.cinema.entity.ShareBO;
import com.myp.cinema.mvp.MVPBaseActivity;
import com.myp.cinema.ui.applicationforrefund.applicationforrefund;
import com.myp.cinema.util.CimemaUtils;
import com.myp.cinema.util.LogUtils;
import com.myp.cinema.util.StringUtils;
import com.myp.cinema.util.ZxingUtils;
import com.myp.cinema.widget.ShareDialog;
import com.squareup.picasso.Picasso;

import butterknife.Bind;


/**
 * MVPPlugin
 * 订单详情页面
 */

public class OrderMessageActivity extends MVPBaseActivity<OrderMessageContract.View,
        OrderMessagePresenter> implements OrderMessageContract.View , View.OnClickListener {
    @Bind(R.id.movies_img)
    ImageView movieImg;
    @Bind(R.id.movies_name)
    TextView moviesname;
    @Bind(R.id.movies_type)
    TextView moviestype;
    @Bind(R.id.movies_address)
    TextView moviesaddress;
    @Bind(R.id.movies_time)
    TextView moviestime;
    @Bind(R.id.movies_seat)
    TextView moviesSeat;
    @Bind(R.id.movies_num)
    TextView moviesnum;
    @Bind(R.id.collect_tickets1)
    TextView collectTickets1;
    @Bind(R.id.collect_tickets2)
    TextView collectTickets2;
    @Bind(R.id.movies_price)
    TextView moviesPrice;
    @Bind(R.id.order_num)
    TextView orderNum;
    @Bind(R.id.phone_num)
    TextView phoneNum;
    @Bind(R.id.pay_time)
    TextView paytime;
    @Bind(R.id.add_ress)
    TextView address;
    @Bind(R.id.tuipiao)
    TextView tuipiao;
    @Bind(R.id.yingcheng)
    TextView yingcheng;
    @Bind(R.id.fenxiang_img)
    ImageView fenxiangimg;
    @Bind(R.id.call_phone)
    ImageView callphone;
    @Bind(R.id.layout_view)
    LinearLayout linear;

    private String cinemaId;
    private String id;
    private OrderBO orderBO;
    private String phoneNnum;
    private String success;
    private String refundStatus;
    private Bean orderMessage;
    private String logo;

    @Override
    protected int getLayout() {
        return R.layout.act_order_message;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goBack();
        setTitle("订单详情");
        cinemaId =  getIntent().getStringExtra("cinemaId");
        id =  getIntent().getStringExtra("id");
        orderBO = (OrderBO) getIntent().getExtras().getSerializable("order");
        if (StringUtils.isEmpty(orderBO.getDxMovie().getPicture())) {
            movieImg.setImageResource(R.color.act_bg01);
        } else {
            Picasso.with(this).load(orderBO.getDxMovie().getPicture()).into(movieImg);
        }
        moviesname.setText(orderBO.getDxMovie().getMovieName());
        moviestype.setText(orderBO.getDxMovie().getMovieDimensional());
        moviesaddress.setText(orderBO.getCinemaName() + " " + orderBO.getHallName());
        if (!StringUtils.isEmpty(orderBO.getPlayName())) {
            String time = orderBO.getPlayName().substring(0, orderBO.getPlayName().length() - 3);
            moviestime.setText(time);
        } else {
            moviestime.setText("");
        }
        moviesSeat.setText(CimemaUtils.getSeats(orderBO.getSeats()));
        moviesnum.setText(orderBO.getTicketNum());
        if(orderBO.getTicketFlag1() ==null || orderBO.getTicketFlag1().isEmpty()){
            collectTickets1.setText("序列号：");
        }else {
            collectTickets1.setText("序列号：" + orderBO.getTicketFlag1());
        }
        if(orderBO.getTicketFlag2() ==null || orderBO.getTicketFlag2().isEmpty()){
            collectTickets2.setText("序列号：");
        }else {
            collectTickets2.setText("验证码："+ orderBO.getTicketFlag2());
        }
        moviesPrice.setText( orderBO.getTicketRealPrice()+"元");
        orderNum.setText(orderBO.getOrderNum());
        phoneNum.setText(settingphone(orderBO.getOrderPhone()));
        paytime.setText(orderBO.getPayDate());
        yingcheng.setText(orderBO.getCinemaName());
        if(cinemaId ==null || cinemaId.isEmpty()){
            LogUtils.showToast("影院地址为空");
        }else {
            mPresenter.loadOrderMessage(id,cinemaId);
        }
        fenxiangimg.setOnClickListener(this);
        callphone.setOnClickListener(this);
    }



    public static String settingphone(String phone) {
        String phone_s = phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
        return phone_s;
    }


    private void setdata(Bean orderMessage) {
            TextView  startTime=(TextView)findViewById(R.id.startTime);
            TextView  contact=(TextView)findViewById(R.id.contact);
            ImageView  er=(ImageView)findViewById(R.id.er);
            if(orderMessage.getData().getCinema().getStartTime() ==null || orderMessage.getData().getCinema().getStartTime().isEmpty()){
                startTime.setText("");
            }else {
                startTime.setText("工作时间：早"+orderMessage.getData().getCinema().getStartTime()+"-晚"+orderMessage.getData().getCinema().getEndTime());
            }
            if(orderMessage.getData().getCinema().getContact() ==null || orderMessage.getData().getCinema().getContact().isEmpty()){
                startTime.setText("");
            }else {
                contact.setText("联系电话："+orderMessage.getData().getCinema().getContact());
            }
            if(getIntent().getStringExtra("refundStatus")==null){
                tuipiao.setVisibility(View.GONE);
            }else {
                if(getIntent().getStringExtra("refundStatus").equals("1")){
                    tuipiao.setVisibility(View.VISIBLE);
                    tuipiao.setText("已退票");
                    tuipiao.setTextColor(Color.parseColor("#eb5e3a"));
                    tuipiao.setBackgroundResource(R.drawable.listitemt);
                }else {
                    if(orderMessage.getData().getCanRefund()==1) {
                        tuipiao.setVisibility(View.VISIBLE);
                        tuipiao.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("order", orderBO);
                                bundle.putString("cinemaId",cinemaId );
                                bundle.putString("id",id );
                                gotoActivity(applicationforrefund.class, bundle, false);
                            }
                        });
                    }else {
                        tuipiao.setVisibility(View.GONE);
                    }
                }
            }
            address.setText(orderMessage.getData().getCinema().getAddress());
            if(orderMessage.getData().getQrCode() ==null || orderMessage.getData().getQrCode().isEmpty()){
                er.setBackgroundResource(R.drawable.erweimshixiao);
            }else {
                Bitmap bitmap = ZxingUtils.createQRImage(orderMessage.getData().getQrCode().toString(), er.getWidth(), er.getHeight());
                er.setImageBitmap(bitmap);
            }
        fenxiangimg.setVisibility(View.VISIBLE);
    }

    @Override
    public void onRequestError(String msg) {
        LogUtils.showToast(msg);
    }
    @Override
    public void onRequestEnd() {

    }
    @Override
    public void getOrderMessageList(Bean orderMessage) {
        this.orderMessage = orderMessage;
        setdata(orderMessage);
        phoneNnum = orderMessage.getData().getCinema().getContact();
    }




    private void callPhone() {
        Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+phoneNnum));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.call_phone:
                callPhone();
                break;
            case R.id.fenxiang_img:
                logo = orderBO.getDxMovie().getPicture();
                String content = orderBO.getDxMovie().getMovieName();
                String url = orderMessage.getData().getShareUrl();
                String title = "好友给你分享电影票";
                ShareBO shareBO = new ShareBO(content,logo, url, title);
                new ShareDialog(this, shareBO).showAtLocation(linear, Gravity.BOTTOM, 0, 0);
                break;
        }
    }
}
