package Server.MessageSender;

import Utils.Message;
import Utils.UserID;

/**
 * Created by Ангелина on 05.09.2015.
 */
public interface MessageSender<E extends Message, U extends UserID> {
    public void send(E e);
}
