package com.wang.headline.pojo.vo;

import java.io.Serializable;
import java.util.Objects;


public class HeadlineDetailVo implements Serializable {
    private Integer hid;
    private String title;
    private String article;
    private Integer type;
    private String typeName;
    private Integer pageViews;
    private Long pastHours;
    private Integer publisher;
    private String author;


    public HeadlineDetailVo() {
    }

    public HeadlineDetailVo(Integer hid, String title, String article, Integer type, String typeName, Integer pageViews, Long pastHours, Integer publisher, String author) {
        this.hid = hid;
        this.title = title;
        this.article = article;
        this.type = type;
        this.typeName = typeName;
        this.pageViews = pageViews;
        this.pastHours = pastHours;
        this.publisher = publisher;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeadlineDetailVo that = (HeadlineDetailVo) o;
        return Objects.equals(hid, that.hid) && Objects.equals(title, that.title) && Objects.equals(article, that.article) && Objects.equals(type, that.type) && Objects.equals(typeName, that.typeName) && Objects.equals(pageViews, that.pageViews) && Objects.equals(pastHours, that.pastHours) && Objects.equals(publisher, that.publisher) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hid, title, article, type, typeName, pageViews, pastHours, publisher, author);
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
     * @return typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置
     * @param typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
     * @return pastHours
     */
    public Long getPastHours() {
        return pastHours;
    }

    /**
     * 设置
     * @param pastHours
     */
    public void setPastHours(Long pastHours) {
        this.pastHours = pastHours;
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
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString() {
        return "HeadlineDetailVo{hid = " + hid + ", title = " + title + ", article = " + article + ", type = " + type + ", typeName = " + typeName + ", pageViews = " + pageViews + ", pastHours = " + pastHours + ", publisher = " + publisher + ", author = " + author + "}";
    }
}
