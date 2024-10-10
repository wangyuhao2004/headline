package com.wang.headline.dao;

import com.wang.headline.pojo.NewsUser;

public interface NewsUserDao {

    /**
     * 根据用户名在数据库当中查询用户信息
     * @param username 用户名
     * @return 如果存在返回NewUser对象,否则返回null
     */
    NewsUser findByUserName(String username);

    /**
     * 根据uid在数据库当中查询用户信息
     * @param uid
     * @return
     */
    NewsUser findByUid(Integer uid);

    /**
     * 将用户信息添加到数据表当中
     * @param registUser
     */
    void insterUser(NewsUser registUser);
}
