package com.gaoshiwei.mvptest.model;

/**
 * Created by gaoshiwei on 2017/6/14.
 */

public interface IUserModel {
    void login(String name,String password,OnLoginListener loginListener);

}
