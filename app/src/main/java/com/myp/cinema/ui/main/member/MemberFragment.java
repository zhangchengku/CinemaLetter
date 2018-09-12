package com.myp.cinema.ui.main.member;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.meg7.widget.CircleImageView;
import com.myp.cinema.R;
import com.myp.cinema.base.MyApplication;
import com.myp.cinema.config.ConditionEnum;
import com.myp.cinema.entity.UserBO;
import com.myp.cinema.mvp.MVPBaseFragment;
import com.myp.cinema.ui.SettingActivity;
import com.myp.cinema.ui.feedbacklist.FeedBackListActivity;

import com.myp.cinema.ui.membercard.MemberCardActivity;
import com.myp.cinema.ui.personcollect.PersonCollectActivity2;
import com.myp.cinema.ui.personcomment.PersonCommentActivity;
import com.myp.cinema.ui.personcoupon.PersonCouponActivity;
import com.myp.cinema.ui.personorder.PersonOrderActivity;
import com.myp.cinema.ui.personread.PersonReadActivity;
import com.myp.cinema.ui.personsetting.PersonSettingActivity;
import com.myp.cinema.ui.personsome.PersonSomeActivity;
import com.myp.cinema.ui.personwantsee.PersonWantSeeActivity;
import com.myp.cinema.ui.userlogin.LoginActivity;
import com.myp.cinema.util.LogUtils;
import com.myp.cinema.util.StringUtils;
import com.myp.cinema.widget.pulltozoomview.PullToZoomScrollViewEx;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 个人中心fragment
 */

public class MemberFragment extends MVPBaseFragment<MemberContract.View, MemberPresenter>
        implements MemberContract.View, View.OnClickListener {

    @Bind(R.id.scollview)
    PullToZoomScrollViewEx scollview;

    /**
     * headler区域
     */
    private ImageView signIn;
    private CircleImageView personImg;
    private TextView personName;

    /**
     * 主要content区域
     */
    LinearLayout moviesComment, moviesRead, moviesWantSee, moviesCollect;
    TextView moviesCommentNum, moviesReadNum, moviesWantSeeNum, moviesCollectNum;
    RelativeLayout memberCard, youhuijuan, moviesOrder, personYuehui, yijianfankuiLayout, settingLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_member, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadViewForPullToZoomScrollView(scollview);
        setPullToZoomViewLayoutParams(scollview);
        initViews();
    }


    /**
     * 初始化控件
     */
    private void initViews() {
        settingLayout = (RelativeLayout) scollview.getPullRootView().findViewById(R.id.setting_layout);
        moviesComment = (LinearLayout) scollview.getPullRootView().findViewById(R.id.movies_comment);
        moviesRead = (LinearLayout) scollview.getPullRootView().findViewById(R.id.movies_read);
        moviesWantSee = (LinearLayout) scollview.getPullRootView().findViewById(R.id.movies_wantsee);
        moviesCollect = (LinearLayout) scollview.getPullRootView().findViewById(R.id.movies_collect);
        memberCard = (RelativeLayout) scollview.getPullRootView().findViewById(R.id.member_card);
        youhuijuan = (RelativeLayout) scollview.getPullRootView().findViewById(R.id.youhuijuan);
        moviesOrder = (RelativeLayout) scollview.getPullRootView().findViewById(R.id.movies_order);
        personYuehui = (RelativeLayout) scollview.getPullRootView().findViewById(R.id.person_yuehui);
        moviesCollectNum = (TextView) scollview.getPullRootView().findViewById(R.id.movies_collect_num);
        moviesReadNum = (TextView) scollview.getPullRootView().findViewById(R.id.movies_read_num);
        moviesWantSeeNum = (TextView) scollview.getPullRootView().findViewById(R.id.movies_wantsee_num);
        moviesCommentNum = (TextView) scollview.getPullRootView().findViewById(R.id.movies_comment_num);
        yijianfankuiLayout = (RelativeLayout) scollview.getPullRootView().findViewById(R.id.yijianfankui_layout);
        signIn = (ImageView) scollview.getHeaderView().findViewById(R.id.sign_img);
        signIn.setVisibility(View.GONE);
        personImg = (CircleImageView) scollview.getHeaderView().findViewById(R.id.person_img);
        personName = (TextView) scollview.getHeaderView().findViewById(R.id.person_name);
        moviesRead.setOnClickListener(this);
        moviesComment.setOnClickListener(this);
        moviesWantSee.setOnClickListener(this);
        moviesCollect.setOnClickListener(this);
        memberCard.setOnClickListener(this);
        youhuijuan.setOnClickListener(this);
        moviesOrder.setOnClickListener(this);
        personYuehui.setOnClickListener(this);
        yijianfankuiLayout.setOnClickListener(this);
        settingLayout.setOnClickListener(this);
        personImg.setOnClickListener(this);
        personName.setOnClickListener(this);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.person_img:
            case R.id.person_name:
                if (MyApplication.isLogin == ConditionEnum.LOGIN) {   //已登录
                    Intent intent = new Intent(getActivity(), PersonSettingActivity.class);
                    startActivityForResult(intent, 1);
                } else if (MyApplication.isLogin == ConditionEnum.NOLOGIN) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivityForResult(intent, 1);
                }
                break;
            case R.id.movies_read:   //看过
                if (goLogin()) {
                    gotoActivity(PersonReadActivity.class, false);
                }
                break;
            case R.id.movies_comment:   //影评
                if (goLogin()) {
                    gotoActivity(PersonCommentActivity.class, false);
                }
                break;
            case R.id.movies_wantsee:   //想看
                if (goLogin()) {
                    gotoActivity(PersonWantSeeActivity.class, false);
                }
                break;
            case R.id.movies_collect:   //收藏
                if (goLogin()) {
                    gotoActivity(PersonCollectActivity2.class, false);
                }
                break;
            case R.id.member_card:   //我的会员卡
                if (goLogin()) {
                    gotoActivity(MemberCardActivity.class, false);
                }
                break;
            case R.id.youhuijuan:   //我的优惠卷
                if (goLogin()) {
                    gotoActivity(PersonCouponActivity.class, false);
                }
