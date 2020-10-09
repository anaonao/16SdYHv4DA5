package com.tjetc.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PayController")
public class PayController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String op = req.getParameter("op");
        if("zf".equals(op)){
            zfSubmit(req,resp);
        }


    }

    private void zfSubmit(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("后台数据");


        String out_trade_no = req.getParameter("WIDout_trade_no");
        String subject = req.getParameter("WIDsubject");
        String total_amount = req.getParameter("WIDtotal_amount");
        String body = req.getParameter("WIDbody");
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

    }
}
