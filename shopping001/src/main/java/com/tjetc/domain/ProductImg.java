package com.tjetc.domain;

public class ProductImg {
    private int productImgId;
    private String productImgName;
    private Product product;

    public ProductImg() {
    }

    public ProductImg(int productImgId, String productImgName, Product product) {
        this.productImgId = productImgId;
        this.productImgName = productImgName;
        this.product = product;
    }

    public int getProductImgId() {
        return productImgId;
    }

    public void setProductImgId(int productImgId) {
        this.productImgId = productImgId;
    }

    public String getProductImgName() {
        return productImgName;
    }

    public void setProductImgName(String productImgName) {
        this.productImgName = productImgName;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductImg{" +
                "productImgId=" + productImgId +
                ", productImgName='" + productImgName + '\'' +
                ", product=" + product +
                '}';
    }
}
