package com.tjetc.controller;

import com.google.gson.Gson;
import com.tjetc.domain.Admin;
import com.tjetc.domain.Cart;
import com.tjetc.domain.Product;
import com.tjetc.domain.User;
import com.tjetc.service.CartService;
import com.tjetc.service.ProductService;
import com.tjetc.service.impl.CartServiceImpl;
import com.tjetc.service.impl.ProductServiceImpl;
import com.tjetc.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CartSrvlet")
public class CartSrvlet extends HttpServlet {
    private CartService cartService = new CartServiceImpl();
    private ProductService productService = new ProductServiceImpl();
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
        }else if("deleteById".equals(op)){
            deleteById(req,resp);
        }else if("deleteByListCartId".equals(op)){
            deleteByListCartId(req,resp);
        }else if("accountsAll".equals(op)){
            //把购物车选中编号获取到
            accountsAll(req,resp);
        }else if("jia".equals(op)){
            //添加商品数量
            jia(req,resp);
        }else if("jian".equals(op)){
            jian(req,resp);
        }else if("count".equals(op)){
            count(req,resp);
        }else if("".equals(op)){

        }else if("".equals(op)){

        }
    }

    //获取购物车中手动输入的商品数量
    private void count(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cartId = req.getParameter("cartId");
        String countnum = req.getParameter("countnum");
        Cart byId = cartService.findById(Integer.parseInt(cartId));
        PrintWriter out = resp.getWriter();
        if(byId!=null){
            int num = Integer.parseInt(countnum);
            if(num>0){
                if(num<=byId.getProduct().getProductCount()){
                    byId.setProductsCount(num);
                    int update = cartService.update(byId);
                    out.write("1");
                }else {
                    out.write("0");
                }
            }else {
                out.write("-1");
            }
        }
        out.flush();
    }

    private void jian(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cartId = req.getParameter("cartId");
        Cart byId = cartService.findById(Integer.parseInt(cartId));
        System.out.println("cart:"+byId);
        PrintWriter out = resp.getWriter();
        if(byId!=null){
            System.out.println("byId.getProductsCount():"+byId.getProductsCount());
            System.out.println("byId.getProduct().getProductCount():"+byId.getProduct().getProductCount());
            if(byId.getProductsCount()>1){
                int num = (byId.getProductsCount())-1;
                byId.setProductsCount(num);
                int update = cartService.update(byId);
                out.write("1");
            }else {
                out.write("0");
            }
        }else {
            out.write("2");
        }
        out.flush();
    }

    //
    private void jia(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cartId = req.getParameter("cartId");
        Cart byId = cartService.findById(Integer.parseInt(cartId));

        System.out.println("cart:"+byId);
        PrintWriter out = resp.getWriter();
        if(byId!=null){
            System.out.println("byId.getProductsCount():"+byId.getProductsCount());
            System.out.println("byId.getProduct().getProductCount():"+byId.getProduct().getProductCount());
           if(byId.getProductsCount()<byId.getProduct().getProductCount()){
               int num = (byId.getProductsCount())+1;
               byId.setProductsCount(num);
               int update = cartService.update(byId);
               out.write("1");
           }else {
               out.write("0");
           }
        }else {
             out.write("2");
        }
        out.flush();

    }

    //获取选中购物车编号，显示数据
    private void accountsAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] list= req.getParameter("listCartId").split(",");

        List<Cart> cartList = new ArrayList<>();

        double sum =0;
        for (int i = 0; i <list.length ; i++) {
            System.out.println("选中的商品购物车编号:"+list[i]);
         Cart cartByid = cartService.findById(Integer.parseInt(list[i]));
         cartList.add(cartByid);
         sum+=cartByid.getProduct().getProductPrice()*cartByid.getProductsCount();
        }
        System.out.println("总价格："+sum);
        System.out.println("显示所有选中的集合："+req.getParameter("listCartId"));
        req.setAttribute("list",cartList);
        req.setAttribute("countPrice",sum);
        //把购物车中选中的编号传递
        req.setAttribute("listByid",req.getParameter("listCartId"));
        req.getRequestDispatcher("foreground/accounts.jsp").forward(req,resp);

    }

    //批量删除购物车中的商品
    private void deleteByListCartId(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] list= req.getParameter("listCartId").split(",");

        for (int i = 0; i <list.length ; i++) {
            System.out.println("获取购物车编号1："+list[i]);
        }

        //调用方法删除数据
        int n = cartService.delteByListCartId(list);
        PrintWriter out = resp.getWriter();
        if(n>0){
            //删除成功
            out.write("1");
        }else {
            out.write("0");
        }
        out.flush();
    }

    //删除商品
    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cartId = req.getParameter("cartId");
        System.out.println(cartId);
        System.out.println();
        int n = cartService.delete(Integer.parseInt(cartId));
        System.out.println("panduan:"+n);
        PrintWriter out = resp.getWriter();
        out.write(n);
        out.flush();
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
