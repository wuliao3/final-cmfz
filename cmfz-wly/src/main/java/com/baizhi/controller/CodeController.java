package com.baizhi.controller;

import com.baizhi.util.SecurityCode;
import com.baizhi.util.SecurityImage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

@Controller
public class CodeController {
    @RequestMapping("/createCode")
    public void createCode(HttpSession session, HttpServletResponse response){
        //生成验证码
        String code = SecurityCode.getSecurityCode();
        //存到session中
        session.setAttribute("code",code);

        //生成图片
        BufferedImage image = SecurityImage.createImage(code);

        //利用ImageIOP将图片以输出流的方式打印到页面上
        try {
            ImageIO.write(image, "jpg", response.getOutputStream());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
