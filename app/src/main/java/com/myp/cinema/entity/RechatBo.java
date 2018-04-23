package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/27.
 */
public class RechatBo implements Serializable {
   private String id;
         private  String   originalPrice;
    private  String realPrice;
    private  String rechargeMoney;

    public String getRechargeMoney() {
        return rechargeMoney;
    }

    public void setRechargeMoney(String rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(String realPrice) {
        this.realPrice = realPrice;
    }
}
