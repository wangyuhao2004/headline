package com.wang.headline.dao.impl;

import com.wang.headline.dao.BaseDao;
import com.wang.headline.dao.NewsTypeDao;
import com.wang.headline.pojo.NewsType;

import java.util.List;

public class NewsTypeDaoImpl extends BaseDao implements NewsTypeDao {
    @Override
    public List<NewsType> findAll() {
        String sql = "select tid, tname from news_type";
        return baseQuery(NewsType.class, sql);
    }

    @Override
    public String findTypeName(Integer type) {
        String sql = "select tname from news_type where tid = ?";
        return baseQueryObject(String.class,sql,type);
    }
}
