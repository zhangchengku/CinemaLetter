package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2017/6/19.
 * <p>
 * 订单简易信息
 */

public class OrderNumBO implements Serializable {


    /**
     * orderNum : 2017102310250135012481
     * order : 0
     */

    private String orderNum;
    private String order;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
