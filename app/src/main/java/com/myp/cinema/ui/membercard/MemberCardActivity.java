package com.myp.cinema.ui.membercard;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

import com.myp.cinema.R;
import com.myp.cinema.entity.CardBO;
import com.myp.cinema.mvp.MVPBaseActivity;
import com.myp.cinema.util.LogUtils;
import com.myp.cinema.widget.superadapter.CommonAdapter;
import com.myp.cinema.widget.superadapter.ViewHolder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**会员卡列表
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MemberCardActivity extends MVPBaseActivity<MemberCardContract.View, MemberCardPresenter> implements
        MemberCardContract.View , AdapterView.OnItemClickListener, View.OnClickListener{

    List<CardBO> data =  new ArrayList<>();
    private CommonAdapter<CardBO> adapter;
    private ListView list;
    private Button addCard;
    private Button addCardButton;
    private LinearLayout nocardlayout;
    private ScrollView sc;


    @Override
    protected int getLayout() {
        return R.layout.fra_card_list1;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goBack();
        setTitle("会员卡");
        list = (ListView)findViewById(R.id.lv);
        addCard = (Button)findViewById(R.id.add_card);
        addCardButton = (Button)findViewById(R.id.add_card_button);
        nocardlayout = (LinearLayout)findViewById(R.id.no_card_layout);
        sc = (ScrollView)findViewById(R.id.sc);
        addCard.setOnClickListener(this);
        addCardButton.setOnClickListener(this);
        list.setOnItemClickListener(this);
        mPresenter.loadCardUser();
        adapter();

    }



    private void adapter() {
        adapter = new CommonAdapter<CardBO>(this, R.layout.item_card_pay, data) {
            @Override
            protected void convert(ViewHolder helper, CardBO item, int position) {
                helper.getView(R.id.card_check).setVisibility(View.GONE);
                BigDecimal bd = new BigDecimal(item.getBalance());
                String str = bd.toPlainString();
                helper.setText(R.id.card_price, "¥ " + str);
                helper.setText(R.id.card_num, item.getCardNumber());
            }
        };
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("cardBO", data.get(position));
        Intent intent = new Intent(MemberCardActivity.this, CardMessageActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 1);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        switch (resultCode) {
            case 1:
                mPresenter.loadCardUser();
                break;
        }
    }
    @Override
    public void getCardList(List<CardBO> cardBOs) {
        if (cardBOs != null && cardBOs.size() != 0) {
            nocardlayout.setVisibility(View.GONE);
            sc.setVisibility(View.VISIBLE);
            data.clear();
            data.addAll(cardBOs);
            list.setAdapter(adapter);
        } else {
            sc.setVisibility(View.GONE);
            nocardlayout.setVisibility(View.VISIBLE);

        }
    }

    @Override
    public void onRequestError(String msg) {
        LogUtils.showToast(msg);
    }

    @Override
    public void onRequestEnd() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_card:
            case R.id.add_card_button:
                Intent intent = new Intent(MemberCardActivity.this, AddCardActiivty.class);
                startActivityForResult(intent, 1);
                break;
        }
    }
}
