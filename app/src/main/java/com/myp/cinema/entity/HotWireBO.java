package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2017/6/22.
 * <p>
 * 好消息的bean
 */

public class HotWireBO implements Serializable {


    /**
     * articleUrl : http://localhost:8080/manage/article/articles/read?id=4
     * description : 的法国海军
     * pic : /upload/20170622/64jiNX.png
     * publishTime : 2017-06-22 11:21:52
     * title : 次电话i
     */

    private String articleUrl;
    private String description;
    private String pic;
    private String publishTime;
    private String title;

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
