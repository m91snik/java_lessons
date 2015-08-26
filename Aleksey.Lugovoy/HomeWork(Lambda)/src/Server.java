import com.lexsus.server.Message;
import com.lexsus.server.MessageType;
import com.lexsus.server.ServerReader;
import com.lexsus.server.ServerWriter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by LugovoyAV on 12.08.2015.
 */
public class Server {
    public static void main(String[] args)
    {


        try{
            ServerSocket serverSocket = new ServerSocket(11005);
            LinkedBlockingQueue<Message> queue = new LinkedBlockingQueue<>(1024) ;
            ConcurrentHashMap clientsMap = new ConcurrentHashMap<String, String>();
            ServerReader reader = new ServerReader(queue, serverSocket,clientsMap);

            Runnable serverReader = ()->{
                while (true) {
                    try {
                        Socket client = serverSocket.accept();
                        ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
                        Message message = (Message) objectInputStream.readObject();
                        switch (message.type){
                            case LOGIN:
                                InetAddress address = client.getInetAddress();
                                clientsMap.put(message.Text, address.toString().substring(1));
                                break;
                            case MESSAGE:
                                queue.put(message);
                                break;
                        }
                        client.close();

                    } catch (IOException | ClassNotFoundException | InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread thread = new Thread(serverReader);
            thread.start();

            ServerWriter writer = new ServerWriter(queue,clientsMap,11007);
            Thread threadWriter = new Thread(writer);
            threadWriter.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
