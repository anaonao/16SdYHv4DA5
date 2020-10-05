package com.tjetc.service;

import com.tjetc.domain.ProductType;
import com.tjetc.util.Page;

public interface ProductTypeService {
    /**
     * @param productType
     * @return
     */
    int add(ProductType productType);

    /**
     * 删除商品类型
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 修改商品类型
     * @param productType
     * @return
     */
    int update(ProductType productType);

    /**
     * 查询所有商品类型
     * @return
     */
    Page<ProductType> findAll(int pageNum, int pageSize);

    /**
     * 根据名字查询
     * @param name
     * @return
     */
    ProductType findByName(String name);

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    ProductType findById(Integer id);

    /**
     * 根据名字模糊查询
     * @param name
     * @return
     */
    Page<ProductType> findPageLikeName(int pageNum, int pageSize,String name);
}
