package com.wang.headline.pojo.vo;


import java.io.Serializable;
import java.util.Objects;


public class HeadlinePageVo implements Serializable {
    private Integer hid;
    private String title;
    private Integer type;
    private Integer pageViews;
    private Long pastHours;
    private Integer publisher;


    public HeadlinePageVo() {
    }

    public HeadlinePageVo(Integer hid, String title, Integer type, Integer pageViews, Long pastHours, Integer publisher) {
        this.hid = hid;
        this.title = title;
        this.type = type;
        this.pageViews = pageViews;
        this.pastHours = pastHours;
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeadlinePageVo that = (HeadlinePageVo) o;
        return Objects.equals(hid, that.hid) && Objects.equals(title, that.title) && Objects.equals(type, that.type) && Objects.equals(pageViews, that.pageViews) && Objects.equals(pastHours, that.pastHours) && Objects.equals(publisher, that.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hid, title, type, pageViews, pastHours, publisher);
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

    public String toString() {
        return "HeadlinePageVo{hid = " + hid + ", title = " + title + ", type = " + type + ", pageViews = " + pageViews + ", pastHours = " + pastHours + ", publisher = " + publisher + "}";
    }
}