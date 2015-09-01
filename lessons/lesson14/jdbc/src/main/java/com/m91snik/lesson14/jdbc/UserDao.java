package com.m91snik.lesson14.jdbc;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by m91snik on 30.08.15.
 */
public interface UserDao {

    String createUser(String name, String password) throws SQLException;

    List<User> getUsers() throws SQLException;
}
