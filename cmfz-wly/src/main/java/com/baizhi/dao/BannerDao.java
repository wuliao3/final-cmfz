package com.baizhi.dao;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Page;

import java.util.List;

public interface BannerDao {
    void addBanner(Banner banner);

    List<Banner> queryAll(Page page);

    int queryAllCount();

    void updateById(Banner banner);

    void deleteById(int id);
}
