package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by wuliang  on 2017/7/3.
 */

public class PayCardBO implements Serializable {


    /**
     * totalButie : 0
     * totalFee : 0
     * totalPrice : 30
     * totalServiceCharge : 10
     */

    private String totalButie;
    private String totalFee;
    private String totalPrice;
    private String totalServiceCharge;

    public String getTotalButie() {
        return totalButie;
    }

    public void setTotalButie(String totalButie) {
        this.totalButie = totalButie;
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTotalServiceCharge() {
        return totalServiceCharge;
    }

    public void setTotalServiceCharge(String totalServiceCharge) {
        this.totalServiceCharge = totalServiceCharge;
    }
}
