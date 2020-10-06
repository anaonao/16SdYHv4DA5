package com.tjetc.service.impl;

import com.tjetc.dao.ProductImgDao;
import com.tjetc.dao.impl.ProductImgDaoImpl;
import com.tjetc.domain.ProductImg;
import com.tjetc.service.ProductImgService;
import com.tjetc.util.Page;

public class ProductImgServiceImpl implements ProductImgService {
    private ProductImgDao productImgDao = new ProductImgDaoImpl();
    @Override
    public int add(ProductImg productImg) {
        if(productImg!=null){
            return productImgDao.add(productImg);
        }
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return productImgDao.delete(id);
    }

    @Override
    public int update(ProductImg productImg) {
        if(productImg!=null){
            return productImgDao.update(productImg);
        }
        return 0;
    }

    @Override
    public Page<ProductImg> findAll(int pageNum, int pageSize) {
        return productImgDao.selectAll(pageNum,pageSize);
    }

    @Override
    public ProductImg findByProductId(Integer id) {
        return productImgDao.selectByProductId(id);
    }
}
