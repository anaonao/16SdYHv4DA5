package com.tjetc.service.impl;

import com.tjetc.dao.ProductTypeDao;
import com.tjetc.dao.impl.ProductTypeDaoImpl;
import com.tjetc.domain.ProductType;
import com.tjetc.service.ProductTypeService;
import com.tjetc.util.Page;

import java.util.List;

public class ProductTypeServiceImpl implements ProductTypeService {
    private ProductTypeDao productTypeDao = new ProductTypeDaoImpl();
    @Override
    public int add(ProductType productType) {
        if(productType!=null){
            return productTypeDao.add(productType);
        }
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return productTypeDao.delete(id);
    }

    @Override
    public int update(ProductType productType) {
        if(productType!=null){
            return productTypeDao.update(productType);
        }
        return 0;
    }

    @Override
    public Page<ProductType> findAll(int pageNum, int pageSize) {
        return productTypeDao.selectAll(pageNum,pageSize);
    }

    @Override
    public ProductType findByName(String name) {
        return productTypeDao.selectByName(name);
    }

    @Override
    public ProductType findById(Integer id) {
        return productTypeDao.selectById(id);
    }

    @Override
    public Page<ProductType> findPageLikeName(int pageNum, int pageSize, String name) {
        return productTypeDao.selectPageLikeName(pageNum,pageSize,name);
    }

    @Override
    public List<ProductType> findListAll() {
        return productTypeDao.selectListAll();
    }
}
