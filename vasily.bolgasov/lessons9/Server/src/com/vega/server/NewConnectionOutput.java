package com.vega.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ListIterator;

/**
 * Created by Вася-Вега on 17.08.2015.
 */
public class NewConnectionOutput implements Runnable {

    private static PrintWriter out;
    private static Socket client;

    public NewConnectionOutput() {
    }

    @Override
    public void run() {
        try {

            while (true){

                /*
                 * Wait new message then send it all users
                 * for sending open new socket and close it
                 */

                String outText = (String)Main.blockingQueue.take();

                System.out.println("We send: " + outText);

                ListIterator<String[]> itr = Main.outputUsers.listIterator();
                String[] users;
                
                while (itr.hasNext()) {
                    users = itr.next();
                    String address = users[0];
                    Integer port = new Integer(users[1]);
                    client = new Socket(address,port);
                    out = new PrintWriter(client.getOutputStream(),true);
                    out.println(outText);
                    client.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
