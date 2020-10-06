package com.tjetc.test;

import com.tjetc.dao.ProductImgDao;
import com.tjetc.dao.impl.ProductImgDaoImpl;
import org.junit.Test;

public class ProductImgTest {
    ProductImgDao productImgDao = new ProductImgDaoImpl();
    @Test
    public void selectDaoAll(){
        productImgDao.selectAll(1,5).getData().forEach(System.out::println);
    }
}
