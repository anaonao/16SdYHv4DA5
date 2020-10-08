package com.tjetc.controller;

import com.google.gson.Gson;
import com.tjetc.domain.Admin;
import com.tjetc.domain.Cart;
import com.tjetc.domain.Product;
import com.tjetc.domain.User;
import com.tjetc.service.CartService;
import com.tjetc.service.impl.CartServiceImpl;
import com.tjetc.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CartSrvlet")
public class CartSrvlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if("addCart".equals(op)){
            addCart(req,resp);
        }else if("findAll".equals(op)){
            findAll(req,resp);
        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }
    }


    //前端页面购物车显示数据
    private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获得用户编号
        int userId =(int) req.getSession().getAttribute("userId");
        String pageSize = req.getParameter("page");
        Page<Cart> all = cartService.findByUserId(pageSize == null ? 1 : Integer.parseInt(pageSize), 10,userId);
        Gson json = new Gson();
        String s = json.toJson(all);
        PrintWriter out = resp.getWriter();
        out.write(s);
        out.flush();
    }

    //把当前信息添加到购物车中
    private void addCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String productId = req.getParameter("productId");
        String userId = req.getParameter("userId");
        Cart cart = new Cart();
        //判断一下当前用户的商品是否存在
        Cart cartByUserIdAndProductId = cartService.findByUserIdAndProductId(Integer.parseInt(userId),Integer.parseInt(productId));
        System.out.println(":"+cartByUserIdAndProductId);
        int n =0;
        if(cartByUserIdAndProductId!=null){
            cartByUserIdAndProductId.setProductsCount(cartByUserIdAndProductId.getProductsCount()+1);
            n = cartService.update(cartByUserIdAndProductId);
        }else {
            //当前数据为空没有当前商品
            Product product = new Product();
            product.setProductId(Integer.parseInt(productId));
            User user = new User();
            user.setUserId(Integer.parseInt(userId));
            cart.setProduct(product);
            cart.setUser(user);

            cart.setProductsCount(1);
            n = cartService.add(cart);
        }


        PrintWriter out = resp.getWriter();
        if(n>0){
            //数据添加成功
            out.write("1");
        }else {
            //数据添加失败
            out.write("0");
        }
        out.flush();
    }
}
