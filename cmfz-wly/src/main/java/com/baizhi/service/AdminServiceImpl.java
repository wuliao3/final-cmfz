package com.baizhi.service;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public void login(String username, String password) {
        Admin admin = adminDao.queryByUsername(username);
        if (admin == null) {
            throw new RuntimeException("用户名或密码不正确");
        } else {
            if (!admin.getPassword().equals(password)) {
                throw new RuntimeException("用户名或密码不正确");
            }
        }
    }
}
