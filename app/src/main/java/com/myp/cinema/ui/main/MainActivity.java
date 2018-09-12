package com.myp.cinema.ui.main;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.KeyEvent;
import android.view.View;

import com.myp.cinema.R;
import com.myp.cinema.base.MyApplication;
import com.myp.cinema.entity.CinemaBo;
import com.myp.cinema.mvp.MVPBaseActivity;
import com.myp.cinema.service.update.UpdateManager;
import com.myp.cinema.ui.main.home.HomeFragment;
import com.myp.cinema.ui.main.hotwire.HotwireFragment;
import com.myp.cinema.ui.main.member.MemberFragment;
import com.myp.cinema.util.AppManager;
import com.myp.cinema.util.LogUtils;
import com.myp.cinema.util.baidumap.BaiduMapLoctionUtils;
import com.xyz.tabitem.BottmTabItem;

import java.util.List;

import butterknife.Bind;

/**
 * 主页面
 */

public class MainActivity extends MVPBaseActivity<MainContract.View, MainPresenter>
        implements MainContract.View, View.OnClickListener {


    @Bind(R.id.home)
    BottmTabItem home;
    @Bind(R.id.haowan)
    BottmTabItem haowan;
    @Bind(R.id.haoxiaoxi)
    BottmTabItem haoxiaoxi;
    @Bind(R.id.huiyuan)
    BottmTabItem huiyuan;

    HomeFragment homeFragment;
    //    PlayfulFragment playfulFragment;
    MemberFragment memberFragment;
    HotwireFragment hotwireFragment;
    PlayfulWebFragment playfulWebFragment;

    BaiduMapLoctionUtils baiduMapLoctionUtils;


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        homeFragment = new HomeFragment();
//        playfulFragment = new PlayfulFragment();
        memberFragment = new MemberFragment();
        hotwireFragment = new HotwireFragment();
        playfulWebFragment = new PlayfulWebFragment();
        goToFragment(homeFragment);

        home.setOnClickListener(this);
        haowan.setOnClickListener(this);
        haoxiaoxi.setOnClickListener(this);
        huiyuan.setOnClickListener(this);
        baiduMapLoctionUtils = new BaiduMapLoctionUtils();
        getPermission();
        new UpdateManager(this, "main").checkUpdate();   //检查更新
    }

    /**
     * 检查定位权限
     */
    private void getPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.READ_PHONE_STATE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1);
        } else {
            startLocation();
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.READ_PHONE_STATE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull
            int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {   //授权成功
            startLocation();
        } else {  //获取权限失败！使用默认地址
            mPresenter.loadCinemaIds(BaiduMapLoctionUtils.city,
                    BaiduMapLoctionUtils.lontitudeNum, BaiduMapLoctionUtils.latitude);
        }
    }

    /**
     * 用户拒绝权限，重新申请
     */
    @Override
    public boolean shouldShowRequestPermissionRationale(@NonNull String permission) {
        return Manifest.permission.ACCESS_COARSE_LOCATION.equals(permission) ||
                super.shouldShowRequestPermissionRationale(permission);
    }



    /**
     * 定位方法调用
     */
    private void startLocation() {
        baiduMapLoctionUtils.startLocation(this, new BaiduMapLoctionUtils.BaiduLocationListener() {
            @Override
            public void getData(String lontitude, String latitude, String city) {
                baiduMapLoctionUtils.stopLocation();
                mPresenter.loadCinemaIds(city, lontitude, latitude);
            }

            @Override
            public void onEroorLocation() {
                mPresenter.loadCinemaIds(BaiduMapLoctionUtils.city,
                        BaiduMapLoctionUtils.lontitudeNum, BaiduMapLoctionUtils.latitude);
            }
        });
    }

    @Override
    public void onData(List<CinemaBo> cinemaIdBOs) {
        homeFragment.setCinemaNameStr(cinemaIdBOs);
    }


    @Override
    public void onRequestError(String msg) {
        LogUtils.showToast(msg);
    }

    @Override
    public void onRequestEnd() {
    }

    private Fragment mContent = null;

    /**
     * 修改显示的内容 不会重新加载
     **/
    public void goToFragment(Fragment to) {
        if (mContent != to) {
            FragmentTransaction transaction = getSupportFragmentManager()
                    .beginTransaction();
            if (!to.isAdded()) { // 先判断是否被add过
                if (mContent != null)
                    transaction.hide(mContent).add(R.id.fragment_container, to).commitAllowingStateLoss(); // 隐藏当前的fragment，add下一个到Activity中
                else
                    transaction.add(R.id.fragment_container, to).commitAllowingStateLoss();
            } else {
                if (mContent != null)
                    transaction.hide(mContent).show(to).commitAllowingStateLoss(); // 隐藏当前的fragment，显示下一个
                else
                    transaction.show(to).commitAllowingStateLoss();
            }
            mContent = to;
        }
    }

    /**
     * 底部按钮点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home:
                goToFragment(homeFragment);
                home.setSelectState(true);
                haowan.setSelectState(false);
                haoxiaoxi.setSelectState(false);
                huiyuan.setSelectState(false);
                break;
            case R.id.haowan:
                goToFragment(playfulWebFragment);
                home.setSelectState(false);
                haowan.setSelectState(true);
                haoxiaoxi.setSelectState(false);
                huiyuan.setSelectState(false);
                break;
            case R.id.haoxiaoxi:
                goToFragment(hotwireFragment);
                home.setSelectState(false);
                haowan.setSelectState(false);
                haoxiaoxi.setSelectState(true);
                huiyuan.setSelectState(false);
                break;
            case R.id.huiyuan:
                goToFragment(memberFragment);
                home.setSelectState(false);
                haowan.setSelectState(false);
                haoxiaoxi.setSelectState(false);
                huiyuan.setSelectState(true);
                break;
        }
    }

    //记录用户首次点击返回键的时间
    private long firstTime = 0;

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 2000) {
                    LogUtils.showToast("再按一次退出程序");
                    firstTime = secondTime;
                    return true;
                } else {
                    MyApplication.SESSIONID = null;
                    AppManager.getAppManager().finishAllActivity();
                    System.exit(0);
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }
}