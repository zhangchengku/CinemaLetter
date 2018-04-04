package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2017/6/16.
 * <p>
 * 影厅场次bean
 */

public class MoviesSessionBO implements Serializable {

    private String allowBook;
    private String cineUpdateTime;
    private String createTime;
    private String deleteTime;
    private String dxId;
    private String endTime;
    private String hallId;
    private String hallName;
    private String id;
    private String lowestPrice;
    private String marketPrice;    //影院价格
    private String modifyTime;
    private String price;
    private String priceType;
    private String seatAvailableNum;
    private String seatTotalNum;
    private String startTime;
    private String valid;
    private String version;
    private String movieFormat;//电影格式(如：胶片，数字)
    private String movieDimensional;//影片放映类型（如：3D，2D）
    private String movieSize;//屏幕尺寸（如：IMAX，普通）
    private String movieLanguage;//配音
    private String movieSubtitle;//字幕
    private String cineMovieNum;//广电总局规定的影片全国唯一编码
    private String partnerPrice;  //优惠价格
    private Integer globalLeftNum;	//	剩余购买活动票价的次数
    private Integer leftScreenLimitNum;//当前场次剩余购买活动票价的次数
    private  Double preferPrice;    //会员价
    private Double globalPreferPrice;// 会员卡优惠价
    private Integer globalCanBuyNum;//会员优惠数量

    public Integer getGlobalCanBuyNum() {
        return globalCanBuyNum;
    }

    public void setGlobalCanBuyNum(Integer globalCanBuyNum) {
        this.globalCanBuyNum = globalCanBuyNum;
    }

    public Double getGlobalPreferPrice() {
        return globalPreferPrice;
    }

    public void setGlobalPreferPrice(Double globalPreferPrice) {
        this.globalPreferPrice = globalPreferPrice;
    }
    public Integer getGlobalLeftNum() {
        return globalLeftNum;
    }

    public void setGlobalLeftNum(Integer globalLeftNum) {
        this.globalLeftNum = globalLeftNum;
    }



    public Double getPreferPrice() {
        return preferPrice;
    }

    public void setPreferPrice(Double preferPrice) {
        this.preferPrice = preferPrice;
    }

    public Integer getLeftScreenLimitNum() {
        return leftScreenLimitNum;
    }

    public void setLeftScreenLimitNum(Integer leftScreenLimitNum) {
        this.leftScreenLimitNum = leftScreenLimitNum;
    }

    public String getPartnerPrice() {
        return partnerPrice;
    }

    public void setPartnerPrice(String partnerPrice) {
        this.partnerPrice = partnerPrice;
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

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public String getMovieSubtitle() {
        return movieSubtitle;
    }

    public void setMovieSubtitle(String movieSubtitle) {
        this.movieSubtitle = movieSubtitle;
    }

    public String getCineMovieNum() {
        return cineMovieNum;
    }

    public void setCineMovieNum(String cineMovieNum) {
        this.cineMovieNum = cineMovieNum;
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

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDxId() {
        return dxId;
    }

    public void setDxId(String dxId) {
        this.dxId = dxId;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(String lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceType() {
        return priceType;
    }

    public void setPriceType(String priceType) {
        this.priceType = priceType;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
