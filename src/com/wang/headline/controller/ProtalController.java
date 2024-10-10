package com.wang.headline.controller;

import com.wang.headline.common.Result;
import com.wang.headline.pojo.NewsType;
import com.wang.headline.pojo.NewsUser;
import com.wang.headline.pojo.vo.HeadlineDetailVo;
import com.wang.headline.pojo.vo.HeadlineQueryVo;
import com.wang.headline.service.NewsHeadlineService;
import com.wang.headline.service.NewsTypeService;
import com.wang.headline.service.NewsUserService;
import com.wang.headline.service.impl.NewsHeadlineServiceImpl;
import com.wang.headline.service.impl.NewsTypeServiceImpl;
import com.wang.headline.service.impl.NewsUserServiceImpl;
import com.wang.headline.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 门户控制器,那些不需要登录,不需要做增删改的请求放在这里
 */
@WebServlet("/portal/*")
public class ProtalController extends BaseController{

    private  NewsTypeService newsTypeService = new NewsTypeServiceImpl();
    private NewsHeadlineService newsHeadlineService =new  NewsHeadlineServiceImpl();
    private NewsUserService newsUserService = new NewsUserServiceImpl();

    /**
     * 查询所有新闻的分类
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findAllTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用服务层方法
        List<NewsType> newsTypeList = newsTypeService.findAll();
        //转化为json串响应给客户端
        Result result = Result.ok(newsTypeList);
        System.out.println(result.toString());
        WebUtil.writeJson(resp, result);
    }

    /**
     * 分页带条件查询所有头条
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findNewsPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HeadlineQueryVo headlineQueryVo = WebUtil.readJson(req, HeadlineQueryVo.class);
        //调用服务层方法
        Map<String,Object> pageInfo = newsHeadlineService.findPage(headlineQueryVo);
        //将分页数据放到data集合当中
        Map<String,Object> data = new HashMap();
        data.put("pageInfo",pageInfo);
        WebUtil.writeJson(resp,Result.ok(data));
    }

    /**
     * 查看头条详情
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showHeadlineDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer hid = Integer.parseInt(req.getParameter("hid"));
        HeadlineDetailVo headlineDetailVo = newsHeadlineService.findByHid(hid);
        //获取作者
        Integer uid = headlineDetailVo.getPublisher();
        NewsUser user = newsUserService.findByUid(uid);
        String author = user.getNickName();
        headlineDetailVo.setAuthor(author);
        //获取新闻类型
        Integer type = headlineDetailVo.getType();
        String typeName = newsTypeService.findByType(type);
        headlineDetailVo.setTypeName(typeName);

        Map<String,Object> headline = new HashMap<>();
        headline.put("headline",headlineDetailVo);
        Map<String,Object> data = new HashMap<>();
        Result result = Result.ok(headline);
        WebUtil.writeJson(resp,result);


    }
}
