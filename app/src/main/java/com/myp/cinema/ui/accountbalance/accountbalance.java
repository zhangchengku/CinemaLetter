package com.myp.cinema.ui.accountbalance;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.myp.cinema.R;
import com.myp.cinema.base.BaseActivity;
import com.myp.cinema.ui.balance.balance;

import java.text.DecimalFormat;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/1/24.
 */

public class accountbalance extends BaseActivity {





    @Bind(R.id.recharge_bu)
    RelativeLayout rechargeBu;
    @Bind(R.id.yu)
    TextView yu;
    private String cardcode;
    private String value;
    private TextView card;

    @Override
    protected int getLayout() {
        return R.layout.accountbalancetactivity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goBack();
        setTitle("账户余额");
        card = (TextView)findViewById(R.id.card_num);
        Intent intent = getIntent();
        //从Intent当中根据key取得value
        if (intent != null) {
             value = intent.getStringExtra("cardPrice");
             cardcode = intent.getStringExtra("getCardNumber");
            yu.setText(value);
            TextPaint paint = yu.getPaint();
            paint.setFakeBoldText(true);
            card.setText("NO." +cardcode);
        }

    }


    @OnClick(R.id.recharge_bu)
    public void onViewClicked() {
        Intent rechatge = new Intent(accountbalance.this, rechatge.class);
        rechatge.putExtra("cardPrice", value);
        rechatge.putExtra("cardcode",  cardcode);
//        Log.d("支付宝充值", "固定金额 " + cardcode);
        startActivity(rechatge);
    }

    @OnClick({R.id.my_balance, R.id.my_mingxi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.my_balance:
                Intent rechatg = new Intent(accountbalance.this, balance.class);
                rechatg.putExtra("mingxi", "1");
                rechatg.putExtra("cardcode", cardcode);
                startActivity(rechatg);
                break;
            case R.id.my_mingxi:
                Intent rechatge = new Intent(accountbalance.this, balance.class);
                rechatge.putExtra("mingxi","2");
                rechatge.putExtra("cardcode", cardcode);
                startActivity(rechatge);
                break;
        }
    }
}

