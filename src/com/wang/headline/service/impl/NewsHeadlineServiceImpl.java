package com.wang.headline.service.impl;

import com.wang.headline.dao.NewsHeadlineDao;
import com.wang.headline.dao.impl.NewsHeadlineDaoImpl;
import com.wang.headline.pojo.NewsHeadline;
import com.wang.headline.pojo.NewsType;
import com.wang.headline.pojo.vo.HeadlineDetailVo;
import com.wang.headline.pojo.vo.HeadlinePageVo;
import com.wang.headline.pojo.vo.HeadlineQueryVo;
import com.wang.headline.service.NewsHeadlineService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NewsHeadlineServiceImpl implements NewsHeadlineService {

    private NewsHeadlineDao newsHeadlineDao = new NewsHeadlineDaoImpl();

    @Override
    public Map<String,Object> findPage(HeadlineQueryVo headlineQueryVo) {
        //创建map集合,存分页数据
        Map<String,Object> pageInfo = new TreeMap<>();
        //创建list集合,用于存新闻主体,调用dao层方法
        List<HeadlinePageVo> pageData = newsHeadlineDao.findPageList(headlineQueryVo);
        //页码数
        int pageNum = headlineQueryVo.getPageNum();
        //页大小
        int pageSize = headlineQueryVo.getPageSize();
        //查询符合条件的总记录数
        int totalSize = newsHeadlineDao.findPageCount(headlineQueryVo);
        //计算总页数
        int totalPage = totalSize%pageSize == 0 ?  totalSize/pageSize  : totalSize/pageSize+1;
        //放入map集合
        pageInfo.put("pageData",pageData);
        pageInfo.put("pageNum",pageNum);
        pageInfo.put("pageSize",pageSize);
        pageInfo.put("totalPage",totalPage);
        pageInfo.put("totalSize",totalSize);

        return pageInfo;

    }

    @Override
    public HeadlineDetailVo findByHid(Integer hid) {
        return newsHeadlineDao.findByHid(hid);
    }

    @Override
    public void addNewsHeadLine(NewsHeadline newsHeadline) {
        newsHeadlineDao.addNewsHeadLine(newsHeadline);
    }

    @Override
    public NewsHeadline findHeadLineByHid(int hid) {
        return newsHeadlineDao.findHeadLineByHid(hid);
    }

    @Override
    public void updateHeadLine(NewsHeadline newsHeadline) {
        newsHeadlineDao.updateHeadLine(newsHeadline);
    }

    @Override
    public void removeByHid(Integer hid) {
        newsHeadlineDao.removeByHid(hid);
    }


}
