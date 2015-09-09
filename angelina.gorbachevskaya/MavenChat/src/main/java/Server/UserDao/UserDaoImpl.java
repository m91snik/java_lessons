package Server.UserDao;

import Utils.RegisterForm;

import java.sql.*;
import java.util.Properties;
import java.util.UUID;

/**
 * Created by Ангелина on 06.09.2015.
 */
public class UserDaoImpl implements UserDao {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public String createUser(RegisterForm form) {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "qwerty");

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/users",
                    connectionProps);

            PreparedStatement preparedStatement = connection.prepareStatement("insert into USER values (?,?,?,?,?,?,?)");
            String id = UUID.randomUUID().toString().replace("-", "");
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, form.getFirstName());
            preparedStatement.setString(3, form.getSecondName());
            preparedStatement.setInt(4, form.getAge());
            preparedStatement.setString(5, form.getNickName());
            preparedStatement.setString(6, form.getPassword());
            preparedStatement.setTimestamp(7, new Timestamp(System.currentTimeMillis()));

            int updatedRecords = preparedStatement.executeUpdate();
            if (updatedRecords != 1) {
                throw new IllegalStateException("Cannot insert new record");
            }
            return id;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean isLoginCorrect(RegisterForm form) throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "qwerty");

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/users",
                connectionProps)) {

            PreparedStatement preparedStatement = connection.prepareStatement("select * from USER where NICK=? ");
            preparedStatement.setString(1, form.getNickName());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (resultSet.getString(6).equals(form.getPassword())) {
                    System.out.println("yes");
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean deleteUser(String nick, String password) throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "qwerty");

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/users",
                connectionProps)) {

            PreparedStatement preparedStatement = connection.prepareStatement("delete from USER where NICK=? and PASSWORD=?");
            preparedStatement.setString(1, nick);
            preparedStatement.setString(2, password);
            int rows = preparedStatement.executeUpdate();
            return (rows!=0);
        }
    }

    @Override
    public RegisterForm find(String nick) throws SQLException {

        RegisterForm form = new RegisterForm();
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "qwerty");

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/users",
                connectionProps)) {

            PreparedStatement preparedStatement = connection.prepareStatement("select * from USER where NICK=? ");
            preparedStatement.setString(1, nick);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                form.setFirstName(resultSet.getString(2));
                form.setSecondName(resultSet.getString(3));
                form.setAge(resultSet.getInt(4));
                form.setNick(resultSet.getString(5));
                return form;
            }
        }
        return null;
    }
}
