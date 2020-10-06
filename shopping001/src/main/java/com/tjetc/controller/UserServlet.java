package com.tjetc.controller;

import com.tjetc.domain.User;
import com.tjetc.service.UserService;
import com.tjetc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if("login".equals(op)){
            login(req,resp);
        }else if("register".equals(op)){
            register(req,resp);
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        User user = userService.findNameAndPwd(username,pwd);
        //判断用户是否为空
        if(user==null){
            req.setAttribute("msg","用户名为空");
        }

        req.getRequestDispatcher("login.jsp");
    }
}
