package Test;

import Server.Consumer.Consumer;
import Server.Consumer.ServerConsumer;
import Server.MessageReceiver.MessageReceiver;
import Server.MessageReceiver.ServerReceiver;
import Server.MessageSender.MessageSender;
import Server.*;
import Server.MessageSender.ServerSender;
import Server.Producer.Producer;
import Server.Producer.ServerProducer;
import Utils.Message;
import Utils.MessageImpl;
import Utils.UserID;
import Utils.UserIDImpl;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by root on 9/4/15.
 */
public class ServerTests {


    private Server server;

    private MessageSender<MessageImpl, UserIDImpl> sender;
    private MessageReceiver<MessageImpl, UserIDImpl> receiver;

    private MessageImpl message = new MessageImpl("mokito");

    @Before
    public void setup() {
        SharedQueue<MessageImpl> sharedQueue = new SharedQueue<MessageImpl>();
        SharedConnectionsDatabase<UserIDImpl> connections = new SharedConnectionsDatabase<UserIDImpl>();

//        receiver = new ServerReceiver(connections);
//        sender = new ServerSender(connections);

        sender = Mockito.mock(MessageSender.class);
        receiver= Mockito.mock(MessageReceiver.class);
//        connections = Mockito.mock(SharedConnectionsDatabase.class);


        Producer<MessageImpl, UserIDImpl> producer = new ServerProducer<>(sharedQueue, receiver);
        Consumer<MessageImpl, UserIDImpl> consumer = new ServerConsumer<>(sharedQueue, sender);

        server = new Server(producer, consumer);
    }

    @Test
    public void testMessageSystem() {
        Mockito.when(receiver.receiveMessage()).thenReturn(message);

        server.startSession();

        long currentTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - currentTime < 2000) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        server.setStop();

        Mockito.verify(sender, Mockito.atLeastOnce()).send(message);
    }

}
