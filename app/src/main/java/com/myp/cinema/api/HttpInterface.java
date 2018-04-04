package com.myp.cinema.api;

import com.myp.cinema.entity.AppVersionBO;
import com.myp.cinema.entity.BaseResult;
import com.myp.cinema.entity.Bean;
import com.myp.cinema.entity.CardBO;
import com.myp.cinema.entity.CinemaBo;
import com.myp.cinema.entity.CommentBO;
import com.myp.cinema.entity.CriticBO;
import com.myp.cinema.entity.FavourBO;
import com.myp.cinema.entity.FeedBackListBO;
import com.myp.cinema.entity.GameBO;
import com.myp.cinema.entity.HotWireBO;

import com.myp.cinema.entity.LunBoAndBO;
import com.myp.cinema.entity.LunBoBO;
import com.myp.cinema.entity.MoviesByCidBO;
import com.myp.cinema.entity.MoviesCommentBO;
import com.myp.cinema.entity.MoviesSoonBO;
import com.myp.cinema.entity.OrderBO;
import com.myp.cinema.entity.OrderNumBO;
import com.myp.cinema.entity.PayBO;
import com.myp.cinema.entity.PayCardBO;
import com.myp.cinema.entity.RechBo;
import com.myp.cinema.entity.ResuBo;
import com.myp.cinema.entity.SessionBO;
import com.myp.cinema.entity.ShareBO;
import com.myp.cinema.entity.ShopBO;
import com.myp.cinema.entity.ShopOrderBO;
import com.myp.cinema.entity.SumptionBo;
import com.myp.cinema.entity.UserBO;
import com.myp.cinema.entity.WXPayBO;

import com.myp.cinema.entity.preferentialnumberBo;
import com.myp.cinema.entity.threelandingBo;
import com.myp.cinema.ui.Prizesreading.HomeTopBean;
import com.myp.cinema.ui.accountbalance.RechatBo;

import java.util.List;


import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import rx.Observable;

/**
 * Created by wuliang on 2017/6/6.
 * <p>
 * 后台接口统一
 */

public interface HttpInterface {
    String URL = "http://192.168.1.54:8080";    //董测试服11123132
//    String URL = "http://hyg.happydoit.com";//好易购服务器
//    String URL = "https://ruiduo.happydoit.com";
//String URL = "http://dxm.happydoit.com";  //12、1正式服
    /**
     * 登陆用户
     */
    @FormUrlEncoded
    @POST("/api/appuser/login")
    Observable<BaseResult<UserBO>> userLogin(@Field("mobile") String mobile,
                                             @Field("password") String password, @Field("uuid") String uuid);


    @FormUrlEncoded
    @POST("/api/appuser/social/login")
    Observable<threelandingBo> userLoginid(@Field("wxUserId") String wxUserId,
                                           @Field("wbUserId") String wbUserId,
                                           @Field("qqUserId") String qqUserId
                                                  );
    /**
     * 退出登录
     */
    @POST("/api/appuser/logout")
    Observable<BaseResult<String>> userlogout();
    /**
     * 用户注册
     */
    @FormUrlEncoded
    @POST("/api/appuser/register")
    Observable<BaseResult<UserBO>> userRegister(@Field("mobile") String mobile, @Field("password") String password,
                                                @Field("verification") String verification, @Field("gender") String gender);

    /**
     * 获取验证码
     */
    @FormUrlEncoded
    @POST("/api/appuser/verification")
    Observable<BaseResult<String>> userVerfication(@Field("mobile") String mobile,
                                                   @Field("verificationType") String verificationType);

    /**
     * 验证用户
     */
    @FormUrlEncoded
    @POST("/api/appuser/verifuser")
    Observable<BaseResult<UserBO>> userVerifuser(@Field("mobile") String mobile,
                                                 @Field("verification") String verification);

