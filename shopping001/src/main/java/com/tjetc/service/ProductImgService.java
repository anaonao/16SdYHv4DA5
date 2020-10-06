package com.tjetc.service;

import com.tjetc.domain.ProductImg;
import com.tjetc.util.Page;

public interface ProductImgService {
    /**
     * 添加图片
     * @param productImg
     * @return
     */
    int add(ProductImg productImg);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(Integer id);

    /**
     * 修改
     * @param productImg
     * @return
     */
    int update(ProductImg productImg);

    /**
     * 查询
     * @return
     */
    Page<ProductImg> findAll(int pageNum, int pageSize);

    /**
     * 根据编号查询
     * @param id
     * @return
     */
    ProductImg findByProductId(Integer id);
}
