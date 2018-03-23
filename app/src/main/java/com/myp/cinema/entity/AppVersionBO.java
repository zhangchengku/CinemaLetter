package com.myp.cinema.entity;

import java.io.Serializable;

/**
 * Created by wuliang on 2017/7/24.
 * <p>
 * App版本号
 */

public class AppVersionBO implements Serializable {


    private Version android;

    public Version getAndroid() {
        return android;
    }

    public void setAndroid(Version android) {
        this.android = android;
    }

    public class Version {
        private String versionCode;    //版本号
        private String versionName;    //版本名称
        private String updateMessage;   //更新内容
        private String minVersionCode;   //最小可使用的版本号
        private String minVersionName;   //最小可使用的版本名称
        private String url;    //app下载的地址

        public String getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(String versionCode) {
            this.versionCode = versionCode;
        }

        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }

        public String getUpdateMessage() {
            return updateMessage;
        }

        public void setUpdateMessage(String updateMessage) {
            this.updateMessage = updateMessage;
        }

        public String getMinVersionCode() {
            return minVersionCode;
        }

        public void setMinVersionCode(String minVersionCode) {
            this.minVersionCode = minVersionCode;
        }

        public String getMinVersionName() {
            return minVersionName;
        }

        public void setMinVersionName(String minVersionName) {
            this.minVersionName = minVersionName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }


}
