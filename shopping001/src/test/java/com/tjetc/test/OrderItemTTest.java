package com.tjetc.test;

import com.tjetc.dao.OrderItemDao;
import com.tjetc.dao.impl.OrderItemDaoImpl;
import com.tjetc.domain.OrderItem;
import org.junit.Test;

public class OrderItemTTest {
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Test
    public void selectPageAll(){
        orderItemDao.selectAll(1,10).getData().forEach(System.out::println);
    }
}
