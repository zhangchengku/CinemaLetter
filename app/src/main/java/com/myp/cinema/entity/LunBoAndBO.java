package com.myp.cinema.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/3/5.
 */
public class LunBoAndBO implements Serializable {

    /**
     * code : null
     * data : {"ads":[{"articleUrl":"http://192.168.1.54:8080/message/article/articles/read?id=687","pic":"http://192.168.1.54:8080/upload/20180305/252SScd.jpg"},{"articleUrl":"http://192.168.1.54:8080/message/article/articles/read?id=686","pic":"http://192.168.1.54:8080/upload/20180305/975vFAV.jpg"}],"banners":[{"dxMovie":null,"imageUrl":"http://dxm.happydoit.com:80/upload/20180115/744XNpL.jpg","playType":1,"redirectUrl":"https://c.hejiajinrong.com/300/324/1330/aHR0cDovL3d3dy5oZWppYWppbnJvbmcuY29tL2NoYW5uZWwvaDU_cmVkaXJlY3RVUkw9L2FjdGl2aXR5LzIwMTcvMjAxN18xMmRleGluLw"},{"dxMovie":{"cineMovieId":1052,"cineMovieNum":"074100172018","country":"美国","dxActors":[{"country":"","name":"米歇尔·威廉姆斯","picture":"http://dxm.happydoit.com:80/upload/20180226/93RKko.png"},{"country":"","name":"克里斯托弗·普卢默","picture":"http://dxm.happydoit.com:80/upload/20180226/732iaub.png"}],"dxDirectors":[{"country":"","name":"雷德利·斯科特","picture":"http://dxm.happydoit.com:80/upload/20180226/235pGRi.png"}],"dxVideos":[{"name":"金钱世界","picture":"http://dxm.happydoit.com:80/upload/20180226/908pZrq.png","url":"http://dxm.happydoit.com:80/upload/20180226/409KQNG.mp4"}],"foreignName":"All the Money in the World","id":374,"infoUrl":"","introduction":"电影《金钱世界》改编自一起曾轰动世界的豪门绑架事件：世界首富保罗·盖蒂（克里斯托弗·普卢默 饰）之孙遭遇黑帮绑架，绑匪向其母盖尔（米歇尔·威廉姆斯 饰）索要1700万美元赎金，已经与丈夫离婚的盖尔无力支付这笔高昂的赎金，只能向盖蒂家族求救，但富可敌国却无比吝啬的老盖蒂却拒绝为孙子（查理·普拉默 饰）支付赎金，拿不到钱的绑匪丧心病狂的割下了人质的耳朵邮寄给盖蒂家族，心碎的盖尔在前CIA特工弗莱彻·蔡斯（马克·沃尔伯格 饰）的协助下，试图撼动这一僵局，解救自己的儿子\u2026\u2026","mediaLib":"","movieDimensional":"2D","movieLanguage":"英语","movieName":"金钱世界（数字）","movieSize":"普通","movieSubtitle":"中文","photos":"http://dxm.happydoit.com:80/upload/20180226/895RtCe.png,http://dxm.happydoit.com:80/upload/20180226/305RQFt.png,http://dxm.happydoit.com:80/upload/20180226/252jNof.png","picture":"http://dxm.happydoit.com:80/upload/20180226/931RnrK.png","playTime":124,"point":0,"preVideo":"","sell":1,"startPlay":"2018-03-02 00:00:00","summary":"有钱人跟你想的不一样"},"imageUrl":"http://dxm.happydoit.com:80/upload/20180226/335FSek.jpg","playType":2,"redirectUrl":null},{"dxMovie":{"cineMovieId":1049,"cineMovieNum":"001108562017","country":"香港 / 中国大陆","dxActors":[{"country":"","name":"薛凯琪","picture":"http://dxm.happydoit.com:80/upload/20171103/574ShVn.png"},{"country":"","name":"陈意涵","picture":"http://dxm.happydoit.com:80/upload/20180209/629CcWa.png"},{"country":"","name":"张钧甯","picture":"http://dxm.happydoit.com:80/upload/20180209/557nUZG.png"}],"dxDirectors":[{"country":"","name":"黄真真","picture":"http://dxm.happydoit.com:80/upload/20180209/455AJCj.png"}],"dxVideos":[{"name":"闺蜜2","picture":"http://dxm.happydoit.com:80/upload/20180209/619UDUs.png","url":"http://dxm.happydoit.com:80/upload/20180209/2bQxn.mp4"}],"foreignName":"","id":367,"infoUrl":"","introduction":"《闺蜜2：无二不作》讲述了陈意涵、薛凯琪、张钧甯闺蜜团空降越南，开启了一场婚前失控单身之旅。\n","mediaLib":"","movieDimensional":"2D","movieLanguage":"国语","movieName":"闺蜜2","movieSize":"普通","movieSubtitle":"中文","photos":"http://dxm.happydoit.com:80/upload/20180209/113dGbL.png,http://dxm.happydoit.com:80/upload/20180209/276lChM.png,http://dxm.happydoit.com:80/upload/20180209/921lFnO.png","picture":"http://dxm.happydoit.com:80/upload/20180209/593uqwF.png","playTime":109,"point":0,"preVideo":"","sell":1,"startPlay":"2018-03-02 00:00:00","summary":"历经坎坷  终于重聚"},"imageUrl":"http://dxm.happydoit.com:80/upload/20180226/666oGCv.jpg","playType":2,"redirectUrl":null}]}
     * message : null
     * status : 1
     */
        private List<AdsBo> ads;
        private List<BannersBo> banners;

        public List<AdsBo> getAds() {
            return ads;
        }

        public void setAds(List<AdsBo> ads) {
            this.ads = ads;
        }

        public List<BannersBo> getBanners() {
            return banners;
        }

        public void setBanners(List<BannersBo> banners) {
            this.banners = banners;
        }

        public static class AdsBo {
            /**
             * articleUrl : http://192.168.1.54:8080/message/article/articles/read?id=687
             * pic : http://192.168.1.54:8080/upload/20180305/252SScd.jpg
             */

            private String articleUrl;
            private String starBanner;

            public String getStarBanner() {
                return starBanner;
            }

            public void setStarBanner(String starBanner) {
                this.starBanner = starBanner;
            }

            public String getArticleUrl() {
                return articleUrl;
            }

            public void setArticleUrl(String articleUrl) {
                this.articleUrl = articleUrl;
            }


        }

        public static class BannersBo {
            /**
             * dxMovie : null
             * imageUrl : http://dxm.happydoit.com:80/upload/20180115/744XNpL.jpg
             * playType : 1
             * redirectUrl : https://c.hejiajinrong.com/300/324/1330/aHR0cDovL3d3dy5oZWppYWppbnJvbmcuY29tL2NoYW5uZWwvaDU_cmVkaXJlY3RVUkw9L2FjdGl2aXR5LzIwMTcvMjAxN18xMmRleGluLw
             */

            private MoviesByCidBO dxMovie;

            public MoviesByCidBO getDxMovie() {
                return dxMovie;
            }

            public void setDxMovie(MoviesByCidBO dxMovie) {
                this.dxMovie = dxMovie;
            }

            private String imageUrl;
            private String playType;
            private String redirectUrl;



            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getPlayType() {
                return playType;
            }

            public void setPlayType(String playType) {
                this.playType = playType;
            }

            public String getRedirectUrl() {
                return redirectUrl;
            }

            public void setRedirectUrl(String redirectUrl) {
                this.redirectUrl = redirectUrl;
            }
        }
    }

