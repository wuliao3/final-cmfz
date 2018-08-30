package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Menu implements Serializable {
    private int id;
    private String title;
    private String href;
    private String iconCls;
    private int parentId;

    private List<Menu> secList;

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", href='" + href + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", parentId=" + parentId +
                ", secList=" + secList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return id == menu.id &&
                parentId == menu.parentId &&
                Objects.equals(title, menu.title) &&
                Objects.equals(href, menu.href) &&
                Objects.equals(iconCls, menu.iconCls) &&
                Objects.equals(secList, menu.secList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, href, iconCls, parentId, secList);
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getSecList() {
        return secList;
    }

    public void setSecList(List<Menu> secList) {
        this.secList = secList;
    }

    public Menu() {
    }

    public Menu(int id, String title, String href, String iconCls, int parentId, List<Menu> secList) {

        this.id = id;
        this.title = title;
        this.href = href;
        this.iconCls = iconCls;
        this.parentId = parentId;
        this.secList = secList;
    }
}
