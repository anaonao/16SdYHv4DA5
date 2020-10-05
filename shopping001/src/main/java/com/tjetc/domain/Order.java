package com.tjetc.domain;

import java.util.Date;
import java.util.List;

public class Order {
    private String orderid;//生成唯一
    private User user;
    private Date orderDate;//下单时间
    private Double order_price;//总价格
    private int state;//订单状态（0：待发货，1：已发货，2：已收货，3：退货）
    private List<OrderItem> list;

    public Order() {
    }

    public Order(String orderid, User user, Date orderDate, Double order_price, int state, List<OrderItem> list) {
        this.orderid = orderid;
        this.user = user;
        this.orderDate = orderDate;
        this.order_price = order_price;
        this.state = state;
        this.list = list;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrder_price() {
        return order_price;
    }

    public void setOrder_price(Double order_price) {
        this.order_price = order_price;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<OrderItem> getList() {
        return list;
    }

    public void setList(List<OrderItem> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderid='" + orderid + '\'' +
                ", user=" + user +
                ", orderDate=" + orderDate +
                ", order_price=" + order_price +
                ", state=" + state +
                ", list=" + list +
                '}';
    }
}
