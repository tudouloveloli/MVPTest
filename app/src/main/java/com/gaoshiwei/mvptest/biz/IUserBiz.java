package com.gaoshiwei.mvptest.biz;

/**
 * Created by gaoshiwei on 2017/6/14.
 */

public interface IUserBiz {
    void login(String name,String password,OnLoginListener loginListener);

}
