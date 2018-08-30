package com.baizhi.service;

import com.baizhi.dao.MenuDao;
import com.baizhi.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> queryAllMenu() {
        List<Menu> menus = menuDao.queryAllMenu();
        return menus;
    }
}
