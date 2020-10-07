package com.tjetc.test;

import com.tjetc.dao.ProductDao;
import com.tjetc.dao.impl.ProductDaoImpl;
import com.tjetc.service.ProductService;
import com.tjetc.service.impl.ProductServiceImpl;
import org.junit.Test;

public class ProductTest {
    ProductDao productDao = new ProductDaoImpl();
    ProductService productService = new ProductServiceImpl();
    @Test
    public void productADaoll(){
        productDao.selectAll(1,1).getData().forEach(System.out::println);
    }

    @Test
    public void findByTypeId(){
        productService.findByTypeId(1,10,1).getData().forEach(System.out::println);
    }
}
