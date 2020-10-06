package com.tjetc.service.impl;

import com.tjetc.dao.OrderItemDao;
import com.tjetc.domain.OrderItem;
import com.tjetc.service.OrderItemService;
import com.tjetc.util.Page;

public class OrderItemServiceImpl implements OrderItemService {
    @Override
    public int add(OrderItem orderItem) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public int update(OrderItem orderItem) {
        return 0;
    }

    @Override
    public Page<OrderItemDao> findAll(int pageNum, int pageSize) {
        return null;
    }
}
