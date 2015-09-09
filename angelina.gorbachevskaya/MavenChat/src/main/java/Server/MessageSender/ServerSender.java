package Server.MessageSender;

import Server.ServerCourier.Impls.*;
import Server.ServerCourier.ServerSenderCourier;
import Server.SharedConnectionsDatabase;
import Utils.MessageImpl;
import Utils.UserIDImpl;

/**
 * Created by Ангелина on 05.09.2015.
 */
public class ServerSender implements MessageSender<MessageImpl, UserIDImpl> {
    private SharedConnectionsDatabase<UserIDImpl> connections;
    private ServerSenderCourier courier;
    private UserIDImpl serverID;

    public ServerSender(SharedConnectionsDatabase<UserIDImpl> connections, UserIDImpl serverID) {
        this.serverID = serverID;
        this.connections = connections;
    }

    @Override
    public void send(MessageImpl message) {

        switch (message.getType()) {
            case MESSAGE:
                String str = message.getText();
                if (str.indexOf("@") == 0) {
                    courier = new PrivateSend(connections);
                } else if ("save".equals(str)) {
                    courier = new SaveHistory(connections);
                } else if ("all".equals(str)) {
                    courier = new ListOfAllUsers(connections);
                } else if ("exit".equals(str)) {
                    courier = new ExitUser(connections);
                } else {
                    courier = new UsualSend(connections);
                }
                break;
            case LOGIN:
            case REGISTER:
            case DELETE:
            case INFO:
                courier = new SpecialMessageSend();
                break;
        }



        courier.setSenderID(serverID);
        courier.sendMessage(message);
        System.out.println("Send message: " + message);
    }
}
