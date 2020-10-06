package com.tjetc.service.impl;

import com.tjetc.dao.ProductDao;
import com.tjetc.dao.impl.ProductDaoImpl;
import com.tjetc.domain.Product;
import com.tjetc.service.ProductService;
import com.tjetc.util.Page;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();
    @Override
    public int add(Product product) {
        if(product!=null){
            return productDao.add(product);
        }
        return 0;
    }

    @Override
    public int delete(int id) {
        return productDao.delete(id);
    }

    @Override
    public int update(Product product) {
        if(product!=null){
            return productDao.update(product);
        }
        return 0;
    }

    @Override
    public Page<Product> findAll(int pageNum, int pageSize) {
        return productDao.selectAll(pageNum,pageSize);
    }

    @Override
    public Product findById(int id) {
        return productDao.selectById(id);
    }

    @Override
    public Page<Product> findLikeName(int pageNum, int pageSize, String name) {
        return productDao.selectLikeName(pageNum,pageSize,name);
    }

    @Override
    public Page<Product> findLikePrice(int pageNum, int pageSize, Double startPrice, Double endPrice) {
        return null;
    }

    @Override
    public Page<Product> findLikeSales(int pageNum, int pageSize, Integer Sales) {
        return null;
    }
}
