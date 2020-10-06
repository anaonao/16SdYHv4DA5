package com.tjetc.dao.impl;

import com.tjetc.dao.ProductTypeDao;
import com.tjetc.domain.ProductType;
import com.tjetc.util.DBUtil;
import com.tjetc.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeDaoImpl implements ProductTypeDao {
    @Override
    public int add(ProductType productType) {
        String sql = "insert into product_type(type_name) values('aa')";
        int n = DBUtil.addDeleteUpdate(sql, productType.getType_name());
        return n;
    }

    @Override
    public int delete(Integer id) {
        String sql = "delete from product_type where type_id=?";
        int n = DBUtil.addDeleteUpdate(sql, id);
        return n;
    }

    @Override
    public int update(ProductType productType) {
        String sql = "update product_type set type_name=? where type_id=?";
        int n = DBUtil.addDeleteUpdate(sql, productType.getType_name(), productType.getType_id());
        return n;
    }

    @Override
    public Page<ProductType> selectAll(int pageNum, int pageSize) {
        Page<ProductType> page = new Page<>(pageNum,pageSize);
        page.setTotalData(countAll());
        List<ProductType> list = new ArrayList<>();
        String sql = "select type_id,type_name from product_type limit ?,?";
        ResultSet rs = DBUtil.select(sql, page.start(), page.getPageSize());
        try {
            while (rs.next()){
                ProductType productType = new ProductType();
                productType.setType_name(rs.getString("type_name"));
                productType.setType_id(rs.getInt("type_id"));
                list.add(productType);
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
        String sql = "select count(1) product_type";
        ResultSet rs = DBUtil.select(sql);
        int n = 0;
        try {
            if(rs.next()){
                n=rs.getInt(1);
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
    public ProductType selectByName(String name) {
        ProductType productType=null;
        String sql = "select type_id,type_name from product_type where type_name=?";
        ResultSet rs = DBUtil.select(sql,name);
        try {
            if(rs.next()){
                productType = new ProductType();
                productType.setType_name(rs.getString("type_name"));
                productType.setType_id(rs.getInt("type_id"));
            }
            return productType;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public ProductType selectById(Integer id) {
        ProductType productType=null;
        String sql = "select type_id,type_name from product_type where type_id=?";
        ResultSet rs = DBUtil.select(sql,id);
        try {
            if(rs.next()){
                productType = new ProductType();
                productType.setType_name(rs.getString("type_name"));
                productType.setType_id(rs.getInt("type_id"));
            }
            return productType;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            DBUtil.close();
        }
    }

    @Override
    public Page<ProductType> selectPageLikeName(int pageNum, int pageSize, String name) {
        Page<ProductType> page = new Page<>(pageNum,pageSize);
        page.setTotalData(countLikeName(name));
        List<ProductType> list = new ArrayList<>();
        String sql = "select type_id,type_name from product_type where type_name like ? limit ?,?";
        ResultSet rs = DBUtil.select(sql,"%"+name+"%",page.start(), page.getPageSize());
        try {
            while (rs.next()){
                ProductType productType = new ProductType();
                productType.setType_name(rs.getString("type_name"));
                productType.setType_id(rs.getInt("type_id"));
                list.add(productType);
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
        String sql = "select count(1) product_type where type_name like ?";
        ResultSet rs = DBUtil.select(sql,"%"+name+"%");
        int n = 0;
        try {
            if(rs.next()){
                n=rs.getInt(1);
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
    public List<ProductType> selectListAll() {
        List<ProductType> list = new ArrayList<>();
        String sql = "select type_id,type_name from product_type";
        ResultSet rs = DBUtil.select(sql);
        try {
            while (rs.next()){
                ProductType productType = new ProductType();
                productType.setType_name(rs.getString("type_name"));
                productType.setType_id(rs.getInt("type_id"));
                list.add(productType);
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
