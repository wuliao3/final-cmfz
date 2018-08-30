package com.baizhi.controller;

import com.baizhi.entity.Banner;
import com.baizhi.entity.Page;
import com.baizhi.service.BannerService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/addBanner")
    public void addBanner(Banner banner, MultipartFile upload, HttpServletRequest request) {
        try {
            //获取项目的绝对路径
            String realPath = request.getServletContext().getRealPath("/");
            //在项目下创建上传文件夹
            File folderName = new File(realPath + "upload");
            if (!folderName.exists()) {
                folderName.mkdir();
            }
            //获取上传图片的名字
            String originalFilename = upload.getOriginalFilename();
            //获取文件后缀名
            String extension = FilenameUtils.getExtension(originalFilename);
            //组装成新的文件名
            String uuid = UUID.randomUUID().toString();
            String newFileName = uuid + "." + extension;

            //上传图片
            upload.transferTo(new File(folderName, newFileName));
            //将图片路径保存到对象中,添加到数据库
            banner.setPicUrl("/"+"upload/"+newFileName);
            bannerService.addBanner(banner);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/updateById")
    public void updateById(Banner banner){
        try {
            bannerService.updateById(banner);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/deleteById")
    @ResponseBody
    public void deleteById(int id){
        try {
            bannerService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/queryAll")
    @ResponseBody
    public Page queryAll(int page, int rows) {
        try {
            Page p = bannerService.queryAll(page, rows);
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
