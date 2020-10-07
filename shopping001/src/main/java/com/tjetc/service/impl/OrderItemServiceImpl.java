package com.tjetc.service.impl;

import com.tjetc.dao.OrderItemDao;
import com.tjetc.dao.impl.OrderItemDaoImpl;
import com.tjetc.domain.OrderItem;
import com.tjetc.service.OrderItemService;
import com.tjetc.util.Page;

public class OrderItemServiceImpl implements OrderItemService {
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Override
    public int add(OrderItem orderItem) {
        if(orderItem!=null){
            return orderItemDao.add(orderItem);
        }
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return orderItemDao.delete(id);
    }

    @Override
    public int update(OrderItem orderItem) {
        if(orderItem!=null){
            return orderItemDao.update(orderItem);
        }
        return 0;
    }

    @Override
    public Page<OrderItem> findAll(int pageNum, int pageSize) {
        return orderItemDao.selectAll(pageNum,pageSize);
    }
}
