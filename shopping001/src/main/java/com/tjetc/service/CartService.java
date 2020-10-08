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
     * 根据购物车编号查询
     * @param id
     * @return
     */
    Cart findById(Integer id);

    /**
     * 根据用户编号查询
     * @param id
     * @return
     */
    Page<Cart> findByUserId(int pageNum, int pageSize,Integer id);

    /**
     * 根据用户编号和商品编号查询
     * @param userId
     * @param productId
     * @return
     */
    Cart findByUserIdAndProductId(Integer userId,Integer productId);

    /**
     *
     * @param id
     * @return
     */
    int delteByListCartId(String[] id);
}
