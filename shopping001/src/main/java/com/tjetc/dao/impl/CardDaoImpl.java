package com.tjetc.dao.impl;

import com.tjetc.dao.CartDao;
import com.tjetc.dao.ProductDao;
import com.tjetc.dao.UserDao;
import com.tjetc.domain.Cart;
import com.tjetc.domain.Product;
import com.tjetc.domain.User;
import com.tjetc.util.DBUtil;
import com.tjetc.util.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardDaoImpl implements CartDao {
    private ProductDao productDao = new ProductDaoImpl();
    private UserDao userDao = new UserDaoImpl();
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
                Product product = productDao.selectById(rs.getInt("product_id"));
                User user = userDao.selectById(rs.getInt("user_id"));
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
    public Cart selectById(Integer id) {
        String sql = "select cart_id,product_id,products_count,user_id from cart where cart_id=?";
        ResultSet rs = DBUtil.select(sql, id);
        Cart cart = new Cart();
        try {
            if(rs.next()){
                Product product = productDao.selectById(rs.getInt("product_id"));
                User user = userDao.selectById(rs.getInt("user_id"));
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
    public Page<Cart> selectByUserId(int pageNum, int pageSize, Integer id) {
        Page<Cart> page = new Page<>(pageNum,pageSize);
        page.setTotalData(countByUserId(id));
        List<Cart> list = new ArrayList<>();
        String sql = "select cart_id,product_id,products_count,user_id from cart where user_id=? limit ?,?";
        ResultSet rs = DBUtil.select(sql,id,page.start(),page.getPageSize());
        try {
            while (rs.next()){
                Cart cart = new Cart();
                Product product = productDao.selectById(rs.getInt("product_id"));
                User user = userDao.selectById(rs.getInt("user_id"));

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
    public int countByUserId(Integer id) {
        String sql = "select count(1) from cart where user_id=?";
        ResultSet rs = DBUtil.select(sql,id);
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
    public Cart selectByUserIdAndProductId(Integer userId, Integer productId) {
        String sql = "select cart_id,product_id,products_count,user_id from cart where user_id=? and product_id=?";
        ResultSet rs = DBUtil.select(sql,userId,productId);
        Cart cart =null;
        try {
            if(rs.next()){
                cart = new Cart();
                Product product = productDao.selectById(rs.getInt("product_id"));
                User user = userDao.selectById(rs.getInt("user_id"));
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
    public int delteByListCartId(String[] id) {
        String sql = "delete from cart where cart_id in (?";
        StringBuffer sqlbuf = new StringBuffer(sql);
        Connection conn = DBUtil.getConnection();
        PreparedStatement pstmt=null;
        try {
            //拼接sqlbuf，两种情况
            if (id.length == 1) {
                //有1条时， 直接加 "）"结束
                sqlbuf.append(")");
            }else{
                //有多条时候，拼接length-1 次，因为初始sql语句已经有一次了。"delete  from `user` where u_id in (? "
                for (int i = 0; i < id.length-1; i++) {
                    sqlbuf.append(",?");

                }
                //最后拼接" )"  圆满完成拼接sql
                sqlbuf.append(")");
            }
            System.out.println(sqlbuf.toString());
            pstmt = conn.prepareStatement(sqlbuf.toString());
            if (id.length == 1) {
                pstmt.setString(1, id[0]);
            }else{

                for (int i = 1; i <= id.length; i++) {
                    pstmt.setString(i, id[i-1]);
                    //userids[i-1] 因为数据下标从0 开始。
                }
            }
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            try {
                conn.close();
                pstmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }
}
