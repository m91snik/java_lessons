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

    public NewConnectionOutput() {
    }

    @Override
    public void run() {
        try {

            while (true){
                String outText = (String)Main.blockingQueue.take();
                System.out.println("We send: " + outText);
                ListIterator<Socket> itr = Main.outputUsers.listIterator();
                while (itr.hasNext()) {
                    out = new PrintWriter(itr.next().getOutputStream(),true);
                    out.println("user" + Main.whoSend + ": " + outText);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
