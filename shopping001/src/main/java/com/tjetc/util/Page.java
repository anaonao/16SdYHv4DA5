package com.tjetc.util;

import java.util.List;

public class Page<T> {
    private int currentPage;//当前页
    private int pageSize;//一页显示多少条数据
    private int totalData;//一共是多少条数据
    private List<T> data;//查询结果
    //构造方法

    public Page() {
    }

    public Page(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalData() {
        return totalData;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalData=" + totalData +
                ", data=" + data +
                '}';
    }

    //创建自定义方法
    //获取总页数

    /**
     * 获取总页数
     * @return int
     */
    public  int getTotalPageCount(){
        return this.totalData % this.pageSize ==0 ? this.totalData/this.pageSize:this.totalData/this.pageSize+1;
    }

    //上一页
    public int prev(){
        return this.currentPage-1>0?this.currentPage-1:1;
    }

    //下一页
    public int next(){
        return this.currentPage+1<=getTotalPageCount()?this.currentPage+1:getTotalPageCount();
    }

    //求sql起始位置

    /**
     * 获取起始位置
     * @return
     */
    public int start(){
        return (this.currentPage-1)*this.pageSize;
    }


}
