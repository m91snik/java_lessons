package com.m91snik.lesson14.jdbc.impl;

import com.m91snik.lesson14.jdbc.User;
import com.m91snik.lesson14.jdbc.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

/**
 * Created by m91snik on 30.08.15.
 */
public class UserDaoImpl implements UserDao {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }


    public String createUser(String name, String password) throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/lesson14_jdbc",
                    connectionProps);

            PreparedStatement preparedStatement = connection.prepareStatement("insert into USER values (?,?,?,?)");
            String id = UUID.randomUUID().toString().replace("-", "");
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, password);
            preparedStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));

            int updatedRecords = preparedStatement.executeUpdate();
            if (updatedRecords != 1) {
                throw new IllegalStateException("Cannot insert new record");
            }
            return id;
        } finally {
            connection.close();
        }
    }

    public List<User> getUsers() throws SQLException {

        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/lesson14_jdbc",
                connectionProps)) {

            PreparedStatement preparedStatement = connection.prepareStatement("select * from USER");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<User> users = new ArrayList<User>();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String password = resultSet.getString(3);
                Timestamp timestamp = resultSet.getTimestamp(4);
                users.add(new User(id, name, password, timestamp));
            }
            return users;
        }
    }
}
