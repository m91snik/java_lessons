package Client.Sender;

import Utils.UserID;

/**
 * Created by Ангелина on 05.09.2015.
 */
public interface Sender<E, U extends UserID> {
    public void send() throws SenderException;
}
