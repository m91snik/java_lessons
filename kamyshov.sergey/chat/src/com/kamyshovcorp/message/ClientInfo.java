package com.kamyshovcorp.message;

import java.io.Serializable;

/**
 * @author kamyshov.sergey
 * @since 21.08.2015
 */
public class ClientInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userName;
    private String hostName;
    private int clientPort;

    public ClientInfo(String userName, String hostName, int clientPort) {
        this.userName = userName;
        this.hostName = hostName;
        this.clientPort = clientPort;
    }

    public String getUserName() {
        return userName;
    }

    public String getHostName() {
        return hostName;
    }

    public int getClientPort() {
        return clientPort;
    }
}
