package com.tjetc.test;

import com.tjetc.dao.UserDao;
import com.tjetc.dao.impl.UserDaoImpl;
import org.junit.Test;

public class UserTest {
    private UserDao userDao = new UserDaoImpl();
    @Test
    public void loginDao(){
        System.out.println(userDao.selectNameAndPwd("yanan","123456"));
    }
    @Test
    public void selectPageAll(){
        userDao.selectPageAll(1,1).getData().forEach(System.out::println);
    }
}
