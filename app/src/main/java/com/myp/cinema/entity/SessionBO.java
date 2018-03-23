package com.myp.cinema.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wuliang on 2017/7/21.
 * <p>
 * 场次bean
 */

public class SessionBO implements Serializable {


    private List<ScreenPlanListBo> screenPlanList;

    public List<ScreenPlanListBo> getScreenPlanList() {
        return screenPlanList;
    }

    public void setScreenPlanList(List<ScreenPlanListBo> screenPlanList) {
        this.screenPlanList = screenPlanList;
    }

    public static class ScreenPlanListBo implements Serializable{
        /**
         * date : 2017-07-21
         * list : []
         */

        private String date;
        private List<MoviesSessionBO> list;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public List<MoviesSessionBO> getList() {
            return list;
        }

        public void setList(List<MoviesSessionBO> list) {
            this.list = list;
        }
    }
}
