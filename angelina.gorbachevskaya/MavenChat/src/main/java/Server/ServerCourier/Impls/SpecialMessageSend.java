package Server.ServerCourier.Impls;

import Server.ServerCourier.ServerSenderCourier;
import Utils.Message;
import Utils.UserID;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by root on 9/7/15.
 */
public class SpecialMessageSend<U extends UserID> implements ServerSenderCourier<U> {
    private UserID senderID;

    @Override
    public void sendMessage(Message message) {

        try (Socket socket = new Socket( message.getSenderID().getIp(), message.getSenderID().getPort());
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
        this.senderID = userID;

    }
}
