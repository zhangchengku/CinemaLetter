package com.myp.cinema.ui.personcoupon;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.myp.cinema.R;
import com.myp.cinema.mvp.MVPBaseActivity;
import com.myp.cinema.util.LogUtils;
import com.myp.cinema.util.ScreenUtils;
import com.myp.cinema.util.SizeUtils;
import com.myp.cinema.widget.superadapter.CommonAdapter;
import com.myp.cinema.widget.superadapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;


/**
 * MVPPlugin
 * 我的优惠券页面
 */

public class PersonCouponActivity extends MVPBaseActivity<PersonCouponContract.View,
        PersonCouponPresenter> implements PersonCouponContract.View, View.OnClickListener {

    @Bind(R.id.unused)
    TextView unused;
    @Bind(R.id.been_used)
    TextView beenUsed;
    @Bind(R.id.out_of_date)
    TextView outOfDate;
    @Bind(R.id.unused_line)
    View unusedline;
    @Bind(R.id.been_used_line)
    View beenusedline;
    @Bind(R.id.out_of_date_line)
    View outofdateline;
    @Bind(R.id.edit_layout)
    LinearLayout editLayout;
    @Bind(R.id.list)
    ListView list;
    @Bind(R.id.edit_coupon)
    EditText editCoupon;
    @Bind(R.id.add_conpon)
    Button addConpon;
    @Bind(R.id.none_layout)
    LinearLayout noneLayout;

    @Override
    protected int getLayout() {
        return R.layout.act_coupon;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goBack();
        setTitle("我的优惠券");

        unused.setOnClickListener(this);
        beenUsed.setOnClickListener(this);
        outOfDate.setOnClickListener(this);
        unusedline.setVisibility(View.VISIBLE);
        beenusedline.setVisibility(View.GONE);
        outofdateline.setVisibility(View.GONE);
        list.setVisibility(View.GONE);
        noneLayout.setVisibility(View.VISIBLE);
//        mPresenter.loadPersonCoupon();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.unused:  //未使用
                unused.setTextColor(Color.parseColor("#32b8e8"));
                beenUsed.setTextColor(Color.parseColor("#666666"));
                outOfDate.setTextColor(Color.parseColor("#666666"));
                unusedline.setVisibility(View.VISIBLE);
                beenusedline.setVisibility(View.GONE);
                outofdateline.setVisibility(View.GONE);
//                setAnniLine(0);
                setAdapter(0);
                break;
            case R.id.been_used:  //已使用
                beenUsed.setTextColor(Color.parseColor("#32b8e8"));
                unused.setTextColor(Color.parseColor("#666666"));
                outOfDate.setTextColor(Color.parseColor("#666666"));
                unusedline.setVisibility(View.GONE);
                beenusedline.setVisibility(View.VISIBLE);
                outofdateline.setVisibility(View.GONE);
//                setAnniLine(1);
                setAdapter(1);
                break;
            case R.id.out_of_date:   //已过期
                outOfDate.setTextColor(Color.parseColor("#32b8e8"));
                beenUsed.setTextColor(Color.parseColor("#666666"));
                unused.setTextColor(Color.parseColor("#666666"));
                unusedline.setVisibility(View.GONE);
                beenusedline.setVisibility(View.GONE);
                outofdateline.setVisibility(View.VISIBLE);
//                setAnniLine(2);
                setAdapter(2);
                break;
        }
    }


    /**
     * 设置适配器
     */
    private void setAdapter(final int type) {
        List<String> ss = new ArrayList<>();
        ss.add("1");
        ss.add("1");
        ss.add("1");
        ss.add("1");
        ss.add("1");
        ss.add("1");
        CommonAdapter<String> adapter = new CommonAdapter<String>(this, R.layout.item_youhuijuan, ss) {

            @Override
            protected void convert(ViewHolder helper, String item, int position) {
                switch (type) {
//                    case 0:   //未使用
//                        helper.getView(R.id.youhuijuan_bg).setBackgroundResource(R.drawable.caibeijing);
//                        helper.getView(R.id.youhui_biaoqian).setVisibility(View.GONE);
//                        break;
//                    case 1:   //已使用
//                        helper.getView(R.id.youhuijuan_bg).setBackgroundResource(R.drawable.huibj);
//                        helper.getView(R.id.youhui_biaoqian).setBackgroundResource(R.drawable.yishiyong);
//                        helper.getView(R.id.youhui_biaoqian).setVisibility(View.VISIBLE);
//                        break;
//                    case 2:
//                        helper.getView(R.id.youhuijuan_bg).setBackgroundResource(R.drawable.huibj);
//                        helper.getView(R.id.youhui_biaoqian).setBackgroundResource(R.drawable.yiguoqi);
//                        helper.getView(R.id.youhui_biaoqian).setVisibility(View.VISIBLE);
//                        break;
                }
            }

        };
        list.setAdapter(adapter);
    }





    @Override
    public void getCoupon(Object object) {
        list.setVisibility(View.GONE);
        noneLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onRequestError(String msg) {
        LogUtils.showToast(msg);
    }

    @Override
    public void onRequestEnd() {

    }
}
