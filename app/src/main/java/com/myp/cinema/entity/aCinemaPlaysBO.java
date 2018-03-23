package com.myp.cinema.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuliang on 2017/4/27.
 *
 * 影厅放映计划列表bean
 */

public class aCinemaPlaysBO implements Serializable{


    /**
     * id : 238700
     * movieInfo : [{"cineMovieId":"329","cineMovieNum":"001203092015","movieName":"消失的凶手（改动）（动作 3D）","movieSubtitle":"英文","movieLanguage":"国语","movieFormat":"数字","movieDimensional":"2D","movieSize":"中国巨幕","joinStartTime":"","joinEndTime":""}]
     * cinePlayId : 817966
     * hallId : 842
     * hallName : 9号特价厅
     * businessDate : 2017-05-11
     * startTime : 2017-05-11 17:25:00
     * endTime : 2017-05-11 19:35:00
     * priceType : 1
     * price : 50
     * marketPrice : 50
     * lowestPrice : 23
     * seatTotalNum : 221
     * seatAvailableNum : 220
     * allowBook : 1
     * cineUpdateTime : 0000-00-00 00:00:00
     * partnerPrice : 60.00
     * areaInfo : [{"areaId":"1","areaPrice":"60.00","areaServiceFee":"0.00"},{"areaId":"3","areaPrice":"60.00","areaServiceFee":"0.00"},{"areaId":"4","areaPrice":"60.00","areaServiceFee":"0.00"}]
     */

    private String id;
    private String cinePlayId;
    private String hallId;
    private String hallName;
    private String businessDate;
    private String startTime;
    private String endTime;
    private String priceType;
    private String price;
    private String marketPrice;
    private String lowestPrice;
    private String seatTotalNum;
    private String seatAvailableNum;
    private String allowBook;
    private String cineUpdateTime;
    private String partnerPrice;
    private List<MovieInfoBo> movieInfo;
    private List<AreaInfoBo> areaInfo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCinePlayId() {
        return cinePlayId;
    }

    public void setCinePlayId(String cinePlayId) {
        this.cinePlayId = cinePlayId;
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
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

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(String lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public String getSeatTotalNum() {
        return seatTotalNum;
    }

    public void setSeatTotalNum(String seatTotalNum) {
        this.seatTotalNum = seatTotalNum;
    }

    public String getSeatAvailableNum() {
        return seatAvailableNum;
    }

    public void setSeatAvailableNum(String seatAvailableNum) {
        this.seatAvailableNum = seatAvailableNum;
    }

    public String getAllowBook() {
        return allowBook;
    }

    public void setAllowBook(String allowBook) {
        this.allowBook = allowBook;
    }

    public String getCineUpdateTime() {
        return cineUpdateTime;
    }

    public void setCineUpdateTime(String cineUpdateTime) {
        this.cineUpdateTime = cineUpdateTime;
    }

    public String getPartnerPrice() {
        return partnerPrice;
    }

    public void setPartnerPrice(String partnerPrice) {
        this.partnerPrice = partnerPrice;
    }

    public List<MovieInfoBo> getMovieInfo() {
        return movieInfo;
    }

    public void setMovieInfo(List<MovieInfoBo> movieInfo) {
        this.movieInfo = movieInfo;
    }

    public List<AreaInfoBo> getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(List<AreaInfoBo> areaInfo) {
        this.areaInfo = areaInfo;
    }

    public static class MovieInfoBo {
        /**
         * cineMovieId : 329
         * cineMovieNum : 001203092015
         * movieName : 消失的凶手（改动）（动作 3D）
         * movieSubtitle : 英文
         * movieLanguage : 国语
         * movieFormat : 数字
         * movieDimensional : 2D
         * movieSize : 中国巨幕
         * joinStartTime :
         * joinEndTime :
         */

        private String cineMovieId;
        private String cineMovieNum;
        private String movieName;
        private String movieSubtitle;
        private String movieLanguage;
        private String movieFormat;
        private String movieDimensional;
        private String movieSize;
        private String joinStartTime;
        private String joinEndTime;

        public String getCineMovieId() {
            return cineMovieId;
        }

        public void setCineMovieId(String cineMovieId) {
            this.cineMovieId = cineMovieId;
        }

        public String getCineMovieNum() {
            return cineMovieNum;
        }

        public void setCineMovieNum(String cineMovieNum) {
            this.cineMovieNum = cineMovieNum;
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

        public String getMovieLanguage() {
            return movieLanguage;
        }

        public void setMovieLanguage(String movieLanguage) {
            this.movieLanguage = movieLanguage;
        }

        public String getMovieFormat() {
            return movieFormat;
        }

        public void setMovieFormat(String movieFormat) {
            this.movieFormat = movieFormat;
        }

        public String getMovieDimensional() {
            return movieDimensional;
        }

        public void setMovieDimensional(String movieDimensional) {
            this.movieDimensional = movieDimensional;
        }

        public String getMovieSize() {
            return movieSize;
        }

        public void setMovieSize(String movieSize) {
            this.movieSize = movieSize;
        }

        public String getJoinStartTime() {
            return joinStartTime;
        }

        public void setJoinStartTime(String joinStartTime) {
            this.joinStartTime = joinStartTime;
        }

        public String getJoinEndTime() {
            return joinEndTime;
        }

        public void setJoinEndTime(String joinEndTime) {
            this.joinEndTime = joinEndTime;
        }
    }

    public static class AreaInfoBo {
        /**
         * areaId : 1
         * areaPrice : 60.00
         * areaServiceFee : 0.00
         */

        private String areaId;
        private String areaPrice;
        private String areaServiceFee;

        public String getAreaId() {
            return areaId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public String getAreaPrice() {
            return areaPrice;
        }

        public void setAreaPrice(String areaPrice) {
            this.areaPrice = areaPrice;
        }

        public String getAreaServiceFee() {
            return areaServiceFee;
        }

        public void setAreaServiceFee(String areaServiceFee) {
            this.areaServiceFee = areaServiceFee;
        }
    }
}
