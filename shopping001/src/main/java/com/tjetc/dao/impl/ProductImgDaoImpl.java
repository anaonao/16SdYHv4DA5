package com.tjetc.dao.impl;

import com.tjetc.dao.ProductDao;
import com.tjetc.dao.ProductImgDao;
import com.tjetc.domain.Product;
import com.tjetc.domain.ProductImg;
import com.tjetc.util.DBUtil;
import com.tjetc.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductImgDaoImpl implements ProductImgDao {
    private ProductDao productDao = new ProductDaoImpl();
    @Override
    public int add(ProductImg productImg) {
        String sql = "insert into product_image(product_img_name,product_id) values(?,?)";
        int n = DBUtil.addDeleteUpdate(sql, productImg.getProductImgName(), productImg.getProduct().getProductId());
        return n;
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from product_image where product_img_id=?";
        int n = DBUtil.addDeleteUpdate(sql, id);
        return n;
    }

    @Override
    public int update(ProductImg productImg) {
        String sql = "update product_image set product_img_name=?,product_id=? where product_img_id=? ";
        int n = DBUtil.addDeleteUpdate(sql, productImg.getProductImgName(), productImg.getProduct().getProductId(), productImg.getProductImgId());
        return n;
    }

    @Override
    public Page<ProductImg> selectAll(int pageNum, int pageSize) {
        Page<ProductImg> page = new Page<>(pageNum,pageSize);
        page.setTotalData(countAll());
        List<ProductImg> list = new ArrayList<>();
        String sql = "select product_img_id,product_img_name,product_id from product_image limit ?,?";
        ResultSet rs = DBUtil.select(sql, page.start(), page.getPageSize());
        try {
            while (rs.next()){
                ProductImg productImg = new ProductImg();
                productImg.setProductImgId(rs.getInt("product_img_id"));
                productImg.setProductImgName(rs.getString("product_img_name"));

                Product product = productDao.selectById(rs.getInt("product_id"));
                productImg.setProduct(product);

                list.add(productImg);
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
        String sql = "select count(1) from product_image";
        ResultSet rs = DBUtil.select(sql);
        int n =0;
        try {
            if(rs.next()){
                n = rs.getInt(1);
            }
            return  n;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }finally {
            DBUtil.close();
        }

    }

    @Override
    public ProductImg selectByProductId(Integer id) {
        ProductImg productImg=null;
        String sql = "select product_img_id,product_img_name,product_id from product_image where product_img_id=?";
        ResultSet rs = DBUtil.select(sql,id);
        try {
            if (rs.next()){
                productImg = new ProductImg();
                productImg.setProductImgId(rs.getInt("product_img_id"));
                productImg.setProductImgName(rs.getString("product_img_name"));

                Product product = productDao.selectById(rs.getInt("product_id"));
                productImg.setProduct(product);
            }
            return productImg;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }
    }


}
