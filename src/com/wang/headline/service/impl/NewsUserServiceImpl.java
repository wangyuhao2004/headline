package com.wang.headline.service.impl;

import com.wang.headline.dao.NewsUserDao;
import com.wang.headline.dao.impl.NewsUserDaoImpl;
import com.wang.headline.pojo.NewsUser;
import com.wang.headline.service.NewsUserService;

public class NewsUserServiceImpl implements NewsUserService {

    private final NewsUserDao newsUserDao = new NewsUserDaoImpl();

    @Override
    public NewsUser findByUserName(String username) {
        //调用dao层方法
        return newsUserDao.findByUserName(username);
    }

    @Override
    public NewsUser findByUid(Integer uid) {
        //调用dao层的方法
        return newsUserDao.findByUid(uid);
    }

    @Override
    public void regist(NewsUser registUser) {
        newsUserDao.insterUser(registUser);
    }
}
