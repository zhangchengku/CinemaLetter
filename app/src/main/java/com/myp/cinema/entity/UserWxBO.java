package com.myp.cinema.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuliang on 2017/7/19.
 * <p>
 * 微信用户Bean
 */

public class UserWxBO implements Serializable {


    /**
     * openid : osIAGxA5mJuhI11Ih9KGiAwTKIOg
     * nickname : 不违心不放纵
     * sex : 1
     * language : zh_CN
     * city : Shaoxing
     * province : Zhejiang
     * country : CN
     * headimgurl : http://wx.qlogo.cn/mmhead/Q3auHgzwzM5kIkibdVvib4W4jcJpUbxcZWmMlhY2Hw2kibBCFok0CIOVQ/0
     * privilege : []
     * unionid : o8uva1OzM9wRXuOhkYblfwOiieEE
     */

    private String openid;
    private String nickname;
    private int sex;
    private String language;
    private String city;
    private String province;
    private String country;
    private String headimgurl;
    private String unionid;
    private List<Object> privilege;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public List<Object> getPrivilege() {
        return privilege;
    }

    public void setPrivilege(List<Object> privilege) {
        this.privilege = privilege;
    }
}
