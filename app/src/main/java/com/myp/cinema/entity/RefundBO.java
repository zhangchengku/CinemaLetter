package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/5.
 */
public class RefundBO implements Serializable {

    /**
     * code : null
     * data : {"refundFee":51.5,"refundHandFee":3}
     * message : null
     * status : 1
     */

    private Object code;
    private DataBo data;
    private String message;
    private int status;

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public DataBo getData() {
        return data;
    }

    public void setData(DataBo data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class DataBo {
        /**
         * refundFee : 51.5
         * refundHandFee : 3
         */

        private double refundFee;
        private double refundHandFee;

        public double getRefundFee() {
            return refundFee;
        }

        public void setRefundFee(double refundFee) {
            this.refundFee = refundFee;
        }

        public double getRefundHandFee() {
            return refundHandFee;
        }

        public void setRefundHandFee(double refundHandFee) {
            this.refundHandFee = refundHandFee;
        }
    }
}
