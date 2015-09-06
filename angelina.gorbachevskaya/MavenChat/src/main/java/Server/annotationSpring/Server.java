package Server.annotationSpring;

import Server.Consumer.Consumer;
import Server.Consumer.ConsumerException;
import Server.Producer.Producer;
import Server.Producer.ProducerException;
import Utils.MessageImpl;
import Utils.UserIDImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ангелина on 06.09.2015.
 */
@Service
public class Server {

    private static String SERVER_HOSTNAME = "localhost";
    private static int SERVER_PORT = 1992;

    private static UserIDImpl serverID = new UserIDImpl(SERVER_HOSTNAME, SERVER_PORT, "server");

//    private Server.SharedQueue<MessageImpl> blockingQueue = new Server.SharedQueue<MessageImpl>();
//    private Server.SharedConnectionsDatabase<UserIDImpl> connections = new Server.SharedConnectionsDatabase<UserIDImpl>();

    @Autowired
    Producer<MessageImpl, UserIDImpl> producer;// = new ServerProducer<>(blockingQueue, new ServerReceiver(connections, serverID));
    @Autowired
    Consumer<MessageImpl, UserIDImpl> consumer;// = new ServerConsumer<>(blockingQueue, new ServerSender(connections, serverID));

    private boolean stop = false;

//    public Server() {
//    }

//    public Server(Producer<MessageImpl, UserIDImpl> producer, Consumer<MessageImpl, UserIDImpl> consumer) {
//        this.producer = producer;
//        this.consumer = consumer;
//    }

    public void startSession() {
        new Thread(()->{
            while (!stop) {
                try {
                    producer.produce();
                } catch (ProducerException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread( ()->{
            while (!stop) {
                try {
                    consumer.consume();
                } catch (ConsumerException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void setStop() {
        this.stop = true;
    }

    public void setServerHostname(String hostname) {
        serverID.setIp(hostname);
    }

    public void setServerPort(int port) {
        serverID.setPort(port);
    }

}
