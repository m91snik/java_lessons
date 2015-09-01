package com.m91snik.lesson14.jdbc;

import com.m91snik.lesson14.jdbc.impl.UserDaoImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by m91snik on 30.08.15.
 */
public class Main {

    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDaoImpl();

        String userId = userDao.createUser("Nick", "123");
        System.out.println(userId);

        List<User> users = userDao.getUsers();
        System.out.println(users);
    }
}
