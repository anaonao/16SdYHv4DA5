package com.tjetc.dao;

import com.tjetc.util.Page;

public interface User {

    /**
     * 用户登录
     * @param name
     * @param pwd
     * @return
     */
    User selectNameAndPwd(String name,String pwd);

    /**
     * 用户注册
     * @param user
     * @return
     */
    User addUser(User user);

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
    Page<User> selectPageAll(int pageNum, int pageSize);
    int countAll();

    /**
     * 根据编号查询用户信息
     * @param id
     * @return
     */
    User selectById(Integer id);

    /**
     * 根据姓名查询用户
     * @param name
     * @return
     */
    User selectByName(String name);

    /**
     * 根据姓名模糊查询
     * @param name
     * @return
     */
    Page<User> selectPageLikeName(int pageNum, int pageSize,String name);
    int countLikeName(String name);

    /**
     * 根据手机号模糊查询
     * @param phone
     * @return
     */
    Page<User> selectPageLikePhone(int pageNum, int pageSize,String phone);
    int countLikePhone(String phone);

    /**
     * 根据状态查询
     * @param state
     * @return
     */
    Page<User> selectPageByState(int pageNum, int pageSize,Integer state);
    int countByState(Integer state);
}
