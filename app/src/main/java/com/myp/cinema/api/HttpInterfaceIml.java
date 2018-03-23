package com.myp.cinema.api;

import android.util.Log;

import com.myp.cinema.entity.AppVersionBO;
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
import com.myp.cinema.entity.threelandingBo;
import com.myp.cinema.ui.Prizesreading.HomeTopBean;
import com.myp.cinema.ui.accountbalance.RechatBo;
import com.myp.cinema.util.rx.RxResultHelper;

import java.util.List;

import okhttp3.RequestBody;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by wuliang on 2017/6/6.
 * <p>
 * 所有后台接口的实现类
 */

public class HttpInterfaceIml {

    private static HttpInterface service;
    private static String pageNum = "20";   //这里设置所有分页的项目一次拿20条

    /**
     * 获取代理对象
     */
    private static HttpInterface getService() {
        if (service == null)
            service = ApiManager.getInstance().configRetrofit(HttpInterface.class, HttpInterface.URL);
        return service;
    }

    /**
     * 用户登陆
     */
    public static Observable<UserBO> userLogin(String phone, String password, String uuid) {
        return getService().userLogin(phone, password, uuid).compose(RxResultHelper.<UserBO>httpRusult());
    }
    /*
    * 授权成功的判断
    *
    * */
public static Observable<threelandingBo> userLoginid(String wxUserId, String wbUserId, String qqUserId) {
    return getService().userLoginid(wxUserId,wbUserId,qqUserId).compose(schedulersTransformer.<threelandingBo>httpRusult());
}
    /**
     * 退出登录
     */
    public static Observable<String> userLogout() {
        return getService().userlogout().compose(RxResultHelper.<String>httpRusult());
    }


    /**
     * 用户注册
     */
    public static Observable<UserBO> userRegister(String phone, String password, String verification,
                                                  String sex) {
        return getService().userRegister(phone, password, verification, sex)
                .compose(RxResultHelper.<UserBO>httpRusult());
    }

    /**
     * 获取验证码
     */
    public static Observable<String> userVerification(String phone, String verificationType) {
        return getService().userVerfication(phone, verificationType).compose(RxResultHelper.<String>httpRusult());
    }

    /**
     * 验证用户
     */
    public static Observable<UserBO> userVerifuser(String phone, String versition) {
        return getService().userVerifuser(phone, versition).compose(RxResultHelper.<UserBO>httpRusult());
    }
    /**
     * 第三方登录验证用户
     */
    public static Observable<threelandingBo> phonebinding(String phone,String wxUserId,String wbUserId,String qqUserId, String versition) {
        return getService().phonebinding(phone,wxUserId,wbUserId ,qqUserId,versition).compose(schedulersTransformer.<threelandingBo>httpRusult());
    }
    /**
     * 第三方注册
     */
    public static Observable<threelandingBo> thirdregist(String mobile,String password,String header,String nickName,String gender,String wxUserId,String wbUserId,String qqUserId) {
        return getService().thirdregist(mobile,password,header,nickName,gender,wxUserId,wbUserId,qqUserId).compose(schedulersTransformer.<threelandingBo>httpRusult());
    }
    /**
     * 修改密码
     */
    public static Observable<UserBO> userUpdatePass(String password, String pwd) {
        return getService().userUpdatePass(password, pwd).compose(RxResultHelper.<UserBO>httpRusult());
    }

    /**
     * 上传头像
     */
    public static Observable<UserBO> userUpdateImg(RequestBody body) {
        return getService().uploadFile(body).compose(RxResultHelper.<UserBO>httpRusult());
    }

    /**
     * 修改昵称
     */
    public static Observable<UserBO> userUpdateName(String name) {
        return getService().updateName(name).compose(RxResultHelper.<UserBO>httpRusult());
    }

    /**
     * 修改性别
     */
    public static Observable<UserBO> userUpdateSex(int sex) {
        return getService().updateUserSex(sex).compose(RxResultHelper.<UserBO>httpRusult());
    }

    /**
     * 绑定会员
     */
    public static Observable<CardBO> cardBindUser(String cinemaId, String card, String pwd) {
        return getService().cardBindUser(cinemaId, card, pwd).compose(RxResultHelper.<CardBO>httpRusult());
    }

    /**
     * 获取用户会员卡
     */
    public static Observable<List<CardBO>> cardUser() {
        return getService().cardUser().compose(RxResultHelper.<List<CardBO>>httpRusult());
    }


