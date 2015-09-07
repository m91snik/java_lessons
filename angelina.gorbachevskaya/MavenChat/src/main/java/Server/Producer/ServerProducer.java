package Server.Producer;

import Server.MessageReceiver.MessageReceiver;
import Server.SharedQueue;
import Utils.Message;
import Utils.UserID;

/**
 * Created by root on 9/4/15.
 */
public class ServerProducer<E extends Message, U extends UserID> implements Producer<E, U> {

    private SharedQueue<E> sharedQueue;
//    private SharedConnectionsDatabase<U> connections;
    private MessageReceiver<E, U> receiver;

    public ServerProducer() {
    }

    public ServerProducer(SharedQueue<E> sharedQueue, MessageReceiver<E, U> receiver) {
        this.sharedQueue = sharedQueue;
//        this.connections = connections;
        this.receiver = receiver;
    }

    @Override
    public void produce() throws ProducerException {
        try {
            sharedQueue.put(receiver.receiveMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
