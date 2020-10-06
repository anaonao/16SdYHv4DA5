package com.tjetc.test;

import com.tjetc.dao.AdminDao;
import com.tjetc.dao.impl.AdminDaoImpl;
import com.tjetc.domain.Admin;
import com.tjetc.service.AdminService;
import com.tjetc.service.impl.AdminServiceImpl;
import org.junit.Test;

public class AdminTest {
    private AdminDao adminDao = new AdminDaoImpl();
    private AdminService adminService = new AdminServiceImpl();
    @Test
    public void loginAdminDao(){
        System.out.println(adminDao.selectNameAndPwd("yanan","1"));
    }
    @Test
    public void selectAll(){
        adminDao.selectAll(1,10).getData().forEach(System.out::println);
    }
    //service管理员注册
    @Test
    public void addAdmin(){
        Admin admin = new Admin();
        admin.setAdminName("1");
        admin.setAdminPwd("123");
        admin.setAdminPhone("1");

        System.out.println(adminService.addAdmin(admin));
    }
    @Test
    public void selectByNameDao(){
        System.out.println(adminDao.selectByName("1"));
    }
}
