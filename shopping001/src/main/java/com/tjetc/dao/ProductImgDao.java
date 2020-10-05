package com.tjetc.dao;

import com.tjetc.domain.ProductImg;
import com.tjetc.util.Page;

public interface ProductImgDao {

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
    Page<ProductImg> selectAll(int pageNum, int pageSize);
    int countAll();
}
