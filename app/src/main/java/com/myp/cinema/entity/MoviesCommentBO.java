package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2017/7/5.
 * <p>
 * 电影影评bean
 */

public class MoviesCommentBO implements Serializable {


    /**
     * collectStatus : 0
     * comment : null
     * commentRecord : 0
     * createTime : 2017-07-06 10:20:12
     * deleteTime : null
     * id : null
     * modifyTime : null
     * movieId : null
     * score : null
     * type : null
     * userId : null
     * valid : true
     * version : 0
     * wantSee : 0
     * watchRecord : 0
     */

    private String collectStatus;
    private String comment;
    private String commentRecord;
    private String createTime;
    private String deleteTime;
    private String id;
    private String modifyTime;
    private String movieId;
    private String score;
    private String type;
    private String userId;
    private String valid;
    private String version;
    private String wantSee;
    private String watchRecord;

    public String getCollectStatus() {
        return collectStatus;
    }

    public void setCollectStatus(String collectStatus) {
        this.collectStatus = collectStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentRecord() {
        return commentRecord;
    }

    public void setCommentRecord(String commentRecord) {
        this.commentRecord = commentRecord;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(String deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String isValid() {
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

    public String getWantSee() {
        return wantSee;
    }

    public void setWantSee(String wantSee) {
        this.wantSee = wantSee;
    }

    public String getWatchRecord() {
        return watchRecord;
    }

    public void setWatchRecord(String watchRecord) {
        this.watchRecord = watchRecord;
    }
}
