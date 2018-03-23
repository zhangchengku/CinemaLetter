package com.myp.cinema.base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;

import com.baidu.mapapi.SDKInitializer;
import com.myp.cinema.R;
import com.myp.cinema.config.ConditionEnum;
import com.myp.cinema.config.LocalConfiguration;
import com.myp.cinema.entity.CinemaBo;
import com.myp.cinema.entity.CityBO;
import com.myp.cinema.entity.MoviesByCidBO;
import com.myp.cinema.entity.OrderBO;
import com.myp.cinema.entity.UserBO;
import com.myp.cinema.service.AdvanceLoadX5Service;
import com.myp.cinema.ui.userlogin.LoginActivity;
import com.myp.cinema.util.LogUtils;
import com.myp.cinema.util.SPUtils;
import com.myp.cinema.util.Utils;
import com.myp.cinema.util.baidumap.LocationService;
import com.myp.cinema.wxapi.WXUtils;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.tencent.smtt.sdk.QbSdk;

import java.util.List;

import cat.ereza.customactivityoncrash.CustomActivityOnCrash;
import cn.jpush.android.api.JPushInterface;
import cn.sharesdk.framework.ShareSDK;

/**
 * 作者 by wuliang 时间 16/10/26.
 * <p>
 * 程序的application
 */

public class MyApplication extends Application {

    public LocationService locationService;
    public static ConditionEnum isLogin = ConditionEnum.NOLOGIN;   //默认未登陆
    public static SPUtils spUtils;   //缓存类型
    public static UserBO user;    //程序使用用户
    public static CinemaBo cinemaBo;   //当前选择影院
    public static String SESSIONID;    //保存的持久化sessionId，用于H5的session同步
    public static List<MoviesByCidBO> movies;   //持久化的正在热映列表
    public static CityBO cityBO;    //当前选中的城市
    public static OrderBO orderBO;
    @Override
    public void onCreate() {
        super.onCreate();
        CustomActivityOnCrash.install(this);
//        CustomActivityOnCrash.setErrorActivityClass(LoginActivity.class);
        CustomActivityOnCrash.setShowErrorDetails(true);
        CustomActivityOnCrash.setDefaultErrorActivityDrawable(R.drawable.logo);
        /***初始化工具类*/
        Utils.init(this);
        /**初始化SharedPreferences缓存*/
        spUtils = new SPUtils(LocalConfiguration.SP_NAME);
        /***注册分享*/
        ShareSDK.initSDK(this);
        /***注册极光推送*/
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        /***注册微信登陆，支付服务*/
        WXUtils.registerWX(this);
        /***初始化定位sdk，建议在Application中创建*/
        locationService = new LocationService(getApplicationContext());
        SDKInitializer.initialize(getApplicationContext());
        initImageLoader();
        preinitX5WebCore();
        //预加载x5内核
        Intent intent = new Intent(this, AdvanceLoadX5Service.class);
        startService(intent);
//        setQ5sDK();
    }

    private void preinitX5WebCore() {
        if (!QbSdk.isTbsCoreInited()) {
            QbSdk.preInit(getApplicationContext(), null);// 设置X5初始化完成的回调接口
        }
    }

    /**
     * 初始化X5内核
     */
    private void setQ5sDK() {
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                LogUtils.E(" onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }

    /**
     * 初始化ImageLoader，这个适用在大图片加载中
     */
    public void initImageLoader() {
        // This configuration tuning is custom. You can tune every option, you
        // may tune some of them,
        // or you can create default configuration by
        // ImageLoaderConfiguration.createDefault(this);
        // method.
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                getApplicationContext()).threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .writeDebugLogs() // Remove for release app
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
