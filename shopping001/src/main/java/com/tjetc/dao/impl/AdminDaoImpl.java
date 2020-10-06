package com.tjetc.dao.impl;

import com.tjetc.dao.AdminDao;
import com.tjetc.domain.Admin;
import com.tjetc.util.DBUtil;
import com.tjetc.util.Page;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin selectNameAndPwd(String name, String Pwd) {
        String sql = "select * from admin where admin_name=? and admin_pwd=?";

        ResultSet rs =DBUtil.select(sql,name,Pwd);
        Admin admin=null;
        try {
            if (rs.next()){
                int id = rs.getInt("admin_Id");
                String names = rs.getString("admin_name");
                String pwd = rs.getString("admin_Pwd");
                String phone = rs.getString("admin_phone");
                int state = rs.getInt("admin_state");
                admin = new Admin(id,names,pwd,phone,state);
               /* if (names.equals(rs.getString("admin_name")) && pwd.equals(rs.getString("admin_Pwd"))){
                }*/

            }
            return admin;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }

    }

    @Override
    public int addAdmin(Admin admin) {
        String sql = "insert into admin values(?,?,?,?,?)";
        PreparedStatement pstmt =null;
        int n = DBUtil.addDeleteUpdate(sql,admin.getAdminId(),admin.getAdminName(),admin.getAdminPwd(),admin.getAdminPhone(),admin.getAdminState());
        return n;
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "delete from admin where admin_id=?";
        int n = DBUtil.addDeleteUpdate(sql,id);
        return n;
    }

    @Override
    public int update(Admin admin) {
        String sql = "update admin set admin_name=?,admin_pwd=?,admin_phone=?,admin_state=? where admin_id=?";
        int n = DBUtil.addDeleteUpdate(sql,admin.getAdminName(),admin.getAdminPwd(),admin.getAdminPhone(),admin.getAdminState(),admin.getAdminId());
        return n;
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
        String sql ="select * from admin where admin_name=?";
        ResultSet rs =DBUtil.select(sql,name);
        Admin admin = new Admin();
        try {
            if (rs.next()){
                new Admin(rs.getInt("admin_Id"),
                        rs.getString("admin_name"),
                        rs.getString("admin_Pwd"),
                        rs.getString("admin_phone"),
                        rs.getInt("admin_state"));
            }
            return admin;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public Admin selectById(Integer id) {
        String sql ="select * from admin where admin_Id=?";
        ResultSet rs =DBUtil.select(sql,id);
        Admin admin = new Admin();
        try {
            if (rs.next()){
                new Admin(rs.getInt("admin_Id"),
                        rs.getString("admin_name"),
                        rs.getString("admin_Pwd"),
                        rs.getString("admin_phone"),
                        rs.getInt("admin_state"));
            }
            return admin;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public Page<Admin> selectByLikeName(int pageNum, int pageSize, String name) {
        Page<Admin> page = new Page<>(pageNum, pageSize);
        page.setTotalData(countByLikeName(name));
        List<Admin> list = new ArrayList<>();
        String sql = "select admin_id,admin_name,admin_pwd,admin_phone,admin_state from admin limit ?,? where name like ?";
        ResultSet rs = DBUtil.select(sql, page.start(), page.getPageSize(),"%"+name+"%");
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
    public int countByLikeName(String name) {
        String sql = "select count(1) from admin where name like ?";
        ResultSet rs = DBUtil.select(sql,"%"+name+"%");
        int count = 0;
        try {
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("根据姓名模糊查询所有管理员数量异常。。。");
            return 0;
        } finally {
            //关闭资源
            DBUtil.close();
        }
    }

    @Override
    public Page<Admin> selectByState(int pageNum, int pageSize, Integer state) {
        Page<Admin> page = new Page<>(pageNum, pageSize);
        page.setTotalData(countadminByState(state));
        List<Admin> list = new ArrayList<>();
        String sql = "select admin_id,admin_name,admin_pwd,admin_phone,admin_state from admin where admin_state=? limit ?,? ";
        ResultSet rs = DBUtil.select(sql, state,page.start(), page.getPageSize());
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
    public int countadminByState(Integer state) {
        String sql = "select count(1) from admin where state=?";
        ResultSet rs = DBUtil.select(sql,state);
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
    public Page<Admin> selectByLikePhone(int pageNum, int pageSize, String phone) {
        Page<Admin> page = new Page<>(pageNum, pageSize);
        page.setTotalData(countByLikePhone(phone));
        List<Admin> list = new ArrayList<>();
        String sql = "select admin_id,admin_name,admin_pwd,admin_phone,admin_state from admin where admin_phone like ? limit ?,?";
        ResultSet rs = DBUtil.select(sql, "%"+phone+"%",page.start(), page.getPageSize(),phone);
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
    public int countByLikePhone(String phone) {
        String sql = "select count(1) from admin where admin_phone like ?";
        ResultSet rs = DBUtil.select(sql,"%"+phone+"%");
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
}
