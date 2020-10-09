package com.tjetc.controller;

import com.tjetc.service.OrderService;
import com.tjetc.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/OrderSubmitServlet")
public class OrderSubmitServlet extends HttpServlet {
    private OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String[] list = (String[]) session.getAttribute("orderSubmitList");
        String countPrice = (String) session.getAttribute("orderSubmitcountPrice");
        String userId = (String) session.getAttribute("orderSubmituserId");

        int n = orderService.addOrders(list, Double.parseDouble(countPrice), Integer.parseInt(userId));
        if (n > 0) {
            resp.sendRedirect("foreground/cart.jsp");
        } else {
            System.out.println("数据提交不成功:n==" + n);
        }
    }
}
