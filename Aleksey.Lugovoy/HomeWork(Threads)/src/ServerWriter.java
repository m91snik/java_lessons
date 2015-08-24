import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Lexsus on 18.08.2015.
 */
public class ServerWriter implements Runnable {

    private ConcurrentHashMap clientsMap = null;
    LinkedBlockingQueue<Message> queue;
    int port;

    public ServerWriter(LinkedBlockingQueue<Message> queue, ConcurrentHashMap<String, String> clientsMap, int port) throws IOException {
        super();
        this.clientsMap = clientsMap;
        this.port = port;
        this.queue = queue;

    }


    protected void sendMessage(String address, int port, String text) throws IOException {
        Socket socket = new Socket(address, port);
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(socket.getOutputStream());
        Message message = new Message(MessageType.MESSAGE, text);
        objectOutputStream.writeObject(message);
        //TODO: it's required to close socket and streams to avoid resource leak

    }

    @Override
    public void run() {

        while (true) {
            try {
                Message message = queue.take();
                Set<Map.Entry<String, String>> set = clientsMap.entrySet();
                for (Map.Entry<String, String> entry : set) {
                    {
                        String login = entry.getKey();
                        String address = entry.getValue();
                        sendMessage(address, port, message.Text);
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
