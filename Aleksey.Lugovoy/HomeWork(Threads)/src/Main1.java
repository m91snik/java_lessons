import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by LugovoyAV on 12.08.2015.
 */
//TODO: rename to ClienMain
public class Main1 {
    public static void main(String[] args) {

        try {
    //    LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(10);
    //    ConsoleReader consoleReader = new ConsoleReader(queue);
    //  Thread thread = new Thread(consoleReader);
    //        thread.start();
            /* PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(kkSocket.getInputStream()));*/

            //TODO: make host and port as input arguments from args
            Thread threadWrite = new Thread(new ClientWriter("127.0.0.1", 11005));
            threadWrite.start();
            //TODO: move it into clientReader class and close it inside of finally method in ClientReader
            ServerSocket serverSocket = new ServerSocket(11007);
            Thread threadReader = new Thread(new ClientReader(serverSocket));
            threadReader.start();
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}