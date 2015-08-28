package oldNotInWork;

import com.client.MessageFromClientToServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Anry on 28.08.2015.
 */
public class EchoServerWithObject {
    static int counter = 0;

    public static void main(String... args) throws IOException {

        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
//while(true){
        try (
                ServerSocket serverSocket =
                        new ServerSocket(Integer.parseInt(args[0]));
                Socket clientSocket = serverSocket.accept();
                PrintWriter out =
                        new PrintWriter(clientSocket.getOutputStream(), true);
//                BufferedReader in = new BufferedReader(
//                        new InputStreamReader(clientSocket.getInputStream()));
                ObjectInputStream in =
                        new ObjectInputStream(clientSocket.getInputStream());
        ) {
            System.out.println("Server works!");
            MessageFromClientToServer messageFromClientToServer =
                    (MessageFromClientToServer) in.readObject();
            System.out.println(messageFromClientToServer.toString());


            String inputLine;

//            while ((inputLine = in.readLine()) != null) {
//                out.println(inputLine);
//                System.out.println(clientSocket.getInetAddress().toString());
//
//
//            }

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException MessageFromClientToServer " +
                    "income message on server");
        }
    }
//}

    static int counterWithSync() {
        synchronized (EchoServer.class) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return ++counter;
        }
    }
}