    /**
     * 第三方登陆验证用户
     */
    @FormUrlEncoded
    @POST("/api/appuser/bind/mobile")
    Observable<threelandingBo> phonebinding(@Field("mobile") String mobile,
                                                     @Field("wxUserId") String wxUserId,
                                                     @Field("wbUserId") String wbUserId,
                                                     @Field("qqUserId") String qqUserId,
                                                     @Field("verification") String verification);
    /**
     * 第三方登陆验证用户
     * mobile,pwd,header,nickname,gender,wxUserId,wbUserId,qqUserId
     *
     */
    @FormUrlEncoded
    @POST("/api/appuser/social/signup")
    Observable<threelandingBo> thirdregist(@Field("mobile") String mobile,
                                                      @Field("password") String password,
                                                      @Field("header") String header,
                                                      @Field("nickName") String nickName,
                                                      @Field("gender") String gender,
                                                       @Field("wxUserId") String wxUserId,
                                                       @Field("wbUserId") String wbUserId,
                                                       @Field("qqUserId") String qqUserId
                                                      );
    /**
     * 修改密码
     */
    @FormUrlEncoded
    @POST("/api/appuser/update")
    Observable<BaseResult<UserBO>> userUpdatePass(@Field("password") String password, @Field("pwd") String pwd);

    /**
     * 上传头像(需要做cookile持久化，否则会清空后台cookie，导致后台状态变为未登录)
     */
    @Multipart
    @POST("/api/appuser/update")
    Observable<BaseResult<UserBO>> uploadFile(@Part("headerImage\"; filename=\"avatar.jpg") RequestBody file);

    /**
     * 修改昵称
     */
    @FormUrlEncoded
    @POST("/api/appuser/update")
    Observable<BaseResult<UserBO>> updateName(@Field("nickName") String nickName);

    /**
     * 修改性别
     */
    @FormUrlEncoded
    @POST("/api/appuser/update")
    Observable<BaseResult<UserBO>> updateUserSex(@Field("gender") int sex);

    /**
     * 绑定会员
     */
    @FormUrlEncoded
    @POST("/api/appuser/bindcard")
    Observable<BaseResult<CardBO>> cardBindUser(@Field("cinemaId") String cinemaId, @Field("card") String card,
                                                @Field("pwd") String pwd
                                                );


    /**
     * 获取用户会员卡
     */
    @POST("/api/appuser/usercard")
    Observable<BaseResult<List<CardBO>>> cardUser();

    /**
     * 获取影院列表信息
     */
    @FormUrlEncoded
    @POST("/api/cinema/cinemas")
    Observable<BaseResult<List<CinemaBo>>> cinemaList(@Field("city") String city, @Field("longitude") String longitude,
                                                      @Field("latitude") String latitude);

    /**
     * 获取城市列表
     */
    @FormUrlEncoded
    @POST("/api/cinema/cinemacity")
    Observable<BaseResult<List<String>>> cityList(@Field("source") String source);


    /**
     * 查询首页轮播图
     */
    @FormUrlEncoded
    @POST("/api/banner/banners")
    Observable<BaseResult<List<LunBoBO>>> lunboList(@Field("source") String source,
                                                    @Field("cinemaId") String cinemaId);

    /**
     * 查询首页轮播图
     */

    @FormUrlEncoded
    @POST("/api/new/banners")
    Observable<BaseResult<LunBoAndBO>> lunboandList(@Field("source") String source,
                                                    @Field("cinemaId") String cinemaId);
    /**LunBoAndBO
     * 获取正在热映影片列表
     */
    @FormUrlEncoded
    @POST("/api/Movie/hotMovie")
    Observable<BaseResult<List<MoviesByCidBO>>> moviesHot(@Field("cinemaId") String cinameId);

    /**
     * 获取即将热映影片列表
     */
    @FormUrlEncoded
    @POST("/api/Movie/soonMovie")
    Observable<BaseResult<List<MoviesSoonBO>>> moviesSoon(@Field("cinemaId") String cinameId);

    /**
     * 获取场次信息
     */
    @FormUrlEncoded
    @POST("/api/Movie/MoviesByCid")
    Observable<BaseResult<List<MoviesByCidBO>>> moviesByCid(@Field("cinemaId") String cinameId);

    /**
     * 提交订单
     */
    @FormUrlEncoded
    @POST("/api/new/order/submitorder")
    Observable<BaseResult<OrderBO>> orderSubmit(   //联系电话
                                                @Field("orderName") String orderName,      //联系人姓名（可不传）
                                                @Field("seats") String seats,              //座位连接
                                                @Field("ticketNum") String ticketNum,       //票数量
                                                @Field("ticketOriginPrice") String ticketOriginPrice,   //总价
                                                @Field("cinemaNumber") String cinemaNumber,     //广电总局影院唯一编码
                                                @Field("hallId") String hallId,              //鼎新影厅id
                                                @Field("playId") String playId,               //鼎新场次id
                                                @Field("cineMovieNum") String cineMovieNum,     //广电总局规定的影片全国唯一编码
                                                @Field("seatId") String seatId);             //鼎新座位id 多个

