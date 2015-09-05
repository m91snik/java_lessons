package Client.Receiver;

import Client.Consumer.Consumer;
import Utils.UserID;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Ангелина on 05.09.2015.
 */
public class ClientReceiver<E, U extends UserID> implements Receiver<E, U> {
    private Consumer<E> consumer;
    private U userID;
    private ServerSocket serverSocket;

    public ClientReceiver(Consumer consumer, U userID) {
        this.consumer = consumer;
        this.userID = userID;
        try {
            serverSocket = new ServerSocket(userID.getPort());
        } catch (IOException e) {
            System.out.println("Error when ServerSocket create.");
            e.printStackTrace();
        }
    }

    @Override
    public void receive() throws ReceiverException {

        try (Socket socket = serverSocket.accept();
             ObjectInputStream inputStream =
                     new ObjectInputStream(socket.getInputStream());) {
            consumer.consume((E) inputStream.readObject());
        } catch (IOException e) {
            throw new ReceiverException();
        } catch (ClassNotFoundException e) {
            throw new ReceiverException();
        }
    }
}
