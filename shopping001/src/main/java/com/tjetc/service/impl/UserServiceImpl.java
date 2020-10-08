package com.tjetc.service.impl;

import com.tjetc.dao.UserDao;
import com.tjetc.dao.impl.UserDaoImpl;
import com.tjetc.domain.User;
import com.tjetc.service.UserService;
import com.tjetc.util.MD5Utils;
import com.tjetc.util.Page;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User findNameAndPwd(String name, String pwd) {
        String pwd1 = MD5Utils.stringToMD5(pwd);
        return userDao.selectNameAndPwd(name, pwd1);
    }

    @Override
    public String addUser(User user) {
        if (user != null) {
            User user1 = userDao.selectByName(user.getUserName());
            if (user1 != null) {
                return "用户名重复！！！";
            } else {
                user.setUserPwd(MD5Utils.stringToMD5(user.getUserPwd()));
                user.setUserStates(1);
                int n = userDao.addUser(user);
                if (n > 0) {
                    return "添加成功";
                } else {
                    return "添加失败！";
                }
            }
        } else {
            return "用户信息为空";
        }
    }

    @Override
    public int deleteById(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    public int update(User user) {
        if (user != null) {
            return userDao.update(user);
        }
        return 0;
    }

    @Override
    public int updateImg(String userImg, int userId) {

        return userDao.updateImg(userImg,userId);
    }

    @Override
    public Page<User> findPageAll(int pageNum, int pageSize) {
        return userDao.selectPageAll(pageNum, pageSize);
    }

    @Override
    public User findById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public User findByName(String name) {
        return userDao.selectByName(name);
    }

    @Override
    public Page<User> findPageLikeName(int pageNum, int pageSize, String name) {
        return userDao.selectPageLikeName(pageNum, pageSize, name);
    }

    @Override
    public Page<User> findPageLikePhone(int pageNum, int pageSize, String phone) {
        return userDao.selectPageLikePhone(pageNum, pageSize, phone);
    }

    @Override
    public Page<User> findPageByState(int pageNum, int pageSize, Integer state) {
        return userDao.selectPageByState(pageNum, pageSize, state);
    }

    @Override
    public int updateUserByIdPwd(Integer id, String pwd) {
        return userDao.updateUserByIdPwd(id,MD5Utils.stringToMD5(pwd));
    }
}
