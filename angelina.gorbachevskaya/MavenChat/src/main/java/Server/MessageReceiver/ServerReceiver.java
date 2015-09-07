package Server.MessageReceiver;

import Server.SharedConnectionsDatabase;
import Server.UserDao.UserDao;
import Server.UserDao.UserDaoImpl;
import Utils.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

/**
 * Created by root on 9/4/15.
 */
public class ServerReceiver implements MessageReceiver<MessageImpl, UserIDImpl> {
//    private static final Logger logger = LogManager.getLogger();

    private SharedConnectionsDatabase<UserIDImpl> connections;
    private Message receivedMessage;
    UserDao userDao = new UserDaoImpl();

    UserIDImpl serverID;
    private static ServerSocket serverSocket;

    public ServerReceiver(SharedConnectionsDatabase<UserIDImpl> connections, UserIDImpl serverID) {
        this.serverID = serverID;
        this.connections = connections;
        try {
            serverSocket = new ServerSocket(serverID.getPort());
        } catch (IOException e) {
            System.out.println("Error when ServerSocket create.");
            e.printStackTrace();
        }
    }

    @Override
    public MessageImpl receiveMessage() {
        try (Socket socket = serverSocket.accept();
             ObjectInputStream inputStream =
                     new ObjectInputStream(socket.getInputStream());) {
            receivedMessage = (MessageImpl) inputStream.readObject();
            switch (receivedMessage.getType()) {
                case REGISTER:

                    try {
                        String userId = userDao.createUser((RegisterForm) receivedMessage);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    receivedMessage.setText("Registration success");
                    connections.put((UserIDImpl) receivedMessage.getSenderID());

                    break;
                case LOGIN:

                    try {
                        if (userDao.isLoginCorrect((RegisterForm) receivedMessage)) {
                            connections.put((UserIDImpl) receivedMessage.getSenderID());
                            receivedMessage.setText("Log in success.");
                        } else {
                            receivedMessage.setText("No user with this password.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    break;
                case DELETE:

                    try {
                        if (userDao.deleteUser(receivedMessage.getText().split(" ")[1], receivedMessage.getText().split(" ")[2])) {
                            connections.remove((UserIDImpl) receivedMessage.getSenderID());
                            receivedMessage.setText("Delete success.");
                        } else {
                            receivedMessage.setText("Username or password invalid.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    break;
                case INFO:

                    System.out.println(receivedMessage.getText());

                    try {
                        RegisterForm user = userDao.find(receivedMessage.getText().split(" ")[1]);
                        if (user != null) {
                            receivedMessage.setText(user.getFirstName() + " " +
                                    user.getSecondName() + " " +
                                    user.getAge() + " " +
                                    user.getNickName());
                        } else {
                            receivedMessage.setText("This user doesn't exist.");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    break;
            }
            System.out.println("Received message: " + receivedMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (MessageImpl) receivedMessage;
    }

    @Override
    public UserIDImpl getSender() {
        return (UserIDImpl) receivedMessage.getSenderID();
    }
}
