package com.myp.cinema.entity;

/**
 * Created by wuliang on 2017/5/16.
 * <p>
 * 影厅座位状态bean
 */

public class aCinemaSeatTableBO {


    /**
     * x : 1
     * y : 1
     * rowValue : 1
     * columnValue : 1
     * cineSeatId : 4898
     * seatStatus : ok
     * type : danren
     * pairValue :
     * areaId : null
     */

    private String x;
    private String y;
    private String rowValue;
    private String columnValue;
    private String cineSeatId;
    private String seatStatus;
    private String type;
    private String pairValue;
    private Object areaId;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getRowValue() {
        return rowValue;
    }

    public void setRowValue(String rowValue) {
        this.rowValue = rowValue;
    }

    public String getColumnValue() {
        return columnValue;
    }

    public void setColumnValue(String columnValue) {
        this.columnValue = columnValue;
    }

    public String getCineSeatId() {
        return cineSeatId;
    }

    public void setCineSeatId(String cineSeatId) {
        this.cineSeatId = cineSeatId;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPairValue() {
        return pairValue;
    }

    public void setPairValue(String pairValue) {
        this.pairValue = pairValue;
    }

    public Object getAreaId() {
        return areaId;
    }

    public void setAreaId(Object areaId) {
        this.areaId = areaId;
    }
}
