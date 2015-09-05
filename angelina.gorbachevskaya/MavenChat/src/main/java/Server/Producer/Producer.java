package Server.Producer;

import Utils.Message;
import Utils.UserID;

/**
 * Created by root on 9/4/15.
 */
public interface Producer<E extends Message, U extends UserID> {
    public void produce() throws ProducerException;
}
