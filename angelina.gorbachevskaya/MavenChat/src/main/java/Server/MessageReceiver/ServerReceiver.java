package Server.MessageReceiver;

import Server.SharedConnectionsDatabase;
import Utils.Message;
import Utils.MessageImpl;
import Utils.UserIDImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by root on 9/4/15.
 */
public class ServerReceiver implements MessageReceiver<MessageImpl, UserIDImpl> {
//    private static final Logger logger = LogManager.getLogger();

    private SharedConnectionsDatabase<UserIDImpl> connections;
    private Message receivedMessage;

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
        MessageImpl message = null;
        try (Socket socket = serverSocket.accept();
             ObjectInputStream inputStream =
                     new ObjectInputStream(socket.getInputStream());) {
            message = (MessageImpl) inputStream.readObject();
            receivedMessage = message;
            connections.put((UserIDImpl) message.getSenderID());
            System.out.println("Received message: " + receivedMessage);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return message;
    }

    @Override
    public UserIDImpl getSender() {
        return (UserIDImpl)receivedMessage.getSenderID();
    }
}
