package com.wang.headline.service.impl;

import com.wang.headline.dao.NewsTypeDao;
import com.wang.headline.dao.impl.NewsTypeDaoImpl;
import com.wang.headline.pojo.NewsType;
import com.wang.headline.service.NewsTypeService;

import java.util.List;

public class NewsTypeServiceImpl implements NewsTypeService {

    private  NewsTypeDao newsTypeDao = new NewsTypeDaoImpl();

    @Override
    public List<NewsType> findAll() {
         //调用dao层的方法
        return newsTypeDao.findAll();
    }

    @Override
    public String findByType(Integer type) {
        return newsTypeDao.findTypeName(type);
    }
}
