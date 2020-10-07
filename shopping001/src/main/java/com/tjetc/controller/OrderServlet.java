package com.tjetc.controller;

import com.tjetc.domain.Admin;
import com.tjetc.domain.Order;
import com.tjetc.service.OrderService;
import com.tjetc.service.impl.OrderServiceImpl;
import com.tjetc.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    private OrderService orderService = new OrderServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if("selectAll".equals(op)){
            selectAll(req,resp);
        }else if("updateByState".equals(op)){
            updateByState(req,resp);
        }else if("".equals(op)){

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

    //根据编号修改订单状态
    private void updateByState(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        Order byId = orderService.findById(id);
        System.out.println("order:"+byId);
        byId.setState(1);
        //修改
        int n = orderService.update(byId);
        resp.sendRedirect(req.getContextPath()+"/OrderServlet?op=selectAll");
    }

    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageSize = req.getParameter("page");
        Page<Order> all = orderService.findAll(pageSize == null ? 1 : Integer.parseInt(pageSize), 10);
        req.setAttribute("page",all);
        req.getRequestDispatcher("backend/admin/order/list.jsp").forward(req,resp);
    }
}
