package com.myp.cinema.entity;


import java.io.Serializable;

/**
 * 电影演员
 * 后台维护一些数据，到时候搜索添加吧
 */

public class DirectorBO implements Serializable {
    private String name;//姓名
    private String country;//国家地区
    private String countryIndex;//国家对应索引简写
    private String Introduction;//导演介绍
    private String picture;//导演图片

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCountryIndex() {
        return countryIndex;
    }

    public void setCountryIndex(String countryIndex) {
        this.countryIndex = countryIndex;
    }
}