    /**
     * 查询订单列表
     */
    @FormUrlEncoded
    @POST("/api/order/orderlist")
    Observable<BaseResult<List<OrderBO>>> orserList(@Field("orderType") String orderType,  //0未完成订单，1已完成订单
                                                    @Field("orderPage") String orderPage,
                                                    @Field("orderSize") String orderSize);

    /**
     * 查询订单详情
     */
    @FormUrlEncoded
    @POST("/api/order/detail")
    Observable<Bean> orderMessage(@Field("id") String id,  //0未完成订单，1已完成订单
                                  @Field("cinemaId") String cinemaId);

    /**
     * 查询订单列表
     */
    @FormUrlEncoded
    @POST("/api/order/refund/info")
    Observable<RefundBO> refundinfo(@Field("id") String id //0未完成订单，1已完成订单
    );
    @FormUrlEncoded
    @POST("/api/order/refund")
    Observable<RefundBO> refund(@Field("id") String id //0未完成订单，1已完成订单
                                ,@Field("cinemaId") String cinemaId
    );

//    @FormUrlEncoded
//    @POST("/api/order/detail")
//    Call<requstBean> orderMessage(@Field("id") String id,  //0未完成订单，1已完成订单
//                                  @Field("cinemaId") String cinemaId);

    /**
     * 查询单个订单详情
     */
    @FormUrlEncoded
    @POST("/api/order/queryorder")
    Observable<BaseResult<OrderBO>> orderQuery(@Field("orderNum") String orderNum);


    /**
     * 检测是否有未完成的订单
     */
    @POST("/api/new/order/checkorder")
    Observable<BaseResult<OrderNumBO>> orderCheck();

    /**
     * 取消未完成订单
     */
    @FormUrlEncoded
    @POST("/api/order/cancelorder")
    Observable<BaseResult<OrderNumBO>> orderCancel(@Field("orderNum") String orderNum);
    /**
     * 会员卡优惠数量
     */
    @FormUrlEncoded
    @POST("/api/global/can/buy/num")
    Observable<BaseResult<preferentialnumberBo>> getsets(@Field("cinemaId") String cinemaId, @Field("playId") String playId);

    /**
     * 获取会员卡支付价格
     */
    @FormUrlEncoded
    @POST("/api/order/cardprice")
    Observable<BaseResult<PayCardBO>> cardPayPrice(@Field("orderNum") String orderNum, @Field("card") String card);


    /**
     * 会员卡支付
     */
    @FormUrlEncoded
    @POST("/api/order/card")
    Observable<BaseResult<ResuBo>> payCard(@Field("orderNum") String orderNum, @Field("pwd") String pwd,
                                           @Field("card") String card);

    /**
     * 支付宝支付
     */
    @FormUrlEncoded
    @POST("/api/order/alipay")
    Observable<BaseResult<PayBO>> payAlipay(@Field("orderNum") String orderNum);


    /**
     * 微信支付
     */
    @FormUrlEncoded
    @POST("/api/order/wechat")
    Observable<BaseResult<WXPayBO>> payWeChat(@Field("orderNum") String orderNum);
    /**
     * 会员卡支付
     */
    @FormUrlEncoded
    @POST("/api/order/coupon/pay")
    Observable<BaseResult<ResuBo>> loadcardPay(@Field("orderNum") String orderNum,@Field("coupon") String coupon);

