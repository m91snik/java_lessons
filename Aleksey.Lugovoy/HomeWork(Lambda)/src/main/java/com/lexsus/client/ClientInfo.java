package com.lexsus.client;

/**
 * Created by LugovoyAV on 27.08.2015.
 */
public class ClientInfo {

    public int getPort() {
        return port;
    }

    public String getIp_address() {
        return ip_address;
    }

    public ClientInfo(String ip_address,int port) {
        this.port = port;
        this.ip_address = ip_address;
    }
    final int port;
    final String ip_address;
}
