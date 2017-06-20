package com.gaoshiwei.mvptest.presenter;

import android.os.Handler;

import com.gaoshiwei.mvptest.bean.User;
import com.gaoshiwei.mvptest.model.IUserModel;
import com.gaoshiwei.mvptest.model.OnLoginListener;
import com.gaoshiwei.mvptest.model.UserModel;
import com.gaoshiwei.mvptest.view.IUserLoginView;

/**
 * Created by gaoshiwei on 2017/6/15.
 */

public class UserLoginPresenter {

    private IUserModel userModel;
    private IUserLoginView userLoginView;
    // handler对象
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {

        this.userLoginView = userLoginView;
        this.userModel = new UserModel();

    }

    /**
     * login
     */

    public void login() {
        userLoginView.showLoading();
        userModel.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();

                    }
                });

            }

            @Override
            public void loginFailed() {
                //需要在UI线程执行
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });


            }
        });


    }

    /**
     * clean status
     */
    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
