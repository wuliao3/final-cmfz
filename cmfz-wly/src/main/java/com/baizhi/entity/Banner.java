package com.baizhi.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Banner implements Serializable {
    private Integer id;
    private String name;
    private String picUrl;
    private String description;
    private String status;
    private String createTime;
    private String url;

    @Override
    public String toString() {
        return "Banner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banner banner = (Banner) o;
        return id == banner.id &&
                Objects.equals(name, banner.name) &&
                Objects.equals(picUrl, banner.picUrl) &&
                Objects.equals(description, banner.description) &&
                Objects.equals(status, banner.status) &&
                Objects.equals(createTime, banner.createTime) &&
                Objects.equals(url, banner.url);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, picUrl, description, status, createTime, url);
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateTime()  {
       return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Banner() {

    }

    public Banner(Integer id, String name, String picUrl, String description, String status, String createTime, String url) {

        this.id = id;
        this.name = name;
        this.picUrl = picUrl;
        this.description = description;
        this.status = status;
        this.createTime = createTime;
        this.url = url;
    }
}
