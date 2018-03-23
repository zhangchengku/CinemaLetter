package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2017/4/19.
 *
 *
 */

public class aCinemaIdBO implements Serializable{

//            "cinemaId": "11",
//            "cinemaName": "测试-81",
//            "validPeriod": "2022-04-18",
//            "cinemaNumber": "10088888"
    private String cinemaId;

    private String cinemaName;

    private String validPeriod;

    private String cinemaNumber;

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(String validPeriod) {
        this.validPeriod = validPeriod;
    }

    public String getCinemaNumber() {
        return cinemaNumber;
    }

    public void setCinemaNumber(String cinemaNumber) {
        this.cinemaNumber = cinemaNumber;
    }
}
