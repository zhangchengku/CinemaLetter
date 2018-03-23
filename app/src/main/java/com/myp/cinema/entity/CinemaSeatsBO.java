package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2017/4/27.
 * <p>
 * 影厅座位图Bean
 */

public class CinemaSeatsBO implements Serializable {

    /**
     * "cineSeatId": "14342",
     * "cinemaId": "1",
     * "xCoord": "7",
     * "yCoord": "9",
     * "loveseats": "",
     * "row": "0",
     * "column": "0",
     * "status": "ok",
     * "type": "road",
     * "areaId":"1"
     */


    private String cineSeatId;
    private String cinemaId;
    private String xCoord;
    private String yCoord;
    private String loveseats;
    private String row;
    private String column;
    private String status;
    private String type;
    private String areaId;

    public String getCineSeatId() {
        return cineSeatId;
    }

    public void setCineSeatId(String cineSeatId) {
        this.cineSeatId = cineSeatId;
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getxCoord() {
        return xCoord;
    }

    public void setxCoord(String xCoord) {
        this.xCoord = xCoord;
    }

    public String getyCoord() {
        return yCoord;
    }

    public void setyCoord(String yCoord) {
        this.yCoord = yCoord;
    }

    public String getLoveseats() {
        return loveseats;
    }

    public void setLoveseats(String loveseats) {
        this.loveseats = loveseats;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
}
