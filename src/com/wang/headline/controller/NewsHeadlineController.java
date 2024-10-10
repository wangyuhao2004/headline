package com.wang.headline.controller;

import com.wang.headline.common.Result;
import com.wang.headline.pojo.NewsHeadline;
import com.wang.headline.service.NewsHeadlineService;
import com.wang.headline.service.impl.NewsHeadlineServiceImpl;
import com.wang.headline.util.JwtHelper;
import com.wang.headline.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/headline/*")
public class NewsHeadlineController extends BaseController{

    private NewsHeadlineService newsHeadlineService = new NewsHeadlineServiceImpl();

    /**
     * 头条发布
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void publish(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsHeadline newsHeadline = WebUtil.readJson(req, NewsHeadline.class);
        //获取token
        String token = req.getHeader("token");
        //根据token获取发布者id
        Long userId = JwtHelper.getUserId(token);
        newsHeadline.setPublisher(userId.intValue());
        //调用服务层方法,将头条添加到数据表
        newsHeadlineService.addNewsHeadLine(newsHeadline);
        WebUtil.writeJson(resp, Result.ok(null));

    }

    /**
     * 修改头条(回显)
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void findHeadlineByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int hid = Integer.parseInt(req.getParameter("hid"));
        NewsHeadline newsHeadline = newsHeadlineService.findHeadLineByHid(hid);
        Map<String,Object> data = new HashMap<>();
        data.put("headline",newsHeadline);
        Result result = Result.ok(data);
        WebUtil.writeJson(resp,result);

    }

    /**
     * 保存修改
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsHeadline newsHeadline = WebUtil.readJson(req, NewsHeadline.class);
        newsHeadlineService.updateHeadLine(newsHeadline);
        WebUtil.writeJson(resp,Result.ok(null));
    }

    /**
     * 删除头条
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void removeByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer hid = Integer.parseInt(req.getParameter("hid"));
        newsHeadlineService.removeByHid(hid);
        WebUtil.writeJson(resp,Result.ok(null));
    }
}
