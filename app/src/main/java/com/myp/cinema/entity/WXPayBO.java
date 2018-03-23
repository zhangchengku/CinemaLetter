package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2017/7/10.
 * <p>
 * 微信支付的bean
 */

public class WXPayBO implements Serializable {


    /**
     * appid : wxb18d1464762457a0
     * noncestr : f228bda69952fa13fe74d09b34e4983b
     * package : Sign=WXPay
     * partnerid : 1484476502
     * prepay_id : wx20170710101458eeef2ba1f20996258174
     * sign : 5E3CD72AEF59FD07713572687364783C
     * timestamp : 1499652899063
     */

    private String appid;
    private String noncestr;
    private String packageX;
    private String partnerid;
    private String prepayid;
    private String sign;
    private String timestamp;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getNoncestr() {
        return noncestr;
    }

    public void setNoncestr(String noncestr) {
        this.noncestr = noncestr;
    }

    public String getPackageX() {
        return packageX;
    }

    public void setPackageX(String packageX) {
        this.packageX = packageX;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid;
    }

    public String getPrepayid() {
        return prepayid;
    }

    public void setPrepay_id(String prepay_id) {
        this.prepayid = prepay_id;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
