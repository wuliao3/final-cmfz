package com.baizhi.service;

import com.baizhi.dao.BannerDao;
import com.baizhi.entity.Banner;
import com.baizhi.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;

    @Override
    public void addBanner(Banner banner) {
        //创建轮播图添加时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
        String format = sdf.format(new Date());
        banner.setCreateTime(format);
        bannerDao.addBanner(banner);
    }

    @Override
    public Page queryAll(int page,int rows) {
        Page p = new Page();
        //设置起始页
        p.setStart((page-1)*rows);
        //设置结束页（显示几行）
        p.setRowNum(rows);
        //设置总记录数
        p.setTotal(this.queryAllCount());
        //设置轮播集合
        p.setRows(bannerDao.queryAll(p));
        return p;
    }

    @Override
    public int queryAllCount() {
        int count = bannerDao.queryAllCount();
        return count;
    }

    @Override
    public void updateById(Banner banner) {
        bannerDao.updateById(banner);
    }

    @Override
    public void deleteById(int id) {
        bannerDao.deleteById(id);
    }
}
