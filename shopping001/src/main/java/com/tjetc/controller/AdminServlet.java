package com.tjetc.controller;

import com.tjetc.domain.Admin;
import com.tjetc.service.AdminService;
import com.tjetc.service.impl.AdminServiceImpl;
import com.tjetc.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {

    private AdminService adminService = new AdminServiceImpl();
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

        }
    }

    //查询所有数据
    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page =1;
        String pageSize = req.getParameter("page");
        Page<Admin> all = adminService.findAll(pageSize == null ? 1 : Integer.parseInt(pageSize), 10);
        req.setAttribute("page",all);
        req.getRequestDispatcher("backend/admin/admin/list.jsp").forward(req,resp);
    }

}
