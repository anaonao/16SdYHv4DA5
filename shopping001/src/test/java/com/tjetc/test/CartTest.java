package com.tjetc.test;

import com.tjetc.dao.CartDao;
import com.tjetc.dao.impl.CardDaoImpl;
import com.tjetc.domain.Cart;
import com.tjetc.domain.Product;
import com.tjetc.domain.User;
import org.junit.Test;

public class CartTest {
    private CartDao cartDao = new CardDaoImpl();
    @Test
    public void selectPageAll(){
        cartDao.selectAll(1,1).getData().forEach(System.out::println);
    }
    @Test
    public void addDao(){
        Cart cart = new Cart();
        Product product = new Product();
        product.setProductId(1);
        User user = new User();
        user.setUserId(1);
        cart.setProduct(product);
        cart.setUser(user);
        cart.setProductsCount(10);

        System.out.println(cartDao.add(cart));
    }
}
