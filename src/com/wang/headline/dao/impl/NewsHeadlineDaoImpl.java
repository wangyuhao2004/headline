package com.wang.headline.dao.impl;

import com.wang.headline.dao.BaseDao;
import com.wang.headline.dao.NewsHeadlineDao;
import com.wang.headline.pojo.NewsHeadline;
import com.wang.headline.pojo.vo.HeadlineDetailVo;
import com.wang.headline.pojo.vo.HeadlinePageVo;
import com.wang.headline.pojo.vo.HeadlineQueryVo;

import java.util.*;

public class NewsHeadlineDaoImpl extends BaseDao implements NewsHeadlineDao {

    @Override
    public List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo) {
        List params = new ArrayList<>();
        String  sql = """
                     select
                     hid,
                     title,
                     type,
                     page_views pageViews,
                     TIMESTAMPDIFF(HOUR,create_time,NOW()) pastHours,
                     publisher from news_headline where is_deleted=0
                     """;
        if (headlineQueryVo.getKeyWords() != null && !headlineQueryVo.getKeyWords().equals("")) {
            sql = sql.concat(" and title like ?");
            params.add("%"+headlineQueryVo.getKeyWords()+"%");
        }
        if (headlineQueryVo.getType() != null && headlineQueryVo.getType() != 0) {
            sql = sql.concat(" and type = ?");
            params.add(headlineQueryVo.getType());
        }
        //根据发布时间已过小时数升序,浏览量降序排列
        sql = sql.concat(" order by pastHours, page_views DESC");
        //分页
        sql = sql.concat(" limit ?,?");
        params.add((headlineQueryVo.getPageNum()-1)*headlineQueryVo.getPageSize());
        params.add(headlineQueryVo.getPageSize());

        //执行sql
        return baseQuery(HeadlinePageVo.class,sql,params.toArray());


    }

    @Override
    public int findPageCount(HeadlineQueryVo headlineQueryVo) {
        List params = new ArrayList();
        String sql = """
                select
                count(1)
                from news_headline
                where is_deleted = 0
                """;
        String keyWords = headlineQueryVo.getKeyWords();
        if (keyWords != null && !keyWords.isEmpty()) {
            sql = sql.concat(" like ?");
            params.add("%"+keyWords+"%");
        }

        Integer type = headlineQueryVo.getType();
        if (type != null && type != 0) {
            sql = sql.concat(" and type = ?");
            params.add(type);
        }

        Long totalSize = baseQueryObject(Long.class, sql, params.toArray());

        return totalSize.intValue();
    }

    @Override
    public HeadlineDetailVo findByHid(Integer hid) {
        String sql = """
                select
                hid,
                title,
                article,
                type,
                page_views pageViews,
                TIMESTAMPDIFF(HOUR,create_time,NOW()) pastHours,
                publisher
                from news_headline
                where hid = ? and is_deleted = 0
                """;
        List<HeadlineDetailVo> list = baseQuery(HeadlineDetailVo.class, sql, hid);

        if (list != null && !list.isEmpty()) {
            return list.getFirst();
        }
        return null;
    }

    @Override
    public void addNewsHeadLine(NewsHeadline newsHeadline) {
        String sql = """
                     insert into news_headline values(default,?,?,?,?,0,now(),now(),0)
                     """;
        String title = newsHeadline.getTitle();
        String article = newsHeadline.getArticle();
        Integer type = newsHeadline.getType();
        Integer publisher = newsHeadline.getPublisher();
        baseUpdate(sql,title,article,type,publisher);
    }

    @Override
    public NewsHeadline findHeadLineByHid(int hid) {
        String sql = """
                     select
                hid,
                title,
                article,
                type,
                publisher,
                page_views pageViews
                from news_headline
                where hid = ?
                """;
        List<NewsHeadline> headlineList = baseQuery(NewsHeadline.class, sql, hid);
        if (headlineList != null && !headlineList.isEmpty()) {
            return headlineList.getFirst();
        }
        return null;
    }

    @Override
    public void updateHeadLine(NewsHeadline newsHeadline) {
        String sql ="update news_headline set title = ?, article= ? , type =? , update_time = NOW() where hid = ? ";
        baseUpdate(
                sql,
                newsHeadline.getTitle(),
                newsHeadline.getArticle(),
                newsHeadline.getType(),
                newsHeadline.getHid()
        );
    }

    @Override
    public void removeByHid(Integer hid) {
        String sql ="update news_headline set is_deleted =1 ,  update_time =NOW() where hid = ? ";
        baseUpdate(sql,hid);
    }
}
