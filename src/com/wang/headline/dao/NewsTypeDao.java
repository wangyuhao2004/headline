package com.wang.headline.dao;

import com.wang.headline.pojo.NewsType;

import java.util.List;

public interface NewsTypeDao {
    /**
     * 从数据库当中查询全部新闻类型
     * @return
     */
    List<NewsType> findAll();

    /**
     * 根据type,获取新闻类型名字
     * @param type
     * @return
     */
    String findTypeName(Integer type);
}
