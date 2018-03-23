package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2017/6/21.
 * <p>
 * 轮播图bean
 */

public class LunBoBO implements Serializable {

    private MoviesByCidBO dxMovie;

    private String imageUrl;

    private String playType;

    private String redirectUrl;


    public MoviesByCidBO getDxMovie() {
        return dxMovie;
    }

    public void setDxMovie(MoviesByCidBO dxMovie) {
        this.dxMovie = dxMovie;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPlayType() {
        return playType;
    }

    public void setPlayType(String playType) {
        this.playType = playType;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
