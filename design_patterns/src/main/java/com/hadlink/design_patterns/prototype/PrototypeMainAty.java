package com.hadlink.design_patterns.prototype;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hadlink.design_patterns.R;
import com.hadlink.design_patterns.prototype.model.Address;
import com.hadlink.design_patterns.prototype.model.User;

/**
 * @author Created by lyao on 2016/3/21.
 */
public class PrototypeMainAty extends AppCompatActivity {
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.protptype_mode);

        //网络返回的用户对象
        User loginedUser = new User();
        loginedUser.name = "lyao";
        loginedUser.age = 18;
        loginedUser.address = new Address("shenzhen");
        AccountMgr.getInstance().setAccount(loginedUser);

        //获取对象并修改

        User curUsr = AccountMgr.getInstance().getCurUsr();
        curUsr.name = "vihuela";
        curUsr.address = new Address("beijing");

        //重新获取对象
        User curUsr1 = AccountMgr.getInstance().getCurUsr();
        System.out.println();


    }
}
