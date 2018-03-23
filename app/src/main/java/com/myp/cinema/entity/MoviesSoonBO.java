package com.myp.cinema.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuliang on 2017/6/15.
 * <p>
 * 即将上映的列表
 */

public class MoviesSoonBO implements Serializable {


    private String date;  //时间

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<MoviesByCidBO> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MoviesByCidBO> movieList) {
        this.movieList = movieList;
    }

    private List<MoviesByCidBO> movieList;


}
