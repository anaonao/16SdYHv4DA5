package com.tjetc.controller;

import com.tjetc.domain.Order;
import com.tjetc.domain.OrderItem;
import com.tjetc.service.OrderItemService;
import com.tjetc.service.impl.OrderItemServiceImpl;
import com.tjetc.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/OrderItemServlet")
public class OrderItemServlet extends HttpServlet {
    private OrderItemService orderItemService = new OrderItemServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if("selectAll".equals(op)){
            selectAll(req,resp);
        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }else if("".equals(op)){

        }
    }

    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageSize = req.getParameter("page");
        Page<OrderItem> all = orderItemService.findAll(pageSize == null ? 1 : Integer.parseInt(pageSize), 10);
        req.setAttribute("page",all);
        req.getRequestDispatcher("backend/admin/orderItem/list.jsp").forward(req,resp);
    }
}
