package com.tjetc.dao.impl;

import com.tjetc.dao.UserDao;
import com.tjetc.domain.User;
import com.tjetc.util.DBUtil;
import com.tjetc.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public User selectNameAndPwd(String name, String pwd) {
        String sql = "select user_id,user_name,user_pwd,user_phone,user_states,user_image from user where user_name=? and user_pwd=?";
        ResultSet rs = DBUtil.select(sql, name, pwd);
        User user=null;
        try {
            if(rs.next()){
             user=new User();
             user.setUserId(rs.getInt("user_id"));
             user.setUserName(rs.getString("user_name"));
             user.setUserPwd(rs.getString("user_pwd"));
             user.setUserIphone(rs.getString("user_phone"));
             user.setUserStates(rs.getInt("user_states"));
             user.setUserImg(rs.getString("user_image"));
            }
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }

    }

    @Override
    public int addUser(User user) {
        String sql = "insert into user(user_name,user_pwd,user_phone,user_states,user_image) values(?,?,?,?,?)";
        int n = DBUtil.addDeleteUpdate(sql,user.getUserName(),user.getUserPwd(),user.getUserIphone(),user.getUserStates(),user.getUserImg());
        return n;
    }

    @Override
    public int deleteById(Integer id) {
        String sql = "delete from user where user_id=?";
        int n = DBUtil.addDeleteUpdate(sql, id);
        return n;
    }

    @Override
    public int update(User user) {
        String sql = "update user set user_name=?,user_phone=?,user_states=?,user_image=? where user_id=?";
        int n = DBUtil.addDeleteUpdate(sql,user.getUserName(),user.getUserIphone(),user.getUserStates(),user.getUserImg(),user.getUserId());
        return n;
    }

    @Override
    public int updateImg(String userImg,int userId) {
        String sql = "update user set user_image=? where user_id=?";
        int n = DBUtil.addDeleteUpdate(sql,userImg,userId);
        return n;
    }

    @Override
    public Page<User> selectPageAll(int pageNum, int pageSize) {
        Page<User> page = new Page<>(pageNum,pageSize);
        page.setTotalData(countAll());
        List<User> list = new ArrayList<>();
        String sql = "select user_id,user_name,user_pwd,user_phone,user_states,user_image from user limit ?,?";
        ResultSet rs = DBUtil.select(sql, page.start(), page.getPageSize());
        try {
            while (rs.next()){
                User user= new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPwd(rs.getString("user_pwd"));
                user.setUserIphone(rs.getString("user_phone"));
                user.setUserStates(rs.getInt("user_states"));
                user.setUserImg(rs.getString("user_image"));
                list.add(user);
                page.setData(list);
            }
            return page;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }

    }

    @Override
    public int countAll() {
        String sql = "select count(1) from user";
        ResultSet rs = DBUtil.select(sql);
        int n = 0;
        try {
            if(rs.next()){
                n= rs.getInt(1);
            }
            return n;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }finally {
            DBUtil.close();
        }

    }

    @Override
    public User selectById(Integer id) {
        User user= null;
        String sql = "select user_id,user_name,user_pwd,user_phone,user_states,user_image from user where user_id=?";
        ResultSet rs = DBUtil.select(sql,id);
        try {
            while (rs.next()){
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPwd(rs.getString("user_pwd"));
                user.setUserIphone(rs.getString("user_phone"));
                user.setUserStates(rs.getInt("user_states"));
                user.setUserImg(rs.getString("user_image"));
            }
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public User selectByName(String name) {
        User user= null;
        String sql = "select user_id,user_name,user_pwd,user_phone,user_states,user_image from user where user_name=?";
        ResultSet rs = DBUtil.select(sql,name);
        try {
            while (rs.next()){
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPwd(rs.getString("user_pwd"));
                user.setUserIphone(rs.getString("user_phone"));
                user.setUserStates(rs.getInt("user_states"));
                user.setUserImg(rs.getString("user_image"));
            }
            return user;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public Page<User> selectPageLikeName(int pageNum, int pageSize, String name) {
        Page<User> page = new Page<>(pageNum,pageSize);
        page.setTotalData(countLikeName(name));
        List<User> list = new ArrayList<>();
        String sql = "select user_id,user_name,user_pwd,user_phone,user_states,user_image from user where user_name like ? limit ?,?";
        ResultSet rs = DBUtil.select(sql,name,page.start(), page.getPageSize());
        try {
            while (rs.next()){
                User user= new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPwd(rs.getString("user_pwd"));
                user.setUserIphone(rs.getString("user_phone"));
                user.setUserStates(rs.getInt("user_states"));
                user.setUserImg(rs.getString("user_image"));
                list.add(user);
                page.setData(list);
            }
            return page;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public int countLikeName(String name) {
        String sql = "select count(1) from user where user_name like ?";
        ResultSet rs = DBUtil.select(sql,"%"+name+"%");
        int n = 0;
        try {
            if(rs.next()){
                n= rs.getInt(1);
            }
            return n;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public Page<User> selectPageLikePhone(int pageNum, int pageSize, String phone) {
        Page<User> page = new Page<>(pageNum,pageSize);
        page.setTotalData(countLikePhone(phone));
        List<User> list = new ArrayList<>();
        String sql = "select user_id,user_name,user_pwd,user_phone,user_states,user_image from user where user_phone like ? limit ?,?";
        ResultSet rs = DBUtil.select(sql,phone,page.start(), page.getPageSize());
        try {
            while (rs.next()){
                User user= new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPwd(rs.getString("user_pwd"));
                user.setUserIphone(rs.getString("user_phone"));
                user.setUserStates(rs.getInt("user_states"));
                user.setUserImg(rs.getString("user_image"));
                list.add(user);
                page.setData(list);
            }
            return page;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public int countLikePhone(String phone) {
        String sql = "select count(1) from user where user_phone like ?";
        ResultSet rs = DBUtil.select(sql,"%"+phone+"%");
        int n = 0;
        try {
            if(rs.next()){
                n= rs.getInt(1);
            }
            return n;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public Page<User> selectPageByState(int pageNum, int pageSize, Integer state) {
        Page<User> page = new Page<>(pageNum,pageSize);
        page.setTotalData(countByState(state));
        List<User> list = new ArrayList<>();
        String sql = "select user_id,user_name,user_pwd,user_phone,user_states,user_image from user where user_states=? limit ?,?";
        ResultSet rs = DBUtil.select(sql,state,page.start(), page.getPageSize());
        try {
            while (rs.next()){
                User user= new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setUserPwd(rs.getString("user_pwd"));
                user.setUserIphone(rs.getString("user_phone"));
                user.setUserStates(rs.getInt("user_states"));
                user.setUserImg(rs.getString("user_image"));
                list.add(user);
                page.setData(list);
            }
            return page;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public int countByState(Integer state) {
        String sql = "select count(1) from user where user_states=?";
        ResultSet rs = DBUtil.select(sql,state);
        int n = 0;
        try {
            if(rs.next()){
                n= rs.getInt(1);
            }
            return n;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public int updateUserByIdPwd(Integer id, String pwd) {
        String sql = "update user set user_pwd=? where user_id=?";
        int n = DBUtil.addDeleteUpdate(sql,pwd,id);
        return n;
    }
}
