package Server.ServerCourier.Impls;

import Server.ServerCourier.ServerSenderCourier;
import Server.SharedConnectionsDatabase;
import Utils.Message;
import Utils.UserID;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * Created by root on 9/4/15.
 */
public class ListOfAllUsers<U extends UserID> implements ServerSenderCourier<U> {
    private SharedConnectionsDatabase<U> users;
    private UserID senderID;

    public ListOfAllUsers(SharedConnectionsDatabase<U> users) {
        this.users = users;
    }


    @Override
    public void sendMessage(Message message) {

        StringBuilder stringBuilder = new StringBuilder("Online users : ");

        for (Map.Entry<U, String> entry : users.all()) {
//            try {
//                Sender.send(new Message("", serverID), entry.getKey());
//            } catch (ConnectException e) {
//                System.out.println("Пользователь " + entry.getKey().getNick() + " отключился");
//                connectionDB.remove(entry.getKey());
//            }
            stringBuilder.append("\"");
            stringBuilder.append(entry.getKey().getName());
            stringBuilder.append("\" ");
        }

        try (Socket socket = new Socket( message.getSenderID().getIp(), message.getSenderID().getPort());
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ) {
            message.setText(stringBuilder.toString());
            System.out.println("User " + message.getSenderID() + " require a list of all");
            message.setSender(senderID);
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
