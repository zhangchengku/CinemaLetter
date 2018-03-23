package com.myp.cinema.ui.userlogin;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/15.
 */
public class UserstyleBo implements Serializable {



    private String createTime;
    private int gender;
    private Object header;
    private int id;
    private int insider;
    private String loginDate;
    private String mobile;
    private String nickName;
    private String uuid;
//    private  int bindStatus;

//    public int getBindStatus() {
//        return bindStatus;
//    }
//
//    public void setBindStatus(int bindStatus) {
//        this.bindStatus = bindStatus;
//    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Object getHeader() {
        return header;
    }

    public void setHeader(Object header) {
        this.header = header;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInsider() {
        return insider;
    }

    public void setInsider(int insider) {
        this.insider = insider;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


}
