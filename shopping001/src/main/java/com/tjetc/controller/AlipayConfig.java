package com.tjetc.controller;

public class AlipayConfig {
    // 商户appid
    public static String APPID = "2016102500758605";
    // 私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCGqfpKLtf33TYZd9fjW97kHJ9DN/AkFV4TsoUr5tOJJ0R2LBHMUYvVLk210qVih1sxCp4dqbmUY0sL/3DK3UdnNCLhFwVTuIt5dhcOdU7zGNCCP9KcDnSIYJAGfGvLrCS98HqBMCe/17CittKsKoAWXFV9HwCEciC4CyD4MeDX4IrAbwr6bBsloiE83jbiIC55KHmui6bpfzTvnH9cN9wm2U9OS5o/2PQSZl4G9dFtX9izkWwHOREe5e5iFcDHFrxvm73MEHK0Zsavh5uzGFTBw+5jxOzK4mzMqIGjYW9p/GXcfBzx6pzlYNDYXMrbwv4stBFdom9Et+cZPnmnlFK7AgMBAAECggEAKzbK2hl0NtdnL/8UaaKmwV8qAKEnz/yHZxzHvZHiWkYeoyl7QKz+iZfFWk7Rwe+b5P36RZycsDC4+Y2sfX1LF6RUeRUxIW+8Wmr59SrR/hL9fn7KsEe3P7h1H4+36/E/DTDpryFr8BVgWqb+rj8pQYO572AOg3I4a7cuilc/RycRKxPC4/HqmttXRTWoMcya65zMIkpY2oy4/cZKpSqBH335ddDq0vtnX26lwjVbeai7aq6tzFWle6fNeVx486bH8zLoOVrwRPfTreb9k0WReudklaxieNhZ6nFF7MF/rl8n4DB8P735oizFIbYfEVJ6PI6ELcV29UJ88GeVs1CFsQKBgQDDqWVzYeuwYkFJpfTMaNgsOMmn7CFzZ/xSSr4IWjpMNXOL8Eordb7fOU2qRJGqbEviL5FbSCK0Vbb6W3lP8ceHE0NWS9uWvJifugo9v7RB1kMRR85a5SrIFn1gINLecONo8KGYZyFNY201CkZeU8sQ0Ys+esaAZW7xrLKZtgHsgwKBgQCwMRZl5iDIe2pDGkEHWPQba+o1uA/28u18Tb82gyOS0NKcPDKsyQcmHFMzcEMMB5yyIByLEVsdb7yBd+a5yzKCsWJbNBDCmgPTNyPbUwptKUGMbdX4XNoR9l0uBeGEQRy1sh1v1Xx/Wx3Ld3ok0UbfCnJTGH7abP3syGfqeV2baQKBgQCyI8RuLLT9Pjfa6fHbOYm3mWxgKqi5/e7IrawexqdVQ0UUH44ny2ggrHd9kjhdRYRBRrW8ugx+y5twjWAB3UugO3WPWDlxH/yFUEiKt8NSPdWKIipKr2MoEPHNV5UlWPpzTMKTkzHK179SDyzKLNgxU9bG59lahP9hoa5qLD/MKQKBgFguOSeGpaGxIt2yphknTATtXarFFDhkHLe5sZl2yLcSDFZlSndvpURNqNZ1uRisNqBvsdloNlHlOlMRz0ftiroeTTuYM0syCfgMAMYkKXO40jWWQyCqV/nlc301NEkczWGiY1k1X7ndwGu0wEzs8KtwbwdnmxV2tx9qrZeMZm0BAoGBAJWDKQC61kDmyM5FUMt0Io01bYIvTFIyTL9DN5WxlTeBsTkW7FOMRIcMrDtYz3apdFK69mLx4jHOcaF9AOQ8kQfLM0+9pUxUPF7dtgGEKzAWrLPpNRfmsf19r/LPsjeDZOTGQw+yrY67303xJ7mRf7Ja0f0RFermYJEoIFG8VNcd";
    // 请求网关地址
    public static String URL = "https://openapi.alipaydev.com/gateway.do";
    // 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhqn6Si7X9902GXfX41ve5ByfQzfwJBVeE7KFK+bTiSdEdiwRzFGL1S5NtdKlYodbMQqeHam5lGNLC/9wyt1HZzQi4RcFU7iLeXYXDnVO8xjQgj/SnA50iGCQBnxry6wkvfB6gTAnv9eworbSrCqAFlxVfR8AhHIguAsg+DHg1+CKwG8K+mwbJaIhPN424iAueSh5roum6X8075x/XDfcJtlPTkuaP9j0EmZeBvXRbV/Ys5FsBzkRHuXuYhXAxxa8b5u9zBBytGbGr4ebsxhUwcPuY8TsyuJszKiBo2Fvafxl3Hwc8eqc5WDQ2FzK28L+LLQRXaJvRLfnGT55p5RSuwIDAQAB";
    // RSA2
    public static String SIGNTYPE = "RSA2";
    // 编码
    public static String CHARSET = "UTF-8";
    // 返回格式
    public static String FORMAT = "json";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://localhost:8080/shopping001/OrderSubmitServlet";

    // 日志记录目录
//    public static String log_path = "/log";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/zfb.jsp";
}
