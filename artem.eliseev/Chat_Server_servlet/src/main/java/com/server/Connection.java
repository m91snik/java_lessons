package com.server;

import org.springframework.stereotype.Component;

import java.net.Socket;
import java.util.Iterator;

/**
 * Created by Anry on 26.08.2015.
 */
public class Connection {
    public String clientIp;
    public int clientInputPort;

    public Connection(String clientIp, int clientInputPort) {
        this.clientIp = clientIp;
        this.clientInputPort = clientInputPort;
    }

    @Override
    public String toString() {
        return "Connection{" +
                "clientIp='" + clientIp + '\'' +
                ", clientInputPort=" + clientInputPort +
                '}';
    }
}