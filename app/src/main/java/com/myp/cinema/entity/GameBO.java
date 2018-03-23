package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2017/7/6.
 * <p>
 * 游戏实体bean
 */

public class GameBO implements Serializable {


    /**
     * gameDescription : 第三个游戏说明
     * gameName : 第三个游戏
     * imageUrl : http://tse1.mm.bing.net/th?id=OIP.90SF2PkW75RPgUT5KlduigEsBu&w=300&h=110&c=7&qlt=90&o=4&pid=1.7
     * point : 123
     * redirectUrl : www.bing.com
     */

    private String gameDescription;
    private String gameName;
    private String imageUrl;
    private String point;
    private String redirectUrl;

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
