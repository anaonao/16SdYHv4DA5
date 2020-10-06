package com.tjetc.test;

import com.tjetc.service.ProductTypeService;
import com.tjetc.service.impl.ProductTypeServiceImpl;
import org.junit.Test;

public class ProductTypeTest {
    private ProductTypeService productTypeService = new ProductTypeServiceImpl();
    @Test
    public void findProductTyorAll(){
        productTypeService.findListAll().forEach(System.out::println);
    }
}
