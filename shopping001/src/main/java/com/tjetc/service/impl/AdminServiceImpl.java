package com.tjetc.service.impl;

import com.tjetc.dao.AdminDao;
import com.tjetc.dao.impl.AdminDaoImpl;
import com.tjetc.domain.Admin;
import com.tjetc.service.AdminService;
import com.tjetc.util.Page;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public Admin findNameAndPwd(String name, String pwd) {
        return adminDao.selectNameAndPwd(name,pwd);
    }

    @Override
    public String addAdmin(Admin admin) {
        if(admin!=null){
            Admin admin1 = adminDao.selectByName(admin.getAdminName());
            if(admin1!=null){
                return "用户名存在";
            }
            //默认管理员状态为1启动
            admin.setAdminState(1);
            int i = adminDao.addAdmin(admin);
            if(i>0){
                return "管理员注册成功";
            }
        }
        return null;
    }

    @Override
    public int deleteById(Integer id) {
        return adminDao.deleteById(id);
    }

    @Override
    public int update(Admin admin) {
        if(admin!=null){
            return adminDao.update(admin);
        }
        return 0;
    }

    @Override
    public Page<Admin> findAll(int pageNum, int pageSize) {
        return adminDao.selectAll(pageNum,pageSize);
    }

    @Override
    public Admin findByName(String name) {
        if(name!=null) {
            return adminDao.selectByName(name);
        }
        return null;
    }

    @Override
    public Admin findById(Integer id) {
        if(id!=null){
            return adminDao.selectById(id);
        }
        return null;
    }

    @Override
    public Page<Admin> findByLikeName(int pageNum, int pageSize, String name) {
        if(name!=null){
            return adminDao.selectByLikeName(pageNum,pageSize,name);
        }
        return null;
    }

    @Override
    public Page<Admin> findByState(int pageNum, int pageSize, Integer state) {
        if(state!=null){
            return adminDao.selectByState(pageNum,pageSize,state);
        }
        return null;
    }

    @Override
    public Page<Admin> findByLikePhone(int pageNum, int pageSize, String phone) {
        if(phone!=null){
            return adminDao.selectByLikePhone(pageNum,pageSize,phone);
        }
        return null;
    }
}
