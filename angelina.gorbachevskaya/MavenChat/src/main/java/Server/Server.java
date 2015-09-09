package Server;

import Server.Consumer.Consumer;
import Server.Consumer.ConsumerException;
import Server.Producer.Producer;
import Server.Producer.ProducerException;
import Utils.MessageImpl;
import Utils.UserIDImpl;


/**
 * Created by root on 8/28/15.
 */

public class Server {
    private static String SERVER_HOSTNAME = "localhost";
    private static int SERVER_PORT = 1992;

    private static UserIDImpl serverID = new UserIDImpl(SERVER_HOSTNAME, SERVER_PORT, "server");

    private SharedQueue<MessageImpl> blockingQueue = new SharedQueue<MessageImpl>();
    private SharedConnectionsDatabase<UserIDImpl> connections = new SharedConnectionsDatabase<UserIDImpl>();

    Producer<MessageImpl, UserIDImpl> producer;// = new ServerProducer<>(blockingQueue, new ServerReceiver(connections, serverID));
    Consumer<MessageImpl, UserIDImpl> consumer;// = new ServerConsumer<>(blockingQueue, new ServerSender(connections, serverID));

    private boolean stop = false;

//    public Server() {
//    }

    public Server(Producer<MessageImpl, UserIDImpl> producer, Consumer<MessageImpl, UserIDImpl> consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

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
