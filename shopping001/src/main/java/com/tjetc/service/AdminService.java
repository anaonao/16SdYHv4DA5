package com.tjetc.service;

import com.tjetc.domain.Admin;
import com.tjetc.util.Page;

public interface AdminService {
    /**
     * 管理员登录
     * @param name
     * @param Pwd
     * @return
     */
    Admin findNameAndPwd(String name,String pwd);

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    String addAdmin(Admin admin);

    /**
     * 删除管理员
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 修改管理员
     * @param admin
     * @return
     */
    int update(Admin admin);
    //查询都是分页

    /**
     * 查询所有管理员
     * @return
     */
    Page<Admin> findAll(int pageNum, int pageSize);

    /**
     * 根据名称查询
     * @param name
     * @return
     */
    Admin findByName(String name);

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    Admin findById(Integer id);

    /**
     * 根据名称模糊查询
     * @param name
     * @return
     */
    Page<Admin> findByLikeName(int pageNum, int pageSize,String name);

    /**
     * 根据状态查询
     * @param state
     * @return
     */
    Page<Admin> findByState(int pageNum, int pageSize,Integer state);

    /**
     * 根据手机号模糊查询
     * @param phone
     * @return
     */
    Page<Admin> findByLikePhone(int pageNum, int pageSize,String phone);
}
