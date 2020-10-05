package com.tjetc.util;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


/**
 * 闫安的工具类
 */
public class DBUtil {

    static Connection conn;
    static PreparedStatement pstmt;
    static ResultSet rs;

    public static Properties properties() {
        //获取属性文件信息
        Properties properties = new Properties();
        //文件路径用classpath路径---加载classpath中的文件，因为properties文件被加载后在class文件中
        InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");


        try {

            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("配置文件db.properties");
        }
        return properties;
    }


    //    1）获取连接方法
    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(properties().getProperty("Driver"));
            String url = properties().getProperty("url");
            String name = properties().getProperty("username");
            String password = properties().getProperty("passeord");
            conn = DriverManager.getConnection(url,name,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("获取连接");
        }
        return conn;
    }

    //2)查询方法

    public static ResultSet select(String sql, Object... object){
        conn = getConnection();
        pstmt = null;
        rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i=0 ; i<object.length ; i++) {
                pstmt.setObject(i+1,object[i]);
            }
            rs = pstmt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("处理sql语句");
        }

        return rs;
    }

    //增删改方法
    public static int addDeleteUpdate(String sql,Object... object){
        int num=0;
        Connection conn = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i=0 ; i<object.length ; i++) {
                pstmt.setObject(i+1,object[i]);
                System.out.println(i+1+","+object);
            }
            num = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            close();
        }
        return num;
    }

    //关闭资源
    public static void close(){
        try {
            if(rs!=null)rs.close();
            if(pstmt!=null)pstmt.close();
            if(conn!=null)conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
