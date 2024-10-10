package com.wang.headline.dao.impl;

import com.wang.headline.dao.BaseDao;
import com.wang.headline.dao.NewsUserDao;
import com.wang.headline.pojo.NewsUser;
import com.wang.headline.util.MD5Util;

import java.util.List;

public class NewsUserDaoImpl extends BaseDao implements NewsUserDao {
    @Override
    public NewsUser findByUserName(String username) {
        String sql = "select uid, username, user_pwd userPwd, nick_name nickName from news_user where username = ?";
        List<NewsUser> loginNewsUser = baseQuery(NewsUser.class, sql, username);
        if (loginNewsUser != null && !loginNewsUser.isEmpty()) {
            return loginNewsUser.getFirst();
        } else {
            return null;
        }
    }

    @Override
    public NewsUser findByUid(Integer uid) {
        String sql = "select uid, username, user_pwd userPwd, nick_name nickName from news_user where uid = ?";
        List<NewsUser> newsUser = baseQuery(NewsUser.class, sql, uid);
        if (newsUser != null && !newsUser.isEmpty()) {
            return newsUser.getFirst();
        }
        return null;
    }

    @Override
    public void insterUser(NewsUser registUser) {
        String sql = "insert into news_user value(default,?,?,?)";
        baseUpdate(sql,registUser.getUsername(), MD5Util.encrypt(registUser.getUserPwd()),registUser.getNickName());
    }
}
