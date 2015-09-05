package Server.Consumer;

import Utils.Message;
import Utils.UserID;

/**
 * Created by root on 9/4/15.
 */
public interface Consumer<E extends Message, U extends UserID> {
    public void consume() throws ConsumerException;

}
