package com.tjetc.controller;

import com.tjetc.domain.Admin;
import com.tjetc.domain.Product;
import com.tjetc.domain.ProductType;
import com.tjetc.service.ProductService;
import com.tjetc.service.ProductTypeService;
import com.tjetc.service.impl.ProductServiceImpl;
import com.tjetc.service.impl.ProductTypeServiceImpl;
import com.tjetc.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    private ProductTypeService productTypeService = new ProductTypeServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if("selectAll".equals(op)){
            selectAll(req,resp);
        }else if("selectById".equals(op)){
            selectById(req,resp);
        }else if("deleteById".equals(op)){
            deleteById(req,resp);
        }else if("updateProduct".equals(op)){
            updateProduct(req,resp);
        }else if("selectProductTypeAll".equals(op)){
            selectProductTypeAll(req,resp);
        }else if("addProduct".equals(op)){
            addProduct(req,resp);
        }else if("findByTypeId".equals(op)){
            findByTypeId(req,resp);
        }else if("findById".equals(op)){
            findById(req,resp);
        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }
    }

    //前台页面详情展示
    private void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);
        Product byId = productService.findById(Integer.parseInt(id));
        req.setAttribute("product",byId);
        req.getRequestDispatcher("foreground/about.jsp").forward(req,resp);
    }

    private void findByTypeId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String pageSize = req.getParameter("page");
        Page<Product> all = productService.findByTypeId(pageSize == null ? 1 : Integer.parseInt(pageSize), 10,Integer.parseInt(id));
        req.setAttribute("page",all);
        req.getRequestDispatcher("foreground/second_menu.jsp").forward(req,resp);
    }

    //添加商品信息
    private void addProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String productName = req.getParameter("productName");//商品名称
        int productCount =Integer.parseInt(req.getParameter("productCount"));//库存
        double productPrice =Double.parseDouble(req.getParameter("productPrice"));//价格
        String productDiscraction = req.getParameter("productDiscraction");//描述
        int producttype =Integer.parseInt(req.getParameter("producttype"));//类型
        int productDiscount = Integer.parseInt(req.getParameter("productDiscount"));//折扣

        Product product = new Product();
        product.setProductName(productName);
        product.setProductCount(productCount);
        product.setProductPrice(productPrice);
        product.setProductDiscraction(productDiscraction);

        ProductType productType = new ProductType();
        productType.setType_id(producttype);
        product.setProducttype(productType);
        product.setProductDiscount(productDiscount);

        int n = productService.add(product);
        System.out.println("添加返回："+n);
        PrintWriter out = resp.getWriter();
        String msg="";
        if(n>0){
            //数据添加成功
            msg="1";
        }else {
            //数据添加失败
            msg="0";
        }
        out.write(msg);
        out.flush();

    }

    //查询所有商品类型
    private void selectProductTypeAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //查询所有商品类型信息
        List<ProductType> listTypeAll = productTypeService.findListAll();
        req.setAttribute("listTypeAll",listTypeAll);
        req.getRequestDispatcher("backend/admin/product/add.jsp").forward(req,resp);
    }

    //修改商品数据
    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int productId =Integer.parseInt(req.getParameter("productId"));
        String productName = req.getParameter("productName");//商品名称
        int productCount =Integer.parseInt(req.getParameter("productCount"));//库存
        double productPrice =Double.parseDouble(req.getParameter("productPrice"));//价格
        String productDiscraction = req.getParameter("productDiscraction");//描述
        int productSales =Integer.parseInt(req.getParameter("productSales"));//销量
        int producttype =Integer.parseInt(req.getParameter("producttype"));//类型
        int productDiscount = Integer.parseInt(req.getParameter("productDiscount"));//折扣

        System.out.println("productDiscount:"+productDiscount);
        Product product = new Product();
        product.setProductId(productId);
        product.setProductName(productName);
        product.setProductCount(productCount);
        product.setProductPrice(productPrice);
        product.setProductDiscraction(productDiscraction);
        product.setProductSales(productSales);

        ProductType productType = new ProductType();
        productType.setType_id(producttype);
        product.setProducttype(productType);
        product.setProductDiscount(productDiscount);

        int update = productService.update(product);
        resp.sendRedirect(req.getContextPath()+"/ProductServlet?op=selectAll");

    }

    //根据商品编号删除商品信息
    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        int n = productService.delete(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath()+"/ProductServlet?op=selectAll");
    }

    //根据商品编号查找商品信息
    private void selectById(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("id");
        Product byId = productService.findById(Integer.parseInt(id));
        //查询所有商品类型信息
        List<ProductType> listTypeAll = productTypeService.findListAll();
        req.setAttribute("product",byId);
        req.setAttribute("listTypeAll",listTypeAll);
        req.getRequestDispatcher("backend/admin/product/modify.jsp").forward(req,resp);
    }

    //分页显示所有商品信息
    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page=1;
        String pageSize = req.getParameter("page");
        Page<Product> all = productService.findAll(pageSize == null ? 1 : Integer.parseInt(pageSize), 10);
        req.setAttribute("page",all);
        req.getRequestDispatcher("backend/admin/product/list.jsp").forward(req,resp);
    }
}
