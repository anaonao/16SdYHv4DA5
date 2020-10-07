package com.tjetc.controller;

import com.google.gson.Gson;
import com.tjetc.dao.ProductTypeDao;
import com.tjetc.domain.Product;
import com.tjetc.domain.ProductType;
import com.tjetc.service.ProductTypeService;
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

@WebServlet("/ProductTypeServlet")
public class ProductTypeServlet extends HttpServlet {
    private ProductTypeService productTypeService = new ProductTypeServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if("selectAll".equals(op)){
            selectAll(req,resp);
        }else if("selectById".equals(op)){
            selectById(req,resp);
        }else if("updateProductType".equals(op)){
            updateProductType(req,resp);
        }else if("deleteById".equals(op)){
            deleteById(req,resp);
        }else if("addProductType".equals(op)){
            addProductType(req,resp);
        }else if("findAllType".equals(op)){
            findAllType(req,resp);
        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }
    }
    //查找所有商品类型
    private void findAllType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<ProductType> listAll = productTypeService.findListAll();
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        String str = gson.toJson(listAll);
        out.write(str);
        out.flush();
    }

    //添加商品类型信息
    private void addProductType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String productTypeName = req.getParameter("productTypeName");
        ProductType productType = new ProductType();
        productType.setType_name(productTypeName);
        int n = productTypeService.add(productType);
        PrintWriter out = resp.getWriter();
        if(n>0){
            //添加成功
            out.write("1");
        }else {
            //添加失败
            out.write("0");
        }
        out.flush();
    }

    //根据编号删除数据
    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        int n = productTypeService.delete(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath()+"/ProductTypeServlet?op=selectAll");

    }

    //数据修改
    private void updateProductType(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String productTypeId = req.getParameter("productTypeId");
        String productTypeName = req.getParameter("productTypeName");
        ProductType productType = new ProductType(Integer.parseInt(productTypeId),productTypeName);
        int n = productTypeService.update(productType);
        PrintWriter out = resp.getWriter();
        if(n>0){
            //修改成功
            out.write("1");
        }else {
            //修改失败
            out.write("0");
        }
        out.flush();
    }

    //根据编号
    private void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ProductType productType = productTypeService.findById(Integer.parseInt(id));
        req.setAttribute("productType",productType);
        req.getRequestDispatcher("backend/admin/productType/modify.jsp").forward(req,resp);
    }

    //查询所有商品类型数据
    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageSize = req.getParameter("page");
        Page<ProductType> all = productTypeService.findAll(pageSize == null ? 1 : Integer.parseInt(pageSize), 10);
        req.setAttribute("page",all);
        req.getRequestDispatcher("backend/admin/productType/list.jsp").forward(req,resp);

    }
}
