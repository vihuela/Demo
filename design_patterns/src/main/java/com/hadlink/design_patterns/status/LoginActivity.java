package com.hadlink.design_patterns.status;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hadlink.design_patterns.R;
import com.hadlink.design_patterns.status.impl.LoginedState;

/**
 * @author Created by lyao on 2016/3/21.
 */
public class LoginActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_mode_login);

    }

    public void login(View view) {
        String user = ((EditText) findViewById(R.id.user)).getText().toString().trim();
        String psw = ((EditText) findViewById(R.id.psw)).getText().toString().trim();

        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(psw)) {
            Toast.makeText(this, "用户名或密码为空", Toast.LENGTH_SHORT).show();
            return;
        }

        /**
         * 网络异步请求。。。
         */
        LoginedState loginedState = new LoginedState();
        AccountMgr.getAccountMgr().setAccountState(loginedState);
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
        finish();
    }
}
