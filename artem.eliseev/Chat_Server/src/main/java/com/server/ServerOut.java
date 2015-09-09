package com.server;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;

/**
 * Created by Anry on 25.08.2015.
 */
@Component
class ServerOut implements Runnable {
    private final BlockingQueue<String> queue;

    ServerOut(BlockingQueue<String> mainQueue) {
        queue = mainQueue;
    }

    //toDO client socket timeout protection;
    @Override
    public synchronized void run() {
        while (true) {
            StringBuilder messageOut = new StringBuilder();

            try {
                messageOut = messageOut.append(queue.take());
                System.out.println("Message in sender " + messageOut);
            } catch (NullPointerException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Iterator<Connection> iter = Server.connections.iterator();
            while (iter.hasNext()) {
                Connection connection = ((Connection) iter.next());
                if (!(messageSender(connection, messageOut.toString()))) {
                    System.err.print("The message has just been lost! ");
                    System.err.println(connection.toString() + messageOut);
                }
            }

        }
    }

    public static boolean messageSender(Connection connection, String messageOut) {
        try (
                Socket echoSocket = new Socket(connection.clientIp, connection.clientInputPort);
                PrintWriter out =
                        new PrintWriter(echoSocket.getOutputStream(), true);
        ) {
            out.println(messageOut);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("The message has been sent");
        return true;
    }
}
