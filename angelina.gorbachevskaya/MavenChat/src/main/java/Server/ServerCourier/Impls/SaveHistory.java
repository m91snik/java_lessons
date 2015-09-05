package Server.ServerCourier.Impls;

import Server.ServerCourier.ServerSenderCourier;
import Server.SharedConnectionsDatabase;
import Utils.Message;
import Utils.UserID;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by root on 9/4/15.
 */
public class SaveHistory<U extends UserID> implements ServerSenderCourier<U> {
    private SharedConnectionsDatabase<U> users;
    private UserID senderID;

    public SaveHistory(SharedConnectionsDatabase<U> users) {
        this.users = users;
    }

    @Override
    public void sendMessage(Message message) {

        try (Socket socket = new Socket( message.getSenderID().getIp(), message.getSenderID().getPort());
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ) {
            System.out.println("User " + message.getSenderID() + " save history");
            out.writeObject(message);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setSenderID(UserID userID) {
        senderID = userID;
    }
}
