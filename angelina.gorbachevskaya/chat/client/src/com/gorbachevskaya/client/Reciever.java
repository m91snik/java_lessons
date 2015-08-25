package com.gorbachevskaya.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by Ангелина on 15.08.2015.
 */
public class Reciever implements Runnable {
    private Socket socket;
    private boolean flag = false;

    public Reciever(Socket socket) {
        this.socket = socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        try (BufferedReader in =
                     new BufferedReader(
                             new InputStreamReader(socket.getInputStream()));

        ) {
            while (!flag) {
              System.out.println("recieve massage: *" + in.readLine() + "*");
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + socket.getLocalAddress());
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    socket.getLocalAddress());
            System.exit(1);
        }
    }
}
