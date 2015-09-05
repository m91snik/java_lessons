package Server.ServerCourier;


import Utils.Message;
import Utils.UserID;

/**
 * Created by root on 9/4/15.
 */
public interface ServerSenderCourier<U extends UserID> {
    public void sendMessage(Message message);
    public void setSenderID(UserID userID);
}
