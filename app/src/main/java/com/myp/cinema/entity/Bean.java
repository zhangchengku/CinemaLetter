package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/2/5.
 */

public class Bean implements Serializable {

    /**
     * code : null
     * data : {"canRefund":0,"cinema":{"address":"vc v","contact":"17826866256","endTime":null,"startTime":null},"qrCode":"536531236531"}
     * message : null
     * status : 1
     */

    private Object code;
    private DataBo data;
    private Object message;
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

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
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
         * canRefund : 0
         * cinema : {"address":"vc v","contact":"17826866256","endTime":null,"startTime":null}
         * qrCode : 536531236531
         */

        private int canRefund;
        private CinemaBo cinema;
        private String qrCode;
        private String shareUrl;

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public int getCanRefund() {
            return canRefund;
        }

        public void setCanRefund(int canRefund) {
            this.canRefund = canRefund;
        }

        public CinemaBo getCinema() {
            return cinema;
        }

        public void setCinema(CinemaBo cinema) {
            this.cinema = cinema;
        }

        public String getQrCode() {
            return qrCode;
        }

        public void setQrCode(String qrCode) {
            this.qrCode = qrCode;
        }

        public static class CinemaBo {
            /**
             * address : vc v
             * contact : 17826866256
             * endTime : null
             * startTime : null
             */

            private String address;
            private String contact;
            private String endTime;
            private String startTime;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getContact() {
                return contact;
            }

            public void setContact(String contact) {
                this.contact = contact;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }
        }
    }
}
