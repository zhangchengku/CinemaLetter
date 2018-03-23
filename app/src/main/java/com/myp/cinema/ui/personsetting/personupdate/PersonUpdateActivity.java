package com.myp.cinema.ui.personsetting.personupdate;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.myp.cinema.R;
import com.myp.cinema.base.MyApplication;
import com.myp.cinema.entity.UserBO;
import com.myp.cinema.mvp.MVPBaseActivity;
import com.myp.cinema.util.LogUtils;
import com.myp.cinema.util.StringUtils;

import butterknife.Bind;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PersonUpdateActivity extends MVPBaseActivity<PersonUpdateContract.View,
        PersonUpdatePresenter> implements PersonUpdateContract.View, View.OnClickListener {

    @Bind(R.id.person_name_edit)
    EditText personNameEdit;
    @Bind(R.id.person_name_layout)
    LinearLayout personNameLayout;
    @Bind(R.id.old_pass)
    EditText oldPass;
    @Bind(R.id.new_pass)
    EditText newPass;
    @Bind(R.id.affirm_pass)
    EditText affirmPass;
    @Bind(R.id.update_password)
    LinearLayout updatePassword;
    @Bind(R.id.update_button)
    Button updateButton;
    @Bind(R.id.go_back)
    LinearLayout goBack;

    private String type = "";

    String name;
    String oldPassStr;
    String newPassStr;
    String affirmPassStr;

    @Override
    protected int getLayout() {
        return R.layout.act_person_update;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        type = getIntent().getStringExtra("type");
        if ("password".equals(type)) {
            personNameLayout.setVisibility(View.GONE);
            updatePassword.setVisibility(View.VISIBLE);
            setTitle("修改密码");
        } else if ("personName".equals(type)) {
            personNameLayout.setVisibility(View.VISIBLE);
            updatePassword.setVisibility(View.GONE);
            setTitle("修改名字");
        }
        updateButton.setOnClickListener(this);
        goBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.update_button:
                if ("password".equals(type)) {
                    oldPassStr = oldPass.getText().toString().trim();
                    newPassStr = newPass.getText().toString().trim();
                    affirmPassStr = affirmPass.getText().toString().trim();
                    if (isUpdatePass()) {
                        mPresenter.updatePassWord(oldPassStr, newPassStr);
                    }
                } else if ("personName".equals(type)) {
                    name = personNameEdit.getText().toString().trim();
                    if (StringUtils.isEmpty(name)) {
                        LogUtils.showToast("请输入昵称！");
                    } else {
                        mPresenter.updateName(name);
                    }
                }
                break;
            case R.id.go_back:
                Intent intent = new Intent();
                intent.putExtra("user", MyApplication.user);
                setResult(0x11, intent);
                finish();
                break;
        }
    }


    /**
     * 检测密码是否符合
     */
    private boolean isUpdatePass() {
        if (StringUtils.isEmpty(oldPassStr)) {
            LogUtils.showToast("请输入旧的密码！");
            return false;
        }
        if (StringUtils.isEmpty(newPassStr)) {
            LogUtils.showToast("请输入新密码！");
            return false;
        }
        if (!affirmPassStr.equals(newPassStr)) {
            LogUtils.showToast("两次密码输入不一致！");
            return false;
        }
        if (oldPassStr.length() < 6 || oldPassStr.length() > 20) {
            LogUtils.showToast("密码的长度为6-20位的字母数字");
            return false;
        }
        if (newPassStr.length() < 6 || newPassStr.length() > 20) {
            LogUtils.showToast("新密码的长度为6-20位的字母数字");
            return false;
        }
        return true;
    }

    @Override
    public void onRequestError(String msg) {
        LogUtils.showToast(msg);
    }

    @Override
    public void onRequestEnd() {

    }

    @Override
    public void getData(UserBO userBO) {
        MyApplication.user = userBO;
        LogUtils.showToast("修改成功！");
        Intent intent = new Intent();
        intent.putExtra("user", MyApplication.user);
        setResult(0x11, intent);
        finish();
    }
}
