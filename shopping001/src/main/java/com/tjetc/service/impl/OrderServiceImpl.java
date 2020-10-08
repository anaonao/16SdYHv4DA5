package com.tjetc.service.impl;

import com.tjetc.dao.OrderDao;
import com.tjetc.dao.impl.OrderDaoImpl;
import com.tjetc.domain.Cart;
import com.tjetc.domain.Order;
import com.tjetc.service.CartService;
import com.tjetc.service.OrderService;
import com.tjetc.util.DBUtil;
import com.tjetc.util.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private CartService cartService = new CartServiceImpl();
    @Override
    public int add(Order order) {
        if(order!=null){
            Date date = new Date();
            order.setOrderDate(date);
            return orderDao.add(order);
        }
        return 0;
    }

    @Override
    public Page<Order> findAll(int pageNum, int pageSize) {
        return orderDao.selectAll(pageNum,pageSize);
    }

    @Override
    public Order findById(String id) {
        return orderDao.selectById(id);
    }

    @Override
    public Page<Order> findLikeDate(int pageNum, int pageSize, Date startDate, Date endStart) {
        return orderDao.selectLikeDate(pageNum,pageSize,startDate,endStart);
    }

    @Override
    public Page<Order> findByUserName(int pageNum, int pageSize, String userName) {
        return orderDao.selectByUserName(pageNum,pageSize,userName);
    }

    @Override
    public int addOrders(String[] id,Double price,int userId) {
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        String sql="";
        try {
            //开启事务
            conn.setAutoCommit(false);
            //订单唯一编号
            String uuid= UUID.randomUUID().toString();

            System.out.println("UUID"+uuid);


            Integer n1=null;
            Integer n2=null;
            Integer n3=null;

            //添加订单信息
            sql ="insert into orders(order_id,order_date,order_price,order_state,user_id) values(?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            //信息
            pstmt.setString(1,uuid);
            pstmt.setObject(2,new Date());
            pstmt.setDouble(3,price);
            pstmt.setInt(4,0);
            pstmt.setInt(5,userId);
            n2 = pstmt.executeUpdate();
            System.out.println("添加订单："+n2);

            //先把购物车中选中的商品添加到订单详情中
            sql = "insert into order_item(order_id,product_id,product_count) values(?,?,?)";
            Cart cartByid=null;
            for (int i = 0; i <id.length ; i++) {
                cartByid = cartService.findById(Integer.parseInt(id[i]));
                pstmt = conn.prepareStatement(sql);
                //信息添加到
                pstmt.setString(1,uuid);
                pstmt.setInt(2,cartByid.getProduct().getProductId());
                pstmt.setInt(3,cartByid.getProductsCount());
                n1= pstmt.executeUpdate();
            }
            System.out.println("添加到订单详情："+n1);


            //删除购物车结算的商品
            sql = "delete from cart where cart_id in (?";
            StringBuffer sqlbuf = new StringBuffer(sql);
            //拼接sqlbuf，两种情况
            if (id.length == 1) {
                //有1条时， 直接加 "）"结束
                sqlbuf.append(")");
            }else{
                //有多条时候，拼接length-1 次，因为初始sql语句已经有一次了。"delete  from `user` where u_id in (? "
                for (int i = 0; i < id.length-1; i++) {
                    sqlbuf.append(",?");

                }
                //最后拼接" )"  圆满完成拼接sql
                sqlbuf.append(")");
            }
            System.out.println(sqlbuf.toString());
            pstmt = conn.prepareStatement(sqlbuf.toString());
            if (id.length == 1) {
                pstmt.setString(1, id[0]);
            }else{
                for (int i = 1; i <= id.length; i++) {
                    pstmt.setString(i, id[i-1]);
                    //userids[i-1] 因为数据下标从0 开始。
                }
            }
            n3 =pstmt.executeUpdate();
            System.out.println("删除购物车下单数据："+n3);

            if(n1!=null&&n2!=null&&n3!=null){
                if(n1>0&&n2>0&&n3>0){
                    //成功提交事务
                    conn.commit();
                    return 1;
                }else {
                    return 0;
                }
            }else {
                return 0;
            }








        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("回滚！！！");
        }
        return 0;
    }

    @Override
    public int update(Order order) {
        if(order!=null){
            return orderDao.update(order);
        }
        return 0;
    }
}