//                LogUtils.showToast("敬请期待！");
                break;
            case R.id.movies_order:  //电影票订单
                if (goLogin()) {
                    gotoActivity(PersonOrderActivity.class, false);
                }
                break;
            case R.id.person_yuehui:   //我的约会
                if (goLogin()) {
                    gotoActivity(PersonSomeActivity.class, false);
                }
//                LogUtils.showToast("敬请期待！");
                break;
            case R.id.yijianfankui_layout:   //意见反馈
                if (goLogin()) {
                    gotoActivity(FeedBackListActivity.class, false);
                }
                break;
            case R.id.setting_layout:  //基本设置
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                startActivityForResult(intent, 2);
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        switch (resultCode) {
            case 1:
                UserBO userBO = (UserBO) data.getSerializableExtra("user");
                setDatas(userBO);
                break;
            case 2:
                boolean isLogout = data.getBooleanExtra("isLogout", false);
                if (isLogout) {
                    personName.setText("点击登录或注册");
                    personImg.setImageResource(R.drawable.defalt_person_img);
                    moviesCommentNum.setText("0");
                    moviesWantSeeNum.setText("0");
                    moviesReadNum.setText("0");
                    moviesCollectNum.setText("0");
                }
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (MyApplication.isLogin == ConditionEnum.LOGIN) {
            setDatas(MyApplication.user);
            mPresenter.loadMemberRecord(MyApplication.user.getId());
        }
    }

    /**
     * 为界面设置值
     */
    private void setDatas(UserBO userBO) {
        if (!StringUtils.isEmpty(userBO.getHeader())) {
            Glide.with(getActivity()).load(userBO.getHeader()).into(personImg);
        }
        if (!StringUtils.isEmpty(userBO.getNickName())) {
            personName.setText(userBO.getNickName());
        } else {
            personName.setText(userBO.getMobile());
        }
        moviesCommentNum.setText(userBO.getCommentNum());
        moviesWantSeeNum.setText(userBO.getWantseeNum());
        moviesReadNum.setText(userBO.getWatchedNum());
        moviesCollectNum.setText(userBO.getCollectNum());
        Log.d("sdfkasjdfkl", "setDatas: "+userBO.getCollectNum());
    }


    private void loadViewForPullToZoomScrollView(PullToZoomScrollViewEx scrollView) {
        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.member_header_layout, null);
        View zoomView = LayoutInflater.from(getActivity()).inflate(R.layout.member_zoom_layout, null);
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.member_content_layout, null);
        scrollView.setHeaderView(headView);
        scrollView.setZoomView(zoomView);
        scrollView.setScrollContentView(contentView);
    }

    // 设置头部的View的宽高。
    private void setPullToZoomViewLayoutParams(PullToZoomScrollViewEx scrollView) {
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams(mScreenWidth,
                (int) (9.0F * (mScreenWidth / 16.0F)));
        scrollView.setHeaderLayoutParams(localObject);
    }

    @Override
    public void onRequestError(String msg) {
        LogUtils.showToast(msg);
    }

    @Override
    public void onRequestEnd() {

    }

    @Override
    public void getUser(UserBO userBO) {
        setDatas(userBO);

    }
}