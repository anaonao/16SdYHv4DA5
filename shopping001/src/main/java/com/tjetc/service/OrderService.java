package com.tjetc.service;

import com.tjetc.domain.Order;
import com.tjetc.util.Page;

import java.util.Date;

public interface OrderService {
    /**
     * 添加订单信息
     * @param order
     * @return
     */
    int add(Order order);

    /**
     * 根据编号修改订单信息
     * @param order
     * @return
     */
    int update(Order order);
    /**
     * 查询订单信息
     * @return
     */
    Page<Order> findAll(int pageNum, int pageSize);

    /**
     * 根据编号查询订单信息
     * @param id
     * @return
     */
    Order findById(String id);

    /**
     * 根据时间范围查询
     * @param startDate
     * @param endStart
     * @return
     */
    Page<Order> findLikeDate(int pageNum, int pageSize,Date startDate, Date endStart);

    /**
     * 根据用户名查询
     * @param userName
     * @return
     */
    Page<Order> findByUserName(int pageNum, int pageSize,String userName);

    int addOrders(String[] id,Double price,int userId);
}
