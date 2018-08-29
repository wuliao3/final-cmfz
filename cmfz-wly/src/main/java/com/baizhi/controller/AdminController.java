package com.baizhi.controller;

import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public ModelAndView login(String username,String password,String enCode,HttpSession session){
        ModelAndView mv = new ModelAndView();
        try {
            //获取session中的code
            String SessionCode = (String) session.getAttribute("code");
            if(!SessionCode.equals(enCode)){
                throw new RuntimeException("验证码不正确");
            }
            adminService.login(username,password);
            mv.setView(new RedirectView("/cmfz/main/main.jsp"));
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
