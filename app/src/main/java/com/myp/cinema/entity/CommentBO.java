package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2017/7/10.
 * <p>
 * 看过的电影bean
 */

public class CommentBO implements Serializable {


    /**
     * comment :
     * commentRecord : 0
     * id : 4
     * movieName : 功夫熊猫2
     * picture :
     * score : 0
     */

    private String comment;
    private String commentRecord;
    private String id;
    private String movieName;
    private String picture;
    private String score;
    private String movieType;
    private String createTime;
    private String summary;

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
