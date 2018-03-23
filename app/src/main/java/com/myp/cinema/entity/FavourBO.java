package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2017/7/25.
 * <p>
 * <p>
 * 优惠信息bean
 */

public class FavourBO implements Serializable {


    /**
     * content : 阿萨德法师打发斯蒂芬
     * id : 3
     * title : 暗示的九分裤拉萨的
     */

    private String content;
    private String id;
    private String title;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
