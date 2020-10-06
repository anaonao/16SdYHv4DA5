package com.tjetc.controller;

import com.tjetc.domain.Product;
import com.tjetc.domain.ProductImg;
import com.tjetc.service.ProductImgService;
import com.tjetc.service.ProductService;
import com.tjetc.service.impl.ProductImgServiceImpl;
import com.tjetc.service.impl.ProductServiceImpl;
import com.tjetc.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet("/ProductImgServlet")
/*支持文件上传注解*/
@MultipartConfig
public class ProductImgServlet extends HttpServlet {
    private ProductImgService productImgService = new ProductImgServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if("selectAll".equals(op)){
            selectAll(req,resp);
        }else if("selectProductAll".equals(op)){
            selectProductAll(req,resp);
        }else if("addProductImg".equals(op)){
            addProductImg(req,resp);
        }else if("deleteById".equals(op)){
            deleteById(req,resp);
        }else if("selectById".equals(op)){
            selectById(req,resp);
        }else if("updateProductImg".equals(op)){
            updateProductImg(req,resp);
        }else if("".equals(op)){

        }else if("".equals(op)){

        }
    }

    //修改图片信息
    private void updateProductImg(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //图片上传
        Part part = req.getPart("productImg");
        System.out.println("part:"+part);
        //获取图片名称
        String imgName = part.getSubmittedFileName();
        System.out.println("图片名字："+imgName);
        //给图片起个新名
        String newName = "/"+ UUID.randomUUID().toString().replaceAll("-","").toUpperCase()
                +imgName.substring(imgName.lastIndexOf("."));
        System.out.println("图片新名字："+newName);
        //获取图片路径
        String realPath = this.getServletContext().getRealPath("/foreground/images");
        System.out.println("路径："+realPath);
        //创建文件？看路径是否存在
        File file = new File(realPath);
        if(!file.exists()){
            //创建文件夹
            file.mkdir();
        }
        //进行图片上传
        part.write(realPath+newName);
        System.out.println("上传路径："+realPath+newName);

        String product = req.getParameter("product");
        String productImgId = req.getParameter("productImgId");

        ProductImg productImg = new ProductImg();
        productImg.setProductImgName(newName);

        Product product1 = new Product();
        product1.setProductId(Integer.parseInt(product));
        System.out.println("product:"+product1);

        productImg.setProduct(product1);
        productImg.setProductImgId(Integer.parseInt(productImgId));
        int n = productImgService.update(productImg);
        System.out.println(n);
        if(n>0){
            //添加成功
            resp.sendRedirect(req.getContextPath()+"/ProductImgServlet?op=selectAll");
        }else {
            req.setAttribute("msg","添加失败！！！");
            System.out.println("添加失败");
        }
    }

    //根据编号查询图片信息
    private void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ProductImg byProductId = productImgService.findByProductId(Integer.parseInt(id));
        //显示所有商品
        List<Product> listAll = productService.findListAll();
        req.setAttribute("product",listAll);

        req.setAttribute("productImg",byProductId);
        req.getRequestDispatcher("backend/admin/productImg/modify.jsp").forward(req,resp);
    }

    //根据编号删除商品信息
    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        int n = productImgService.delete(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath()+"/ProductImgServlet?op=selectAll");
    }

    //添加商品图片信息
    private void addProductImg(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //图片上传
        Part part = req.getPart("productImg");
        System.out.println("part:"+part);
        //获取图片名称
        String imgName = part.getSubmittedFileName();
        System.out.println("图片名字："+imgName);
        //给图片起个新名
        String newName = "/"+ UUID.randomUUID().toString().replaceAll("-","").toUpperCase()
                +imgName.substring(imgName.lastIndexOf("."));
        System.out.println("图片新名字："+newName);
        //获取图片路径
        String realPath = this.getServletContext().getRealPath("/foreground/images");
        System.out.println("路径："+realPath);
        //创建文件？看路径是否存在
        File file = new File(realPath);
        if(!file.exists()){
            //创建文件夹
            file.mkdir();
        }
        //进行图片上传
        part.write(realPath+newName);
        System.out.println("上传路径："+realPath+newName);

        String product = req.getParameter("product");

        ProductImg productImg = new ProductImg();
        productImg.setProductImgName(newName);

        Product product1 = new Product();
        product1.setProductId(Integer.parseInt(product));
        System.out.println("product:"+product1);

        productImg.setProduct(product1);
        int n = productImgService.add(productImg);
        System.out.println(n);
        if(n>0){
            //添加成功
            resp.sendRedirect(req.getContextPath()+"/ProductImgServlet?op=selectAll");
        }else {
            req.setAttribute("msg","添加失败！！！");
            System.out.println("添加失败");
        }

    }

    //显示所有商品
    private void selectProductAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> listAll = productService.findListAll();
        req.setAttribute("product",listAll);
        req.getRequestDispatcher("backend/admin/productImg/add.jsp").forward(req,resp);
    }

    //显示所有商品图片信息
    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page=1;
        String pageSize = req.getParameter("page");
        Page<ProductImg> all = productImgService.findAll(pageSize == null ? 1 : Integer.parseInt(pageSize), 10);
        req.setAttribute("page",all);
        req.getRequestDispatcher("backend/admin/productImg/list.jsp").forward(req,resp);
    }
}
