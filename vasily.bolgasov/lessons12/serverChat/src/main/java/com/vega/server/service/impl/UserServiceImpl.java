package com.vega.server.service.impl;

import com.vega.server.service.User;
import com.vega.server.service.UserService;
import com.vega.server.until.PasswordUntil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;


/**
 * Created by Вася-Вега on 08.09.2015.
 */
public class UserServiceImpl implements UserService {

    @Override
    public boolean addUser(String login, String password, String name, String lastname){
        boolean queryCheck = false;
        Properties properties = new Properties();
        properties.put("user", String.valueOf(BDType.USER));
        try {
            if(checkLogin(login)==true) {
                Connection connection = null;
                try {
                    connection = DriverManager.getConnection(String.valueOf(BDType.CONNECTBASE), properties);
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            String.valueOf(BDType.INSERTQUERY));
                    String id = UUID.randomUUID().toString().replace("-", "");
                    preparedStatement.setString(1, id);
                    preparedStatement.setString(2, login);
                    preparedStatement.setString(3, PasswordUntil.getPasswordHash(password, login));
                    preparedStatement.setString(4, name);
                    preparedStatement.setString(5, lastname);

                    int update = preparedStatement.executeUpdate();
                    if (update != 1) {
                        throw new IllegalStateException("Cannot insert new record");
                    }
                    queryCheck = true;
                }finally {
                    connection.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return queryCheck;
        }
    }

    @Override
    public List<User> findUser(String userLogin, String userPassword){
        List<User> users = new ArrayList<>();
        Properties properties = new Properties();
        properties.put("user",String.valueOf(BDType.USER));

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(String.valueOf(BDType.CONNECTBASE), properties);
            PreparedStatement preparedStatement = connection.prepareStatement(String.valueOf(BDType.FINDUSER));
            preparedStatement.setString(1, userLogin);
            preparedStatement.setString(2, PasswordUntil.getPasswordHash(userPassword, userLogin));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String id = resultSet.getString(1);
                String login = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String lastname = resultSet.getString(5);

                users.add(new User(id, login, password, name, lastname));
            }
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return users;
        }
    }

    @Override
    public boolean changePassword(String userLogin, String oldPassword, String newPassword){
        boolean queryCheck = false;
        Properties properties = new Properties();
        properties.put("user",String.valueOf(BDType.USER));

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(String.valueOf(BDType.CONNECTBASE), properties);
            PreparedStatement preparedStatement = connection.prepareStatement(String.valueOf(BDType.CHANGEPASSWORD));
            preparedStatement.setString(1, PasswordUntil.getPasswordHash(newPassword,userLogin));
            preparedStatement.setString(2, userLogin);
            preparedStatement.setString(3, PasswordUntil.getPasswordHash(oldPassword,userLogin));
            int update = preparedStatement.executeUpdate();
            if (update != 1) {
                throw new IllegalStateException("Cannot insert new record");
            }
            queryCheck = true;
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return queryCheck;
        }
    }

    @Override
    public boolean changeName(String userLogin, String userPassword, String newName){
        boolean queryCheck = false;
        Properties properties = new Properties();
        properties.put("user",String.valueOf(BDType.USER));

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(String.valueOf(BDType.CONNECTBASE), properties);
            PreparedStatement preparedStatement = connection.prepareStatement(String.valueOf(BDType.CHANGENAME));
            preparedStatement.setString(1, newName);
            preparedStatement.setString(2, userLogin);
            preparedStatement.setString(3, PasswordUntil.getPasswordHash(userPassword,userLogin));
            int update = preparedStatement.executeUpdate();
            if (update != 1) {
                throw new IllegalStateException("Cannot insert new record");
            }
            queryCheck = true;
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return queryCheck;
        }
    }

    @Override
    public boolean changeLastname(String userLogin, String userPassword, String newLastname){
        boolean queryCheck = false;
        Properties properties = new Properties();
        properties.put("user",String.valueOf(BDType.USER));

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(String.valueOf(BDType.CONNECTBASE), properties);
            PreparedStatement preparedStatement = connection.prepareStatement(String.valueOf(BDType.CHANGELASTNAME));
            preparedStatement.setString(1, newLastname);
            preparedStatement.setString(2, userLogin);
            preparedStatement.setString(3, PasswordUntil.getPasswordHash(userPassword,userLogin));
            int update = preparedStatement.executeUpdate();
            if (update != 1) {
                throw new IllegalStateException("Cannot insert new record");
            }
            queryCheck = true;
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return queryCheck;
        }
    }

    public boolean checkLogin(String checkLogin) throws SQLException {
        Properties properties = new Properties();
        properties.put("user",String.valueOf(BDType.USER));

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(String.valueOf(BDType.CONNECTBASE), properties);
            PreparedStatement preparedStatement = connection.prepareStatement(String.valueOf(BDType.FINDQUERY));
            preparedStatement.setString(1, checkLogin);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<>();
            while (resultSet.next()){
                String id = resultSet.getString(1);
                String login = resultSet.getString(2);
                String password = resultSet.getString(3);
                String name = resultSet.getString(4);
                String lastname = resultSet.getString(5);

                users.add(new User(id, login, password, name, lastname));
            }
            return users.isEmpty();
        }finally {
            connection.close();
        }
    }
}
