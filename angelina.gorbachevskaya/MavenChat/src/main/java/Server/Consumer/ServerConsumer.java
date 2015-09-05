package Server.Consumer;

import Server.MessageSender.MessageSender;
import Server.SharedQueue;
import Utils.Message;
import Utils.UserID;

/**
 * Created by root on 9/4/15.
 */
public class ServerConsumer<E extends Message, U extends UserID> implements Consumer<E, U> {

    private SharedQueue<E> sharedQueue;
    private MessageSender<E, U> sender;

    public ServerConsumer() {
    }

    public ServerConsumer(SharedQueue<E> sharedQueue, MessageSender<E, U> sender) {
        this.sharedQueue = sharedQueue;
        this.sender = sender;
    }

    @Override
    public void consume() throws ConsumerException{
        E element = null;
        try {
            element = sharedQueue.take();
        } catch (InterruptedException e) {
            throw new ConsumerException(e);
        }
        sender.send(element);
    }
}
