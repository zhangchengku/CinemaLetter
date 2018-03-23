package com.myp.cinema.ui.phonecode;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.myp.cinema.R;
import com.myp.cinema.api.HttpInterfaceIml;
import com.myp.cinema.base.BaseActivity;
import com.myp.cinema.entity.UserBO;
import com.myp.cinema.ui.userlogin.Person;
import com.myp.cinema.util.LogUtils;
import com.myp.cinema.util.MD5;
import com.myp.cinema.util.RegexUtils;
import com.myp.cinema.util.StringUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.Bind;
import rx.Subscriber;


/**
 * MVPPlugin
 * 注册页面
 */

public class phonecode extends BaseActivity implements View.OnClickListener {


    @Bind(R.id.phone_edit)
    EditText phoneEdit;
    @Bind(R.id.verification_edit)
    EditText verificationEdit;
    @Bind(R.id.get_verification)
    Button getVerification;
    @Bind(R.id.register_button)
    Button registerButton;

    String phone;
    String loadVersition = "";   //获取的正确验证码
    String versition;



    @Override
    protected int getLayout() {
        return R.layout.act_forword_one;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goBack();


        registerButton.setOnClickListener(this);
        getVerification.setOnClickListener(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onClick(View v) {
        phone = phoneEdit.getText().toString().trim();
        switch (v.getId()) {
            case R.id.register_button:
                versition = verificationEdit.getText().toString().trim();
                if (isRegister()) {
                    userVersiton();
                }
                break;
            case R.id.get_verification:
                if (RegexUtils.isMobileExact(phone)) {
                    getVersition();
                    timer.start();
                    getVerification.setEnabled(false);
                } else {
                    LogUtils.showToast("请输入正确的手机号！");
                }
                break;
        }
    }

//    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
//    public void eventBusReceive(Person person) {
//        bu.setText(person.toString());
//    }

    private void getVersition() {
        HttpInterfaceIml.userVerification(phone, "validate").subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.showToast(e.getMessage());
            }

            @Override
            public void onNext(String s) {
                loadVersition = s;
            }
        });
    }


    /**
     * 身份验证
     */
    private void userVersiton() {
        HttpInterfaceIml.userVerifuser(phone, versition).subscribe(new Subscriber<UserBO>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                LogUtils.showToast(e.getMessage());
            }

            @Override
            public void onNext(UserBO s) {
                if (timer != null) {
                    timer.cancel();
                }

                finsh();
            }
        });
    }

    private void finsh() {
        finish();
    }


    /**
     * 验证输入
     */
    private boolean isRegister() {
        if (!RegexUtils.isMobileExact(phone)) {
            LogUtils.showToast("请输入正确的手机号！");
            return false;
        }
        if (StringUtils.isEmpty(versition) || !versition.equals(loadVersition)) {
            LogUtils.showToast("验证码错误！");
            return false;
        }
        return true;
    }

    CountDownTimer timer = new CountDownTimer(60 * 1000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            //每隔countDownInterval秒会回调一次onTick()方法
            getVerification.setText(millisUntilFinished / 1000 + " s");
        }

        @Override
        public void onFinish() {
            getVerification.setText("重新获取");
            getVerification.setEnabled(true);
        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (timer != null) {
            timer.cancel();
        }
        EventBus.getDefault().unregister(this);
    }
}