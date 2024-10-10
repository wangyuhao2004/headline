package com.wang.headline.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * news_user表对应的实体类
 */
public class NewsUser implements Serializable {
    private Integer uid;
    private String username;
    private String userPwd;
    private String nickName;


    public NewsUser() {
    }

    public NewsUser(Integer uid, String username, String userPwd, String nickName) {
        this.uid = uid;
        this.username = username;
        this.userPwd = userPwd;
        this.nickName = nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsUser newsUser = (NewsUser) o;
        return Objects.equals(uid, newsUser.uid) && Objects.equals(username, newsUser.username) && Objects.equals(userPwd, newsUser.userPwd) && Objects.equals(nickName, newsUser.nickName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, username, userPwd, nickName);
    }

    /**
     * 获取
     * @return uid
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * 设置
     * @param uid
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return userPwd
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * 设置
     * @param userPwd
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * 获取
     * @return nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String toString() {
        return "NewsUser{uid = " + uid + ", username = " + username + ", userPwd = " + userPwd + ", nickName = " + nickName + "}";
    }
}
