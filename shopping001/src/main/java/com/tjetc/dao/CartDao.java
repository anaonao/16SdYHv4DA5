package com.tjetc.dao;

import com.tjetc.domain.Cart;
import com.tjetc.domain.Product;
import com.tjetc.domain.User;
import com.tjetc.util.Page;

import java.util.List;

public interface CartDao {

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
    Page<Cart> selectAll(int pageNum, int pageSize);
    int countAll();

    /**
     * 根据购物车编号查询
     * @param id
     * @return
     */
    Cart selectById(Integer id);

    /**
     * 根据用户编号查询
     * @param id
     * @return
     */
    Page<Cart> selectByUserId(int pageNum, int pageSize,Integer id);
    int countByUserId(Integer id);





}
