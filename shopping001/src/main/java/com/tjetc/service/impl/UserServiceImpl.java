package com.tjetc.service.impl;

import com.tjetc.dao.UserDao;
import com.tjetc.dao.impl.UserDaoImpl;
import com.tjetc.domain.User;
import com.tjetc.service.UserService;
import com.tjetc.util.Page;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoImpl();
    }

    //登录
    @Override
    public User findNameAndPwd(String name, String pwd) {
        return this.userDao.selectNameAndPwd(name,pwd);
    }
    //注册
    @Override
    public boolean addUser(User user) {
        //用户名重复
        if(this.userDao.selectByName(user.getUserName())!=null){
            return false;
            //数据库添加失败
        }else if(this.userDao.addUser(user)<0){
            return false;
        }
        return true;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }

    @Override
    public int update(UserDao user) {
        return 0;
    }

    @Override
    public Page<UserDao> findPageAll(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public int countAll() {
        return 0;
    }

    @Override
    public UserDao findById(Integer id) {
        return null;
    }

    @Override
    public UserDao findByName(String name) {
        return null;
    }

    @Override
    public Page<UserDao> findPageLikeName(int pageNum, int pageSize, String name) {
        return null;
    }

    @Override
    public int countLikeName(String name) {
        return 0;
    }

    @Override
    public Page<UserDao> findPageLikePhone(int pageNum, int pageSize, String phone) {
        return null;
    }

    @Override
    public int countLikePhone(String phone) {
        return 0;
    }

    @Override
    public Page<UserDao> findPageByState(int pageNum, int pageSize, Integer state) {
        return null;
    }

    @Override
    public int countByState(Integer state) {
        return 0;
    }
}
