package com.baizhi.controller;

import com.baizhi.entity.Menu;
import com.baizhi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/queryAllMenu")
    @ResponseBody
    public List<Menu> queryAllMenu() {
        try {
            List<Menu> menus = menuService.queryAllMenu();
            return menus;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
