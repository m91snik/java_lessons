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
    //TODO: make field final
    private ServerSocket socket = null;
    private BlockingQueue queue = null;
    //TODO: create class to encapsulate address and port and
    // use it's instances as values in map to avoid client port hardcoding (in this case it's 11007 in Main class)
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
                //TODO: move to final block or use try-with-resources
                client.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                //TODO: throw an exception!
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}