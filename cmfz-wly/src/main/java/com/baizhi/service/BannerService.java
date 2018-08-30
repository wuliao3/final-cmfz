package com.baizhi.service;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Page;

public interface BannerService {
    void addBanner(Banner banner);

    Page queryAll(int page,int rows);

    int queryAllCount();

    void updateById(Banner banner);

    void deleteById(int id);
}
