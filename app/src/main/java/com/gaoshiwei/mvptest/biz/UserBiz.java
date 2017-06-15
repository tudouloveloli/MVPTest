package com.gaoshiwei.mvptest.biz;


import com.gaoshiwei.mvptest.bean.User;

/**
 * Created by gaoshiwei on 2017/6/14.
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if ("tudou".equals(username) && "123".equals(password)) {
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    loginListener.loginSuccess(user);
                } else {
                    loginListener.loginFailed();
                }
            }
        }).start();
    }
}
