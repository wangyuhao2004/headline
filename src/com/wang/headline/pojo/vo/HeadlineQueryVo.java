package com.wang.headline.pojo.vo;


import java.io.Serializable;
import java.util.Objects;


public class HeadlineQueryVo implements Serializable {
    private String keyWords;
    private Integer type ;
    private Integer pageNum;
    private Integer pageSize;


    public HeadlineQueryVo() {
    }

    public HeadlineQueryVo(String keyWords, Integer type, Integer pageNum, Integer pageSize) {
        this.keyWords = keyWords;
        this.type = type;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HeadlineQueryVo that = (HeadlineQueryVo) o;
        return Objects.equals(keyWords, that.keyWords) && Objects.equals(type, that.type) && Objects.equals(pageNum, that.pageNum) && Objects.equals(pageSize, that.pageSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyWords, type, pageNum, pageSize);
    }

    /**
     * 获取
     * @return keyWords
     */
    public String getKeyWords() {
        return keyWords;
    }

    /**
     * 设置
     * @param keyWords
     */
    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
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
     * @return pageNum
     */
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     * 设置
     * @param pageNum
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * 获取
     * @return pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * 设置
     * @param pageSize
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String toString() {
        return "HeadlineQueryVo{keyWords = " + keyWords + ", type = " + type + ", pageNum = " + pageNum + ", pageSize = " + pageSize + "}";
    }
}
