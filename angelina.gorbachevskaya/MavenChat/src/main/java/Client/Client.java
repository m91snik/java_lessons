package Client;

import Client.Consumer.ClientConsumer;
import Client.Producer.ClientProducer;
import Client.Receiver.ClientReceiver;
import Client.Receiver.Receiver;
import Client.Receiver.ReceiverException;
import Client.Sender.ClientSender;
import Client.Sender.Sender;
import Client.Sender.SenderException;
import Utils.MessageImpl;
import Utils.UserIDImpl;

/**
 * Created by �������� on 01.09.2015.
 */
public class Client {

    private static UserIDImpl clientID = new UserIDImpl();

    Sender<MessageImpl, UserIDImpl> sender = new ClientSender<>(new ClientProducer(), clientID);
    Receiver<MessageImpl, UserIDImpl> receiver = new ClientReceiver<>(new ClientConsumer(), clientID);

    private boolean stop = false;

    public void startSession() {

        new Thread( ()->{
            try {
                sender.send();
            } catch (SenderException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread( ()->{
            while (!stop) {
                try {
                    receiver.receive();
                } catch (ReceiverException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void setStop() {
        this.stop = true;
    }
}
