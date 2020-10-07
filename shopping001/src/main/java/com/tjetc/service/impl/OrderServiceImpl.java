package com.tjetc.service.impl;

import com.tjetc.dao.OrderDao;
import com.tjetc.dao.impl.OrderDaoImpl;
import com.tjetc.domain.Order;
import com.tjetc.service.OrderService;
import com.tjetc.util.Page;

import java.util.Date;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
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
}
