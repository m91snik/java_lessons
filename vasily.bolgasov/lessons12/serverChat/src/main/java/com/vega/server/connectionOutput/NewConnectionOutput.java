package com.vega.server.connectionOutput;

import com.vega.server.Main;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ListIterator;

/**
 * Created by Вася-Вега on 01.09.2015.
 */
@Component
public class NewConnectionOutput implements ConnectionOutput {

    private static PrintWriter out;
    private static Socket client;

    @Override
    public void run() {
        try {

            while (true){

                /*
                 * Wait new message then send it all users
                 * for sending open new socket and close it
                 */

                String outText = (String) Main.blockingQueue.take();

                System.out.println("We send: " + outText);

                for(ListIterator<String[]> itr = Main.outputUsers.listIterator(); itr.hasNext(); ){
                    String[] users = itr.next();
                    String address = users[0];
                    Integer port = new Integer(users[1]);
                    try {
                        client = new Socket(address, port);
                        out = new PrintWriter(client.getOutputStream(), true);
                        out.println(outText);
                    } finally {
                        client.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
