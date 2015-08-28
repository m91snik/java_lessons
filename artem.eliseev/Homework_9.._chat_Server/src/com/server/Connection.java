package com.server;

import java.net.Socket;
import java.util.Iterator;

/**
 * Created by Anry on 26.08.2015.
 */
  class Connection {
    Socket clientSocket;
    String clientIp;
    int clientInputPort;

    public Connection(Socket clientSocket, String clientIp, int clientInputPort) {
        this.clientSocket = clientSocket;
        this.clientIp = clientIp;
        this.clientInputPort = clientInputPort;

    }
    public boolean newUserCheck(com.server.Connection connection) {
        Iterator<com.server.Connection> iter = Server.connections.iterator();
        while (iter.hasNext()) {
            if (((com.server.Connection) iter.next()).equals(connection)) {
                return false;
            }
        }
        return true;
    }

}