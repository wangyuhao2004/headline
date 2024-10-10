package com.wang.headline.service;

import com.wang.headline.pojo.NewsUser;

public interface NewsUserService {

    /**
     * 根据用户名查询用户的方法
     * @param username 用户输入的用户名
     * @return 如果找到返回NewsUser对象,否则返回null
     */
    NewsUser findByUserName(String username);

    /**
     * 根据uid查询用户信息的方法
     * @param uid
     * @return 如果找到返回NewsUser对象,否则返回null
     */
    NewsUser findByUid(Integer uid);

    /**
     * 用户注册的方法
     * @param registUser 用户注册的信息
     */
    void regist(NewsUser registUser);
}