    /**
     * 获取影院列表
     */
    public static Observable<List<CinemaBo>> cinemaList(String city, String longitude, String latitude) {
        return getService().cinemaList(city, longitude, latitude).compose(RxResultHelper.<List<CinemaBo>>httpRusult());
    }


    /**
     * 获取城市列表
     */
    public static Observable<List<String>> cityList() {
        return getService().cityList("app").compose(RxResultHelper.<List<String>>httpRusult());
    }


    /**
     * 查询轮播图
     */
    public static Observable<List<LunBoBO>> lunboList(String source, String cinemaId) {
        return getService().lunboList(source, cinemaId).compose(RxResultHelper.<List<LunBoBO>>httpRusult());
    }

    public static Observable<LunBoAndBO> lunboandList(String source, String cinemaId) {
        return getService().lunboandList(source, cinemaId).compose(RxResultHelper.<LunBoAndBO>httpRusult());
    }

    /**
     * 获取正在热映影片
     */
    public static Observable<List<MoviesByCidBO>> moviesHot(String cinameId) {
        return getService().moviesHot(cinameId).compose(RxResultHelper.<List<MoviesByCidBO>>httpRusult());
    }

    /**
     * 获取即将热映影片
     */
    public static Observable<List<MoviesSoonBO>> moviesSoon(String cinameId) {
        return getService().moviesSoon(cinameId).compose(RxResultHelper.<List<MoviesSoonBO>>httpRusult());
    }

    /**
     * 获取场次信息
     */
    public static Observable<List<MoviesByCidBO>> moviesCid(String cinemaId) {
        return getService().moviesByCid(cinemaId).compose(RxResultHelper.<List<MoviesByCidBO>>httpRusult());
    }


    /**
     * 提交订单
     */
    public static Observable<OrderBO> orderSubmit(
                                                  String orderName,      //联系人姓名（可不传）
                                                  String seats,              //座位连接
                                                  String ticketNum,       //票数量
                                                  String ticketOriginPrice,   //总价
                                                  String cinemaNumber,     //广电总局影院唯一编码
                                                  String hallId,              //鼎新影厅id
                                                  String playId,               //鼎新场次id
                                                  String cineMovieNum,     //广电总局规定的影片全国唯一编码
                                                  String seatId) {
        return getService().orderSubmit( orderName, seats, ticketNum, ticketOriginPrice,
                cinemaNumber, hallId, playId, cineMovieNum, seatId).compose(RxResultHelper.<OrderBO>httpRusult());
    }

    /**
     * 查询订单列表
     */
    public static Observable<List<OrderBO>> orderList(String orderType, String orderPage) {
        return getService().orserList(orderType, orderPage, pageNum).compose(RxResultHelper.<List<OrderBO>>httpRusult());
    }


