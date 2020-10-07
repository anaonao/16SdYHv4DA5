package com.tjetc.controller;

import com.tjetc.domain.Admin;
import com.tjetc.domain.User;
import com.tjetc.service.UserService;
import com.tjetc.service.impl.UserServiceImpl;
import com.tjetc.util.Page;

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
        if ("login".equals(op)) {
            login(req, resp);
        } else if ("register".equals(op)) {
            register(req, resp);
        }else if ("selectAll".equals(op)) {
            selectAll(req, resp);
        }
    }

    //后台显示所有用户信息
    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageSize = req.getParameter("page");
        Page<User> all = userService.findPageAll(pageSize == null ? 1 : Integer.parseInt(pageSize), 10);
        req.setAttribute("page",all);
        req.getRequestDispatcher("backend/admin/user/list.jsp").forward(req,resp);
    }


    //注册
    private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");
        String userPhone = req.getParameter("userPhone");
        User user = new User();
        user.setUserName(userName);
        user.setUserIphone(userPhone);
        user.setUserPwd(userPwd);
        String msg = userService.addUser(user);
        System.out.println(msg);
        PrintWriter out = resp.getWriter();

        out.write(msg);
        out.flush();

    }

    //登录
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");
        User user = userService.findNameAndPwd(userName, userPwd);
        PrintWriter out = resp.getWriter();
        System.out.println(userName);
        System.out.println(userPwd);
        System.out.println(user);
        //登录成功
        if (user != null) {
            req.setAttribute("user", user);
            System.out.println(user);
            req.getSession().setAttribute("userName",userName);
            req.getSession().setAttribute("userId",user.getUserId());
            out.write("1");
            out.flush();
        } else {
            out.write("0");
            out.flush();
        }
    }
}
