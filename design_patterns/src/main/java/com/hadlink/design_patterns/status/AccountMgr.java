package com.hadlink.design_patterns.status;

import android.content.Context;

import com.hadlink.design_patterns.status.impl.LogoutState;
import com.hadlink.design_patterns.status.interfaces.IAccountStatus;

/**
 * @author Created by lyao on 2016/3/21.
 */
public enum AccountMgr implements IAccountStatus {

    INSTANCE;


    /**
     * 默认为注销状态
     */
    private IAccountStatus accountStatus = new LogoutState();

    public static AccountMgr getAccountMgr() {
        return INSTANCE;
    }

    public void setAccountState(IAccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * 转发
     */
    @Override public void forward(Context c) {
        accountStatus.forward(c);
    }

    /**
     * 评论
     */
    @Override public void comment(Context c) {
        accountStatus.comment(c);
    }

    /**
     * 点赞
     */
    @Override public void star(Context c) {
        accountStatus.star(c);
    }
}
