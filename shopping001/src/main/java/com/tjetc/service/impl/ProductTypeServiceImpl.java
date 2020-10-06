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
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public int update(ProductType productType) {
        return 0;
    }

    @Override
    public Page<ProductType> findAll(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public ProductType findByName(String name) {
        return null;
    }

    @Override
    public ProductType findById(Integer id) {
        return null;
    }

    @Override
    public Page<ProductType> findPageLikeName(int pageNum, int pageSize, String name) {
        return null;
    }

    @Override
    public List<ProductType> findListAll() {
        return productTypeDao.selectListAll();
    }
}
