package Client.Sender;

import Client.Producer.Producer;
import Utils.UserID;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Ангелина on 05.09.2015.
 */
public class ClientSender<E, U extends UserID> implements Sender<E, U> {

    private static String SERVER_HOSTNAME = "localhost";
    private static int SERVER_PORT = 1992;
    private Producer<E, U> producer;
//    private U userID;

    public ClientSender(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void send() throws SenderException{

        while ( !producer.isStop() ) {
            E element = producer.produce();
            try (Socket socket = new Socket(SERVER_HOSTNAME, SERVER_PORT);
                 ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ) {
                out.writeObject( element );
            } catch (UnknownHostException e) {
                System.out.println("Ошибка при передачи сообщения. Неизвестный хост");
            } catch (IOException e) {
                throw new SenderException();
            }
        }
    }
}
