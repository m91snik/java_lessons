import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Lexsus on 20.08.2015.
 */
public class ClientReader implements Runnable{
    private int port;
    private ServerSocket socket = null;
    ClientReader( ServerSocket socket ) throws IOException {
        this.port = port;
        this.socket = socket;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Socket client = socket.accept();
                ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
                Message message = (Message) objectInputStream.readObject();
                if (message.type == MessageType.MESSAGE) {
                    System.out.println(message.Text);
                }
                //TODO: move to final block or use try-with-resources
                client.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                //TODO: throw an exception!
                e.printStackTrace();
            }
        }
    }
}

