package com.tjetc.domain;

import java.util.List;

public class Product {
    private int productId;//商品编号
    private String productName;//商品名称
    private int productCount;//商品库存
    private double productPrice;//商品价格
    private List<ProductImg> list;//商品图片路径
    private String productDiscraction;//商品描述
    private int productSales;//商品销量
    private int productDiscount;//折扣
    private ProductType producttype;//商品类型信息

    public Product() {
    }

    public Product(int productId, String productName, int productCount, double productPrice, List<ProductImg> list, String productDiscraction, int productSales, int productDiscount, ProductType producttype) {
        this.productId = productId;
        this.productName = productName;
        this.productCount = productCount;
        this.productPrice = productPrice;
        this.list = list;
        this.productDiscraction = productDiscraction;
        this.productSales = productSales;
        this.productDiscount = productDiscount;
        this.producttype = producttype;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public List<ProductImg> getList() {
        return list;
    }

    public void setList(List<ProductImg> list) {
        this.list = list;
    }

    public String getProductDiscraction() {
        return productDiscraction;
    }

    public void setProductDiscraction(String productDiscraction) {
        this.productDiscraction = productDiscraction;
    }

    public int getProductSales() {
        return productSales;
    }

    public void setProductSales(int productSales) {
        this.productSales = productSales;
    }

    public int getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(int productDiscount) {
        this.productDiscount = productDiscount;
    }

    public ProductType getProducttype() {
        return producttype;
    }

    public void setProducttype(ProductType producttype) {
        this.producttype = producttype;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productCount=" + productCount +
                ", productPrice=" + productPrice +
                ", list=" + list +
                ", productDiscraction='" + productDiscraction + '\'' +
                ", productSales=" + productSales +
                ", productDiscount=" + productDiscount +
                ", producttype=" + producttype +
                '}';
    }
}
