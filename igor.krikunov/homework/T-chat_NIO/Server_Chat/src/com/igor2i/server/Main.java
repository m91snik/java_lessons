package com.igor2i.server;

import com.igor2i.server.prevetstvie.Prevetstvie;
import com.igor2i.server.scanner.Scanner;
import com.igor2i.server.thread.Connector;

import java.io.IOException;

/**
 * Created by igor2i on 12.08.2015.
 */
import java.net.*;

public class Main {

    public static int SERVER_PORT = 5055;

    public static void main(String args[]) throws IOException {

        Prevetstvie.getPrevetstvie(InetAddress.getLocalHost().getHostAddress() + ":" + SERVER_PORT);


        Thread connector = new Thread(new Connector(SERVER_PORT));
        connector.setDaemon(true);
        connector.start();

        while (true) {
            if (Scanner.getScan().equals("shutdown")) {

                Connector.setStop();
                break;
            }
        }
    }
}
