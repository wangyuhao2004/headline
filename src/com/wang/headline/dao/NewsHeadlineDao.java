package com.wang.headline.dao;

import com.wang.headline.pojo.NewsHeadline;
import com.wang.headline.pojo.vo.HeadlineDetailVo;
import com.wang.headline.pojo.vo.HeadlinePageVo;
import com.wang.headline.pojo.vo.HeadlineQueryVo;

import java.util.List;

public interface NewsHeadlineDao {
    /**
     *根据查询条件,查询当前页数据
     * @param headlineQueryVo
     * @return
     */
    List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo);

    /**
     * 根据查询条件,查询总记录数
     * @param headlineQueryVo
     * @return
     */
    int findPageCount(HeadlineQueryVo headlineQueryVo);

    /**
     * 根据hid查询数据
     * @param hid
     * @return
     */
    HeadlineDetailVo findByHid(Integer hid);

    /**
     * 将发布的头条添加到数据库当中
     * @param newsHeadline
     */
    void addNewsHeadLine(NewsHeadline newsHeadline);

    /**
     * 在数据库中根据hid查询数据
     *
     * @param hid
     * @return
     */
    NewsHeadline findHeadLineByHid(int hid);

    /**
     * 修改数据库当中的数据
     * @param newsHeadline
     */
    void updateHeadLine(NewsHeadline newsHeadline);

    /**
     * 在数据库中删除头条
     * @param hid
     */
    void removeByHid(Integer hid);
}
