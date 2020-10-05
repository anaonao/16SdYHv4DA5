package com.tjetc.dao.impl;

import com.tjetc.dao.AdminDao;
import com.tjetc.domain.Admin;
import com.tjetc.util.DBUtil;
import com.tjetc.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin selectNameAndPwd(String name, String Pwd) {
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
    public Page<Admin> selectAll(int pageNum, int pageSize) {
        Page<Admin> page = new Page<>(pageNum, pageSize);
        page.setTotalData(countAll());
        List<Admin> list = new ArrayList<>();
        String sql = "select admin_id,admin_name,admin_pwd,admin_phone,admin_state from admin limit ?,?";
        ResultSet rs = DBUtil.select(sql, page.start(), page.getPageSize());
        try {
            while (rs.next()) {
                Admin admin = new Admin(rs.getInt("admin_id"),
                        rs.getString("admin_name"),
                        rs.getString("admin_pwd"),
                        rs.getString("admin_phone"),
                        rs.getInt("admin_state"));
                //把数据放入集合中
                list.add(admin);
                //把集合数据添加到分页数据中
                page.setData(list);
            }
            return page;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("管理员查询异常。。。");
            return null;
        }finally {
            //关闭所有资源
            DBUtil.close();
        }
    }

    @Override
    public int countAll() {
        String sql = "select count(1) from admin";
        ResultSet rs = DBUtil.select(sql);
        int count = 0;
        try {
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("查询所有管理员数量异常。。。");
            return 0;
        } finally {
            //关闭资源
            DBUtil.close();
        }
    }

    @Override
    public Admin selectByName(String name) {
        return null;
    }

    @Override
    public Admin selectById(Integer id) {
        return null;
    }

    @Override
    public Page<Admin> selectByLikeName(int pageNum, int pageSize, String name) {
        return null;
    }

    @Override
    public int countByLikeName(String name) {
        return 0;
    }

    @Override
    public Page<Admin> selectByState(int pageNum, int pageSize, Integer state) {
        return null;
    }

    @Override
    public int countadminByState(Integer state) {
        return 0;
    }

    @Override
    public Page<Admin> selectByLikePhone(int pageNum, int pageSize, String phone) {
        return null;
    }

    @Override
    public int countByLikePhone(String phone) {
        return 0;
    }
}
