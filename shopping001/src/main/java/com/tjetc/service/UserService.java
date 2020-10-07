package com.tjetc.service;

import com.tjetc.dao.UserDao;
import com.tjetc.domain.User;
import com.tjetc.util.Page;

public interface UserService {
    /**
     * 用户登录
     * @param name
     * @param pwd
     * @return
     */
    User findNameAndPwd(String name, String pwd);

    /**
     * 用户注册
     * @param user
     * @return
     */
    String addUser(User user);

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
    int update(User user);

    /**
     * 查询所有用户信息
     * @return
     */
    Page<User> findPageAll(int pageNum, int pageSize);

    /**
     * 根据编号查询用户信息
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 根据姓名查询用户
     * @param name
     * @return
     */
    User findByName(String name);

    /**
     * 根据姓名模糊查询
     * @param name
     * @return
     */
    Page<User> findPageLikeName(int pageNum, int pageSize, String name);

    /**
     * 根据手机号模糊查询
     * @param phone
     * @return
     */
    Page<User> findPageLikePhone(int pageNum, int pageSize, String phone);

    /**
     * 根据状态查询
     * @param state
     * @return
     */
    Page<User> findPageByState(int pageNum, int pageSize, Integer state);
}
