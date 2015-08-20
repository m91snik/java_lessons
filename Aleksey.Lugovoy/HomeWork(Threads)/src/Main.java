import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by LugovoyAV on 12.08.2015.
 */
public class Main {
    public static void main(String[] args)
    {
        try{
            ServerSocket serverSocket = new ServerSocket(11005);

           /* PrintWriter out =
                    new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));*/
            LinkedBlockingQueue<Message> queue = new LinkedBlockingQueue<Message>() ;
            ConcurrentHashMap clientsMap = new ConcurrentHashMap<String, String>();
            ServerReader reader = new ServerReader(queue, serverSocket,clientsMap);
            Thread thread = new Thread(reader);
            thread.start();

            ServerWriter writer = new ServerWriter(queue,clientsMap,11007);
            Thread threadWriter = new Thread(writer);
            threadWriter.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
