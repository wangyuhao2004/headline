package com.wang.headline.controller;

import com.wang.headline.common.Result;
import com.wang.headline.common.ResultCodeEnum;
import com.wang.headline.pojo.NewsUser;
import com.wang.headline.service.NewsUserService;
import com.wang.headline.service.impl.NewsUserServiceImpl;
import com.wang.headline.util.JwtHelper;
import com.wang.headline.util.MD5Util;
import com.wang.headline.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet("/user/*")
public class NewsUserController extends BaseController{

    private final NewsUserService newsUserService = new NewsUserServiceImpl();

    /**
     * 用户登录验证
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsUser newsUser = WebUtil.readJson(req, NewsUser.class);
        //调用服务层方法,判断用户账号密码是否正确
        NewsUser loginNewsUser = newsUserService.findByUserName(newsUser.getUsername());
        Result result = null;
        //判断用户名
        if (loginNewsUser != null) {
            //判断密码
            if (MD5Util.encrypt(newsUser.getUserPwd()).equals(loginNewsUser.getUserPwd())) {
                //密码正确
                Map<String, Object> data = new HashMap<>();
                //根据用户uid生成token
                String token = JwtHelper.createToken(loginNewsUser.getUid().longValue());
                //封装数据
                data.put("token",token);
                //封装结果
                result = Result.ok(data);
            } else {
                //密码错误
                result = Result.build(null, ResultCodeEnum.PASSWORD_ERROR);
            }
        } else {
            //用户名错误
            result = Result.build(null,ResultCodeEnum.USERNAME_ERROR);
        }

        WebUtil.writeJson(resp,result);

    }


    /**
     * 根据token获取完整用户信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        Result result = Result.build(null,ResultCodeEnum.NOTLOGIN);
        if (token != null) {
            if (!JwtHelper.isExpiration(token)) {
                Integer uid = JwtHelper.getUserId(token).intValue();
                NewsUser newsUser = newsUserService.findByUid(uid);
                newsUser.setUserPwd("");
                Map<String, Object> data= new HashMap<>();
                data.put("loginUser",newsUser);
                result = Result.ok(data);
            }
        }
        WebUtil.writeJson(resp,result);
    }


    /**
     * 检查注册时用户名是否被占用
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkUserName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        //调用服务层方法
        NewsUser byUserName = newsUserService.findByUserName(username);
        Result result = null;
        if (byUserName == null) {
            result = Result.ok(null);
        } else {
            result = Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp,result);
    }


    /**
     * 注册功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsUser registUser = WebUtil.readJson(req, NewsUser.class);
        String username = registUser.getUsername();
        NewsUser byUserName = newsUserService.findByUserName(username);
        Result result = null;
        if (byUserName == null) {
            //将用户信息添加到数据表当中
            newsUserService.regist(registUser);
            result = Result.ok(null);
        } else {
            result = Result.build(null,ResultCodeEnum.USERNAME_USED);
        }

        WebUtil.writeJson(resp,result);
    }

    /**
     * 登录校验,根据token是否过期判断是否要重新登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        Result result = Result.build(null,ResultCodeEnum.NOTLOGIN);
        if(null!= token){
            if (!JwtHelper.isExpiration(token)) {
                result=Result.ok(null);
            }
        }
        WebUtil.writeJson(resp,result);
    }
}
