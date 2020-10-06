package com.tjetc.service;

import com.tjetc.dao.UserDao;
import com.tjetc.util.Page;

public interface UserService {
    /**
     * 用户登录
     * @param name
     * @param pwd
     * @return
     */
    UserDao findNameAndPwd(String name, String pwd);

    /**
     * 用户注册
     * @param user
     * @return
     */
    UserDao addUser(UserDao user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    int update(UserDao user);

    /**
     * 查询所有用户信息
     * @return
     */
    Page<UserDao> findPageAll(int pageNum, int pageSize);
    int countAll();

    /**
     * 根据编号查询用户信息
     * @param id
     * @return
     */
    UserDao findById(Integer id);

    /**
     * 根据姓名查询用户
     * @param name
     * @return
     */
    UserDao findByName(String name);

    /**
     * 根据姓名模糊查询
     * @param name
     * @return
     */
    Page<UserDao> findPageLikeName(int pageNum, int pageSize, String name);
    int countLikeName(String name);

    /**
     * 根据手机号模糊查询
     * @param phone
     * @return
     */
    Page<UserDao> findPageLikePhone(int pageNum, int pageSize, String phone);
    int countLikePhone(String phone);

    /**
     * 根据状态查询
     * @param state
     * @return
     */
    Page<UserDao> findPageByState(int pageNum, int pageSize, Integer state);
    int countByState(Integer state);
}
