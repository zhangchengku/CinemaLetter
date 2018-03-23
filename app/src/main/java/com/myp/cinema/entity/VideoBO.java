package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2017/6/22.
 * <p>
 * 视频bean
 */

public class VideoBO implements Serializable {

    private String picture;//播放展示图片链接
    private String url;//播放地址链接
    private String name;//预告片名称，添加时候需要使用名字来搜索选择，添加时候最好带上电影名字

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
