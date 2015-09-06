package Client.Receiver;

import Utils.UserID;

/**
 * Created by Ангелина on 05.09.2015.
 */
public interface Receiver<E, U extends UserID> {
    public void receive() throws ReceiverException;
}
