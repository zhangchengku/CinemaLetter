package com.myp.cinema.entity;

import com.mcxtzhang.indexlib.IndexBar.bean.BaseIndexPinyinBean;

import java.io.Serializable;

/**
 * Created by wuliang on 2017/7/11.
 * <p>
 * 城市javabean
 */

public class CityBO extends BaseIndexPinyinBean implements Serializable {


    private String city;//城市名字
    private boolean isTop;//是否是最上面的 不需要被转化成拼音的

    public CityBO(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public CityBO setCity(String city) {
        this.city = city;
        return this;
    }

    public boolean isTop() {
        return isTop;
    }

    public CityBO setTop(boolean top) {
        isTop = top;
        return this;
    }

    @Override
    public String getTarget() {
        return city;
    }

    @Override
    public boolean isNeedToPinyin() {
        return !isTop;
    }


    @Override
    public boolean isShowSuspension() {
        return !isTop;
    }


}
