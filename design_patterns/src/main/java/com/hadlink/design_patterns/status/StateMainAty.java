package com.hadlink.design_patterns.status;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.hadlink.design_patterns.R;
import com.hadlink.design_patterns.status.impl.LogoutState;

/**
 * @author Created by lyao on 2016/3/21.
 */
public class StateMainAty extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_mode);

    }

    public void logout(View view) {

        LogoutState logoutState = new LogoutState();
        AccountMgr.getAccountMgr().setAccountState(logoutState);
        Toast.makeText(this, "注销成功", Toast.LENGTH_SHORT).show();
    }

    public void comment(View view) {
        AccountMgr.getAccountMgr().comment(this);
    }

    public void forward(View view) {
        AccountMgr.getAccountMgr().forward(this);
    }
}
