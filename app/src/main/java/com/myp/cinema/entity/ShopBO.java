package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2017/7/17.
 * <p>
 * 商品bean
 */

public class ShopBO implements Serializable {


    /**
     * endTime : 2017-07-20 10:38:33
     * goodName : 耳机
     * id : 1
     * imageUrl : http://192.168.1.61:8080/upload/20170717/954bhSD.png
     * point : 100
     * price : 100
     * redirectUrl : http://192.168.1.61:8080/h5/game/exchange/detail?id=1
     * startTime : 2017-07-04 10:38:31
     */

    private String endTime;
    private String goodName;
    private String id;
    private String imageUrl;
    private String point;
    private String price;
    private String redirectUrl;
    private String startTime;

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
}
