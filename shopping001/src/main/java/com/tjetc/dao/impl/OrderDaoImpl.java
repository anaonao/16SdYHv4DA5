package com.tjetc.dao.impl;

import com.tjetc.dao.OrderDao;
import com.tjetc.domain.Order;
import com.tjetc.domain.User;
import com.tjetc.util.DBUtil;
import com.tjetc.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public int add(Order order) {
        String sql = "insert into orders(order_id,order_date,order_price,order_state,user_id) values(?,?,?,?,?)";
        int n = DBUtil.addDeleteUpdate(sql, order.getOrderid(), order.getOrderDate(), order.getOrder_price(), order.getState(), order.getUser().getUserId());
        return n;
    }

    @Override
    public Page<Order> selectAll(int pageNum, int pageSize) {
        Page<Order> page = new Page<>(pageNum,pageSize);
        page.setTotalData(countAll());
        List<Order> list = new ArrayList<>();
        String sql = "select order_id,order_date,order_price,order_state,user_id from orders limit ?,?";
        ResultSet rs = DBUtil.select(sql, page.start(), page.getPageSize());
        try {
            while (rs.next()){
                Order order = new Order();
                order.setOrderid(rs.getString("order_id"));
                order.setOrderDate(rs.getDate("order_date"));
                order.setOrder_price(rs.getDouble("order_price"));
                order.setState(rs.getInt("order_state"));

                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                order.setUser(user);
                list.add(order);
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
        String sql = "select count(1) from orders";
        ResultSet rs = DBUtil.select(sql);
        int n = 0;
        try {
            if(rs.next()){
                n=rs.getInt(1);
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
    public Order selectById(String id) {
        String sql = "select order_id,order_date,order_price,order_state,user_id from orders where order_id=?";
        ResultSet rs = DBUtil.select(sql,id);
        Order order =null;
        try {
           if (rs.next()){
                order = new Order();
                order.setOrderid(rs.getString("order_id"));
                order.setOrderDate(rs.getDate("order_date"));
                order.setOrder_price(rs.getDouble("order_price"));
                order.setState(rs.getInt("order_state"));

                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                order.setUser(user);
            }
            return order;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public Page<Order> selectLikeDate(int pageNum, int pageSize, Date startDate, Date endStart) {
        return null;
    }

    @Override
    public int countLikeDate(Date startDate, Date endStart) {
        return 0;
    }

    @Override
    public Page<Order> selectByUserName(int pageNum, int pageSize, String userName) {
        return null;
    }

    @Override
    public int countByUserName(String userName) {
        return 0;
    }
}
