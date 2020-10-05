package com.tjetc.dao;

import com.tjetc.domain.Cart;
import com.tjetc.util.Page;

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
     * 根据订单编号查询
     * @param orderId
     * @return
     */
    Cart selectById(String orderId);

    /**
     * 根据用户名查询
     * @param name
     * @return
     */
    Page<Cart> selectByName(int pageNum, int pageSize,String name);
    int countByName(String name);

    /**
     * 根据用户名模糊查询
     * @param name
     * @return
     */
    Page<Cart> selectLikeName(int pageNum, int pageSize,String name);
    int countLikeName(String name);

}
