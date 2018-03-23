package com.myp.cinema.ui.balance;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;

import com.myp.cinema.R;
import com.myp.cinema.base.MyApplication;
import com.myp.cinema.entity.HotWireBO;
import com.myp.cinema.entity.RechBo;
import com.myp.cinema.entity.SumptionBo;
import com.myp.cinema.mvp.MVPBaseFragment;
import com.myp.cinema.ui.personcollect.articleContract;
import com.myp.cinema.util.LogUtils;
import com.myp.cinema.util.ScreenUtils;
import com.myp.cinema.util.SizeUtils;
import com.myp.cinema.util.StringUtils;
import com.myp.cinema.util.TimeUtils;
import com.myp.cinema.widget.superadapter.CommonAdapter;
import com.myp.cinema.widget.superadapter.ViewHolder;
import com.myp.cinema.widget.swiferefresh.SwipeRefreshVie;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/1/28.
 * 充值记录界面
 */
public class rechargefragment extends MVPBaseFragment<rechargefragmenteContract.View, rechargefragmentPresenter>
        implements rechargefragmenteContract.View{
    private String cardNum;
    private CommonAdapter<RechBo> adapter;
    @Bind(R.id.list)
    ListView listview;
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout smartRefreshLayout;
    private int page = 1;
    private ArrayList<RechBo> data= new ArrayList<>();
    private boolean finsh=false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rechargelayout, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.loadRecharge(1,cardNum);
        setPullRefresher();
        adapter();
    }
    private void adapter() {
        adapter = new CommonAdapter<RechBo>(getActivity(),
                R.layout.item_recharge, data) {
            @Override
            protected void convert(ViewHolder helper, RechBo item, int position) {
                helper.setText(R.id.shijian, item.getPayFinishTime());
                helper.setText(R.id.chongzhijine,"+"+ String.valueOf(item.getRechargeMoney())+"元");
                if( item.getPayType()==1){//支付宝
                    helper.setText(R.id.card_num, "支付宝支付");
                    helper.setTextColor(R.id.card_num,Color.parseColor("#32B8E8"));
                }else {
                    helper.setText(R.id.card_num, "微信支付");
                    helper.setTextColor(R.id.card_num,Color.parseColor("#45CB46"));
                }
            }
        };
    }
    private void setPullRefresher(){
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPresenter.loadRecharge(1,cardNum);
                page=1;
                smartRefreshLayout.finishRefresh(1000);
                refreshlayout.finishRefresh(2000);
            }
        });
        smartRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page++;
                mPresenter.loadRecharge(page,cardNum);
                smartRefreshLayout.finishLoadmore(1000);
                refreshlayout.finishLoadmore(2000);
            }
        });
    }


    @Override
    public void onRequestError(String msg) {
        LogUtils.showToast(msg);
    }

    @Override
    public void onRequestEnd() {
    }

    @Override
    public void getRecharge(List<RechBo> rechBo,int pages) {
        if (pages == 1) {
            data.clear();
            data.addAll(rechBo);
            listview.setAdapter(adapter);
        } else {
            data.addAll(rechBo);
            adapter.setmDatas(data);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        cardNum = ((balance) activity).getTitles();
    }
}
