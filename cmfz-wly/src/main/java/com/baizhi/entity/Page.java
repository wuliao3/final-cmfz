package com.baizhi.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Page implements Serializable {
    private int total;
    private List<Banner> rows;
    private int start;
    private int rowNum;

    @Override
    public String toString() {
        return "Page{" +
                "total=" + total +
                ", rows=" + rows +
                ", start=" + start +
                ", rowNum=" + rowNum +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return total == page.total &&
                start == page.start &&
                rowNum == page.rowNum &&
                Objects.equals(rows, page.rows);
    }

    @Override
    public int hashCode() {

        return Objects.hash(total, rows, start, rowNum);
    }

    public int getTotal() {

        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Banner> getRows() {
        return rows;
    }

    public void setRows(List<Banner> rows) {
        this.rows = rows;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public Page() {
    }

    public Page(int total, List<Banner> rows, int start, int rowNum) {

        this.total = total;
        this.rows = rows;
        this.start = start;
        this.rowNum = rowNum;
    }
}
