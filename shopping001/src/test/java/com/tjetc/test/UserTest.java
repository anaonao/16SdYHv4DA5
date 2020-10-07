package com.tjetc.test;

import com.tjetc.dao.UserDao;
import com.tjetc.dao.impl.UserDaoImpl;
import com.tjetc.domain.User;
import org.junit.Test;

public class UserTest {
    private UserDao userDao = new UserDaoImpl();

    public static void main(String[] args) {
         UserDao userDao = new UserDaoImpl();

        System.out.println(userDao.selectByName("yanan"));
    }
    @Test
    public void add(){
        System.out.println(userDao.addUser(new User("adfs","123")));
    }


    @Test
    public void loginDao(){
        System.out.println(userDao.selectNameAndPwd("yanan","123456"));
    }
    @Test
    public void selectPageAll(){
        userDao.selectPageAll(1,10).getData().forEach(System.out::println);
    }


}
