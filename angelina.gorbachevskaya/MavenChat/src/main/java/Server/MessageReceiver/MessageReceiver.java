package Server.MessageReceiver;

import Utils.Message;
import Utils.UserID;

/**
 * Created by root on 9/4/15.
 */
public interface MessageReceiver<E extends Message, U extends UserID> {
    public E receiveMessage();// throws ReceiverException;
    public U getSender();
}
