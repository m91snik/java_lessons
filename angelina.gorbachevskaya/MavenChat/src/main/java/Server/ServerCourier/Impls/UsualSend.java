package Server.ServerCourier.Impls;

import Server.ServerCourier.ServerSenderCourier;
import Server.SharedConnectionsDatabase;
import Utils.Message;
import Utils.UserID;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * Created by root on 9/4/15.
 */
public class UsualSend<U extends UserID> implements ServerSenderCourier<U> {
    private SharedConnectionsDatabase<U> users;
    private UserID senderID;

    public UsualSend(SharedConnectionsDatabase<U> users) {
        this.users = users;
    }

    @Override
    public void sendMessage(Message message) {

        for (Map.Entry<U, String> entry : users.all()) {
            try (Socket socket = new Socket( entry.getKey().getIp(), entry.getKey().getPort());
                 ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ) {
                message.setSender(senderID);
                out.writeObject(message);
            } catch (ConnectException e) {
                System.out.println("Delete user from DB");
                users.remove((U)entry.getKey());
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void setSenderID(UserID userID) {
        senderID = userID;
    }
}
