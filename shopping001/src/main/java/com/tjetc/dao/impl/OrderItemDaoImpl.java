package com.tjetc.dao.impl;

import com.tjetc.dao.OrderItemDao;
import com.tjetc.domain.Order;
import com.tjetc.domain.OrderItem;
import com.tjetc.domain.Product;
import com.tjetc.util.DBUtil;
import com.tjetc.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDaoImpl implements OrderItemDao {
    @Override
    public int add(OrderItem orderItem) {
        String sql = "insert into order_item(order_id,product_id,product_count) values(?,?,?)";
        int n = DBUtil.addDeleteUpdate(sql,orderItem.getOrder().getOrderid(), orderItem.getProduct().getProductId(), orderItem.getProductCount());
        return n;
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from order_item where orderitem_id=?";
        int n = DBUtil.addDeleteUpdate(sql, id);
        return n;
    }

    @Override
    public int update(OrderItem orderItem) {
        String sql = "update order_item set order_id=?,product_id=?,product_count=? where orderitem_id=?";
        int n = DBUtil.addDeleteUpdate(sql, orderItem.getOrder().getOrderid(), orderItem.getProduct().getProductId(), orderItem.getProductCount(), orderItem.getOrderitemId());
        return n;
    }

    @Override
    public Page<OrderItem> selectAll(int pageNum, int pageSize) {
        Page<OrderItem> page = new Page<>();
        page.setTotalData(countAll());
        List<OrderItem> list= new ArrayList<>();
        String sql = "select orderitem_id,order_id,product_id,product_count from order_item limit ?,?";
        ResultSet rs = DBUtil.select(sql, page.start(), page.getPageSize());
        try {
            while (rs.next()){
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderitemId(rs.getInt("orderitem_id"));

                Order order = new Order();
                order.setOrderid(rs.getString("order_id"));
                orderItem.setOrder(order);

                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                orderItem.setProduct(product);
                orderItem.setProductCount(rs.getInt("product_count"));
                list.add(orderItem);
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
        String sql = "select count(1) from order_item";
        ResultSet rs = DBUtil.select(sql);
        int n = 0;
        try {
            if(rs.next()){
                n = rs.getInt(1);
            }
            return n;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
        finally {
            DBUtil.close();
        }

    }
}
