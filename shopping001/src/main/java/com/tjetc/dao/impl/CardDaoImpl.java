package com.tjetc.dao.impl;

import com.tjetc.dao.CartDao;
import com.tjetc.domain.Cart;
import com.tjetc.domain.Product;
import com.tjetc.domain.User;
import com.tjetc.util.DBUtil;
import com.tjetc.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardDaoImpl implements CartDao {
    @Override
    public int add(Cart cart) {
        String sql = "insert into cart (cart_id,product_id,products_count,user_id) values(null,?,?,?);";
        int n = DBUtil.addDeleteUpdate(sql,cart.getProduct().getProductId(),cart.getProductsCount(),cart.getUser().getUserId());
        return n;
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from cart where cart_id=?";
        int n = DBUtil.addDeleteUpdate(sql, id);
        return n;
    }

    @Override
    public int update(Cart cart) {
        String sql = "update cart set product_id=?,products_count=?,user_id=? where cart_id=?";
        int n = DBUtil.addDeleteUpdate(sql,cart.getProduct().getProductId(),cart.getProductsCount(),cart.getUser().getUserId(),cart.getCartId());
        return n;
    }

    @Override
    public Page<Cart> selectAll(int pageNum, int pageSize) {
        Page<Cart> page = new Page<>(pageNum,pageSize);
        page.setTotalData(countAll());
        List<Cart> list = new ArrayList<>();
        String sql = "select cart_id,product_id,products_count,user_id from cart limit ?,?";
        ResultSet rs = DBUtil.select(sql, page.start(), page.getPageSize());
        try {
            while (rs.next()){
                Cart cart = new Cart();
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                cart.setCartId(rs.getInt("cart_id"));
                cart.setProduct(product);
                cart.setProductsCount(rs.getInt("products_count"));
                cart.setUser(user);
                list.add(cart);
                page.setData(list);
            }
            return page;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public int countAll() {
        String sql = "select count(*) from cart";
        ResultSet rs = DBUtil.select(sql);
        int n = 0;
        try {
            if(rs.next()){
                n = rs.getInt(1);
            }
            return n;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public Cart selectById(String orderId) {
        String sql = "select cart_id,product_id,products_count,user_id from cart where cart_id=?";
        ResultSet rs = DBUtil.select(sql, orderId);
        Cart cart = new Cart();
        try {
            if(rs.next()){
                Product product = new Product();
                product.setProductId(rs.getInt("product_id"));
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                cart.setCartId(rs.getInt("cart_id"));
                cart.setProduct(product);
                cart.setProductsCount(rs.getInt("products_count"));
                cart.setUser(user);
            }
            return cart;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }

    }

    @Override
    public Page<Cart> selectByName(int pageNum, int pageSize, String name) {
        return null;
    }

    @Override
    public int countByName(String name) {
        return 0;
    }

    @Override
    public Page<Cart> selectLikeName(int pageNum, int pageSize, String name) {
        return null;
    }

    @Override
    public int countLikeName(String name) {
        return 0;
    }

}
