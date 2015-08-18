package com.kamyshovcorp.server;

import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kamyshov.sergey on 17.08.15.
 */
public class SocketList {

    private static List<Socket> sockets = new LinkedList<>();

    public static synchronized List<Socket> getSockets() {
        return sockets;
    }

    public static synchronized void addSocketToList(Socket socket) {
        sockets.add(socket);
    }

}
