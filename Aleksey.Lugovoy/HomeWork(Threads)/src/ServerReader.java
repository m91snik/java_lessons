import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by LugovoyAV on 13.08.2015.
 */
public class ServerReader implements Runnable {
    private ServerSocket socket = null;
    private BlockingQueue queue = null;
    private ConcurrentHashMap<String, String> clientsMap;


    ServerReader(BlockingQueue<Message> queue, ServerSocket socket,ConcurrentHashMap<String, String> clientsMap) throws IOException {
        this.queue = queue;
        this.socket = socket;
        this.clientsMap = clientsMap;
    }

    @Override
    public void run() {
      while (true) {
            try {
                Socket client = socket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
                Message message = (Message) objectInputStream.readObject();
                if (message.type == MessageType.LOGIN) {
                    InetAddress address = client.getInetAddress();
                    clientsMap.put(message.Text, address.toString().substring(1));
                    client.close();
                    continue;
                }
                if (message.type == MessageType.MESSAGE) {
                    queue.put(message);
                }
                client.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}