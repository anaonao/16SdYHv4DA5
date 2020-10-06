package com.tjetc.dao.impl;

import com.tjetc.dao.ProductDao;
import com.tjetc.domain.Product;
import com.tjetc.domain.ProductImg;
import com.tjetc.domain.ProductType;
import com.tjetc.util.DBUtil;
import com.tjetc.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProductDaoImpl implements ProductDao {
    @Override
    public int add(Product product) {
        String sql = "insert into product (product_id,product_name,product_count,product_price,product_msg,product_sales,type_id,product_discount) values(null,?,?,?,?,?,?,?);";
        int n = DBUtil.addDeleteUpdate(sql,product.getProductName(),product.getProductCount(),product.getProductPrice(),product.getProductDiscraction(),product.getProductSales(),product.getProducttype().getType_id(),product.getProductCount());
        return n;
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from product where product_id=? ";
        int n = DBUtil.addDeleteUpdate(sql, id);
        return n;
    }

    @Override
    public int update(Product product) {
        String sql = "update product set product_name=?,product_count=?,product_price=?,product_msg=?,product_sales=?,type_id=?,product_discount=? where product_id=?";
        int n = DBUtil.addDeleteUpdate(sql,product.getProductName(),product.getProductCount(),product.getProductPrice(),product.getProductDiscraction(),product.getProductSales(),product.getProducttype().getType_id(),product.getProductDiscount(),product.getProductId());
        return n;
    }

    @Override
    public Page<Product> selectAll(int pageNum, int pageSize) {
        Page<Product> page = new Page<>(pageNum,pageSize);
        page.setTotalData(countAll());
        List<Product> list = new ArrayList<>();
        String sql = "select product_id,product_name,product_count,product_price,product_msg,product_sales,type_id,product_discount from product limit ?,?";
        ResultSet rs = DBUtil.select(sql, page.start(), page.getPageSize());
        try {
            while (rs.next()){
                Product product = new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getInt("product_count"),rs.getDouble("product_price"),selectLikeProductId(rs.getInt("product_id")),rs.getString("product_msg"),rs.getInt("product_sales"),rs.getInt("product_discount"),selectByProductTypeId(rs.getInt("type_id")));
                list.add(product);
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
        String sql = "select count(*) from product";
        ResultSet rs = DBUtil.select(sql);
        int n =0;
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
    public Product selectById(Integer id) {
        String sql = "select product_id,product_name,product_count,product_price,product_msg,product_sales,type_id,product_discount from product where product_id=?";
        ResultSet rs = DBUtil.select(sql, id);
        Product product=null;
        try {
            while (rs.next()){
                product = new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getInt("product_count"),rs.getDouble("product_price"),selectLikeProductId(rs.getInt("product_id")),rs.getString("product_msg"),rs.getInt("product_sales"),rs.getInt("product_discount"),selectByProductTypeId(rs.getInt("type_id")));
            }
            return product;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public Page<Product> selectLikeName(int pageNum, int pageSize, String name) {
        Page<Product> page = new Page<>(pageNum,pageSize);
        page.setTotalData(countAll());
        List<Product> list = new ArrayList<>();
        String sql = "select product_id,product_name,product_count,product_price,product_msg,product_sales,type_id,product_discount from  product where product_name like ? limit ?,?";
        ResultSet rs = DBUtil.select(sql, name,page.start(), page.getPageSize());
        try {
            while (rs.next()){
                Product product = new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getInt("product_count"),rs.getDouble("product_price"),selectLikeProductId(rs.getInt("product_id")),rs.getString("product_msg"),rs.getInt("product_sales"),rs.getInt("product_discount"),selectByProductTypeId(rs.getInt("type_id")));
                list.add(product);
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
    public int countLikeName(String name) {
        String sql = "select count(*) from product where product_name like ?";
        ResultSet rs = DBUtil.select(sql,"%"+name+"%");
        int n =0;
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
    public Page<Product> selectLikePrice(int pageNum, int pageSize, Double startPrice, Double endPrice) {
        return null;
    }

    @Override
    public int countLikePrice(Double startPrice, Double endPrice) {
        return 0;
    }

    @Override
    public Page<Product> selectLikeSales(int pageNum, int pageSize, Integer Sales) {
        return null;
    }

    @Override
    public int countLikeSales(Integer Sales) {
        return 0;
    }

    //根据商品编号查询所有图片
    @Override
    public List<ProductImg> selectLikeProductId(int id) {
        List<ProductImg> list = new ArrayList<>();
        ProductImg productImg=null;
        String sql = "select product_img_id,product_img_name,product_id from product_image where product_id=?";
        ResultSet rs = DBUtil.select(sql, id);
        try {
            while (rs.next()){
                Product product = new Product();
                productImg=new ProductImg();
                productImg.setProductImgId(rs.getInt("product_img_id"));
                productImg.setProductImgName(rs.getString("product_img_name"));
                list.add(productImg);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public ProductType selectByProductTypeId(Integer id) {
        String sql = "select type_id,type_name from product_type where type_id=?";
        ResultSet rs = DBUtil.select(sql, id);
        ProductType productType=null;
        try {
            if(rs.next()){
                productType = new ProductType();
                productType.setType_id(rs.getInt("type_id"));
                productType.setType_name(rs.getString("type_name"));
            }
            return productType;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("根据编号查询商品类型异常！！");
            return null;
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public List<Product> selectListAll() {
        List<Product> list = new ArrayList<>();
        String sql = "select product_id,product_name,product_count,product_price,product_msg,product_sales,type_id,product_discount from product";
        ResultSet rs = DBUtil.select(sql);
        try {
            while (rs.next()){
                Product product = new Product(rs.getInt("product_id"),rs.getString("product_name"),rs.getInt("product_count"),rs.getDouble("product_price"),selectLikeProductId(rs.getInt("product_id")),rs.getString("product_msg"),rs.getInt("product_sales"),rs.getInt("product_discount"),selectByProductTypeId(rs.getInt("type_id")));
                list.add(product);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }
    }
}
