package com.myp.cinema.ui.Prizesreading;

import java.util.List;

/**
 * Created by Administrator on 2018/1/28.
 */
public class HomeTopBean  {


    /**
     * code : null
     * data : [{"articleUrl":"http://192.168.1.54:8080/message/article/articles/read?id=26","description":"阿斯达阿斯蒂芬感觉","pic":"http://127.0.0.1:8080/upload/20171017/844ppOm.jpg","publishTime":"2017-10-17 18:32:28","title":"地方规范化飞过海"},{"articleUrl":"http://192.168.1.54:8080/message/article/articles/read?id=25","description":"少时诵诗书","pic":"http://127.0.0.1:8080/upload/20171017/667CEJs.jpg","publishTime":"2017-10-17 15:42:35","title":"搜索"},{"articleUrl":"http://192.168.1.54:8080/message/article/articles/read?id=24","description":"2222","pic":"http://127.0.0.1:8080/upload/20171016/795krWs.jpg","publishTime":"2017-10-16 18:11:13","title":"11111"},{"articleUrl":"http://192.168.1.54:8080/message/article/articles/read?id=23","description":"sdfs","pic":"http://127.0.0.1:8080/upload/20171016/158GXJT.jpg","publishTime":"2017-10-16 14:49:01","title":"sdf "},{"articleUrl":"http://192.168.1.54:8080/message/article/articles/read?id=22","description":"散打","pic":"http://127.0.0.1:8080/upload/20171016/382PGBb.jpg","publishTime":"2017-10-16 14:37:09","title":"阿萨德"},{"articleUrl":"http://192.168.1.54:8080/message/article/articles/read?id=21","description":"阿斯顿发送到发生的打发斯蒂芬爱上对方输入法各色人刚不和","pic":"http://192.168.1.64:8080/upload/20170824/263MTGE.jpg","publishTime":"2017-08-24 15:59:48","title":"阿斯顿发生放大撒的发生的发盛世嫡妃发生的发生非法"},{"articleUrl":"http://192.168.1.54:8080/message/article/articles/read?id=20","description":"jjkjkjljlk","pic":"http://192.168.1.64:8080/upload/20170824/876hyBJ.jpg","publishTime":"2017-08-24 14:42:10","title":"lalla"},{"articleUrl":"http://192.168.1.54:8080/message/article/articles/read?id=19","description":"234","pic":"","publishTime":"2017-08-23 13:02:50","title":"234"}]
     * message : null
     * status : 1
     */

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    private Integer status;
    private List<DataBo> data;



    public List<DataBo> getData() {
        return data;
    }

    public void setData(List<DataBo> data) {
        this.data = data;
    }

    public static class DataBo {
        /**
         * articleUrl : http://192.168.1.54:8080/message/article/articles/read?id=26
         * description : 阿斯达阿斯蒂芬感觉
         * pic : http://127.0.0.1:8080/upload/20171017/844ppOm.jpg
         * publishTime : 2017-10-17 18:32:28
         * title : 地方规范化飞过海
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
}
