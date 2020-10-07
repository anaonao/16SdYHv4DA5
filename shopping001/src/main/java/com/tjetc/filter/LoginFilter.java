package com.tjetc.filter;



import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("登录过滤器启动。。。");
        HttpServletRequest req =(HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse)response;
        //获取session对象
        HttpSession session =req.getSession();
        if(session.getAttribute("adminname")==null){
            System.out.println("adminname:"+session.getAttribute("adminname"));
            req.setAttribute("msg","对不起，你还没有登录，没有权限访问该页面！！！");
            req.getRequestDispatcher("/backend/login.jsp").forward(req,response);
        }
        chain.doFilter(req,response);
    }

    @Override
    public void destroy() {


    }
}
