package com.gaoshiwei.mvptest.presenter;

import android.os.Handler;

import com.gaoshiwei.mvptest.bean.User;
import com.gaoshiwei.mvptest.model.IUserBiz;
import com.gaoshiwei.mvptest.model.OnLoginListener;
import com.gaoshiwei.mvptest.model.UserBiz;
import com.gaoshiwei.mvptest.view.IUserLoginView;

/**
 * Created by gaoshiwei on 2017/6/15.
 */

public class UserLoginPresenter {

    private IUserBiz userBiz;
    private IUserLoginView userLoginView;

    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView){

        this.userLoginView=userLoginView;
        this.userBiz=new UserBiz();

    }


    public void login() {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
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

    public void clear() {
        userLoginView.clearUserName();
        userLoginView.clearPassword();
    }
}
