package com.tjetc.service;

import com.tjetc.domain.Product;
import com.tjetc.util.Page;

import java.util.List;

public interface ProductService {
    /**
     * 添加商品
     * @param product
     * @return
     */
    int add(Product product);

    /**
     * 删除商品
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 修改商品
     * @param product
     * @return
     */
    int update(Product product);

    /**
     * 查询所有商品
     * @return
     */
    Page<Product> findAll(int pageNum, int pageSize);

    /**
     * 根据编号查询商品
     * @param id
     * @return
     */
    Product findById(int id);

    /**
     * 根据名称模糊查询商品
     * @param name
     * @return
     */
    Page<Product> findLikeName(int pageNum, int pageSize,String name);

    /**
     * 根据价格范围查询商品
     * @param startPrice
     * @param endPrice
     * @return
     */
    Page<Product> findLikePrice(int pageNum, int pageSize,Double startPrice,Double endPrice);

    /**
     * 根据商品销量降序查询
     * @param Sales
     * @return
     */
    Page<Product> findLikeSales(int pageNum, int pageSize,Integer Sales);

    /**
     * 显示所有商品
     * @return
     */
    List<Product> findListAll();
}
