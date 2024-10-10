package com.wang.headline.pojo;



import java.io.Serializable;
import java.util.Objects;

/**
 * news_type表对应的实体类
 */


public class NewsType implements Serializable {
    private Integer tid;
    private String tname;


    public NewsType() {
    }

    public NewsType(Integer tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsType newsType = (NewsType) o;
        return Objects.equals(tid, newsType.tid) && Objects.equals(tname, newsType.tname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, tname);
    }

    /**
     * 获取
     * @return tid
     */
    public Integer getTid() {
        return tid;
    }

    /**
     * 设置
     * @param tid
     */
    public void setTid(Integer tid) {
        this.tid = tid;
    }

    /**
     * 获取
     * @return tname
     */
    public String getTname() {
        return tname;
    }

    /**
     * 设置
     * @param tname
     */
    public void setTname(String tname) {
        this.tname = tname;
    }

    public String toString() {
        return "NewsType{tid = " + tid + ", tname = " + tname + "}";
    }
}
