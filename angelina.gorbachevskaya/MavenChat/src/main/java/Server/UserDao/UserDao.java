package Server.UserDao;

import Utils.RegisterForm;

import java.sql.SQLException;

/**
 * Created by Ангелина on 06.09.2015.
 */
public interface UserDao {
    public String createUser(RegisterForm form) throws SQLException;
    public boolean isLoginCorrect(RegisterForm form) throws SQLException;
    public boolean deleteUser(String nick, String password) throws SQLException;
    public RegisterForm find(String nick) throws SQLException;
}
