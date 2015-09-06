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
public class PrivateSend<U extends UserID> implements ServerSenderCourier<U> {
    SharedConnectionsDatabase<U> users;
    private UserID senderID;

    public PrivateSend(SharedConnectionsDatabase<U> users) {
        this.users = users;
    }

    @Override
    public void sendMessage(Message message) {
        // parse string to take the private reseiver's name
        String str = message.getText();
        String[] strings = str.split(" ");
        String receiverNick = strings[0];
        receiverNick = receiverNick.substring(1);
        // find this userID in database
        UserID privateReceiver = users.take(receiverNick);

        try (Socket socket = new Socket( privateReceiver.getIp(), privateReceiver.getPort());
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ) {
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
