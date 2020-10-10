package com.tjetc.controller;

import com.tjetc.domain.User;
import com.tjetc.service.UserService;
import com.tjetc.service.impl.UserServiceImpl;
import com.tjetc.util.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/UserServlet")
@MultipartConfig
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
        }else if ("updateUser".equals(op)) {
            updateUser(req, resp);
        }else if ("updateUserImg".equals(op)) {
            updateUserImg(req, resp);
        }else if("updateUserPwd".equals(op)){
            updateUserPwd(req,resp);
        }
    }

    //修改密码
    private void updateUserPwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int userId = (int)req.getSession().getAttribute("userId");
        String userPwd = req.getParameter("userPwd");
        int n = userService.updateUserByIdPwd(userId, userPwd);
        PrintWriter out = resp.getWriter();
        if(n>0){
            //销毁用户名
            req.getSession().removeAttribute("userName");
            out.write("1");
        }else {
            out.write("0");
        }
        out.flush();
    }

    //修改头像
    private void updateUserImg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String userImg = req.getParameter("userImg");
//        System.out.println(userImg);
        req.getSession().setAttribute("userImg",userImg);
        userService.updateImg(userImg,Integer.parseInt(userId));
        req.getRequestDispatcher("foreground/person_message.jsp").forward(req,resp);
    }

    //修改用户信息
    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (int)req.getSession().getAttribute("userId");
        String userName = req.getParameter("userName");
        System.out.println(userName);
        String userPhone = req.getParameter("userPhone");
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserIphone(userPhone);
        user.setUserStates(1);
        System.out.println("图片："+((User)req.getSession().getAttribute("user")).getUserImg());
        user.setUserImg(((User)req.getSession().getAttribute("user")).getUserImg());
        req.getSession().setAttribute("user",user);
        System.out.println(user);
        int n = userService.update(user);
        System.out.println("修改："+n);
        PrintWriter out = resp.getWriter();
        if(n>0){
            out.write("1");
        }else {
            out.write("0");
        }
        out.flush();
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
        System.out.println(userName);
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
        //获取用户状态
        int userStates = user.getUserStates();
        PrintWriter out = resp.getWriter();
        System.out.println(userName);
        System.out.println(userPwd);
        System.out.println(user);
        //登录成功
        if (userStates==1) {
            req.setAttribute("user", user);
            System.out.println(user);
            req.getSession().setAttribute("userName",userName);
            req.getSession().setAttribute("userId",user.getUserId());
            req.getSession().setAttribute("user",user);
            out.write("1");
            out.flush();
        } else if (userStates==0) {//禁用
            out.write("2");
            out.flush();
        }else {//不正确
            out.write("0");
            out.flush();
        }
    }
}
