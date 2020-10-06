package com.tjetc.test;

import com.tjetc.dao.ProductDao;
import com.tjetc.dao.impl.ProductDaoImpl;
import org.junit.Test;

public class ProductTest {
    ProductDao productDao = new ProductDaoImpl();
    @Test
    public void productADaoll(){
        productDao.selectAll(1,1).getData().forEach(System.out::println);
    }
}
