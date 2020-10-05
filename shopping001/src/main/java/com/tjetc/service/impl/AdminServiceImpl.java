package com.tjetc.service.impl;

import com.tjetc.dao.AdminDao;
import com.tjetc.dao.impl.AdminDaoImpl;
import com.tjetc.domain.Admin;
import com.tjetc.service.AdminService;
import com.tjetc.util.Page;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();

    @Override
    public Admin findNameAndPwd(String name, String Pwd) {
        return null;
    }

    @Override
    public int addAdmin(Admin admin) {
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public int update(Admin admin) {
        return 0;
    }

    @Override
    public Page<Admin> findAll(int pageNum, int pageSize) {
        return adminDao.selectAll(pageNum,pageSize);
    }

    @Override
    public Admin findByName(String name) {
        return null;
    }

    @Override
    public Admin findById(Integer id) {
        return null;
    }

    @Override
    public Page<Admin> findByLikeName(int pageNum, int pageSize, String name) {
        return null;
    }

    @Override
    public Page<Admin> findByState(int pageNum, int pageSize, Integer state) {
        return null;
    }

    @Override
    public Page<Admin> findByLikePhone(int pageNum, int pageSize, String phone) {
        return null;
    }
}
