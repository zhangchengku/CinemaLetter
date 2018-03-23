package com.myp.cinema.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuliang on 2017/4/27.
 * <p>
 * 影厅列表bean
 */

public class aCinemaHallsBO implements Serializable {


    /**
     * id : 1
     * name : 153f75385
     * seatNum : 214
     * type : 666e901a5f715385
     * audioType : HIFI
     * cineHallId: "9",
     * areaInfo : [{"areaId":"1","areaName":"默认区域"},"\u2026\u2026"]
     */

    private String id;
    private String name;
    private String seatNum;
    private String type;
    private String audioType;
    private String cineHallId;
    private List<AreaInfoBo> areaInfo;


    public String getCineHallId() {
        return cineHallId;
    }

    public void setCineHallId(String cineHallId) {
        this.cineHallId = cineHallId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAudioType() {
        return audioType;
    }

    public void setAudioType(String audioType) {
        this.audioType = audioType;
    }

    public List<AreaInfoBo> getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(List<AreaInfoBo> areaInfo) {
        this.areaInfo = areaInfo;
    }

    public static class AreaInfoBo {
        /**
         * areaId : 1
         * areaName : 默认区域
         */

        private String areaId;
        private String areaName;

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }
    }
}
