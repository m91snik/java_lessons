import com.lexsus.client.ClientReader;
import com.lexsus.client.ClientWriter;
import com.lexsus.server.Message;
import com.lexsus.server.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by LugovoyAV on 12.08.2015.
 */
public class Client {
    public static void main(String[] args) {

        Runnable clientReader = ()->{
            while (true) {
                try (ServerSocket serverSocket = new ServerSocket(11007)){
                    Socket client = serverSocket.accept();
                    ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
                    Message message = (Message) objectInputStream.readObject();
                    if (message.type == MessageType.MESSAGE) {
                        System.out.println(message.Text);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        };

        try {
            Thread threadWrite = new Thread(new ClientWriter("127.0.0.1", 11005));
            threadWrite.start();



            Thread threadReader = new Thread(clientReader);
            threadReader.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}