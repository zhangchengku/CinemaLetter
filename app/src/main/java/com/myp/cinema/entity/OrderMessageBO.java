package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/5.
 */
public class OrderMessageBO implements Serializable {
   private String qrCode;
    private Integer        canRefund;
   private Object cinema;
      private String     address;
   private String contact;
    private String startTime;
    private String endTime;
    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Integer getCanRefund() {
        return canRefund;
    }

    public void setCanRefund(Integer canRefund) {
        this.canRefund = canRefund;
    }

    public Object getCinema() {
        return cinema;
    }

    public void setCinema(Object cinema) {
        this.cinema = cinema;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


}
