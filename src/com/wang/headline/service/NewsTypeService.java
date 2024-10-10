package com.wang.headline.service;

import com.wang.headline.pojo.NewsType;

import java.util.List;

public interface NewsTypeService {
    /**
     * 查询所有新闻类型的方法
     * @return 返回一个list集合,泛型为NewsType对象(一种新闻类型,为一个对象)
     */
    List<NewsType> findAll();

    /**
     * 获取新闻类型名字的方法
     * @param type
     * @return string
     */
    String findByType(Integer type);
}
