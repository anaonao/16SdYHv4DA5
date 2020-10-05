package com.tjetc.domain;

public class Cart {
    private int cartId;
    private Product product;//商品信息
    private int productsCount;
    private User user;//用户信息

    public Cart() {
    }

    public Cart(int cartId, Product product, int productsCount, User user) {
        this.cartId = cartId;
        this.product = product;
        this.productsCount = productsCount;
        this.user = user;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", product=" + product +
                ", productsCount=" + productsCount +
                ", user=" + user +
                '}';
    }
}
