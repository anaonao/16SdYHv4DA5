package com.tjetc.domain;

public class
OrderItem {
    private int orderitemId;
    private Order order;
    private Product product;
    private int productCount;

    public OrderItem() {
    }

    public OrderItem(int orderitemId, Order order, Product product, int productCount) {
        this.orderitemId = orderitemId;
        this.order = order;
        this.product = product;
        this.productCount = productCount;
    }

    public int getOrderitemId() {
        return orderitemId;
    }

    public void setOrderitemId(int orderitemId) {
        this.orderitemId = orderitemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderitemId=" + orderitemId +
                ", order=" + order +
                ", product=" + product +
                ", productCount=" + productCount +
                '}';
    }
}