    /**
     * 获取好消息文章
     */
    @FormUrlEncoded
    @POST("/api/article/articles")
    Observable<BaseResult<List<HotWireBO>>> hotWire(@Field("articleType") String articleType,
                                                    @Field("articlePage") String articlePage,
                                                    @Field("articleSize") String articleSize,
                                                    @Field("cinemaId") String cinemaId);
    /**
     * 获取收藏消息文章
     */
    @FormUrlEncoded
    @POST("/api/appuser/keep/article/list")
    Observable<BaseResult<List<HotWireBO>>> articlesCollection(@Field("pageNo") String pageNo,
                                                    @Field("pageSize") String pageSize);
    /**
     * 获取充值记录
     */
    @FormUrlEncoded
    @POST("/api/member/card/recharge/order/list")
    Observable<BaseResult<List<RechBo>>> loadRecharge( @Field("cardNum") String cardNum,
                                                       @Field("pageNo") String pageNo,
                                                      @Field("pageSize") String pageSize



                                                     );
    /**
     * 消费明细
     */
    @FormUrlEncoded
    @POST("/api/member/card/consumption/list")
    Observable<BaseResult<List<SumptionBo>>> loadcosumption(@Field("cardNum") String cardNum,
                                                            @Field("pageNo") String pageNo,
                                                            @Field("pageSize") String pageSize

    );
    /**loadcosumption
     * 获取单个电影评论
     */
    @FormUrlEncoded
    @POST("/api/Comment/myComment")
    Observable<BaseResult<MoviesCommentBO>> moviesComment(@Field("appUserId") String appUserId,
                                                          @Field("movieId") String movieId);


    /**
     * 收藏电影
     */
    @FormUrlEncoded
    @POST("/api/Comment/saveCollect")
    Observable<BaseResult<MoviesCommentBO>> moviesShouCang(@Field("appUserId") String appUserId,
                                                           @Field("movieId") String movieId,
                                                           @Field("collectStatus") String collectStatus);  //收藏为1，不收藏为0

    /**
     * 想看电影
     */
    @FormUrlEncoded
    @POST("/api/Comment/saveWantSee")
    Observable<BaseResult<MoviesCommentBO>> moviesWantSee(@Field("appUserId") String appUserId,
                                                          @Field("movieId") String movieId,
                                                          @Field("wantSee") String wantSee);  // 想看为1，不想看为0

    /**
     * 提交评论
     */
    @FormUrlEncoded
    @POST("/api/Comment/saveComment")
    Observable<BaseResult<Object>> moviesSummitCom(@Field("appUserId") String appUserId,
                                                   @Field("movieId") String movieId,
                                                   @Field("score") String score,//分数
                                                   @Field("comment") String comment);   //评论

    /**
     * 获取游戏列表
     */
    @FormUrlEncoded
    @POST("/api/game/games")
    Observable<BaseResult<List<GameBO>>> gameList(@Field("pageSize") String pageSize, @Field("pageNo") String pageNo);

    /**
     * 获取有奖任务列表
     */
    @FormUrlEncoded
    @POST("/api/reward/article/list")
    Observable<HomeTopBean>getList(@Field("pageNo") String pageNo,
            @Field("pageSize") String pageSize );

    /**
     * 意见反馈
     */
    @FormUrlEncoded
    @POST("/api/suggestion/suggestions")
    Observable<BaseResult<String>> submitFeed(@Field("phone") String phone, @Field("suggestion") String suggestion);


    /**
     * 获取个人中心四个记录数量
     */
    @FormUrlEncoded
    @POST("/api/Comment/myRecords")
    Observable<BaseResult<UserBO>> memberRecords(@Field("appUserId") String appUserId);

    /**
     * 获取自己的电影评论记录
     */
    @FormUrlEncoded
    @POST("/api/Comment/myCommentList")
    Observable<BaseResult<List<CommentBO>>> personCommentList(@Field("appUserId") String appUserId,
                                                              @Field("pageNo") String pageNo,
                                                              @Field("pageSize") String pageSize);

    @POST("/api/member/card/recharge/amount")
    Observable<BaseResult<List<RechatBo>>> rechatgejine();
    /**rechatgejine
     * 获取自己观看电影记录
     */
    @FormUrlEncoded
    @POST("/api/Movie/myWatchedList")
    Observable<BaseResult<List<CommentBO>>> personReadList(@Field("appUserId") String appUserId,
                                                           @Field("pageNo") String pageNo,
                                                           @Field("pageSize") String pageSize);

    /**
     * weixinpay
     * 支付宝支付
     */
    @FormUrlEncoded
    @POST("/api/member/card/recharge/alipay")
    Observable<BaseResult<PayBO>> zhifubaopay(@Field("cinemaId") String cinemaId,
                                              @Field("amountType") Integer amountType,
                                              @Field("amountId") Integer amountId,
                                              @Field("cardNum") String cardNum,
                                              @Field("app") Integer app
    );
    /**
     * weixinpay
     * 支付宝支付其他金额
     */
    @FormUrlEncoded
    @POST("/api/member/card/recharge/alipay")
    Observable<BaseResult<PayBO>> zhifubaopayqita(@Field("cinemaId") String cinemaId,
                                                  @Field("amountType") Integer amountType,
                                                  @Field("rechargeMoney") Integer rechargeMoney,
                                                  @Field("cardNum") String cardNum,
                                                  @Field("app") Integer app);

