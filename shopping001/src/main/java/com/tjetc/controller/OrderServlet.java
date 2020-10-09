package com.tjetc.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
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
import java.util.UUID;

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
        if ("selectAll".equals(op)) {
            selectAll(req, resp);
        } else if ("updateByState".equals(op)) {
            updateByState(req, resp);
        } else if ("submitCart".equals(op)) {
            submitCart(req, resp);
        } else if ("".equals(op)) {

        } else if ("".equals(op)) {

        } else if ("".equals(op)) {

        } else if ("".equals(op)) {

        } else if ("".equals(op)) {

        } else if ("".equals(op)) {

        } else if ("".equals(op)) {

        } else if ("".equals(op)) {

        }
    }

    //提交订单
    private void submitCart(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] list = req.getParameter("cartIListd").split(",");
        String countPrice = req.getParameter("countPrice");
        String userId = req.getParameter("userId");
        System.out.println("list:" + list);
        System.out.println("countPrice:" + countPrice);
        System.out.println("userId:" + userId);
        if (countPrice != null && userId != null) {
            int n = orderService.addOrders(list, Double.parseDouble(countPrice), Integer.parseInt(userId));
            if (n > 0) {
                //成功
                //返回到购物车
//                resp.sendRedirect("foreground/cart.jsp");
                System.out.println("生成订单");




                String out_trade_no = UUID.randomUUID().toString();
                String subject = "凯瑞智能家居";
                String total_amount = countPrice;
                String body = "请您保存好订单信息，便于以后使用";
                String timeout_express="2m";
                String product_code="FAST_INSTANT_TRADE_PAY";
                // 还可以多获取些其他的信息(比如下订单的用户id)，生成订单，存入数据库。
                // 或者回调之后，获取相应消息生成订单
                /**********************/
                // SDK 公共请求类，包含公共请求参数，以及封装了签名与验签，开发者无需关注签名与验签
                AlipayClient client = new DefaultAlipayClient(AlipayConfig.URL, AlipayConfig.APPID, AlipayConfig.RSA_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
//        AlipayTradeWapPayRequest alipay_request=new AlipayTradeWapPayRequest();
                AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
                // 设置同步地址
                alipayRequest.setReturnUrl(AlipayConfig.return_url);
                alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                        + "\"total_amount\":\""+ total_amount +"\","
                        + "\"subject\":\""+ subject +"\","
                        + "\"body\":\""+ body +"\","
                        + "\"timeout_express\":\""+ timeout_express +"\","
                        + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
                // form表单生产
                String form = "";
                try {
                    // 调用SDK生成表单
                    form = client.pageExecute(alipayRequest).getBody();
                    resp.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
                    resp.getWriter().write(form);//直接将完整的表单html输出到页面
                    resp.getWriter().flush();
                    resp.getWriter().close();
                    System.out.println("form:"+form);
                } catch (AlipayApiException e) {
                    System.out.println("异常！！！");
                    e.printStackTrace();
                } catch (IOException e) {
                    System.out.println("异常11323");
                    e.printStackTrace();
                }



















            } else {
                System.out.println("数据提交不成功:n==" + n);
            }
        } else {
            System.out.println("提交失败！！");
        }
    }

    //根据编号修改订单状态
    private void updateByState(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        Order byId = orderService.findById(id);
        System.out.println("order:" + byId);
        byId.setState(1);
        //修改
        int n = orderService.update(byId);
        resp.sendRedirect(req.getContextPath() + "/OrderServlet?op=selectAll");
    }

    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pageSize = req.getParameter("page");
        Page<Order> all = orderService.findAll(pageSize == null ? 1 : Integer.parseInt(pageSize), 10);
        req.setAttribute("page", all);
        req.getRequestDispatcher("backend/admin/order/list.jsp").forward(req, resp);
    }
}
