package com.gaoshiwei.mvptest.biz;

import com.gaoshiwei.mvptest.bean.User;

/**
 * Created by gaoshiwei on 2017/6/14.
 */

/**
 *
 * 一个回调接口来通知登录的状态
 */
public interface OnLoginListener {

    void loginSuccess(User user);
    void loginFailed();
}
