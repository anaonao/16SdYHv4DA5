package com.tjetc.test;

import com.tjetc.domain.Order;
import com.tjetc.domain.User;
import com.tjetc.service.OrderService;
import com.tjetc.service.impl.OrderServiceImpl;
import org.junit.Test;

public class OrderServiceSubmitTest {
    private OrderService orderService = new OrderServiceImpl();

    @Test
    public void add(){
        String[] id ={"34"};
        Order order = new Order();
        order.setOrder_price(1000.00);
        User user = new User();
        user.setUserId(1);
        order.setUser(user);
        int n =orderService.addOrders(id,123456.00,1);
    }
}
