package com.tjetc.service.impl;

import com.tjetc.dao.CartDao;
import com.tjetc.dao.impl.CardDaoImpl;
import com.tjetc.domain.Cart;
import com.tjetc.service.CartService;
import com.tjetc.util.Page;

public class CartServiceImpl implements CartService {
    private CartDao cartDao = new CardDaoImpl();
    @Override
    public int add(Cart cart) {
        if(cart!=null){
            return cartDao.add(cart);
        }
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return cartDao.delete(id);
    }

    @Override
    public int update(Cart cart) {
        if(cart!=null){
            return cartDao.update(cart);
        }
        return 0;
    }

    @Override
    public Page<Cart> findAll(int pageNum, int pageSize) {
        return cartDao.selectAll(pageNum,pageSize);
    }

    @Override
    public Cart findById(Integer id) {
        return cartDao.selectById(id);
    }

    @Override
    public Page<Cart> findByUserId(int pageNum, int pageSize, Integer id) {
        return cartDao.selectByUserId(pageNum,pageSize,id);
    }

}
