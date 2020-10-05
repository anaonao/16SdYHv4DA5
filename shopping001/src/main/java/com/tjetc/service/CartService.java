package com.tjetc.service;

import com.tjetc.domain.Cart;
import com.tjetc.util.Page;

public interface CartService {
    /**
     * 添加商品到购物车
     * @param cart
     * @return
     */
    int add(Cart cart);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 修改
     * @param cart
     * @return
     */
    int update(Cart cart);

    /**
     * 查询所有
     * @return
     */
    Page<Cart> findAll(int pageNum, int pageSize);

    /**
     * 根据订单编号查询
     * @param orderId
     * @return
     */
    Cart findById(String orderId);

    /**
     * 根据用户名查询
     * @param name
     * @return
     */
    Page<Cart> findByName(int pageNum, int pageSize,String name);

    /**
     * 根据用户名模糊查询
     * @param name
     * @return
     */
    Page<Cart> findLikeName(int pageNum, int pageSize,String name);
}
