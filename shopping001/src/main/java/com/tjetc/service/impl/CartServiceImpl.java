package com.tjetc.service.impl;

import com.tjetc.domain.Cart;
import com.tjetc.service.CartService;
import com.tjetc.util.Page;

public class CartServiceImpl implements CartService {
    @Override
    public int add(Cart cart) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public int update(Cart cart) {
        return 0;
    }

    @Override
    public Page<Cart> findAll(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public Cart findById(String orderId) {
        return null;
    }

    @Override
    public Page<Cart> findByName(int pageNum, int pageSize, String name) {
        return null;
    }

    @Override
    public Page<Cart> findLikeName(int pageNum, int pageSize, String name) {
        return null;
    }
}