    public static Observable<RefundBO>  refundinfo(String id) {
        return getService(). refundinfo(id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
    public static Observable<RefundBO>  refund(String id,String cinemaId) {
        return getService(). refund(id,cinemaId).compose(schedulersTransformer.<RefundBO>httpRusult());
    }

    /**refund
     * 查询订单详情
     */
    public static Observable<Bean> orderMessage(String id, String cinemaId) {
        return getService().orderMessage(id,cinemaId).compose(schedulersTransformer.<Bean>httpRusult());
    }


    /**
     * 查询单个订单详情
     */
    public static Observable<OrderBO> orderQuery(String orderNum) {
        return getService().orderQuery(orderNum).compose(RxResultHelper.<OrderBO>httpRusult());
    }


    /**
     * 检测是否有未完成订单
     */
    public static Observable<OrderNumBO> orderCheck() {
        return getService().orderCheck().compose(RxResultHelper.<OrderNumBO>httpRusult());
    }

    /**
     * 取消订单
     */
    public static Observable<OrderNumBO> orderCancle(String orderNum) {
        return getService().orderCancel(orderNum).compose(RxResultHelper.<OrderNumBO>httpRusult());
    }

    /**
     * 支付宝支付
     */
    public static Observable<PayBO> payAlipay(String orderNum) {
        return getService().payAlipay(orderNum).compose(RxResultHelper.<PayBO>httpRusult());
    }

    /**
     * 微信支付
     */
    public static Observable<WXPayBO> payWeChat(String orderNum) {
        return getService().payWeChat(orderNum).compose(RxResultHelper.<WXPayBO>httpRusult());
    }

    /**
     * 会员卡支付
     */
    public static Observable<ResuBo> loadcardPay(String orderNum,String coupon) {
        return getService().loadcardPay(orderNum,coupon).compose(RxResultHelper.<ResuBo>httpRusult());
    }
    /**
     * 获取会员卡支付价格
     */
    public static Observable<PayCardBO> cardPayPrice(String orderNum, String card) {
        return getService().cardPayPrice(orderNum, card).compose(RxResultHelper.<PayCardBO>httpRusult());
    }

    /**
     * 会员卡支付
     */
    public static Observable<ResuBo> payCard(String orderNum, String pwd, String card) {
        return getService().payCard(orderNum, pwd, card).compose(RxResultHelper.<ResuBo>httpRusult());
    }


    /**
     * 获取好消息文章
     */
    public static Observable<List<HotWireBO>> hotWire(String articleType, String flpage, String cinemaId) {
        return getService().hotWire(articleType, flpage, pageNum, cinemaId).compose(RxResultHelper.<List<HotWireBO>>httpRusult());
    }
    /**
     * 获取收藏列表Collection of articles
     */
    public static Observable<List<HotWireBO>> articlesCollection(String pageNo) {
        return getService().articlesCollection(pageNo,pageNum).compose(RxResultHelper.<List<HotWireBO>>httpRusult());
    }
    /**
     * 获取充值记录列表
     */
    public static Observable<List<RechBo>> loadRecharge(String pageNo,String cardNum) {
        return getService().loadRecharge(cardNum,pageNo, "20").compose(RxResultHelper.<List<RechBo>>httpRusult());
    }
    /**loadcosumption
     * 获取消费金额
     */
    public static Observable<List<SumptionBo>> loadcosumption(String pageNo, String cardNum) {
        return getService().loadcosumption(cardNum,pageNo, "20").compose(RxResultHelper.<List<SumptionBo>>httpRusult());
    }
    /**loadcosumption
     * 获取单个电影评论
     */
    public static Observable<MoviesCommentBO> moviesComment(String userId, String movieId) {
        return getService().moviesComment(userId, movieId).compose(RxResultHelper.<MoviesCommentBO>httpRusult());
    }

    /**
     * 收藏电影
     */
    public static Observable<MoviesCommentBO> moviesShouCang(String userId, String movieId,
                                                             String collectStatus) {
        return getService().moviesShouCang(userId, movieId, collectStatus).compose(RxResultHelper.<MoviesCommentBO>httpRusult());
    }

    /**
     * 想看电影
     */
    public static Observable<MoviesCommentBO> moviesWantSee(String userId, String movieId,
                                                            String wantSee) {
        return getService().moviesWantSee(userId, movieId, wantSee).compose(RxResultHelper.<MoviesCommentBO>httpRusult());
    }

    /**
     * 提交评论
     */
    public static Observable<Object> moviesSunmitCom(String userId, String movieId, String score,
                                                     String comment) {
        return getService().moviesSummitCom(userId, movieId, score, comment).compose(RxResultHelper.httpRusult());
    }


    /**
     * 获取游戏列表
     */
    public static Observable<List<GameBO>> gameList(String pageNo) {
        return getService().gameList(pageNum, pageNo).compose(RxResultHelper.<List<GameBO>>httpRusult());
    }

    /**
     * 获取有奖任务列表
     */
    public static Observable<HomeTopBean>getList(String pageNo) {
        return getService().getList( pageNo,pageNum).compose(schedulersTransformer.<HomeTopBean>httpRusult());
    }
    /**
     * 提交反馈
     */
    public static Observable<String> submitFeed(String phone, String suggestion) {
        return getService().submitFeed(phone, suggestion).compose(RxResultHelper.<String>httpRusult());
    }

    /**
     * 获取个人中心四个记录数量
     */
    public static Observable<UserBO> memberRecord(String appUserId) {
        return getService().memberRecords(appUserId).compose(RxResultHelper.<UserBO>httpRusult());
    }

    /**
     * 获取自己的电影评论记录
     */
    public static Observable<List<CommentBO>> personCommentList(String appUserId, String pageNo) {
        return getService().personCommentList(appUserId,pageNo,pageNum).compose(RxResultHelper.<List<CommentBO>>httpRusult());
    }


    public static Observable<List<RechatBo>> rechatgejine() {
        return getService().rechatgejine().compose(RxResultHelper.<List<RechatBo>>httpRusult());
    }
    //支付宝
    public static Observable<PayBO> zhifubaopay(String cinemaId, Integer amountType, Integer amountId,String cardNum) {
        return getService().zhifubaopay(cinemaId,amountType,amountId,cardNum,0).compose(RxResultHelper.<PayBO>httpRusult());
    }
    //支付宝其他
    public static Observable<PayBO> zhifubaopayqita(String cinemaId, Integer amountType, Integer rechargeMoney,String cardNum) {
        return getService().zhifubaopayqita(cinemaId,amountType,rechargeMoney,cardNum,0).compose(RxResultHelper.<PayBO>httpRusult());
    }
    //微信
    public static Observable<WXPayBO> weixinpay(String cinemaId, Integer amountType, Integer amountId,String cardNum) {
        return getService().weixinpay(cinemaId,amountType,amountId,cardNum,0).compose(RxResultHelper.<WXPayBO>httpRusult());
    }
    //微信其他
    public static Observable<WXPayBO> weixinpayta(String cinemaId, Integer amountType, Integer rechargeMoney,String cardNum) {
        return getService().weixinpayta(cinemaId,amountType,rechargeMoney,cardNum,0).compose(RxResultHelper.<WXPayBO>httpRusult());
    }

    /**weixinpay
     * 获取自己观看电影记录
     */
    public static Observable<List<CommentBO>> personReadList(String appUserId, String pageNo) {
        return getService().personReadList(appUserId, pageNo, pageNum).compose(RxResultHelper.<List<CommentBO>>httpRusult());
    }

    /**
     * 获取自己想看电影列表
     */
    public static Observable<List<MoviesByCidBO>> personWantSeeList(String appUserId, String cinemaId, String pageNo) {
        return getService().personWantSeeList(appUserId, cinemaId,pageNo, pageNum).compose(RxResultHelper.<List<MoviesByCidBO>>httpRusult());
    }

    /**
     * 获取自己收藏电影记录
     */
    public static Observable<List<MoviesByCidBO>> personCollectList(String appUserId,String zzpage) {
        return getService().personCollectList(appUserId,zzpage,pageNum).compose(RxResultHelper.<List<MoviesByCidBO>>httpRusult());
    }

    /**
     * 分享电影
     */
    public static Observable<ShareBO> shareMovie(String movieId) {
        return getService().shareMovie(movieId).compose(RxResultHelper.<ShareBO>httpRusult());
    }
    /**
     * 电影评论列表
     */

    public static Observable<List<CriticBO>> criticMovie(Long movieId, Integer pageNo, Integer pageSize) {
        return getService().criticMovie(movieId,pageNo,pageSize).compose(RxResultHelper.<List<CriticBO>>httpRusult());
    }
    public static Observable<CriticBO> dianZan(Long Id) {
        return getService().dianZan(Id).compose(RxResultHelper.<CriticBO>httpRusult());
    }
    /**
     * 获取金币兑换商品
     */
    public static Observable<List<ShopBO>> creditsShop(String pageNo, String cinemaId) {
        return getService().creditsShop(pageNum, pageNo, cinemaId).compose(RxResultHelper.<List<ShopBO>>httpRusult());
    }

    /**
     * 获取金币兑换记录
     */
    public static Observable<List<ShopOrderBO>> creditsOrder() {
        return getService().creditsOrder().compose(RxResultHelper.<List<ShopOrderBO>>httpRusult());
    }

    /**
     * 我的约会
     */
    public static Observable<String> personSome() {
        return getService().personSome().compose(RxResultHelper.<String>httpRusult());
    }

    /**
     * 我的优惠券
     */
    public static Observable<String> personCoupon() {
        return getService().personCoupon().compose(RxResultHelper.<String>httpRusult());
    }

    /**
     * 添加优惠券
     */
    public static Observable<String> personAddCoupon() {
        return getService().personAddCoupon().compose(RxResultHelper.<String>httpRusult());
    }
    /**
     * 意见反馈列表
     */
    public static Observable<List<FeedBackListBO>> feedBackList() {
        return getService().feedBackList().compose(RxResultHelper.<List<FeedBackListBO>>httpRusult());
    }
    /**
     * 获取单个电影场次
     */
    public static Observable<SessionBO> movieSereen(String cinemaId, String movieId) {
        return getService().movieScreen(cinemaId, movieId).compose(RxResultHelper.<SessionBO>httpRusult());
    }

    /**
     * 检测版本更新
     */
    public static Observable<AppVersionBO> VersionCheck() {
        return getService().loadVersion().compose(RxResultHelper.<AppVersionBO>httpRusult());
    }

    /**
     * 获取优惠信息列表
     */
    public static Observable<List<FavourBO>> forvoreinfo() {
        return getService().favorinfo().compose(RxResultHelper.<List<FavourBO>>httpRusult());
    }

}
