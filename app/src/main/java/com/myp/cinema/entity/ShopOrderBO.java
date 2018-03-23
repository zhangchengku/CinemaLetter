package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2017/7/17.
 * <p>
 * 兑换商品订单信息
 */

public class ShopOrderBO implements Serializable {


    /**
     * consumePoString : 36
     * good : {"goodName":"第三","imageUrl":"http://192.168.1.66:8080/upload/20170717/367fmfa.jpg","poString":6,"price":103}
     * goodNum : 6
     * id : 2
     * orderNo : d1f4bf234a564de3ba78824a16340c83
     * payDate : 2017-07-17 10:32:17
     * status : 0
     */

    private String consumePoint;
    private ShopBO good;
    private String goodNum;
    private String id;
    private String orderNo;
    private String payDate;
    private String status;

    public String getConsumePoint() {
        return consumePoint;
    }

    public void setConsumePoint(String consumePoString) {
        this.consumePoint = consumePoString;
    }

    public ShopBO getGood() {
        return good;
    }

    public void setGood(ShopBO good) {
        this.good = good;
    }

    public String getGoodNum() {
        return goodNum;
    }

    public void setGoodNum(String goodNum) {
        this.goodNum = goodNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
