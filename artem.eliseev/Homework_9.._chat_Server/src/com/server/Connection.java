package com.server;

import java.net.Socket;
import java.util.Iterator;

/**
 * Created by Anry on 26.08.2015.
 */
class Connection {
    String clientIp;
    int clientInputPort;

    public Connection(String clientIp, int clientInputPort) {
        this.clientIp = clientIp;
        this.clientInputPort = clientInputPort;

    }

    public boolean newUserCheck(Connection connection) {
        Iterator<Connection> iter = Server.connections.iterator();
        while (iter.hasNext()) {
            Connection next = iter.next();
            if ((next.clientIp.equals(connection.clientIp)) &
                    ((next.clientInputPort) == (connection.clientInputPort))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "clientIp='" + clientIp + '\'' +
                ", clientInputPort=" + clientInputPort +
                '}';
    }
}