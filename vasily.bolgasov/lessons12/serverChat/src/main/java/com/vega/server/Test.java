package com.vega.server;

import com.vega.server.service.User;
import com.vega.server.service.UserService;
import com.vega.server.service.impl.UserServiceImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Вася-Вега on 08.09.2015.
 */
public class Test {

    public static void main(String[] args) throws SQLException {

        UserService userService = new UserServiceImpl();

//        System.out.println("NAME".equals(String.valueOf(ChatType.NAME)));

//        System.out.println(userService.addUser("login2", "password", "name", "lastname"));
//        System.out.println(userService.findUser("login2"));
//        System.out.println(userService.changePassword("login2", "password", "drowssap"));
//        System.out.println(userService.findUser("login2"));
//        System.out.println(userService.changeName("qwe", "qwe", "qwe"));
//        System.out.println(userService.findUser("login2"));
//        System.out.println(userService.changeName("login2", "drowssap2", "LUIZE"));
//        System.out.println(userService.findUser("login2"));
//        System.out.println(userService.changeLastname("login2", "drowssap2", "MARTINI"));
//        System.out.println(userService.findUser("login2"));

    }

}
