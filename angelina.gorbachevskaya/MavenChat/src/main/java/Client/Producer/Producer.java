package Client.Producer;

import Utils.UserID;

/**
 * Created by Ангелина on 05.09.2015.
 */
public interface Producer<E, U extends UserID> {
    public E produce();
    public boolean isStop();
}
