package com.hadlink.design_patterns.prototype;

import com.hadlink.design_patterns.prototype.model.User;

/**
 * @author Created by lyao on 2016/3/21.
 */
public enum AccountMgr {
    INSTANCE;

    private User curUsr = new User();

    public static AccountMgr getInstance() {
        return INSTANCE;
    }

    /**
     * 包内可访问
     */
    void setAccount(User u) {
        this.curUsr = u;
    }

    public User getCurUsr() {
        try {
            return (User) curUsr.clone();//仅返回一份拷贝
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
