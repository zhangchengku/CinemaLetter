package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2017/6/19.
 * <p>
 * 订单bean
 */

public class OrderBO implements Serializable {


    /**
     * cinemaName : 测试-81
     * dxMovie : {"movieDimensional":"2D","movieLanguage":"国语","movieName":"让子弹飞","movieSubtitle":"中文","picture":null}
     * hallName : VIP(I)厅
     * orderExpireSecond : 1497926588
     * orderName : null
     * orderNum : 5ac05a62626a4020170620102908
     * orderPhone : 15629127249
     * payDate : null
     * payStatus : 0
     * payType : null
     * playName : 2017-06-20 11:35:00
     * seats : 3_5,3_6
     * ticketFlag1 : null
     * ticketFlag2 : null
     * ticketNum : 2
     * ticketOriginPrice : 200.0
     * ticketRealPrice : null
     */
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }
    private String refundStatus;

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    private String cinemaId;
    private String cinemaName;
    private DxMovieBo dxMovie;
    private String hallName;
    private String orderExpireSecond;
    private String orderName;
    private String orderNum;
    private String orderPhone;
    private String payDate;
    private String payStatus;
    private String payType;
    private String playName;
    private String seats;
    private String ticketFlag1;
    private String ticketFlag2;
    private String ticketNum;
    private String ticketOriginPrice;
    private String ticketRealPrice;
    private String poundage;    //服务费

    public String getPoundage() {
        return poundage;
    }

    public void setPoundage(String poundage) {
        this.poundage = poundage;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public DxMovieBo getDxMovie() {
        return dxMovie;
    }

    public void setDxMovie(DxMovieBo dxMovie) {
        this.dxMovie = dxMovie;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getOrderExpireSecond() {
        return orderExpireSecond;
    }

    public void setOrderExpireSecond(String orderExpireSecond) {
        this.orderExpireSecond = orderExpireSecond;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getTicketFlag1() {
        return ticketFlag1;
    }

    public void setTicketFlag1(String ticketFlag1) {
        this.ticketFlag1 = ticketFlag1;
    }

    public String getTicketFlag2() {
        return ticketFlag2;
    }

    public void setTicketFlag2(String ticketFlag2) {
        this.ticketFlag2 = ticketFlag2;
    }

    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }

    public String getTicketOriginPrice() {
        return ticketOriginPrice;
    }

    public void setTicketOriginPrice(String ticketOriginPrice) {
        this.ticketOriginPrice = ticketOriginPrice;
    }

    public String getTicketRealPrice() {
        return ticketRealPrice;
    }

    public void setTicketRealPrice(String ticketRealPrice) {
        this.ticketRealPrice = ticketRealPrice;
    }

    public static class DxMovieBo implements Serializable {
        /**
         * movieDimensional : 2D
         * movieLanguage : 国语
         * movieName : 让子弹飞
         * movieSubtitle : 中文
         * picture : null
         */

        private String movieDimensional;
        private String movieLanguage;
        private String movieName;
        private String movieSubtitle;
        private String picture;

        public String getMovieDimensional() {
            return movieDimensional;
        }

        public void setMovieDimensional(String movieDimensional) {
            this.movieDimensional = movieDimensional;
        }

        public String getMovieLanguage() {
            return movieLanguage;
        }

        public void setMovieLanguage(String movieLanguage) {
            this.movieLanguage = movieLanguage;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getMovieSubtitle() {
            return movieSubtitle;
        }

        public void setMovieSubtitle(String movieSubtitle) {
            this.movieSubtitle = movieSubtitle;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }
    }
}
