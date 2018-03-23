package com.myp.cinema.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/6.
 */

public class ResuBo implements Serializable {
        @SerializedName("result")
        private int resultX;

        public int getResultX() {
            return resultX;
        }

        public void setResultX(int resultX) {
            this.resultX = resultX;
        }

}
