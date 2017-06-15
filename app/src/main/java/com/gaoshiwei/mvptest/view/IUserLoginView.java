package com.gaoshiwei.mvptest.view;

import com.gaoshiwei.mvptest.bean.User;

/**
 * Created by gaoshiwei on 2017/6/14.
 *
 */

public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();


}
