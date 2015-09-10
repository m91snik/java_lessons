package com.vega.server.service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Вася-Вега on 08.09.2015.
 */
public interface UserService {

    boolean addUser(String login, String password, String name, String lastname);

    boolean changePassword(String userLogin, String oldPassword, String newPassword);

    boolean changeName(String userLogin, String userPassword, String newName);

    boolean changeLastname(String userLogin, String userPassword, String newLastname);

    List<User> findUser(String userLogin, String userPassword);

}
