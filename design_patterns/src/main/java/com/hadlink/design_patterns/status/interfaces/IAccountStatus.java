package com.hadlink.design_patterns.status.interfaces;

import android.content.Context;

/**
 * @author Created by lyao on 2016/3/21.
 */
public interface IAccountStatus {

    /**
     * 转发
     */
    void forward(Context c);

    /**
     * 评论
     */
    void comment(Context c);

    /**
     * 点赞
     */
    void star(Context c);


}
