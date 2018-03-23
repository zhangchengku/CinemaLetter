package com.myp.cinema.ui.userregister;


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

import com.myp.cinema.R;
import com.myp.cinema.entity.UserBO;
import com.myp.cinema.mvp.MVPBaseActivity;
import com.myp.cinema.util.LogUtils;
import com.myp.cinema.util.MD5;
import com.myp.cinema.util.RegexUtils;
import com.myp.cinema.util.StringUtils;

import butterknife.Bind;


/**
 * MVPPlugin
 * 注册页面
 */

public class RegisterActivity extends MVPBaseActivity<RegisterContract.View, RegisterPresenter>
        implements RegisterContract.View, View.OnClickListener,
        CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.phone_edit)
    EditText phoneEdit;
    @Bind(R.id.verification_edit)
    EditText verificationEdit;
    @Bind(R.id.get_verification)
    Button getVerification;
    @Bind(R.id.password_edit)
    EditText passwordEdit;
    @Bind(R.id.radio_nan)
    RadioButton radioNan;
    @Bind(R.id.radio_nv)
    RadioButton radioNv;
    @Bind(R.id.radio_layout)
    RadioGroup radioLayout;
    @Bind(R.id.checkbox)
    CheckBox checkbox;
    @Bind(R.id.register_button)
    Button registerButton;

    String phone = "";
    String password = "";
    String versition = "";  //后台获取的验证码
    String editVersition = "";   //输入的验证码
    String sex = "1";   //性别默认为1
    boolean isCheck = true;   //默认同意服务条款

    @Override
    protected int getLayout() {
        return R.layout.act_register;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        goBack();
        setTitle("注册");

        getVerification.setOnClickListener(this);
        checkbox.setOnCheckedChangeListener(this);
        radioLayout.setOnCheckedChangeListener(this);
        registerButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        phone = phoneEdit.getText().toString().trim();
        password = passwordEdit.getText().toString().trim();
        editVersition = verificationEdit.getText().toString().trim();
        switch (v.getId()) {
            case R.id.get_verification:  //获取验证码
                if (RegexUtils.isMobileExact(phone)) {
                    mPresenter.loadVersition(phone);
                    timer.start();
                    getVerification.setEnabled(false);
                } else {
                    LogUtils.showToast("请输入正确的手机号");
                }
                break;
            case R.id.register_button:
                if (isSubmit()) {
                    mPresenter.loadRegisterUser(phone, MD5.strToMd5Low32(password), editVersition, sex);
                }
                break;
        }
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


    /**
     * 请求返回的验证码
     *
     * @param version
     */
    @Override
    public void getVersition(String version) {
        versition = version;
    }

    /**
     * 注册成功之后返回用户信息
     *
     * @param user
     */
    @Override
    public void getUser(UserBO user) {
        Intent intent = new Intent();
        intent.putExtra("user", user);
        setResult(1, intent);
        finish();
    }


    private boolean isSubmit() {
        if (!RegexUtils.isMobileExact(phone)) {
            LogUtils.showToast("请输入正确的手机号!");
            return false;
        }
        if (StringUtils.isEmpty(password)) {
            LogUtils.showToast("请输入密码!");
            return false;
        }
        if (password.length() < 6 || password.length() > 20) {
            LogUtils.showToast("密码长度要在6-20位!");
            return false;
        }
        if (StringUtils.isEmpty(editVersition) || !editVersition.equals(versition)) {
            LogUtils.showToast("请输入正确的验证码！");
            return false;
        }
        if (!isCheck) {
            LogUtils.showToast("请同意《德信影城服务条款》!");
            return false;
        }
        return true;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        this.isCheck = isChecked;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.radio_nan:
                sex = "1";
                break;
            case R.id.radio_nv:
                sex = "2";
                break;
        }
    }

    @Override
    public void onRequestError(String msg) {
        LogUtils.showToast(msg);
    }

    @Override
    public void onRequestEnd() {

    }
}
