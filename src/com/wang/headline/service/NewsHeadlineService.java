package com.wang.headline.service;

import com.wang.headline.pojo.NewsHeadline;
import com.wang.headline.pojo.vo.HeadlineDetailVo;
import com.wang.headline.pojo.vo.HeadlineQueryVo;

import java.util.Map;

public interface NewsHeadlineService {
    /**
     * 分页头条新闻的方法
     * @param headlineQueryVo
     * @return
     */
    Map<String, Object> findPage(HeadlineQueryVo headlineQueryVo);

    /**
     * 查看头条详情的方法
     * @param hid
     * @return
     */
    HeadlineDetailVo findByHid(Integer hid);

    /**
     * 发布头条的方法
     * @param newsHeadline
     */
    void addNewsHeadLine(NewsHeadline newsHeadline);

    /**
     * 修改头条回显的方法
     * @param hid
     * @return
     */
   NewsHeadline findHeadLineByHid(int hid);


    /**
     * 保存修改的方法
     * @param newsHeadline
     */
    void updateHeadLine(NewsHeadline newsHeadline);

    /**
     * 删除头条
     * @param hid
     */
    void removeByHid(Integer hid);
}
