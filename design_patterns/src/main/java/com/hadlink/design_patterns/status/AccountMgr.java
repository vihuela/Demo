package com.hadlink.design_patterns.status;

import android.content.Context;

import com.hadlink.design_patterns.status.impl.LogoutState;
import com.hadlink.design_patterns.status.interfaces.IAccountStatus;

/**
 * @author Created by lyao on 2016/3/21.
 */
public class AccountMgr {

    private static AccountMgr accountMgr = new AccountMgr();

    /**
     * 默认为注销状态
     */
    private IAccountStatus accountStatus = new LogoutState();

    private AccountMgr() {
    }

    public static AccountMgr getAccountMgr() {
        return accountMgr;
    }

    public void setAccountState(IAccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }


    /**
     * 转发
     */
    public void forward(Context c) {
        accountStatus.forward(c);
    }

    /**
     * 评论
     */
    public void comment(Context c) {
        accountStatus.comment(c);
    }


}
