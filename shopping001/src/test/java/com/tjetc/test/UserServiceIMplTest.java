package com.tjetc.test;

import com.tjetc.domain.User;
import com.tjetc.service.UserService;
import com.tjetc.service.impl.UserServiceImpl;

public class UserServiceIMplTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
//        System.out.println(userService.findNameAndPwd("yanan","123456"));
        User user = new User();
        user.setUserName("yanan");
//        System.out.println(userService.addUser(user));
        System.out.println(userService.addUser(user));
    }
}
