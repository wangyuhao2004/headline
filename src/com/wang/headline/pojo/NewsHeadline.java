package com.wang.headline.pojo;


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * news_headline表对应的实体类
 */

public class NewsHeadline implements Serializable {
    private Integer hid;
    private String title;
    private String article;
    private Integer type;
    private Integer publisher;
    private Integer pageViews;
    private Date createTime;
    private Date updateTime;
    private Integer isDeleted;


    public NewsHeadline() {
    }

    public NewsHeadline(Integer hid, String title, String article, Integer type, Integer publisher, Integer pageViews, Date createTime, Date updateTime, Integer isDeleted) {
        this.hid = hid;
        this.title = title;
        this.article = article;
        this.type = type;
        this.publisher = publisher;
        this.pageViews = pageViews;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDeleted = isDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsHeadline that = (NewsHeadline) o;
        return Objects.equals(hid, that.hid) && Objects.equals(title, that.title) && Objects.equals(article, that.article) && Objects.equals(type, that.type) && Objects.equals(publisher, that.publisher) && Objects.equals(pageViews, that.pageViews) && Objects.equals(createTime, that.createTime) && Objects.equals(updateTime, that.updateTime) && Objects.equals(isDeleted, that.isDeleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hid, title, article, type, publisher, pageViews, createTime, updateTime, isDeleted);
    }

    /**
     * 获取
     * @return hid
     */
    public Integer getHid() {
        return hid;
    }

    /**
     * 设置
     * @param hid
     */
    public void setHid(Integer hid) {
        this.hid = hid;
    }

    /**
     * 获取
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取
     * @return article
     */
    public String getArticle() {
        return article;
    }

    /**
     * 设置
     * @param article
     */
    public void setArticle(String article) {
        this.article = article;
    }

    /**
     * 获取
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取
     * @return publisher
     */
    public Integer getPublisher() {
        return publisher;
    }

    /**
     * 设置
     * @param publisher
     */
    public void setPublisher(Integer publisher) {
        this.publisher = publisher;
    }

    /**
     * 获取
     * @return pageViews
     */
    public Integer getPageViews() {
        return pageViews;
    }

    /**
     * 设置
     * @param pageViews
     */
    public void setPageViews(Integer pageViews) {
        this.pageViews = pageViews;
    }

    /**
     * 获取
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取
     * @return isDeleted
     */
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置
     * @param isDeleted
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String toString() {
        return "NewsHeadline{hid = " + hid + ", title = " + title + ", article = " + article + ", type = " + type + ", publisher = " + publisher + ", pageViews = " + pageViews + ", createTime = " + createTime + ", updateTime = " + updateTime + ", isDeleted = " + isDeleted + "}";
    }
}
