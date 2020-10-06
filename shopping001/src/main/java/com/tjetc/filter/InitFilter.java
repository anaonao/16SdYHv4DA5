package com.tjetc.filter;

import javax.servlet.*;
import java.io.IOException;

public class InitFilter implements Filter {
    private String character;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化。。。");
        this.character=filterConfig.getInitParameter("character");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("过滤器服务启动。。。");
        request.setCharacterEncoding(character);
        response.setCharacterEncoding(character);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁!!!");
    }
}