    /**
     * weixinpay
     * 微信支付
     */
    @FormUrlEncoded
    @POST("/api/member/card/recharge/wxpay")
    Observable<BaseResult<WXPayBO>> weixinpay(@Field("cinemaId") String cinemaId,
                                              @Field("amountType") Integer amountType,
                                              @Field("amountId") Integer amountId,
                                              @Field("cardNum") String cardNum,
                                              @Field("app") Integer app);
    /**
     * weixinpay
     * 微信支付其他金额
     */
    @FormUrlEncoded
    @POST("/api/member/card/recharge/wxpay")
    Observable<BaseResult<WXPayBO>> weixinpayta(@Field("cinemaId") String cinemaId,
                                                @Field("amountType") Integer amountType,
                                                @Field("rechargeMoney") Integer rechargeMoney,
                                                @Field("cardNum") String cardNum,
                                                @Field("app") Integer app);
    /**
     * 获取自己想看电影列表
     */
    @FormUrlEncoded
    @POST("/api/Movie/myWantSeeList")
    Observable<BaseResult<List<MoviesByCidBO>>> personWantSeeList(@Field("appUserId") String appUserId,
                                                                  @Field("cinemaId") String cinemaId,
                                                                  @Field("pageNo") String pageNo,
                                                                  @Field("pageSize") String pageSize);
    /**
     * 获取自己收藏电影记录
     */
    @FormUrlEncoded
    @POST("/api/Movie/myCollectList")
    Observable<BaseResult<List<MoviesByCidBO>>> personCollectList(@Field("appUserId") String appUserId,
                                                                  @Field("pageNo") String pageNo,
                                                                  @Field("pageSize") String pageSize);
    /**


    /**
     * 分享电影
     */
    @FormUrlEncoded
    @POST("/api/Movie/share")
    Observable<BaseResult<ShareBO>> shareMovie(@Field("movieId") String movieId);


    @FormUrlEncoded
    @POST("/api/movie/comment/list")
    Observable<BaseResult<List<CriticBO>>> criticMovie(@Field("movieId") Long movieId,
                                                 @Field("pageNo") Integer pageNo,
                                                 @Field("pageSize") Integer pageSize);
    @FormUrlEncoded
    @POST("/api/movie/comment/upvote")
    Observable<BaseResult<CriticBO>> dianZan(@Field("id") Long id);
    /**
     * 获取金币兑换的商品
     */
    @FormUrlEncoded
    @POST("/api/game/exchanges")
    Observable<BaseResult<List<ShopBO>>> creditsShop(@Field("pageSize") String pageSize,
                                                     @Field("pageNo") String pageNo,
                                                     @Field("cinemaId") String cinemaId);

    /**
     * 金币兑换记录
     */
    @POST("/api/game/pointorder/list")
    Observable<BaseResult<List<ShopOrderBO>>> creditsOrder();


    /**
     * 我的约会
     */
    @POST("/api/appointment/appointments")
    Observable<BaseResult<String>> personSome();

    /**
     * 我的优惠券
     */
    @POST("/api/coupon/coupons")
    Observable<BaseResult<String>> personCoupon();

    /**
     * 添加优惠券
     */
    @POST("/api/coupon/add")
    Observable<BaseResult<String>> personAddCoupon();

    /**
     * 意见反馈列表
     */
    @POST("/api/suggestion/list")
    Observable<BaseResult<List<FeedBackListBO>>> feedBackList();
    /**feedBackList
     * 获取单个电影的场次
     */
    @FormUrlEncoded
    @POST("/api/new/movie/screening")
    Observable<BaseResult<SessionBO>> movieScreen(@Field("cinemaId") String cinemaId,
                                                  @Field("movieId") String movieId);


    /**
     * 版本检测更新
     */
    @POST("/dx/version/version.json")
    Observable<BaseResult<AppVersionBO>> loadVersion();


    /**
     * 获取场次上面的优惠信息列表
     */
    @POST("/api/price/favorinfo/list")
    Observable<BaseResult<List<FavourBO>>> favorinfo();

}

